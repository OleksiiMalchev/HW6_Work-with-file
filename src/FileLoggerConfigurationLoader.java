import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileLoggerConfigurationLoader implements ConfigurationLoader {
    public LoggerConfiguration load(String str) throws FileNotFoundException {
        return getConfiguration(str);
    }

    public LoggerConfiguration getConfiguration(String str) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(str));
        List<String> logConfig = (List<String>) br.lines()
                .map(s -> s.split(":")[1])
                .collect(Collectors.toList());
        return toLog(logConfig);
    }

    private FileLoggerConfiguration toLog(List<String> row) {
        return new FileLoggerConfiguration(Path.of(row.get(0)), LoggingLevel.valueOf(row.get(1)), Byte.valueOf(row.get(2)),row.get(3));
    }
    
    
}



