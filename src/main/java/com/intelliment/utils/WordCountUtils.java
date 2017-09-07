package com.intelliment.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * An utility class to work on the Word Frequency
 * 
 * @author priya
 * @version 1.1
 */
public class WordCountUtils {
	/**
	 * An Utility method that returns a Map of words with its corresponding
	 * count in the Input Paragraph
	 * 
	 * 
	 * @param classLoader
	 * @return Map which contains the words and its corresponding frequency in
	 *         the Input Paragraph
	 */
	public static Map getFrequencyMap(ClassLoader classLoader) {

		Map<String, Integer> frequencyMap = new TreeMap<String, Integer>();
		try {
			File file = new File(String.valueOf(classLoader.getResource(
					getFileName("fileName",classLoader)).getFile()));

			FileInputStream is = null;
			is = new FileInputStream(file);

			ArrayList<String> countList = countWords(is);

			for (String count : countList) {
				if (frequencyMap.containsKey(count)) {
					frequencyMap.put(count, frequencyMap.get(count) + 1);
				} else {
					frequencyMap.put(count, 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return frequencyMap;
	}

	/**
	 * An Utility method that traverses the Input File Input to add the words to
	 * a List.
	 * 
	 * 
	 * @param is
	 * @return list of words in the Inpiut file
	 * @throws IOException
	 */
	public static ArrayList countWords(FileInputStream is) throws IOException {
		int totalCount = 0;
		ArrayList resultList = new ArrayList();
		int wordCount = 0;

		java.util.Scanner s = new java.util.Scanner(is);

		while (s.hasNext()) {
			totalCount++;
			String str = s.next();
			str = str.replaceAll("[^a-zA-Z0-9]", "");
			str = str.toLowerCase();
			str = str.trim();
			resultList.add(str);
		}
		s.close();
		is.close();

		return resultList;
	}
	
	/**
	 * A method to return the name of the input file from a configuration properties file. 
	 * Properties file can be changed during run time 
	 * hence the input file name is not hard-coded in the project.
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String getFileName(String fileName,ClassLoader classLoader) throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(classLoader.getResource("config.properties").getFile());
		prop.load(input);
		return prop.getProperty(fileName);
	}
}
