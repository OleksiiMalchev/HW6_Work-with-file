import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class FileLogger implements AutoCloseable {
    private final OutputStream outputStream;

    public FileLogger(FileLoggerConfiguration configuration) {
        try {
            outputStream = new FileOutputStream(FileLoggerConfiguration.filePath, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void info(String msg) {
        if (FileLoggerConfiguration.level.ordinal() >= LoggingLevel.INFO.ordinal()) {
            String log = FileLoggerConfiguration.format(msg,LoggingLevel.INFO);
            writeToFile(log);
        }
    }

    public void debug(String msg) {
        if (FileLoggerConfiguration.level.ordinal() >= LoggingLevel.DEBUG.ordinal()) {
            String log = FileLoggerConfiguration.format(msg,LoggingLevel.DEBUG);
            writeToFile(log);
        }
    }

    private void writeToFile(String msg) {
        try {
            if (FileLoggerConfiguration.filePath.length() < FileLoggerConfiguration.maxSizeFile) {
                outputStream.write(msg.getBytes());
                outputStream.write("\n".getBytes());
                outputStream.flush();
            } else {
                throw new FileMaxSizeReachedException("Max size file: " + FileLoggerConfiguration.maxSizeFile
                        + " File size: " + FileLoggerConfiguration.filePath.length() + "byte"
                        + " File path: " + FileLoggerConfiguration.filePath + "byte");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
