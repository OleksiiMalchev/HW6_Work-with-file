import java.io.FileNotFoundException;

public interface ConfigurationLoader {
    LoggerConfiguration getConfiguration(String str) throws FileNotFoundException;
}