package by.it.stanishevski.at16;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class RunnerSAX {



    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {





            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            String fileName = "src/by/it/stanishevski/at16/sites.xml";
            SAX handler = new SAX();
            saxParser.parse(fileName, handler);

    }
}
