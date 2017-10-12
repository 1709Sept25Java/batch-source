package com.revature.logging;

import org.apache.log4j.Logger;

public class LoggingClass {

	private static Logger log = Logger.getRootLogger();
	
	public void someMethod() {
		log.trace("Trace message");
		log.debug("debug message");
		log.info("Info message");
		log.warn("Warn message");
		log.error("Error message");
		log.fatal("Fatal message");
	}
	public void giveFatal(Throwable t) {
		log.fatal(t.getMessage(),t);
	}
}
