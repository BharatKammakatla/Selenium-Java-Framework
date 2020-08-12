package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.Base;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Utils extends Base {

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//reports//" + testCaseName + "_"
				+ ThreadLocalRandom.current().nextInt() + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	public HashMap<String, String> getTestData(String tcid) throws FilloException, IOException {

		HashMap<String, String> data = new HashMap<String, String>();
		String testDataFilePath = loadConfig().getProperty("testDataPath");

		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(testDataFilePath);
		String strQuery = "Select * from Sheet1 where TCID='" + tcid + "'";
		Recordset recordset = connection.executeQuery(strQuery);

		while (recordset.next()) {
			ArrayList<String> columnNames = recordset.getFieldNames();
			for (String name : columnNames) {
				data.put(name, recordset.getField(name));
			}
		}

		recordset.close();
		connection.close();

		return data;

	}

}
