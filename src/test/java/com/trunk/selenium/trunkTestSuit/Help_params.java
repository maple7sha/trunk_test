package com.trunk.selenium.trunkTestSuit;

import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Help_params {
	public String get_sample_txt(){
		return "C:\\Users\\VEK\\Desktop\\sample.txt";
	}
	
	public String get_sample_jpg(){
		return "C:\\Users\\VEK\\Desktop\\sample.jpg";
	}
	
	public String get_baseUrl(){
		return "https://trunk-stage.tufts.edu/";
	}
	public String get_uploadtxt_text(){
		return "this is to upload a .txt file";
	}
	
	public String get_cpright_text(){
		return "copyright owned by the file producers";
	}
	
	public String get_search_text(){
		return "news";
	}
	
	public String get_saysth_text(){
		return "I am happy today";
	}
	
	public WebDriver get_driver(WebDriver driver){
		//String Xport = System.getProperty("importal.xvfb.id", ":1");
		//FirefoxBinary firefoxBinary = new FirefoxBinary();
		
		
		driver = new FirefoxDriver();
		return driver;
	}
}
