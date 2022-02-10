package com.techelevator.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TELog {

//	public static void log(String message) {
//		try {
//			PrintWriter pw = new PrintWriter(new FileOutputStream("logs/search.log", true));
//			pw.println(message);
//			pw.close();
//		} catch (FileNotFoundException e) {
//			throw new TELogException(e.getLocalizedMessage());
//		}
//	}

//	// Challenge: Avoid repeatedly opening and closing log file
//	//
//	private static PrintWriter pw = null;
//	
//	public static void log(String message) {
//		try {
//			if (pw == null) {
//				pw = new PrintWriter(new FileOutputStream("logs/search.log", true));
//			}
//			pw.println(message);
//			pw.flush();
//		} catch (FileNotFoundException e) {
//			throw new TELogException(e.getLocalizedMessage());
//		}
//	}
	
//	// Challenge: Use LocalDate/LocalDateTime in TELog
//	//
	private static PrintWriter pw = null;
	
	public static void log(String message) {
		try {
			if (pw == null) {
				String logFilename = "logs/" + LocalDate.now().format(DateTimeFormatter.ISO_DATE) + ".log";
				pw = new PrintWriter(new FileOutputStream(logFilename));
			}
			pw.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " " + message);
			pw.flush();
		}
		catch (FileNotFoundException e) {
			throw new TELogException(e.getMessage());
		}
	}

}
