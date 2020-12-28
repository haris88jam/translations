import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class GermanDictionary implements Dictionaries,  Comparator {

    private Map<String, String> germanDict = new HashMap<>();

    public GermanDictionary() {
        create();
    }


    @Override
    public void create() {
        try (BufferedReader reader = Helper.openReader(WorkFile.GERMANTRANSLATIONS)) {
            System.out.println(Files.exists(WorkFile.GERMANTRANSLATIONS));
            String line = reader.readLine();
            while (line != null)
            {
                try {
                    List<String> pairs = Arrays.asList(line.split("    "));
                    while (pairs.size() < 2)
                        {
                            line = reader.readLine();
                            pairs = Arrays.asList(line.split("    "));
                        }
                    germanDict.put(pairs.get(0), pairs.get(1));
                }catch (NullPointerException p)
                    {
                        p.printStackTrace();
                        line = reader.readLine();
                    }
               line = reader.readLine();

            }


        } catch (IOException e)
            {
                System.out.println("Exception in German dict:"+e.getClass().getSimpleName() + ":" + e.getMessage());
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
        var gd = germanDict.entrySet();
        for (Map.Entry<String, String> entry : gd){
            System.out.println (entry.getKey() + "    " + entry.getValue());
        }
    }
}


