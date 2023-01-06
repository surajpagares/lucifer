package Demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener implements ITestListener {
	ExtentReports ee;
	
//	It will monitor the Listener class example when it is starting and ending
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String name = result.getName();
//		Perticular test case monitor
		test = ee.createTest(name);
	}

	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		test.log(Status.PASS, name + "-------Pass");
	}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		test.log(Status.FAIL, name + "-------Fail");
	}

	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		test.log(Status.SKIP, name + "-------Skipped");
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\Reports" + 2 + ".html");
		
//		To provide title of the report
		esr.config().setDocumentTitle("Final Extent Report");

//		To providing the Theme or color
		esr.config().setTheme(Theme.STANDARD);

//		Providing reporter name
		esr.config().setReportName("Suraj");

//		Extra relavent Information of the report
		ee = new ExtentReports();

		ee.attachReporter(esr);

		ee.setSystemInfo("System", "Windows");

	}

	public void onFinish(ITestContext context) {
		ee.flush();
	}

}
