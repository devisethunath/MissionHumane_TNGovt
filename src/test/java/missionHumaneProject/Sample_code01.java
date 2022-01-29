package missionHumaneProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class Sample_code01 {
	
	WebDriver driver= null;




    @BeforeTest
    public void beforeTest() throws InterruptedException  {
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
               LocalDateTime now = LocalDateTime.now();  
               System.out.println("Start Time:" + dtf.format(now)); 
               
               System.setProperty("webdriver.chrome.driver", "C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
    }


    
    public class FacilityDetails {
            private String facility;
            private String distributorName;
            private String contactInfo; 
            private String links ;
            private String status ;
            private String comment ;
            private String caller;


            public String getFacility() {return facility;}
            public void setFacility(String facility) { this.facility = facility; }


            public String getDistributorName() {return distributorName;}
            public void setDistributorName(String distributorName) { this.distributorName = distributorName; }


            public String getContactInfo(){return contactInfo;}
            public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }


            public String getLinks(){return links;}
            public void setLinks(String links) { this.links = links; }


            public String getStatus(){return status;}
            public void setStatus(String status) { this.status = status; }


            public String getComment() {return comment;}
            public void setComment(String comment ) { this.comment = comment; }


            public String getCaller() {return caller;}
            public void setCaller(String caller) { this.caller = caller; }
    }


    @Test
    public void f() throws FileNotFoundException, InterruptedException{ 


            driver.navigate() .to("website ");


            System.out.println("Navigate to website name");
            Thread.sleep(7000);
            
            Reporter.log(" homepage lanched succussefully");


            driver.findElement(By.xpath("// span[normalize-space()='National Resources']")).click();
            Thread.sleep(7000);
            
            //driver.findElement(By.xpath("// span[normalize-space()='view in Sheet']")).click();


            driver.navigate().to("https://docs.google.com/spreadsheets/d/e/2PACX-1vRR1glENQvCEZN8H7PzCq3bjSr2bQIIodVOd2kPmGy-wD0JMIFTHXVj8eLr0gW0Ya9UAO7Fti6XTUiz/pubhtml?gid=0&single=true");
            // trying to navigate table by using below xpath 
            //List<WebElement> tbls = driver.findElements(By.tagName("table"));
            WebElement tblData= driver.findElement(By.xpath("//body/div[@id='sheets-viewport']/div[@id='0']/div[1]/table[1]")); 
            List<WebElement> rowVals = tblData.findElements(By.tagName("tr"));




            // create instance of our facilityDetails class to store all data for a facility
            //check




            Thread.sleep(7000);




            
            Map<Integer,FacilityDetails> facilityMap =new HashMap<Integer,FacilityDetails>();
                            List<WebElement> tbls = driver.findElements(By.tagName("table"));
                            for (WebElement currTbl : tbls) {


                    int index=1;


                    List<WebElement> rowList=
                                    currTbl.findElements(By.tagName("tr"));
                    List<WebElement>columnsList = null;


                    int dictIndex=0;
                    
                    for (WebElement row : rowList) {


                            dictIndex++;
                            
                            columnsList  =        row.findElements(By.tagName("td"));


                            
                            if (index <4)
                            {
                                    index++;
                                    continue;


                            }


                            
                            if (index>22) {


                                    break;
                            }
                            index++;


                            
                            int colPosition=0;
                            
                            FacilityDetails f = new FacilityDetails();
                            for (WebElement column : columnsList) {


                                    if ( colPosition ==0)
                                    {f.setFacility(column.getText());}
                                    else if(colPosition==1)
                                    {f.setDistributorName(column.getText());}
                                    else if (colPosition==2)
                                    {f.setContactInfo(column.getText());}
                                    else if (colPosition==3)
                                    {f.setLinks(column.getText());}
                                    else if (colPosition==4)
                                    {f.setStatus(column.getText());}
                                    else if (colPosition==5)
                                    {f.setComment(column.getText());}
                                    else if (colPosition==6)
                                    {f.setCaller(column.getText());}
                                    colPosition++;
                            }
                            // add facility to dictionary
                            facilityMap.put(dictIndex, f);
                    }
                    
                    System.out.println("Size:" + facilityMap.size());
                    //Test code to print value in console
                    for (FacilityDetails fkey : facilityMap.values())
                    {
                            
                            System.out.println(fkey.getFacility());
                            System.out.println(fkey.getDistributorName());
                            System.out.println(fkey.getContactInfo());
                            System.out.println(fkey.getLinks());
                            System.out.println(fkey.getStatus());
                            System.out.println(fkey.getComment());
                            System.out.println(fkey.getCaller());
                            
                    }        
                                            break;
            }


                            try (
                            FileWriter writer = new FileWriter("c:/Bhagyashree/UncutTeam.csv")){
                    for (FacilityDetails fkey : facilityMap.values())
                    {
                            writer.append(quoteString(fkey.getFacility()) + "," + 
                                            quoteString(fkey.getDistributorName()) + "," + 
                                            quoteString(fkey.getContactInfo())+ "," + 
                                            quoteString(fkey.getLinks()) + "," + 
                                            quoteString(fkey.getStatus()) + "," + 
                                            quoteString(fkey.getComment()) + "," + 
                                            quoteString(fkey.getCaller()));
                            writer.append('\n');
                    }        
            } catch (FileNotFoundException e) {
                    throw e;                 } catch (IOException e) {
                    System.err.print("Something went wrong");
            }


    }


        private String quoteString(String str) {
            return "\"" + str + "\"";
    }




    @AfterTest
    public void afterTest() {


//            driver.close();
//            driver.quit();
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
               LocalDateTime now = LocalDateTime.now();  
               System.out.println("End Time:" + dtf.format(now)); 
    }



}
