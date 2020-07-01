package core;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;
import org.openqa.selenium.By;

class SignUp {

	static Properties p = new Properties();
	static Writer report;

////////////////////////////////  -  Method  open  -  ///////////////////////          - runs browser we want
	static void open(String browser) throws Exception {
		p.load(new FileInputStream("./input.properties"));
		Common.open(browser, p.getProperty("url"));
	}

	
////////////////////////////////  -  Method  validate -  ///////////////////////   for the Elements on the SignUp page
	static void validate() throws Exception {
//		Input from external file
		//Every time we use the new method we need to load file in a new method again
		p.load(new FileInputStream("./input.properties"));
		
		
//		Report into external file
		// to lowerCase
		// we have it set to "false" as we want .csv file to be override
		report = new FileWriter("./report_" + Common.getBrowser().toString().toLowerCase() +".csv", false);

		
		Common.writeReportHeader(report);

		
//SIGN_UP
		// 01 :: First Name
		Common.setValue(By.id(p.getProperty("firstName_id")), p.getProperty("fname_value"));
		Common.writeReportLine("01", "First Name", By.id(p.getProperty("firstName_id")), report);
		
		// 02 :: Last Name
		Common.setValue(By.id(p.getProperty("lname_id")), p.getProperty("lname_value"));
		Common.writeReportLine("02", "Last Name", By.id(p.getProperty("lname_id")), report);
		
		// 03 :: Email
		Common.setValue(By.id(p.getProperty("email_id")), p.getProperty("email_value"));
		Common.writeReportLine("03", "Email", By.id(p.getProperty("email_id")), report);
		
		// 04 :: Phone
		Common.setValue(By.id(p.getProperty("phone_id")), p.getProperty("phone_value"));
		Common.writeReportLine("04", "Phone", By.id(p.getProperty("phone_id")), report);
		
		// 05 :: Submit
		Common.writeReportLine("05", "Submit", By.id(p.getProperty("submit_id")), report);
		
		// 06 :: TimeStamp
		Common.writeReportLine("06", "TimeStamp", By.id(p.getProperty("timestamp_id")), report);
		
		// 07 :: Quotes
		Common.writeReportLine("07", "Quotes", By.id(p.getProperty("quotes_id")), report);
		
		// 08 :: F_Title
		Common.writeReportLine("08", "F_Title", By.id(p.getProperty("f_title_id")), report);
		
		// 09 :: Current_Location
		Common.writeReportLine("09", "Current_Location", By.id(p.getProperty("current_location_id")), report);
		
		// 10 :: Weather_Icon
		Common.writeReportLine("10", "Weather_Icon", By.id(p.getProperty("weather_icon_id")), report);
		
		// 11 :: Temperature
		Common.writeReportLine("11", "Temperature", By.id(p.getProperty("temperature_id")), report);
		
		// 12 :: F_label_Fn
		Common.writeReportLine("12", "F_label_Fn", By.id(p.getProperty("f_label_fn_id")), report);
		
		// 13 :: F_label_Ln
		Common.writeReportLine("13", "F_label_Ln", By.id(p.getProperty("f_label_ln_id")), report);
		
		// 14 :: F_label_Ea
		Common.writeReportLine("14", "F_label_Ea", By.id(p.getProperty("f_label_ea_id")), report);
		
		// 15 :: F_label_Pn
		Common.writeReportLine("15", "F_label_Pn", By.xpath(p.getProperty("f_label_pn_xpath")), report);
		
		// 16 :: F_label_S
		Common.writeReportLine("16", "F_label_S", By.id(p.getProperty("f_label_s_id")), report);
		
		// 17 :: Fname_Error
		Common.writeReportLine("17", "Fname_Error", By.id(p.getProperty("fname_error_id")), report);
		
		// 18 :: Lname_Error
		Common.writeReportLine("18", "Lname_Error", By.id(p.getProperty("lname_error_id")), report);
		
		// 19 :: Email_Error
		Common.writeReportLine("19", "Email_Error", By.id(p.getProperty("email_error_id")), report);
		
		// 20 :: Phone_Error
		Common.writeReportLine("20", "Phone_Error", By.id(p.getProperty("phone_error_id")), report);
		
		// 21 :: Rb_label_g
		Common.writeReportLine("21", "Rb_label_g", By.id(p.getProperty("rb_label_g_id")), report);
		
		// 22 :: Rb_label_m
		Common.writeReportLine("22", "Rb_label_m", By.xpath(p.getProperty("rb_label_m_xpath")), report);
		
		// 23 :: Rb_label_f
		Common.writeReportLine("23", "Rb_label_f", By.id(p.getProperty("rb_label_f_id")), report);
		
		// 24 :: Cb_label_t
		Common.writeReportLine("24", "Cb_label_t", By.id(p.getProperty("cb_label_t_id")), report);
		
		// 25 :: ErrorLine
		Common.writeReportLine("25", "ErrorLine", By.id(p.getProperty("ErrorLine_id")), report);
		
		// 26 :: Img_flickr
		Common.writeReportLine("26", "Img_flickr", By.id(p.getProperty("img_flickr_id")), report);
		
		// 27 :: Img_facebook
		Common.writeReportLine("27", "Img_facebook", By.id(p.getProperty("img_facebook_id")), report);
		
		// 28 :: Img_youtube
		Common.writeReportLine("28", "Img_youtube", By.xpath(p.getProperty("img_youtube_xpath")), report);
		
		// 29 :: Img_twitter
		Common.writeReportLine("29", "Img_twitter", By.id(p.getProperty("img_twitter_id")), report);
		
		// 30 :: Link_twitter
		Common.writeReportLine("30", "Link_twitter", By.id(p.getProperty("link_twitter_id")), report);
		
		// 31 :: Link_facebook
		Common.writeReportLine("31", "Link_facebook", By.id(p.getProperty("link_facebook_id")), report);
		
		// 32 :: Link_flickr
		Common.writeReportLine("32", "Link_flickr", By.id(p.getProperty("link_flickr_id")), report);
		
		// 33 :: Link_youtube
		Common.writeReportLine("33", "Link_youtube", By.xpath(p.getProperty("link_youtube_xpath")), report);
		
		// 34 :: Reset_button
		Common.writeReportLine("34", "Reset_button", By.xpath(p.getProperty("reset_button_xpath")), report);
		
		// 35 :: Copyright
		Common.writeReportLine("35", "Copyright", By.xpath(p.getProperty("copyright_xpath")), report);
		
		// 36 :: OS_Browser
		Common.writeReportLine("36", "OS_Browser", By.id(p.getProperty("os_browser_id")), report);
		
		// 37 :: F_Title
		Common.writeReportLine("37", "F_Title", By.id(p.getProperty("f_title_id")), report);
		
		// 38 :: Gender_male
		Common.checkRadioButton(By.id(p.getProperty("gender_male_id")));
		Common.writeReportLine("38", "Gender_male", By.id(p.getProperty("gender_male_id")), report);
		
		// 39 :: Gender_female
		Common.writeReportLine("39", "Gender_female", By.id(p.getProperty("gender_female_id")), report);
		
		// 40 :: Terms
		Common.checkCheckBox(By.id(p.getProperty("terms_id")));
		Common.writeReportLine("40", "Terms", By.id(p.getProperty("terms_id")), report);
		
		// 40b :: State
		Common.selectDropDown(By.id(p.getProperty("state_id")), p.getProperty("state_value"));
		Common.writeReportLine("06", "State", By.id(p.getProperty("state_id")), report);
		
		

		
		// SUBMIT
		Common.submit(By.id(p.getProperty("submit_id")));
		Common.waitTitlePage("Confirmation");

		report.flush();
		report.close();
	}
}