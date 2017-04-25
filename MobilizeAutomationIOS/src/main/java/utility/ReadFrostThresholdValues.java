package utility;

import jxl.Sheet;

public class ReadFrostThresholdValues extends Thread {

	private Sheet sh;
	private ExcelUtils eu;
	public String frost_F_MinimumValue, frost_F_OutOfRangeValue, frost_F_MaximumValue, earlyFrostMinvalue,
			earlyFrostOutOfRangeValues, earlyFrostmaxvalue, Frost_C_Minm, Frost_C_Maxm, Frost_C_OutOf_Range,
			early_C_frost_Minm, early_C_Frost_Maxm, early_C_Frost_OutOfRage;
	String device, sensor, frost_threshold_temp, early_frost_warning, uniquefrostname;

	public void run() {

		try {

			eu = new ExcelUtils();
			sh = eu.setExcelFile(Constant.PATH_TESTDATA + Constant.File_TestData, "FrostPageThresholdValues");

			frost_F_MinimumValue = eu.getCellData(sh, 1, 1);

			frost_F_OutOfRangeValue = eu.getCellData(sh, 1, 2);

			frost_F_MaximumValue = eu.getCellData(sh, 1, 3);

			earlyFrostMinvalue = eu.getCellData(sh, 1, 1);

			earlyFrostOutOfRangeValues = eu.getCellData(sh, 2, 1);

			earlyFrostOutOfRangeValues = eu.getCellData(sh, 2, 2);

			earlyFrostmaxvalue = eu.getCellData(sh, 2, 3);

			Frost_C_Minm = eu.getCellData(sh, 1, 5);
			Frost_C_Maxm = eu.getCellData(sh, 1, 7);
			Frost_C_OutOf_Range = eu.getCellData(sh, 1, 6);
			early_C_frost_Minm = eu.getCellData(sh, 2, 5);

			early_C_Frost_Maxm = eu.getCellData(sh, 2, 7);
			early_C_Frost_OutOfRage = eu.getCellData(sh, 2, 6);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
