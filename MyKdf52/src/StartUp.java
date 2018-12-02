


//อ่านค่าข้อมูลทดสอบจากไฟล์ Excel จากนั้นเขียนผลลัพธ์ลงในไฟล์ตามลำดับ

public class StartUp {
	
	public static String vUrl, vTitle, vName, vUsername, vPassword;
	public static String vEducation;
	public static String vJob;
	public static String vResult, vError, vflag; 
	public static String xTDdata[][];
	
	public static void main(String[] args) throws Exception {
		
		String xTSdata[][]; 
		String xTCdata[][]; 
		String vKeyword, vIP1, vIP2;
		
		String xlPath_tc = "C:/Users/NPRU/Desktop/Selenium ราชภัฎนครปฐม/KDF/TC_Res12.xlsx";
		String xlPath_ts = "C:/Users/NPRU/Desktop/Selenium ราชภัฎนครปฐม/KDF/TS_Res12.xlsx";
		String xlPath_td = "C:/Users/NPRU/Desktop/Selenium ราชภัฎนครปฐม/KDF/TD_Res12.xlsx";
	    String xlPath ="C:/Users/NPRU/Desktop/Selenium ราชภัฎนครปฐม/KDF/SeleniumData 4.xlsx";
	   

		Driver myDriver = new Driver();
		
		ManageExcel kdf = new ManageExcel();
		xTCdata = kdf.xlRead(xlPath, 0);
		xTSdata = kdf.xlRead(xlPath, 1);
		xTDdata = kdf.xlRead(xlPath, 2);
		
		for (int i = 1; i < xTCdata.length; i++) {
			if (xTCdata[i][4].equals("Y")) {
		 		vflag = "Pass";
		 		
		 		for (int k = 1; k < xTDdata.length; k++) {// วนตามจำนวน TestData
					if (xTDdata[k][1].equals("Y")) {
						myDriver.getData(k);
						
					for (int j = 1; j <xTSdata.length; j++){
						if (xTCdata[i][1].equals(xTSdata[j][0])){	
							vKeyword = xTSdata[j][4];
							vIP1 = xTSdata[j][5];
							vIP2 = xTSdata[j][6];
							System.out.println("---" + vKeyword + "````" + vIP1 + "````" + vIP2);
							vResult = "Pass";
	                		vError = "No Error";
	               
	                		vResult = myDriver.keyword_executor( vKeyword, vIP1, vIP2);
	                
	                		
	                		if (!vError.equals("No Error")){
	                			vflag = "Fail";   
	                			myDriver.getUtility().saveScreen(i);  
	                			xTSdata[j][8] = vResult;
	                			xTDdata[k][12] = vResult;
		        				xTDdata[k][13] = vError;
						    }
				        }
				   }
				xTCdata[i][5] = vflag;							
			}
		}	
		kdf.xlWrite(xlPath_tc, xTCdata, xTCdata.length, xTCdata[1].length);
		kdf.xlWrite(xlPath_ts, xTSdata, xTSdata.length, xTSdata[1].length);	
		kdf.xlWrite(xlPath_td, xTDdata, xTDdata.length, xTDdata[1].length);		
	  }		
    }
  }		
}


	
