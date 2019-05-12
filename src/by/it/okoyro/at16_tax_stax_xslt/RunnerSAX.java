package by.it.okoyro.at16_tax_stax_xslt;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class RunnerSAX {
	public static void main(String[] args) throws ParserConfigurationException, org.xml.sax.SAXException, IOException {

			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			String filename = "/Users/oksanakoyro/work/AT2019-03-12/src/by/it/okoyro/at15/sites.xml"; // xml doc from previous homework
			SAX handler = new SAX(); // экземпляр потомка Defaulthandler собственного класса SAX
			saxParser.parse(filename, handler);
		}
}
