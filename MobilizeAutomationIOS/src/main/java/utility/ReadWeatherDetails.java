package utility;

import jxl.Sheet;

public class ReadWeatherDetails extends Thread{

	private Sheet sh;
	private ExcelUtils eu ;
	public String device ,sensor, avg_wind_speed_treshold, high_wind_alert, Daily_Rain_alert, High_rain_rate, High_temp_alert, Low_temp_alert,uniqueweather;

	public void run(){

		try {
			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"Weather_details");

			device = eu.getCellData(sh, 1, 1);
			System.out.println("device"+device);

			sensor = eu.getCellData(sh, 2, 1);
			System.out.println("sensor "+sensor);

			avg_wind_speed_treshold = eu.getCellData(sh, 3, 1);
			System.out.println("avg_wind_speed_treshold"+avg_wind_speed_treshold);

			high_wind_alert = eu.getCellData(sh, 3, 2);
			System.out.println("high_wind_alert"+high_wind_alert);
			
			Daily_Rain_alert = eu.getCellData(sh, 3, 3);
			System.out.println("Daily_Rain_alert"+Daily_Rain_alert);
			
			High_rain_rate = eu.getCellData(sh, 3, 4);
			System.out.println("High_rain_rate"+High_rain_rate);
			
			High_temp_alert = eu.getCellData(sh, 3, 5);
			System.out.println("High_temp_alert"+High_temp_alert);
			
			Low_temp_alert = eu.getCellData(sh, 3, 6);
			System.out.println("Low_temp_alert"+Low_temp_alert);

			uniqueweather = eu.getCellData(sh, 1, 7);
			System.out.println("uniqueweather"+uniqueweather);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





}
