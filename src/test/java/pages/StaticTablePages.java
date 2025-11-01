package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StaticTablePages {
	
	WebDriver driver;
	
	public StaticTablePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<List<String>> readAllDataFromTable(String tableXPath) {
		List<List<String>> allData = new ArrayList<>();
		List<WebElement> tableRows = driver.findElements(By.xpath(tableXPath));
		int rowCount = getRowCount(tableXPath);
		for(int r = 1; r <= rowCount; r++) {
			List <WebElement> tableColumns = tableRows.get(r).findElements(By.tagName("td"));
			List<String> rowData = new ArrayList<>();
			for(WebElement column: tableColumns) {
				String columnData = column.getText();
				rowData.add(columnData);
			}
			allData.add(rowData);
		}
		return allData;
	}
	
	public List<List<String>> readAllDataFromStaticTable() {
		return readAllDataFromTable("//table[@name='BookTable']//tr");
	}
	
	public int getRowCount(String tableXPath) {
		return driver.findElements(By.xpath(tableXPath)).size() - 1;
	}

}
