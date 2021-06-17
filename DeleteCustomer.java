package com.krn.actitime.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class DeleteCustomer extends BaseClass {
	@Test
	public void deleteCustomerTask() throws InterruptedException {
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("Manju");
		WebElement custToDel = driver.findElement(By.xpath("(//span[text()='Manju'])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(custToDel));
		Actions act=new Actions(driver);
		custToDel.click();
		WebElement settingsBtn=driver.findElement(By.xpath("//div[@title='Manju']/..//div[@class='editButton']"));	
		wait.until(ExpectedConditions.elementToBeClickable(settingsBtn));
		act.moveToElement(settingsBtn);
		settingsBtn.click();
		
		WebElement actionBtn=driver.findElement(By.xpath("//div[@class='nameLabel' and text()='Manju']/../../..//div[@class='action']"));
		wait.until(ExpectedConditions.elementToBeClickable(actionBtn));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", actionBtn);
		
        WebElement dltBtn= driver.findElement(By.xpath("(//div[@class='action'])[1]/../../../../../..//div[text()='Delete']"));
        wait.until(ExpectedConditions.elementToBeClickable(dltBtn));     
		js.executeScript("arguments[0].click();", dltBtn);
		
        WebElement dltPrm=driver.findElement(By.xpath("//span[text()='Delete permanently']"));
        wait.until(ExpectedConditions.elementToBeClickable(dltPrm));
		js.executeScript("arguments[0].click();", dltPrm);
        Thread.sleep(5000);
	}
}
