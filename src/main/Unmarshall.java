package main;


import generated.DirectionType;
import generated.MetricDataType;
import generated.ObjectFactory;
import generated.ReportType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;




import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Unmarshall {
	public static void main(String[] args) throws Exception {

		System.out.println(unmarshal(ReportType.class, new FileInputStream(new File("report.xml"))));
		
		
		OutputStream f=new FileOutputStream(new File("Teste.xml"));
		marshalXML(f);
	}


	public static <T> T unmarshal( Class<T> docClass, InputStream inputStream )
			throws JAXBException {
		String packageName = docClass.getPackage().getName();
		JAXBContext jc = JAXBContext.newInstance( packageName );
		Unmarshaller u = jc.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<T> doc = (JAXBElement<T>)u.unmarshal( inputStream );
		return doc.getValue();
	}


	public static void marshalXML(OutputStream out) throws Exception{

		  
		String context = "generated";
		
		JAXBContext jc = JAXBContext.newInstance(context);
		
		ObjectFactory factory = new ObjectFactory();
		ReportType report = factory.createReportType();

		report.getMetricData().add(new MetricDataType("Ricardo",-2,0.2f,"float","flops","spoof",DirectionType.DGSG_BOINC));
		report.getMetricData().add(new MetricDataType("Marisa",156789123,0.2f,"float","flops","spoof",DirectionType.DGSG_BOINC));
		

		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

		// Write the XML File
		m.marshal(report, out);

	}
}


