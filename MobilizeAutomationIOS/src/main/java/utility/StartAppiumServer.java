package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class StartAppiumServer {

	private static Process process;
	private static String APPIUMSERVERSTART = "node /home/adminuser/Java_Projects/Appium/appium";
	public static CommandLine command = new CommandLine("/bin/sh -c");

	@BeforeSuite
	public static void startAppiumServer() throws IOException, InterruptedException {
/*
		List list = new ArrayList();
		list.add("/Applications/Appium.app/Contents/Resources/node/bin/node");
		list.add("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js");
		list.add("--address");
		list.add("127.0.0.1");
		list.add("--port");
		list.add("4723");
		list.add("--no-reset");
		// create the process builder
		ProcessBuilder pb = new ProcessBuilder(list);
		try {
		pb.start();
		} catch (IOException e1) {
		// TODO Auto-generated catch block
			System.out.println(e1);
		e1.printStackTrace();
		}
		*/
		command.addArgument("/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium-doctor.js",false);
		command.addArgument("--address");
		command.addArgument("0.0.0.0");
		command.addArgument("--port");
		command.addArgument("4724");
		command.addArgument("--no-reset", false);
		command.addArgument("--log");
		command.addArgument("argument", false);
		System.out.println("Appium server");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		System.out.println("resultHandler"+resultHandler);
		DefaultExecutor executor = new DefaultExecutor();
		System.out.println("executor"+executor);
		
		try {
			executor.setExitValue(1);
			executor.execute(command, resultHandler);
			System.out.println("Appium server started");
			} catch (ExecuteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		

		/*Runtime runtime = Runtime.getRuntime();
		process = runtime.exec(APPIUMSERVERSTART);
		Thread.sleep(5000);
		if (process != null) {
			System.out.println("Appium server started");
		}*/
	}
	
	@AfterSuite
	public static void stopAppiumServer() throws IOException {

		command.addArgument("killall node");
		System.out.println("Appium server stop");

		/*if (process != null) {
			process.destroy();
		}
		System.out.println("Appium server stop");
	}

	public static void main(String args[]) throws IOException, InterruptedException {        
		startAppiumServer();
		stopAppiumServer();
	}*/
	}
}
