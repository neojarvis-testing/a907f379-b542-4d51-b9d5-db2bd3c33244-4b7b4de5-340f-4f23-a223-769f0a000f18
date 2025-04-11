// package utils;
 
// import org.apache.log4j.Logger;
 
// public class LogHelper {
   
 
//     private static final Logger logger = Logger.getLogger(LogHelper.class);
   
   
//     /**
//      * Author: Bharani
//      * Description: DEBUG status in a Log
//      * @param message
//      */
//     public static void debug(String message) {
//         logger.debug(message);
//     }
//     /**
//      * Author: Bharani
//      * Description: INFO status in log
//      * @param message
//      */
//     public static void info(String message) {
//         logger.info(message);
//     }
//     /**
//      * Author: Bharani
//      * Description: ERROR status in log
//      * @param message
//      */
//     public static void error(String message) {
//         logger.error(message);
//     }

//     /**
//      * Author: Bharani
//      * Description: TRACE status in log
//      * @param message
//      */
//     public static void trace(String message) {
//         logger.trace(message);
//     }
   
 
// }


package utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
 
public class LogHelper {
		    private static final Logger logger = Logger.getLogger(LogHelper.class);

		    static {
		        try {
		            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		            String logFileName = "logs/app_" + timestamp + ".log";
//		            String logFileName = "logs/app_" + timestamp + ".html";
		            // Set up the layout
		            PatternLayout layout = new PatternLayout("[%p] %d %c %M - %m%n");
//                     HTMLLayout layout=new HTMLLayout();
//                     layout.setTitle("HOMEDEPOT");
//                     layout.setLocationInfo(true);
		            // Create the rolling file appender with dynamic file name
		            DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
		            rollingAppender.setFile(logFileName);
		            rollingAppender.setDatePattern("'.'yyyy-MM-dd");
		            rollingAppender.setLayout(layout);
		            rollingAppender.activateOptions();

		            Logger rootLogger = Logger.getRootLogger();
		            rootLogger.setLevel(Level.DEBUG);
		            rootLogger.addAppender(rollingAppender);
		        } catch (Exception e) {
		            System.err.println("Failed to initialize logger: " + e.getMessage());
		        }
		    }

		    public static void debug(String message) {
		        logger.debug(message);
		    }

		    public static void info(String message) {
		        logger.info(message);
		    }

		    public static void error(String message) {
		        logger.error(message);
		    }

		    public static void trace(String message) {
		        logger.trace(message);
		    }
		}