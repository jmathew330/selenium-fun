package advanced;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.StaticTablePages;

public class StaticTable extends BaseTest {
	
	StaticTablePages sp;
	
	@Test
	public void readAllDataFromStaticTableTest() {
		sp = new StaticTablePages(driver);
		List<List<String>> actualTableData = sp.readAllDataFromStaticTable();
		List<List<String>> expectedTableData = List.of(
		        List.of("Learn Selenium", "Amit", "Selenium", "300"),
		        List.of("Learn Java", "Mukesh", "Java", "500"),
		        List.of("Learn JS", "Animesh", "Javascript", "300"),
		        List.of("Master In Selenium", "Mukesh", "Selenium", "3000"),
		        List.of("Master In Java", "Amod", "JAVA", "2000"),
		        List.of("Master In JS", "Amit", "Javascript", "1000")
		);
		Assert.assertEquals(actualTableData, expectedTableData);
	}

}
