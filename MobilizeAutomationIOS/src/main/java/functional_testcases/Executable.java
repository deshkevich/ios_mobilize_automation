package functional_testcases;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Listeners;
import org.testng.collections.Lists;

import utility.Constant;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class, TestListenerAdapter.class })
public class Executable {

	public static void main(String[] args) {
		if (args.length == 1) {
			Constant.PATH_TESTDATA = args[0]; 
		}
		if (args.length == 2) {
			System.setProperty("Device", args[1]);
		}
		{
			System.setProperty("atu.reporter.config", Constant.PATH_TESTDATA
					+ "/ATUReporter_Selenium_testNG_5.5 BETA + ATU Recorder 2.1+javadoc+propfile/atu.properties");
		}
		
		if (args.length == 3) {
			System.out.println(args[2]);
			System.setProperty("xmlfilename",args[2]);
			}
		try {
			TestListenerAdapter tla = new TestListenerAdapter();
			// Create object of TestNG Class

			TestNG testng = new TestNG();
			// testng.setTestClasses(new Class[] { Parallel_Test.class });
			// testng.setTestClasses(new Class[] { Login.class });
			testng.addListener(tla);
			// testng.run();

			/*
			 * XmlSuite suite = new XmlSu ite(); suite.setName("Smoke Test");
			 * 
			 * XmlTest test = new XmlTest(suite); test.setName(
			 * "Registration Test"); List<XmlClass> classes = new
			 * ArrayList<XmlClass>(); classes.add(new 
			 * XmlClass("testcase.Parallel_Test")); classes.add(new
			 * XmlClass("testcase.Login")); test.setXmlClasses(classes) ;
			 * 
			 * List<XmlSuite> suites = new ArrayList<XmlSuite>();
			 * suites.add(suite); TestNG tng = new TestNG();
			 * tng.setXmlSuites(suites); tng.run();
			 */

			List<String> suites = Lists.newArrayList();
			String property = System.getProperty("xmlfilename","testNG8");
			suites.add(utility.Constant.PATH_TESTDATA+"/"+property+".xml");
			//suites.add(Constant.PATH_TESTDATA + "/testNG1.xml");// path to xml..
			// suites.add("/Users/shiva/Documents/Workspace/Mobilize/src/testNG2.xml");//path
			// to xml..
			testng.setTestSuites(suites);
			testng.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

//error couldn't start appium rest http interface listener
//killall node 
