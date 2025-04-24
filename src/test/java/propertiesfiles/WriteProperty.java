package propertiesfiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProperty {

	public static void main(String[] args) throws IOException {
		// first create a object of property to insert data
		
//		Properties properties=new Properties();
		
		// now object bn gya ab data add krenge key value format add krna hota h
		
		
//		properties.setProperty("phone", "9988776655");
		
		
		//add entire data into property file , first of all get the path
		//.getProperty a method help to get current project location---user.dir is fix
		String filePath=System.getProperty("user.dir")+"\\data\\example.properties";
		
		//ab data file m send krne ke liye use 
//		fileoutputstream---to make a file
		
		FileOutputStream file=new FileOutputStream(filePath);
		//data dalne ke liye
		
//		properties.store(file, "Sample data");
		
		file.close();
		
	  System.out.println(" The file is created");
		

	}

}
