package com.kangtian.util.xml;


import com.kangtian.util.file.FileUtil;
import com.kangtian.util.http.HttpUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.tree.DefaultDocument;

import java.util.List;
import java.util.ListIterator;


public class BuildMDHref {


    public static void main(String[] args) throws DocumentException, InterruptedException {
        StringBuffer stringBuffer=new StringBuffer();
        Document  document=  DocumentHelper.parseText(FileUtil.readFileToStr("E:\\hexo\\blog\\public/sitemap.xml"));
        List<Element> list = document.getRootElement().elements("url");
        String line;
        String url;
        int k=0;
        HttpUtils.setUserAgent("Mozilla/5.0 (compatible;Baiduspider-render/2.0; +http://www.baidu.com/search/spider.html)");
       // while (true)
       for(int i=0;i<list.size();i++){
           line=list.get(i).element("loc").getText().substring(25);
//           url="http://kangtian.coding.me"+line;
//
//           Thread.sleep(2000);
//           HttpUtils.sendGet(url);
////           url="http://pankangtian.github.io"+line;
////           Thread.sleep(1000);
//           HttpUtils.sendGet(url);
//           Thread.sleep(1000);
//           url="http://pankangtian.gitee.io"+line;
//           HttpUtils.sendGet(url);
//           System.out.println(i );

        stringBuffer.append("[&nbsp;&nbsp;](").append("http://kangtian.coding.me").append(line).append(")  &nbsp;&nbsp;&nbsp; ");
        stringBuffer.append("[&nbsp;&nbsp;](").append("http://pankangtian.github.io").append(line).append(")  &nbsp;&nbsp;&nbsp;");
        stringBuffer.append("[&nbsp;&nbsp;](").append("http://pankangtian.gitee.io").append(line).append(")  &nbsp;&nbsp;&nbsp;");

           if (i%9==8)
            stringBuffer.append("\n");

       }
       System.out.println(stringBuffer.toString());
    }
}
