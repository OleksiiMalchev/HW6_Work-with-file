import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
public class FileLoggerConfiguration implements LoggerConfiguration {
    private Path filePath;
    private LoggingLevel level;
    private byte maxSizeFile;
    private String fileName;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


    public FileLoggerConfiguration(Path filePath, LoggingLevel level, byte maxSizeFile, String fileName) {
        this.filePath = filePath;
        this.level = level;
        this.maxSizeFile = maxSizeFile;
        this.fileName = fileName;
    }

    public Path getFilePath() {
        return filePath;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public byte getMaxSizeFile() {
        return maxSizeFile;
    }

    public String getFileName() {
        return fileName;
    }

    public String format(String msg, LoggingLevel level) {
        return "[" +
                timeFormat.format(new Date()) +
                "]" +
                "[" +
                level +
                "]" +
                " Message:" +
                "[" +
                msg +
                "] ";
    }
}