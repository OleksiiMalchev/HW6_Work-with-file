public class Test {
    public static void main(String[] args) throws Exception {

        ConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        LoggerConfiguration load = ((FileLoggerConfigurationLoader) fileLoggerConfigurationLoader).load("src\\file_config.txt");
        FileLogger logger = new FileLogger(load);
        logger.debug("Debug log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
        logger.info("Info log");
    }
}