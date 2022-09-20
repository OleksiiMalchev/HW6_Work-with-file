public class Test {
    public static void main(String[] args) throws Exception {
        ConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        LoggerConfiguration load = ((FileLoggerConfigurationLoader) fileLoggerConfigurationLoader).load("src\\file_config.txt");
        FileLogger logger = new FileLogger(load);
        logger.info("info log1");
        logger.info("info log2");
        logger.info("info log3");
        logger.info("info log4");
        logger.info("info log5");
        logger.info("info log6");
        logger.info("info log7");
        logger.info("info log8");
        logger.info("info log9");
        logger.info("info log10");
        logger.info("info log11");
    }
}