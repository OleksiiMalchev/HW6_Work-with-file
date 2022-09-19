import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {
    private final LoggerConfiguration configuration;
    protected File fileLog;

    public FileLogger(LoggerConfiguration configuration) {
        this.configuration = configuration;
        fileLog = createFile(configuration);
    }

    public void info(String msg) throws IOException {
        if (configuration.getLevel().ordinal() >= LoggingLevel.INFO.ordinal()) {
            String log = configuration.format(msg, LoggingLevel.INFO);
            writeToFile(log);
        }
    }

    public void debug(String msg) throws IOException {
        if (configuration.getLevel().ordinal() >= LoggingLevel.DEBUG.ordinal()) {
            String log = configuration.format(msg, LoggingLevel.DEBUG);
            writeToFile(log);
        }
    }

    private void writeToFile(String msg) throws IOException {
        if(fileLog.length() >= configuration.getMaxSizeFile()){
            fileLog = createFile(configuration);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLog, true));
            writer.write(msg);
            writer.write("\n");
            writer.close();
        } else {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLog, true));
            writer.write(msg);
            writer.write("\n");
            writer.close();
        }
    }

    private File createFile(LoggerConfiguration configuration) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
        String date = dateFormat.format(new Date());
        File file = new File(configuration.getFilePath() + "\\" + configuration.getFileName() + date + ".txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}