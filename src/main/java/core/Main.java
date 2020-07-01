package core;

import java.time.LocalDateTime;


public class Main {
	static String browser;
	static String username;
	//Expiration
	static String exp_2020_06_31 = "2020-07-25T14:52:26.098"; // System.out.println(LocalDateTime.now());
	static String user = "evgeniy";
	
	//------------------------------------------------------------   Main_Method  --------------------------------------------------- //
	

	public static void main(String[] args) throws Exception {
		

				
//		Expiration
		if (LocalDateTime.now().isAfter(LocalDateTime.parse(exp_2020_06_31))) {
			String msg = String.format("Today at [%s] this version has expired.", LocalDateTime.now());
			throw new RuntimeException(msg);}
		
//		We can create password and put it into a bashrc	  to authorize the running of the file
			
		// username = "alex";
		username = System.getProperty("username"); 					// -Dusername="evgeniy"
		if (!username.equalsIgnoreCase(user)) {
			String msg = String.format("Username [%s] is not authorized run this program.", username);
			throw new RuntimeException(msg);}
		
		
		// browser = "firefox";
		browser = System.getProperty("browser");     					 // -Dbrowser="firefox" will run as Firefox      or      -Dbrowser="chrome" will run as Chrome
		if(browser == null) {System.err.println("Please provide browser: -Dbrowser=\"firefox\""); System.exit(0);}
		else if( !browser.equalsIgnoreCase("chrome") &&
					!browser.equalsIgnoreCase("firefox") &&
					!browser.equalsIgnoreCase("safari") &&
					!browser.equalsIgnoreCase("edge")) 
				{System.err.println("Framework supports only: Chrome, Firefox, Safari or Edge"); System.exit(0);}
		
		
		//It calls Orchestration
		SignUp.open(browser);
		SignUp.validate();
		Confirmation.validate();
//		When adding new pages
//		Confirmation_2.validate();
//		Confirmation_3.validate();
		Common.quit();
	}
}