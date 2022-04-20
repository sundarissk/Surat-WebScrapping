package ExcelHandling;

import com.poiji.annotation.ExcelCellName;

public class Person {
	@ExcelCellName("Name")
	public String Name;
	@ExcelCellName("Age")
	private int age;
	@ExcelCellName("Gender")
	String Gender;
	@ExcelCellName("Location")
	String Location;

	public int getAge() {
		return age;
	}

	public int setAge(int age) {
		return this.age = age;
	}

	public String getName() {
		return Name;
	}

	public String setName(String name) {
		return Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public String setGender(String gender) {
		return Gender = gender;
	}

	public String getLocation() {
		return Location;
	}

	public String setLocation(String location) {
		return Location = location;
	}

	public Person m1() {
		return this;
	}
}
