import java.io.IOException;

public interface Logger {
    void info(String msg)throws IOException;
    void debug(String msg)throws IOException;
}

