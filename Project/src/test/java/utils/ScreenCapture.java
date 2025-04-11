package utils;
 
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenCapture {
       public static TakesScreenshot ts;
       
       /**
        * Author: Suhansh Bagre
        * Description: captures screenshot of whole webPage
        * @param filename


        * @return 
        */
       public static String takePageScreenShot(String filename) {

     String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
     String name = "/" + filename + timestamp + ".png";
     try {
      TakesScreenshot ts = (TakesScreenshot) Root.driver;
      File file = ts.getScreenshotAs(OutputType.FILE);
      File target = new File(System.getProperty("user.dir") + "/screenshots");
      // deleteAllFilesInsideDirectory(target.toString());
   // target.delete();
      if (!target.exists()) {
       target.mkdirs();
      }
      FileHandler.copy(file, new File(target.toString() + name));
      return target.toString()+name;
     } catch (Exception e) {
      LogHelper.error(e.getMessage());
     }
     return null;
    }


       
       /**
        * Author: Suhansh Bagre
        * Description: captures screenshot of a particular element of a webPage
        * @param filename


        * @return 
        */
       public static String takeElementScreenShot(By elementLocator, String fileName) {
     String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
       String name = "/" + fileName + timestamp + ".png";
       try {
   WebElement elementParam=Root.driver.findElement(elementLocator);
   File file = elementParam.getScreenshotAs(OutputType.FILE);
   File target = new File(System.getProperty("user.dir") + "/screenshots");
      if (!target.exists()){
       target.mkdirs();
      }
      FileHandler.copy(file, new File(target.toString() + name));
      return "."+name;
  } catch (Exception e) {
   LogHelper.error(e.getMessage());
  }   
       return null;
       }
       
       
       /**
        * Author: Suhansh Bagre
        * Description: Delete old files so that we can replace it with new files
        * @param dirPath
        * @return
        */
       public static void deleteAllFilesInsideDirectory(String dirPath) {


        File directory=new File(dirPath);
        if(directory.exists()) {
         File[] files=directory.listFiles();
         if(files!=null) {
          for(File file:files) {
           if(file.isFile()) {
            file.delete();
           }
          }
         }
        }
       }
}


