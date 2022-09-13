

public class Test {
    public static void main(String[] args) throws Exception {
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration("logger.txt",LoggingLevel.INFO, (byte) 100);

        FileLogger logger = new FileLogger(fileLoggerConfiguration);

        logger.info("Info log");
        logger.debug("Debug log");
    }
}
