import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger implements Logger {
    private final LoggerConfiguration configuration;
    protected File fileLog;

    public FileLogger(LoggerConfiguration configuration) {
        this.configuration = configuration;
        fileLog = createFile(configuration);
    }

    public void info(String msg) {
        configuration.getLevel();
        String log = configuration.format(msg, LoggingLevel.INFO);
        writeToFile(log);
    }

    public void debug(String msg) {
        if (configuration.getLevel().ordinal() >= LoggingLevel.DEBUG.ordinal()) {
            String log = configuration.format(msg, LoggingLevel.DEBUG);
            writeToFile(log);
        }
    }

    private void writeToFile(String msg) {
        if (fileLog.length() >= configuration.getMaxSizeFile()) {
            fileLog = createFile(configuration);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLog, true))) {
            writer.write(msg);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createFile(LoggerConfiguration configuration) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss.S");
        String date = dateFormat.format(new Date());
        File file = new File(configuration.getFilePath() + "\\" +configuration.getFileName()+ date +".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
