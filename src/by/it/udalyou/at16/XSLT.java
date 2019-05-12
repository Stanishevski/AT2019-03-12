package by.it.udalyou.at16;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XSLT {
    public static void main(String[] args) throws IOException, TransformerException {
        String xslPath = "src/by/it/udalyou/at16/ruls.xsl";
        String xmlPath = "src/by/it/udalyou/at15/sites.xml";
        String htmlPath = "src/by/it/udalyou/at16/result.html";
        TransformerFactory factory=TransformerFactory.newInstance();
        StreamSource xml=new StreamSource(new FileReader(xslPath));
        Transformer transformer=factory.newTransformer(xml);
        transformer.transform(new StreamSource(new FileReader(xmlPath)),
                new StreamResult(new FileWriter(htmlPath)));

    }
}
