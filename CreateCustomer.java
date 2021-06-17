package com.krn.actitime.tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class CreateCustomer extends BaseClass {
	@Test
	public void createCustomerTask() throws InterruptedException {
		
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
		driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']"))
				.sendKeys("Manju");
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']"))
				.sendKeys("This is test description");
		driver.findElement(By.xpath("//div[@class='components_button_label' and text()='Create Customer']")).click();
		Thread.sleep(5000);
		
	}
}
