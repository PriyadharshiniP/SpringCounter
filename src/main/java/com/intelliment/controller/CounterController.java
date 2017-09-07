package com.intelliment.controller;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intelliment.model.SearchText;
import com.intelliment.utils.CSVUtils;
import com.intelliment.utils.WordCountUtils;

/**
 * 
 * CounterController.java
 * Purpose: Inteliment Screening Test.
 * Implemented RESTful Services, which provide the solution of the tasks, given the sample paragraphs. 
 * These Restful  services are protected with Spring Security
 * 
 * @author Priya
 * @version 1.0 7/09/17
 */
@RestController
public class CounterController {
	/**
	 * Welcome method
	 *
	 * 
	 * @return Default Welcome String to the User!
	 */
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to CounterController.";
	}

	
	

	/**
	 * A method to provide the counts of the words in the input <search> list
	 * 
	 * 
	 * @param search
	 * @return SearchText
	 */
	@RequestMapping(value = "/counter-api/search", method = RequestMethod.POST)
	public SearchText search(@RequestBody SearchText search) {

		SearchText resultText = new SearchText();
		Map<String, Integer> frequencyMap = WordCountUtils.getFrequencyMap(getClass().getClassLoader());
		ArrayList<HashMap> resultList = new ArrayList<HashMap>();
		
		for (int i = 0; i < search.getSearchText().size(); i++) {
			String word = (String) search.getSearchText().get(i);
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			int matchedWord = frequencyMap.get(word.toLowerCase()) == null ? 0
					: frequencyMap.get(word.toLowerCase());
			hm.put(word, matchedWord);
			resultList.add(hm);
		}
		
		resultText.setSearchText(resultList);
		return resultText;

	}
	/**
	 * A method  to provide the highest <topVal> counts of occurrence of the words in the Input Paragraph
	 * 
	 * 
	 * @param topVal
	 * @return SearchText 
	 */
	@RequestMapping(value = "/top/{topVal}", method = RequestMethod.GET)
	public SearchText topSearch(@PathVariable int topVal) {
		Map<String, Integer> frequencyMap = WordCountUtils.getFrequencyMap(getClass().getClassLoader());

		Map<String, Integer> sortedFrequencyMap = new LinkedHashMap<>();
		frequencyMap.entrySet().stream().sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
				.forEachOrdered(
						x -> sortedFrequencyMap.put(x.getKey(), x.getValue()));
		ArrayList<String> resultList = new ArrayList<String>();
		int i = 0;
		Set set = sortedFrequencyMap.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			if (i++ < topVal) {
				Map.Entry me = (Map.Entry) it.next();
				resultList.add(me.getKey() + "|" + me.getValue());
				resultList.add("\n");

			} else
				break;
		}
		
		String csvFile = "developer.csv";
		FileWriter writer;
		try {
			writer = new FileWriter(csvFile);
			CSVUtils.writeLine(writer, resultList, '|', '\"');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		SearchText resultSearchText = new SearchText();
		resultSearchText.setSearchText(resultList);
		return resultSearchText;
	}
}