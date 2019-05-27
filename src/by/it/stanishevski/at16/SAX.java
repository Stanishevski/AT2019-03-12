package by.it.stanishevski.at16;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



public class SAX extends DefaultHandler {
    private String tab ="";
    private StringBuilder text;



    @Override
    public void startDocument() throws SAXException {
        text=new StringBuilder();
        System.out.println("Start SAX:");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End SAX:");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(tab+"<"+qName+">");
        tab=tab.concat("\t");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tab=tab.substring(1);
        String out = text.toString().trim();
        if (!out .isEmpty()) {
            System.out.println(tab+out);
            text.setLength(0);
        }
        System.out.println(tab+"</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);

    }
}
