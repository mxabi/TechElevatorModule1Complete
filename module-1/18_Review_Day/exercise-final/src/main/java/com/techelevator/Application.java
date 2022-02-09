package com.techelevator;

import java.util.List;

import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchDomainException;
import com.techelevator.search.SearchEngine;
import com.techelevator.util.TELog;

public class Application {

	public static void main(String[] args) {
		
		try {

			// Step Two: Create TELog, and log the start of the application.
			//
			TELog.log("Search application started");
			
			// Step Four: Instantiate a Search Domain
			//
			SearchDomain sd = new SearchDomain("data");
			TELog.log("Indexed files:\n" + sd.toString());
			
			// Step Six: Single word search
			//
//			SearchEngine se = new SearchEngine(sd);
//			se.indexFiles();
//			List<String> foundInFiles = se.search("squirrel");
//			if (foundInFiles.size() > 0) {
//			for (String file : foundInFiles) {
//				System.out.println(file);
//			}	
//			} else {
//				System.out.println("The search term does not appear in any of the indexed files.");
//			}
//
//			foundInFiles = se.search("Larry");
//			if (foundInFiles.size() > 0) {
//				for (String file : foundInFiles) {
//					System.out.println(file);
//				}	
//			} else {
//				System.out.println("The search term does not appear in any of the indexed files.");
//			}
			
			// Step Seven: Multiple word search
			//
			SearchEngine se = new SearchEngine(sd);
			se.indexFiles();
			List<String> foundInFiles = se.search("telephone line");
			if (foundInFiles.size() > 0) {
				for (String file : foundInFiles) {
					System.out.println(file);
				}	
			} else {
				System.out.println("The search term does not appear in any of the indexed files.");
			}
		} 
		catch (SearchDomainException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
