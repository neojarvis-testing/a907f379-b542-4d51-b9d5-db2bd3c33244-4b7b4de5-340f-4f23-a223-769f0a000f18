package utils;
 
import org.apache.log4j.Logger;
 
public class LogHelper {
   
 
    private static final Logger logger = Logger.getLogger(LogHelper.class);
   
   
    /**
     * Author: Bharani
     * Description: DEBUG status in a Log
     * @param message
     */
    public static void debug(String message) {
        logger.debug(message);
    }
    /**
     * Author: Bharani
     * Description: INFO status in log
     * @param message
     */
    public static void info(String message) {
        logger.info(message);
    }
    /**
     * Author: Bharani
     * Description: ERROR status in log
     * @param message
     */
    public static void error(String message) {
        logger.error(message);
    }

    /**
     * Author: Bharani
     * Description: TRACE status in log
     * @param message
     */
    public static void trace(String message) {
        logger.trace(message);
    }
   
 
}

