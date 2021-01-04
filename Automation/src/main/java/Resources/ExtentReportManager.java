package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
public class ExtentReportManager {
public static ExtentReports report;
	
	public static ExtentReports getReportInstance(){
		
		if(report == null){
			String reportName = DateUtils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "\\reports\\" + reportName);
			report =  new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("Kavitha Thangaraj", "873201");
			report.setSystemInfo("Kevin Simon", "873466");
			report.setSystemInfo("Krishna Prakash", "873115");
			report.setSystemInfo("Megashree", "873477");
			report.setSystemInfo("Teja Kamasani", "873221");
			
			htmlReporter.config().setDocumentTitle("UI Automation Results");
			htmlReporter.config().setReportName("UI Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
		
		return report;
	}
}
