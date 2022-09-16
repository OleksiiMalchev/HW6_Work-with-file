import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileLogger implements AutoCloseable {
    private final OutputStream outputStream;
    private FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        try {
            outputStream = new FileOutputStream(configuration.getFilePath(), true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void info(String msg) {
        if (configuration.getLevel().ordinal() >= LoggingLevel.INFO.ordinal()) {
            String log = configuration.format(msg, LoggingLevel.INFO);
            writeToFile(log);
        }
    }

    public void debug(String msg) {
        if (configuration.getLevel().ordinal() >= LoggingLevel.DEBUG.ordinal()) {
            String log = configuration.format(msg, LoggingLevel.DEBUG);
            writeToFile(log);
        }
    }

    private void writeToFile(String msg) {
        try {
            if (configuration.getFilePath().length() < configuration.getMaxSizeFile()) {
                outputStream.write(msg.getBytes());
                outputStream.write("\n".getBytes());
                outputStream.flush();
            } else {
                throw new FileMaxSizeReachedException("Max size file: " + configuration.getMaxSizeFile()
                        + " File size: " + configuration.getFilePath().length() + "byte"
                        + " File path: " + configuration.getFilePath() + "byte");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }

    @Override
    public void close() {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}