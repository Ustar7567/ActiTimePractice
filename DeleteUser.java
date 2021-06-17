package com.krn.actitime.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class DeleteUser extends BaseClass{
  @Test
  public void deleteUser() throws InterruptedException {
	
	  driver.findElement(By.id("container_users")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  WebElement findBtn=driver.findElement(By.xpath("//span[text()='Show disabled accounts']/../../../../../../../..//div[@class='icon']"));
	  wait.until(ExpectedConditions.elementToBeClickable(findBtn));
	  findBtn.click();
	  Thread.sleep(2000);
	  WebElement searchBtn= driver.findElement(By.xpath("(//input[@placeholder='Start typing name...'])[1]"));
	  searchBtn.sendKeys("Manju");
	  Thread.sleep(2000);
	  
	  WebElement mgUser=driver.findElement(By.xpath("//span[text()='Manju']/../../../../../../../../../..//div[@class='icon manageUsers']"));
	  wait.until(ExpectedConditions.elementToBeClickable(mgUser));
	  mgUser.click();
	  
	  WebElement dltUser=driver.findElement(By.xpath("//div[text()='DELETE']"));
	  wait.until(ExpectedConditions.elementToBeClickable(dltUser));
	  dltUser.click();
	  
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert delAlert=driver.switchTo().alert();
	  delAlert.accept();
	  Thread.sleep(5000);
  }
}
