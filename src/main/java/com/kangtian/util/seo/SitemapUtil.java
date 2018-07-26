package com.kangtian.util.seo;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.tree.DefaultDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**使用本工具请加载jar包org.dom4j
 * 使用方法请看main方法
 * sitemap文件例子可看：
 * https://www.zulily.com/sitemap.xml
 */
public  class SitemapUtil {

    //xml文件头xmlns属性值：例<sitemapindex xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
    private static String xmlns ="com.kangtian.util.http://www.sitemaps.org/schemas/sitemap/0.9";
    //存放文件路径：可为/aaa/bbb/等，最后位必须带/符号
    private static final String filePath="E:/aa/";
    //private static final String filePath=System.getenv("SITE_MAP_PATH");//可通过环境变量拿
    //生成xml文件的编码
    private static final String encode="gbk";

    //以上值可按情况修改

    //用于记录子sitemap文件名，最后用于生成主sitemap文件
    private static ArrayList<String> childSitemaps=new ArrayList<String>();
    //先声明节点
   private static Element urlElement;
   private static Element locElement;
   private static Element freqElement;
   private static Element priElement;

    /**
     * 使用示例
     * @param args
     */
    public static void main(String[] args){

        //初始化document，并赋予带namespace的根节点
        Document document=new DefaultDocument();
        //xmlns即命名空间
        Element root=document.addElement("urlset",xmlns);
        document.setRootElement(root);

        //写入n个子sitemap文件的示例========================
        boolean isOk=false;
        for (int i=1;i<20;i++) {
            //构建document
            for (int j = 0; j < 50000; j++) {
                createChildDom(root, "https://www.scut.edu.cn/new/gasdvgaswcsfes" + j, "weekly", "0.9");
            }
            //写入文件
             isOk =   SitemapUtil.createChoildSitemap(document, "sitemap-child-"+i+".xml");
            if (!isOk){
                //生成出错
            }
        }
        //=====================================================

       //写入主sitemap
        isOk= SitemapUtil.createMainSitemap();
        if (!isOk){
            //生成出错
        }

    }






    /**
     * 创建主sitemap文件，该方法应该在生成所有子sitemap文件调用。
     */
    public static   boolean  createMainSitemap(){
       Document document=new DefaultDocument();
        Element root=document.addElement("sitemapindex",xmlns);
       for (int i=0;i<childSitemaps.size();i++){
            Element sitemap=root.addElement("sitemap");
            Element loc=sitemap.addElement("loc");
            loc.setText(childSitemaps.get(i));
        }
        try {
            writeDocument("sitemap.xml",document);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            //清空根节点下的所有内容
            if (document.hasContent())
                document.clearContent();
        }
        return true;
    }


    public static   boolean createChoildSitemap(Document document ,String filename){
        try {
            writeDocument(filename,document);
            childSitemaps.add(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            //清空根节点下的所有内容
            if (document.hasContent()&&document.getRootElement().hasContent())
                document.getRootElement().clearContent();
        }
        return true;
    }

    /**
     * 将document写入 filePath目录下的fileName文件里
     * @param fileName
     * @param document
     * @throws IOException
     */
    private static   void writeDocument( String fileName,Document document) throws IOException {
        File file=new File(filePath);
        document.setXMLEncoding(encode);
        recursionMkDir(file);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(new File(filePath+fileName)));
        document.write(outputStreamWriter);
        //如果outputStreamWriter未关闭，则关闭outputStreamWriter
        if (outputStreamWriter!=null)
        outputStreamWriter.close();
    }

    /**
     * 创建子sitemap的节点，并将其挂载到root节点
     * 例：<url>
     * <loc>https://www.zulily.com/baby-boy-outerwear</loc>
     * <changefreq>daily</changefreq> 值只能为always, hourly, daily, weekly, monthly, yearly及never
     * <priority>0.4</priority>数值为0到1.0，最高为1.0，一般首页的priority最高为1.0
     * </url>
     * @param root
     * @param url
     * @param changefreq
     * @param priority
     */
    private  static void createChildDom(Element root,String url,String changefreq ,String priority){
        urlElement=root.addElement("url");
        locElement=urlElement.addElement("loc");
        freqElement=urlElement.addElement("changefreq");
        priElement=urlElement.addElement("priority");
        locElement.setText(url);
        freqElement.setText(changefreq);
        priElement.setText(priority);
    }

    //递归创建目录
    private static void recursionMkDir(File file) {
        if (file.getParentFile().exists()) {
            file.mkdir();
        } else {
            recursionMkDir(file.getParentFile());
            file.mkdir();
        }
    }

}
