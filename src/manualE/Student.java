package manualE;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="student", propOrder={"name","age"})
public class Student {
	
	@XmlElement(required=true)
	protected String name;
	@XmlElement(required=true)
	protected int age;
	@XmlAttribute
	protected Long id;
	
	
	

	public Student() {
	}


	public Student(String name, int age, Long id) {

		this.name = name;
		this.age = age;
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString (){
		return "name: " +name+ "---idade: " +age;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
