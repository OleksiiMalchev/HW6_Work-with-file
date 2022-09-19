import java.nio.file.Path;

public interface LoggerConfiguration {
    Path getFilePath();

    LoggingLevel getLevel();

    byte getMaxSizeFile();

    String getFileName();

    String format(String msg, LoggingLevel level);
}
