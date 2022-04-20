package Surat_hospital_details;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import ExcelHandling.excel_utility;

public class hospital3 {
	static String path = "C:\\Users\\skuma\\eclipse-workspace\\Web_scrapping\\src\\main\\java\\ExcelHandling\\Hospital Details.xlsx";

	static WebDriver driver = null;
	// public XSSFWorkbook workbook;
	static {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\skuma\\eclipse-workspace\\Web_scrapping\\src\\main\\resources\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://office.suratsmartcity.com/SuratCOVID19/Home/COVID19BedAvailabilitydetails");
		driver.manage().window().maximize();
	}

	public hospital3(String path) {

		super();
		System.out.println(path);
	}

	public void hos_det() throws InterruptedException, IOException {

		Select zonecont = new Select(driver.findElement(By.xpath("//select[@id='ddlZone']")));
		int zone_count = zonecont.getOptions().size();
		System.out.println("No of zone:" + zone_count);
		System.out.println(driver);
		System.out.println(path);

		// Select zone= new
		// Select(driver.findElement(By.xpath("//select[@id='ddlZone']")));

		// for(int a =2;a<=zone_count;a++) {

		// String path =
		// "C:\\Users\\skuma\\eclipse-workspace\\Web_scrapping\\src\\main\\java\\ExcelHandling\\Hospital
		// Details.xlsx";

		excel_utility excelutil = new excel_utility(path);
		System.out.println("Read 2 :" + path);

		// workbook = new XSSFWorkbook(path);

		// excelutil.addSheet("example1");

		excelutil.setCellData("example3", 0, 0, "Hospital Name");
		excelutil.setCellData("example3", 0, 1, "Hospital Address");
		excelutil.setCellData("example3", 0, 3, "Contact No");
		excelutil.setCellData("example3", 0, 4, "Bed");
		excelutil.setCellData("example3", 0, 5, "Vocant");
		excelutil.setCellData("example3", 0, 6, "Ward");
		excelutil.setCellData("example3", 0, 7, "OZ");
		excelutil.setCellData("example3", 0, 7, "Ventilator");

		Select zoneselect = new Select(driver.findElement(By.xpath("//select[@id='ddlZone']")));
		zoneselect.selectByValue("3");

		int listlen = driver.findElements(By.xpath("//div[@class='card custom-card']")).size();
		System.out.println("Total no of hospital " + listlen);

		for (int i = 1; i <= listlen; i++) {

			// Clicking Hospital from the list
			WebElement hospital = driver.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//a"));
			hospital.click();
			Thread.sleep(2000);

			// Reading Hospital Name
			WebElement hospname = driver.findElement(By.xpath("//div[@class ='modal-content']//div//h5//label"));
			String hospn = hospname.getText();
			System.out.println(hospn);

			// Reading Hospital Address
			WebElement hospaddress = driver.findElement(By.xpath("//div[@class ='modal-content']//div//li[1]//label"));
			String hospadd = hospaddress.getText();
			System.out.println(hospadd);

			// Reading Hospital Contact
			WebElement contact = driver
					.findElement(By.xpath("//div[@class ='modal-content']//div//li[2]//span[@id='lblhosCno']"));
			String contactdet = contact.getText();
			System.out.println(contactdet);

			// Closing address popup
			WebElement closepop = driver.findElement(By.xpath("//button[@class='close']"));
			closepop.click();
			Thread.sleep(2000);

			// Finding total bed avaliable
			WebElement bedd = driver.findElement(
					By.xpath("//div[@class = 'card custom-card'][" + i + "]/div//span[@class='count-text']"));
			String bedtot = bedd.getText();
			System.out.println(bedtot);

			// Finding total Vocant
			WebElement vocant = driver.findElement(
					By.xpath("//div[@class='card custom-card'][" + i + "]//div//span[@class='count-text pr-2']"));
			String vocanttot = vocant.getText();
			System.out.println(vocanttot);

			// Finding Ward Avaliability
			WebElement ward = driver
					.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//ul/li[1]//div[2]"));
			String wardto = ward.getText();
			System.out.println(wardto);

			// Finding Oxygen Avaliability
			WebElement oz = driver
					.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//ul/li[2]//div[2]"));
			String totaloz = oz.getText();
			System.out.println(totaloz);

			// Finding Ventilator Avaliability
			WebElement Ventilator = driver
					.findElement(By.xpath("//div[@class='card custom-card'][" + i + "]//ul/li[4]//div[2]"));
			String ven = Ventilator.getText();
			System.out.println(ven);

			System.out.println("***********************************************************");
			Thread.sleep(1000);

			excelutil.setCellData("example3", i, 0, hospn);
			excelutil.setCellData("example3", i, 1, hospadd);
			excelutil.setCellData("example3", i, 3, contactdet);
			excelutil.setCellData("example3", i, 4, bedtot);
			excelutil.setCellData("example3", i, 5, vocanttot);
			excelutil.setCellData("example3", i, 6, wardto);
			excelutil.setCellData("example3", i, 7, totaloz);
			excelutil.setCellData("example3", i, 7, ven);

			// driver.quit();
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		hospital3 run = new hospital3(path);
		run.hos_det();

		driver.quit();
	}
}