package manualC;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlSchema;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="class",  propOrder={"students"})
@XmlRootElement(name="class")
@XmlSchema(namespace="http://dei.uc.pt/EAI")
public class Class {

	@XmlElement(name="student",namespace="")
	protected List<Student> students;

	public List<Student> getStudents() {
		if(students==null){
			students=new ArrayList<Student>();
		}

		return students;
	}




}
