package com.ldd;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * 把一个Java对象转换成XML文件
 * Created by Administrator on 2017/12/4.
 */
public class JavaToXML {

    public void CreateXMLByDOM4J(File dest){
        //创建Document对象
        Document document = DocumentHelper.createDocument();
        //创建根节点
        Element rss = document.addElement("rss");
        //为rss根节点添加属性
        rss.addAttribute("version","2.0");
        //创建channel子节点
        Element channel = rss.addElement("channel");
        //创建title子节点
        Element title = channel.addElement("title");
        //设置title节点的值
        title.setText("<![CDATA[西安电子科技大学计算机出品]]>");
        //创建输出格式（OutputFormat对象）
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置输出文件的编码
        //format.setEncoding("GBK");

        try {
            //创建XMLWriter对象
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(dest),format);
            //设置不自动进行转义
            xmlWriter.setEscapeText(false);
            //生成XML文件
            xmlWriter.write(document);
            //关闭XMLWriter对象
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JavaToXML javaToXML = new JavaToXML();
        javaToXML.CreateXMLByDOM4J(new File("E:/master/JavaAndXML/s.xml"));
    }
}