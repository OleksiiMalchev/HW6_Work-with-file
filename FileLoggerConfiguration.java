import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;


public class FileLoggerConfiguration {
    protected static File filePath;
    protected static LoggingLevel level;
    protected static byte maxSizeFile;
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");


    public FileLoggerConfiguration(String nameFile, LoggingLevel level, byte maxSizeFile) {
        filePath = new File("src\\" + nameFile);
        this.level = level;
        this.maxSizeFile = maxSizeFile;
    }

    public static String format(String msg,LoggingLevel level) {
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

