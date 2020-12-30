import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class Dictionary implements Dictionaries,  Comparator {

    private Map<String, String> dictReference = new HashMap<>();
    private Path workFile;
    public Dictionary(Path workFile) {

        this.workFile = workFile;
        create();
    }


    @Override
    public void create() {
        try (BufferedReader reader = Helper.openReader(this.workFile)) {
            System.out.println(Files.exists(this.workFile));
            String line = reader.readLine();
            while (line != null)
            {
                try {
                    List<String> pairs = Arrays.asList(line.split("    "));
                    try {
                        pairs.get(1).replaceAll("\\n", "");
                        System.out.println(pairs.get(1));
                    }catch (PatternSyntaxException pe){
                        System.out.println(pe.getClass().getSimpleName() +" : " +pe.getMessage() );
                    }catch (IndexOutOfBoundsException iob){
                        System.out.println(iob.getClass().getSimpleName() +" : " +iob.getMessage() );
                    }
                    while (pairs.size() < 2) {
                        line = reader.readLine();
                        pairs = Arrays.asList(line.split("    "));
                    }

                    dictReference.put(pairs.get(0), pairs.get(1));
                }catch (PatternSyntaxException pe){
                    pe.getMessage();

                }catch (NullPointerException ne){
                        ne.getMessage();

                    }
               line = reader.readLine();

            }


        } catch (IOException e)
            {
                System.out.println("Exception in German dict:"+e.getClass().getSimpleName() + ":" + e.getMessage());
                e.getLocalizedMessage();
                e.printStackTrace();
            }
    }

    @Override
    public void update() {
        create();
    }

    @Override
    public int compare(Object o1, Object o2) {

        return 0;
    }


    public void printOut(){
        var gd = dictReference.entrySet();
        for (Map.Entry<String, String> entry : gd){
            System.out.println (entry.getKey() + "    " + entry.getValue());
        }
    }

    public Map<String, String> getDict(){
        return dictReference;
    }
}


