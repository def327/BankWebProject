package by.zyablov.bank.logger;

import org.apache.log4j.Logger;

public class WebAppLogger {
	
	static Logger logger = Logger.getLogger(WebAppLogger.class);
	
	public static void main(String[] args) {
		
		System.out.println("Work");
		
		logger.info("Hello world!");
		
	}

}
