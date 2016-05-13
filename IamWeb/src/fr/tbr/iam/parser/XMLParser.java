package fr.tbr.iam.parser;

import java.net.URL;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLParser {

    public XMLParser()
    {
       
       
    }
    public String parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        System.out.println(url);
        Document document = reader.read(url);
       
        String res = "";
        Element root = document.getRootElement();

        for ( Iterator i = root.elementIterator( "field" ); i.hasNext(); ) {
            Element foo = (Element) i.next();
            String inputText="<input ";
            for ( Iterator j = foo.attributeIterator(); j.hasNext(); )
            {
                Attribute attribute = (Attribute) j.next();
               
               
                if(attribute.getName() == "type" )
                {
                    if(attribute.getText().equals("hidden"))
                    {
                        res += "<div style='display: none;' class='form-group col-md-6 col-sm-6 col-xs-12 wow' data-wow-delay='.2s'>";
                    }
                    else
                    {
                        res += "<div style='display: block;' class='form-group col-md-6 col-sm-6 col-xs-12 wow' data-wow-delay='.2s'>";
                    }
                }
                if(attribute.getName() == "required" && attribute.getText()=="true")
                {
                    inputText += " required ";
                }
                else if(attribute.getName() == "readonly" && attribute.getText()=="true")
                {
                    inputText += " readonly ";
                }
                else
                {
                    inputText += attribute.getName() + "='" + attribute.getText() + "' ";
                }
               
               }
                res += inputText+" /> </div>";
            }
        res += "<button class='btn btn-lg btn-success btn-block' type='submit'>Submit</button>";
        return res;
    }
   
 
}
