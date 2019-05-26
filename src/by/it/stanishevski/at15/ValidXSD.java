package by.it.stanishevski.at15;

import org.xml.sax.SAXException;

import javax.xml.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class ValidXSD {
    public static void main(String[ ] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName =   "C:/AT2019-03-12/src/by/it/stanishevski/at15/sites.xml";
        String schemaName = "C:/AT2019-03-12/src/by/it/stanishevski/at15/sites.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
            // создание валидатора на основе схемы
            Validator validator = schema.newValidator();
            // проверка документа
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " валиден.");
        } catch (SAXException e) {
            System.err.print("Валидация "+ fileName + " не выполена: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " не валиден:"
                    + e.getMessage());
        }
    }
}