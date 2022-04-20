package ExcelHandling;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

public class Runnerxl {
	public static void main(String[] args) {
		/*
		 * List<Person> person = new ArrayList<>(); File xl = new File(""); person =
		 * Poiji.fromExcel(xl, Person.class);
		 */

		PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().sheetName("Sheet1").build();
		List<Person> pp = Poiji.fromExcel(new File("Testdata1.xls"), Person.class, options);

		for(int i=0;i<=1;i++)
		{
		String Name = pp.get(i).getName();
		int age = pp.get(i).getAge();
		String Gender = pp.get(i).getGender();
		String Location = pp.get(i).getLocation();

		System.out.println("Name:" + Name);
		System.out.println("Age:" + age);
		System.out.println("Gender:" + Gender);
		System.out.println("Location:" + Location);
		System.out.println("****************************************************");
		}
	
	
		/*String Name = pp.get(2).addName("tamil");
		int age = pp.get(2).setAge(12);
		String Gender = pp.get(2).setGender("Ma/Fe");
		String Location = pp.get(2).setLocation("Madras");
		System.out.println("New record asucessfully added");
		
		System.out.println("Name:" + Name);
		System.out.println("Age:" + age);
		System.out.println("Gender:" + Gender);
		System.out.println("Location:" + Location);
		System.out.println("****************************************************");*/
	}

}
