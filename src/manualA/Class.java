package manualA;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="class", propOrder={"students"})
@XmlRootElement(name="class")
public class Class {

	@XmlElement(name="student")
	protected List<Student> students;

	public List<Student> getStudents() {
		if(students==null){
			students=new ArrayList<Student>();
		}

		return students;
	}




}
