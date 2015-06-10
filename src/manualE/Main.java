package manualE;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class Main {

	
	public static void main (String[] arg){
		
		List<Student> students =  new ArrayList<Student>();
		students.add(new Student("Alberto",21, 201134441110L));
		students.add(new Student("Patricia",22,201134441116L));
		students.add(new Student("Luis",21,201134441210L));
		
		try{
			File f=new File("StudentE.xml");
			FileOutputStream out= new FileOutputStream(f);
			marshalXML(out, students);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	
	public static void marshalXML(OutputStream out, List<Student> s) throws Exception{
	  
		String context = "manualE";

		JAXBContext jc = JAXBContext.newInstance(context);
		ObjectFactory factory = new ObjectFactory();
		Class classe= factory.createClass();
		classe.getStudents().addAll(s);
		
		Marshaller m = jc.createMarshaller();
	
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		m.marshal(classe, out);

	}
}
