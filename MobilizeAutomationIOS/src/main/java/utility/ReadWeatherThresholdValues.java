package utility;
import jxl.Sheet;
import utility.Constant;
import utility.ExcelUtils;

public class ReadWeatherThresholdValues extends Thread{


	private Sheet sh;
	private ExcelUtils eu ;
		public String MinWindMin_Mph,MinWindOutOfRange_Mph,MinWindMin_Max_Mph, MinWindMin_Knots,MinWindMinOutOfRange_Knots,MinWindMin_Max_Knots,high_wind_min_mph,high_wind_ot_range_mph,high_wind_max_mph,high_wind_min_knots,high_wind_ot_range_knots,high_wind_max_knots,daily_rain_min_inches,daily_rain_ot_range_inches,daily_rain_max_inches,daily_ran_min_mm,daily_rain_ot_range_mm,daily_rain_max_mm_max,high_rain_inches_min,high_rain_inches_ot_range,high_rain_max_inches,high_rain_mm_min,high_rain_mm_ot_range,high_range_max_mm,hightem_F_min,high_tem_F_ot_range,high_temp_F_max,high_temp_c_min,high_temp_c_ot_range,high_temp_c_max,
		low_tem_f_min,low_temp_f_ot_range,low_f_max,low_c_min,low_temp_c_ot_range,low_temp_c_max;
		
		public void run(){

			try {
				eu = new ExcelUtils();
				sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData,"WeatherThresholdValues");
				
				
				
				MinWindMin_Mph=eu.getCellData(sh, 1,1);	
				MinWindOutOfRange_Mph=eu.getCellData(sh, 1,2);	
				MinWindMin_Max_Mph=eu.getCellData(sh, 1,3);
				MinWindMin_Knots=eu.getCellData(sh, 1,5);	
				MinWindMinOutOfRange_Knots=eu.getCellData(sh, 1,6);
				MinWindMin_Max_Knots=eu.getCellData(sh, 1,7);
				
				
				high_wind_min_mph=eu.getCellData(sh, 2,1);
				high_wind_ot_range_mph=eu.getCellData(sh, 2,2);
				high_wind_max_mph=eu.getCellData(sh, 2,3);
				high_wind_min_knots=eu.getCellData(sh, 2,5);
                high_wind_ot_range_knots=eu.getCellData(sh, 2,6);
                 high_wind_max_knots=eu.getCellData(sh, 2,7);
                 
                 daily_rain_min_inches=eu.getCellData(sh, 3,1);
                 daily_rain_ot_range_inches=eu.getCellData(sh, 3,2);
                 daily_rain_max_inches=eu.getCellData(sh, 3,3);
                 daily_ran_min_mm=eu.getCellData(sh, 3,5);
                 daily_rain_ot_range_mm=eu.getCellData(sh, 3,6);
                 daily_rain_max_mm_max=eu.getCellData(sh, 3,7);
                 
                 high_rain_inches_min=eu.getCellData(sh, 4,1);
                 high_rain_inches_ot_range=eu.getCellData(sh, 4,2);
                 high_rain_max_inches=eu.getCellData(sh, 4,3);
                 high_rain_mm_min=eu.getCellData(sh, 4,5);
                 high_rain_mm_ot_range=eu.getCellData(sh, 4,6);
                 high_range_max_mm=eu.getCellData(sh, 4,7);
                 
             	hightem_F_min=eu.getCellData(sh, 5,1);
             	high_tem_F_ot_range=eu.getCellData(sh, 5,2);
             	high_temp_F_max=eu.getCellData(sh, 5,3);
             	high_temp_c_min=eu.getCellData(sh,5,5);
             	high_temp_c_ot_range=eu.getCellData(sh, 5,6);
             	high_temp_c_max=eu.getCellData(sh, 5,7);
             	
             	low_tem_f_min=eu.getCellData(sh, 6,1);
             	low_temp_f_ot_range=eu.getCellData(sh, 6,2);
             	low_f_max=eu.getCellData(sh, 6,3);         	
            	low_c_min=eu.getCellData(sh, 6,5);
            	low_temp_c_ot_range=eu.getCellData(sh, 6,6);
            	low_temp_c_max=eu.getCellData(sh, 6,7);
				
			
				
			

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
