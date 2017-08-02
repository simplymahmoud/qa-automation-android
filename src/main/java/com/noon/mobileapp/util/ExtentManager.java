//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

package com.noon.mobileapp.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	
	private ExtentManager(){}

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d= new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			//extent = new ExtentReports(FKConstants.REPORT_PATH+fileName, true, DisplayOrder.NEWEST_FIRST);
			extent = new ExtentReports(System.getProperty("user.dir") + "/target/Reports/report.html"+fileName, true, DisplayOrder.NEWEST_FIRST);

			// optional
		//	extent.config().documentTitle("Automation Report")
		//			.reportName("Regression").reportHeadline("");
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53").addSystemInfo(
					"Environment", "STAGING");
		}
		return extent;
	}
}
