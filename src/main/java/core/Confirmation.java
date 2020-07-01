package core;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;
import org.openqa.selenium.By;

class Confirmation {

	static Properties p = new Properties();
	static Writer report;

	
////////////////////////////////-  Method  validate -  ///////////////////////  for the Elements on the Confirmation page
	static void validate() throws Exception {
//		Input from external file
		p.load(new FileInputStream("./input.properties"));
			
		
//		Report into external file
		// we have it set to "true" as we want to add(append) to our .csv file  
		report = new FileWriter("./report_" + Common.getBrowser().toString().toLowerCase() +".csv", true);

		
		// 41 :: First Name
		Common.writeReportLine("41", "First Name", By.id(p.getProperty("firstName_id")), report);
		
		// 42 :: Last Name
		Common.writeReportLine("42", "Last Name", By.id(p.getProperty("lname_id")), report);
		
		// 43 :: Email
		Common.writeReportLine("43", "Email", By.id(p.getProperty("email_id")), report);
		
		// 44 :: Phone
		Common.writeReportLine("44", "Phone", By.id(p.getProperty("phone_id")), report);
		
		// 45 :: F_title
		Common.writeReportLine("45", "F_title", By.id(p.getProperty("f_title_id")), report);
		
		// 46 :: F_label_fn
		Common.writeReportLine("46", "F_label_fn", By.id(p.getProperty("f_label_fn_id")), report);
		
		// 47 :: F_label_ln
		Common.writeReportLine("47", "F_label_ln", By.id(p.getProperty("f_label_ln_id")), report);
		
		// 48 :: F_label_ea
		Common.writeReportLine("48", "F_label_ea", By.id(p.getProperty("f_label_ea_id")), report);
		
		// 49 :: F_label_Pn
		Common.writeReportLine("49", "F_label_Pn", By.xpath(p.getProperty("f_label_pn_xpath")), report);
		
		// 50 :: Rb_label_g
		Common.writeReportLine("50", "Rb_label_g", By.id(p.getProperty("rb_label_g_id")), report);
		
		// 51 :: F_label_s
		Common.writeReportLine("51", "F_label_s", By.id(p.getProperty("f_label_s_id")), report);
		
		// 52 :: Cb_label_t
		Common.writeReportLine("52", "Cb_label_t", By.id(p.getProperty("cb_label_t_id")), report);
		
		// 53 :: Back_button
		Common.writeReportLine("53", "Back_button", By.id(p.getProperty("back_button_id")), report);
		
		// 54 :: Copyright
		Common.writeReportLine("54", "Copyright", By.xpath(p.getProperty("copyright_xpath")), report);
		
		// 55 :: Gender
		Common.writeReportLine("55", "Gender", By.xpath(p.getProperty("gender_xpath")), report);
		
		// 56 :: State
		Common.writeReportLine("56", "State", By.xpath(p.getProperty("state_xpath")), report);
		
		// 57 :: Terms
		Common.writeReportLine("57", "Terms", By.id(p.getProperty("terms_id")), report);
		
		
		
		report.flush();
		report.close();
	}
	

}
