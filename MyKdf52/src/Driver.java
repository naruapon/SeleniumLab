import org.openqa.selenium.NoSuchElementException;


public class Driver {
  
	
	private Utility util = new Utility();
	
	public Utility getUtility() {
		return util;
	}

	public String keyword_executor(String vKeyword, String vIP1, String vIP2) throws Exception {
		
		String flag = "false";
	
		try {
		if (vKeyword.equals("browser_open")){		   
		    util.browser_open(getIP(vIP1));
		    flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("radio_select")){
			util.radio_select(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("checkbox_set")){
			util.checkbox_set(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("list_select")){
			util.list_select(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("edit_input")){
			util.edit_input(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("button_click")){
			util.button_click(getIP(vIP1));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("click_link")){
			util.click_link(getIP(vIP1));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("dialog_click")){
			boolean works = util.dialog_click();
			if (works) {
		        flag = "True";
	            return "pass";
		    }
		}
		if (vKeyword.equals("browser_close")){		   
		    util.browser_close();
		    flag = "True";
		    return "pass";
		}
		
		if (flag.equals("false")){
			System.out.println("Keyword is missing " + vKeyword);
			StartUp.vError = "Error";		//แก้ไขเพิ่มเติม
			return "False-Keyword Missing";
		  }
    	}
		catch (NoSuchElementException e){
			System.out.println("Error is " + e);
			StartUp.vError = String.valueOf(e);
			
			return "Fail";
		}
		return "Unknown Keyword";
	}
	
	public String getIP(String vIP){
		
		if (vIP.equals("vUrl")){
			vIP = StartUp.vUrl;
		}
		if (vIP.equals("vTitle")){
			vIP = StartUp.vTitle;
		}
		if (vIP.equals("vName")){
			vIP = StartUp.vName;
		}
		if (vIP.equals("vEducation")){
			vIP = StartUp.vEducation;
		}
		if (vIP.equals("vJob")){
			vIP = StartUp.vJob;
		}
		if (vIP.equals("vUsername")){
			vIP = StartUp.vUsername;
		}
		if (vIP.equals("vPassword")){
			vIP = StartUp.vPassword;
		}
	  return vIP;
	}

	public void getData(int k) {
		StartUp.vUrl = StartUp.xTDdata[k][2];
		StartUp.vTitle = StartUp.xTDdata[k][4];
		StartUp.vName = StartUp.xTDdata[k][5];
		StartUp.vEducation = StartUp.xTDdata[k][6];
		StartUp.vJob = StartUp.xTDdata[k][7];
		StartUp.vUsername = StartUp.xTDdata[k][8];
		StartUp.vPassword = StartUp.xTDdata[k][9];		
	}
}