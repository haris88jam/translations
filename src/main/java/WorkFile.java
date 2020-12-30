import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class WorkFile {

    public static Path ENGLISHTRANSLATIONS = Path.of("./src/files/bs_en.txt");
    public static Path GERMANTRANSLATIONS = Path.of("./src/files/bs_de.txt");
    public static Path UNTRANSLATEDTEXTS = Path.of("./src/files/toBeMapped.txt");
    public static Path translatedTexts = Path.of("./src/files/translatedTexts.txt");
    public static Path ACTUALFILE = Path.of("./src/files/actualText.txt");
    public static Path NOTFOUNDTEXTS = Path.of("./src/files/notFoundTexts.txt");
    public static Path GERMANOUTPUT = Path.of("./src/files/germanOutput.txt");
    public static Path ENGLISHOUTPUT = Path.of("./src/files/englishOutput.txt");
}
