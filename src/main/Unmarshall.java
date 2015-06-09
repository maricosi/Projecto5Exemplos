package main;

import generated.ObjectFactory;
import generated.ReportType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Unmarshall {
	public static void main(String[] args) throws FileNotFoundException, JAXBException {
		
		System.out.println(unmarshal(ReportType.class, new FileInputStream(new File("report.xml"))));
	}


	public static <T> T unmarshal( Class<T> docClass, InputStream inputStream )
		    throws JAXBException {
		    String packageName = docClass.getPackage().getName();
		    JAXBContext jc = JAXBContext.newInstance( packageName );
		    Unmarshaller u = jc.createUnmarshaller();
		    JAXBElement<T> doc = (JAXBElement<T>)u.unmarshal( inputStream );
		    return doc.getValue();
	}
}


