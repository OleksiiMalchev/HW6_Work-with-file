import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerConfiguration {
    private File filePath;
    private LoggingLevel level;
    private byte maxSizeFile;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public FileLoggerConfiguration(String nameFile, LoggingLevel level, byte maxSizeFile) {
        filePath = new File("src\\" + nameFile);
        this.level = level;
        this.maxSizeFile = maxSizeFile;
    }

    public File getFilePath() {
        return filePath;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public byte getMaxSizeFile() {
        return maxSizeFile;
    }

    public SimpleDateFormat getTimeFormat() {
        return timeFormat;
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