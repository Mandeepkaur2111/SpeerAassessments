package wikilink; 
	

	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Testbase.Testbase;

	

	public class WikiLink extends Testbase{
		public static void main(String[] args) {
			
			WebDriver dr = Testbase.getInstance();
			
	        String url = "http://en.wikipedia.org/wiki/";
	        HttpURLConnection huc = null;
	        int respCode = 200;
	        List<String> all_elements_text=new ArrayList<String>();
	        
			for(int i=1;i<=20;i++) {
				
				dr.get(url+i);
				try {
					huc = (HttpURLConnection)(new URL(url+i).openConnection());
	                
	                huc.setRequestMethod("HEAD");
	                
	                huc.connect();
	                
	                respCode = huc.getResponseCode();
	                if(respCode >= 400){
	                    System.out.println(url+" is a broken link");
	                }
	                else{
	                    System.out.println(url+" is a valid link");
	                    all_elements_text.add(url+i);
	                }
					
				} catch (MalformedURLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
				
			}
			// count the number of link on wikipedia and stored in the list data structure
			System.out.println("count of wiki links:");
			for (String r : all_elements_text) {
				System.out.println(r);
			}
			   //String url="";
			      List<WebElement> allURLs = driver.findElements(By.tagName("a"));
			      System.out.println("Total links on the Web Page: " + allURLs.size());

			      //We will iterate through the list and will check the elements in the list.
			      Iterator<WebElement> iterator = allURLs.iterator();
			      while (iterator.hasNext()) {
			    	  url = iterator.next().getText();
			    	  System.out.println(url);
			      }
		}
	}


