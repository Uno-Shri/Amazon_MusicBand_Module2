package com.amazonMenu.testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.amazonMenu.pageObjects.SearchPage;

public class TC_SearchTest_001 extends BaseClass {
  @Test
  public void searchMenu() throws InterruptedException   
  {
    SearchPage lp =new SearchPage(driver);
	System.out.println("Entered in the class TC_Searchtest_001\n");
	

	//---------------for Hamburgermenu --------------------//
	  System.out.println("Hamurger Menu is clicked now\n");
	  lp.HamMenu();
	 
	//-------------for- Amazon Music-------------------//
	  System.out.println("AmazonMusic is clicked now\t\n");
	  lp.AmzMusic();
	 
	//---------for- verify title stream music is present----------//
		  
	  System.out.println("Title will be verified\n");
      lp.verifyTitle();
	
	 // ----------- for- Pod cast----------------------//
	  System.out.println("\n Podcasts is clicked now\n");
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  lp.PodcastsClick();

	
	//--------------for ListenNow--------------//
	  
	
	  System.out.println("\npageTitle before 'Listen now' button is clicked\t" + driver.getTitle());
	  
	  System.out.println("\nListenNow is clicked now\n");
	 
	  lp.ListenNowClick();
	  
	 
	  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	   // System.out.println(tabs);  ----will give total tabs opened by the driver in this session
       
	   
	//-----Driver is shifted to newly opened tab --by windows management method---//
	   driver.switchTo().window(tabs.get(1));
	 
	   System.out.println("\n pageTitle after driver switched\t" +driver.getTitle());
	   
	   driver.findElement(By.xpath("//input[@id='navbarSearchInput']")).click(); //--search is clicked to give input 
	   
	   
  //----------------INPUTS MUSIC NAME-----------------------------//
	   
	   lp.setMusicName(Musicname);
	   System.out.println("\nMusic name is given now"); 
	   
	
//----------------------CLick ON Search--------------------------//
	   lp.MusicSearchbtn();
	  
	   
//-------------------------classic rock playlist click---------//
	   try {
		lp.PlaylistClick();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   
 //-------------MUSIC BAND NAME IS LISTED ---//  

       lp.MusicBand();
      
  
  }



  
}
