package http;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**Create By knagtian.poon  。引用https://blog.csdn.net/tianya3530/article/details/77337124
 * 须引入
 * <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient -->
 *         <dependency>
 *             <groupId>org.apache.httpcomponents</groupId>
 *             <artifactId>httpclient</artifactId>
 *             <version>4.5.5</version>
 *         </dependency>
 *         <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime -->
 *         <dependency>
 *             <groupId>org.apache.httpcomponents</groupId>
 *             <artifactId>httpmime</artifactId>
 *             <version>4.5.5</version>
 *         </dependency>
 */
public class HttpsUtils {
    private static final CloseableHttpClient httpsclient = createSSLClientDefault();
    private static String  charset="utf-8";
    private static  String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
    private static int socketTimeout=2000;
    private static int connectTimeout=2000;

    public static CloseableHttpClient createSSLClientDefault(){
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){
                //信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }



    /**参数直接附在url上
     * @param url
     * @return String
     */
    public static String sendGet(String url) {
        return excuteHttpGet(url);
    }

    /**
     * map参数形式
     * @param url
     * @param params
     * @return String
     */
    public static String sendGet(String url,Map<String,String> params){
        url+="?";
        for (String key:params.keySet()) {
            url+=key+"="+params.get(key)+"&";
        }
        return excuteHttpGet(url);
    }

    /**
     * 发送HttpPost请求
     * @param url
     * @param map 参数
     * @return String
     */
    public static String sendPost(String url, Map<String, String> map) {
        // 设置参数
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        // 编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        // 取得HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
        httpPost.setHeader("User-Agent", userAgent);
        // 参数放入Entity
        httpPost.setEntity(formEntity);
        return excuteHttpPost(httpPost);
    }

    /**发送HttpPost请求
     * @param url
     * @param file 参数为文件
     * @return String
     */
    public static String sendPost(String url, File file) {
        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
        httpPost.setHeader("User-Agent", userAgent);
        MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
        multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntity.addPart("media", new FileBody(file));
        httpPost.setEntity(multipartEntity.build());
        return excuteHttpPost(httpPost);
    }
    /**
     * 发送HttpPost请求
     * @param url
     * @param jsonStr 参数为json字符串
     * @return String
     */
    public static String sendPost(String url, String jsonStr) {
        // 字符串编码
        StringEntity entity = new StringEntity(jsonStr, Consts.UTF_8);
        // 设置content-type
        entity.setContentType("application/json");
        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
        httpPost.setHeader("User-Agent", userAgent);
        // 接收参数设置
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(entity);
        return excuteHttpPost(httpPost);
    }
    /**
     * 发送不带参数的HttpPost请求
     * @param url
     * @return String
     */
    public static String sendPost(String url) {
        // 得到一个HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
        httpPost.setHeader("User-Agent", userAgent);
        return excuteHttpPost(httpPost);
    }

    /**
     * httpPost公用方法
     * @param httpPost
     * @return
     */
    private static  String excuteHttpPost(HttpPost httpPost){
        CloseableHttpResponse response = null;
        String result = null;
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();//设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        try {
            // 执行post请求
            response = httpsclient.execute(httpPost);
            // 得到entity
            HttpEntity entity = response.getEntity();
            // 得到字符串
            if (entity != null) {
                result = EntityUtils.toString(entity,charset);
            }
        } catch (IOException e) {
            System.out.println("IO异常："+e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    System.out.println("关闭Response对象出现异常："+e.getMessage());
                }
            }
        }
        return result;
    }
    private static String excuteHttpGet(String url){
        String result=null;
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent", userAgent);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();//设置请求和传输超时时间
            httpGet.setConfig(requestConfig);
            response = httpsclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity,charset);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    System.out.println("关闭Response对象出现异常："+e.getMessage());
                }
            }
        }
        return result;
    }

    /**
     * 默认utf-8
     * @param charset
     */
    public static void setCharset(String charset) {
        HttpsUtils.charset = charset;
    }
    public static void setUserAgent(String userAgent) {
        HttpsUtils.userAgent = userAgent;
    }

    /**
     * 默认2秒
     * @param socketTimeout
     */
    public static void setSocketTimeout(int socketTimeout) {
        HttpsUtils.socketTimeout = socketTimeout;
    }

    /**
     * 默认2秒
     * @param connectTimeout
     */
    public static void setConnectTimeout(int connectTimeout) {
        HttpsUtils.connectTimeout = connectTimeout;
    }
}