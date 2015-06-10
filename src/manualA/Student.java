package manualA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="student", propOrder={"name","age"})
public class Student {
	
	@XmlElement(required=true)
	protected String name;
	@XmlElement(required=true)
	protected int age;
	
	
	public Student() {
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
}
