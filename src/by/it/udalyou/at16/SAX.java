package by.it.udalyou.at16;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAX extends DefaultHandler {
    private String tab="";
    private StringBuilder text;

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        String filename="src/by/it/udalyou/at15/sites.xml";
        SAX hendler=new SAX();//??????
        saxParser.parse(filename,hendler);

    }

    @Override
    public void startDocument(){
        text=new StringBuilder();
        System.out.println("START SAX");
    }
    @Override
    public void endDocument(){
        System.out.println("END SAX");
    }
    @Override
    public void startElement(String uri,String localName,String qName, Attributes attributes){
        StringBuilder sb=new StringBuilder();
        int n=attributes.getLength();
        for (int i=0;i<n;i++){
                sb
                  .append(" ")
                  .append(attributes.getLocalName(i))
                  .append("=")
                  .append(attributes.getValue(i));
                 }
        System.out.println(tab+"<"+qName+sb+">");
        tab=tab.concat("\t");
          }
          @Override
    public void endElement(String uri,String localName,String qName){
        tab=tab.substring(1);
        String out=text.toString().trim();
        if (!out.isEmpty()){
            System.out.println(tab+out);
            text.setLength(0);
        }
              System.out.println(tab+"</"+qName+">");
          }
          @Override
    public void characters(char[] ch,int start, int lenth){
        text.append(ch,start,lenth);
          }
}
