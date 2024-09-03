package com.testyantra.generic.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJson(String key) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("./configurationAppdata/commonData.properties");
		Object obj = parser.parse(file);
		JSONObject map = (JSONObject) obj;
		String data = (String) map.get(key);
		return data;
	}
}