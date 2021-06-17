package com.krn.actitime.users;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.BaseClass;

public class CreateUser extends BaseClass{
  @Test
  public void createUser() throws InterruptedException {
	  driver.findElement(By.id("container_users")).click();
	  driver.findElement(By.xpath("//div[text()='New User']")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement firstname=driver.findElement(By.id("createUserPanel_firstNameField"));
	  wait.until(ExpectedConditions.visibilityOf(firstname));
	  firstname.sendKeys("Manju");  
	  driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys("Sha");
	  driver.findElement(By.id("createUserPanel_emailField")).sendKeys("manjusha703@gmail.com");
	  driver.findElement(By.id("createUserPanel_emailField")).sendKeys(Keys.ENTER);
	  
	  WebElement save=driver.findElement(By.xpath("//div[text()='Save & Send Invitation']"));
	  wait.until(ExpectedConditions.elementToBeClickable(save));
	  Actions act=new Actions(driver);
	  act.moveToElement(save);
	  //act.doubleClick();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", save);
	  
	  WebElement close= driver.findElement(By.xpath("(//span[text()='Close'])[1]"));
	  wait.until(ExpectedConditions.elementToBeClickable(close));
	  close.click();
	  
  }
}
