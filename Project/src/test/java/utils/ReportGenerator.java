package utils;
 
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ReportGenerator {
	
	private static ExtentReports extentReport;
	
	public static ExtentReports generateExtentReport(String reportName) {
        if (extentReport == null) {
            extentReport = createExtentReport(reportName);
        }
        return extentReport;
    }

	
	private static ExtentReports createExtentReport(String reportName) {
		extentReport=new ExtentReports();
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
      	String reportFilePath = System.getProperty("user.dir") + "/reports/";
      	ScreenCapture.deleteAllFilesInsideDirectory(reportFilePath);
      	reportFilePath += reportName + "_" + timestamp + ".html";
        File extentReportFile = new File(reportFilePath);
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
        sparkReporter.config().setTimeStampFormat("yyyy.MM.dd.HH.mm.ss");
        extentReport.attachReporter(sparkReporter);
        return extentReport;

	}
	
	public static void addScreenshotToReport(String fileName,ExtentTest test,String description) {
		test.log(Status.INFO, description,
                 MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.takePageScreenShot(fileName)).build());
	}

}
