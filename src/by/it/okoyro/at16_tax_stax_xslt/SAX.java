package by.it.okoyro.at16_tax_stax_xslt;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {

	private StringBuilder text;
	private String tab = "";

	@Override
	public void startDocument() throws SAXException {
		text = new StringBuilder();
		System.out.println("START SAX");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("END SAX");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		StringBuilder at = new StringBuilder();
		int length = attributes.getLength();
		for (int i = 0; i < length; i++) {
			at.append(" ").append(attributes.getLocalName(i)).append("=").append(attributes.getValue(i));
		}
		System.out.println(tab + "<" + qName + at +">");
		tab = tab.concat("\t"); // добавить табулятор
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tab = tab.substring(1);  // удалить табулятор
		String out = text.toString().trim();
		if (!out.isEmpty()) {
			System.out.println(tab + out);
			text.setLength(0); // чистим StringBuilder
		}
		System.out.println(tab + "</" + qName + ">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}
}
