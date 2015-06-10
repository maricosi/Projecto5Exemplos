package main;


import generated.DirectionType;
import generated.MetricDataType;
import generated.ObjectFactory;
import generated.ReportType;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;









import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;



public class Unmarshall {
	public static void main(String[] args) throws Exception {

		System.out.println(unmarshal(ReportType.class, new FileInputStream(new File("report.xml"))));
		
		
		OutputStream f=new FileOutputStream(new File("Teste.xml"));
		marshalXML(f);
	}


	public static <T> T unmarshal( Class<T> docClass, InputStream inputStream )
			throws JAXBException, SAXException {
		String packageName = docClass.getPackage().getName();
		JAXBContext jc = JAXBContext.newInstance( packageName );
		Unmarshaller u = jc.createUnmarshaller();
		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("report.xsd")); 
		u.setSchema(schema);
		
		@SuppressWarnings("unchecked")
		JAXBElement<T> doc = (JAXBElement<T>)u.unmarshal( inputStream );
		return doc.getValue();
	}


	public static void marshalXML(OutputStream out) throws Exception{

		  
		String context = "generated";
		
		JAXBContext jc = JAXBContext.newInstance(context);
		
		ObjectFactory factory = new ObjectFactory();
		ReportType report = factory.createReportType();

		report.getMetricData().add(new MetricDataType("Ricardo",2,0.2f,"float","flops","spoof",DirectionType.DGSG_BOINC));
		report.getMetricData().add(new MetricDataType("Marisa",156789123,0.2f,"float","flops","spoof",DirectionType.DGSG_BOINC));
		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("report.xsd")); 
		
		Marshaller m = jc.createMarshaller();
		m.setSchema(schema);
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

		// Write the XML File
		m.marshal(report, out);

	}
}


