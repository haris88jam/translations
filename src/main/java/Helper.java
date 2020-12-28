import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Helper {

    public static BufferedReader openReader(Path filename) throws IOException {
        return Files.newBufferedReader(filename, StandardCharsets.ISO_8859_1);
    }

    public static BufferedWriter openWriter(Path filename) throws IOException{
        return Files.newBufferedWriter(filename);
    }
}
