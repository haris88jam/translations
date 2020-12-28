import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> untranslatedTexts = new ArrayList<>();

        try (BufferedReader reader = Helper.openReader(WorkFile.UNTRANSLATEDTEXTS);){
            String line = reader.readLine();

            while (line!=null)
            {
                untranslatedTexts.add(line);
                line = reader.readLine();
            }



        }catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + ":" + e.getMessage());
        }
        System.out.println(untranslatedTexts);
        GermanDictionary gd = new GermanDictionary();
//        gd.printOut();


//        try (BufferedReader br = Files.newBufferedReader(WorkFile.untranslatedTexts)) {
//            String line = br.readLine();
//            List<String> l = new ArrayList<>(Arrays.asList(line.split("    ")));
//            String indexKey = l.get(0);
//            String definitionEn = l.get(1);
//            System.out.println(l);
//            Map<String, String> englishDict = new HashMap();
//            englishDict.put(indexKey, definitionEn);
//            englishDict.forEach(indexKey, definitionEn) -> System.out.println(indexKey + "    " + definitionEn);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//            System.out.println(e1.getClass().getSimpleName() + e1.getMessage());
//        }

//        try (BufferedReader br = Files.newBufferedReader(inEnglish)) {
//            String line = br.readLine();
//            List<String> l = new ArrayList<>(Arrays.asList(line.split("    ")));
//            String indexKey = l.get(0);
//            String definitionEn = l.get(1);
//            System.out.println(l);
//            Map<String, String> englishDict = new HashMap();
//            englishDict.put(indexKey, definitionEn);
//            englishDict.forEach(indexKey, definitionEn) -> System.out.println(indexKey + "    " + definitionEn);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//            System.out.println(e1.getClass().getSimpleName() + e1.getMessage());
//        }
//

//        try (BufferedReader aFR = Files.newBufferedReader(actualFile); BufferedWriter aFW = Files.newBufferedWriter(Path.of("./src/files/toBeMapped.txt"))) {
//
//                List<String> lineAF = new ArrayList<>();
//                Set<String> definitions = new HashSet<>();
//
//
//            Collections.addAll(lineAF, aFR.readLine().split(" "));
//            while (lineAF.get(lineAF.size()-1).equals("END") != true) {
//                while(lineAF.get(lineAF.size()-1) == null){
//                    lineAF.add(aFR.readLine());
//
//                }
//                Collections.addAll(lineAF, aFR.readLine().split(" "));
//
//            }
//            definitions.addAll(lineAF);
//            for (String d : definitions){
//                aFW.write("\n"+d);
//            }
//
//
//
//        } catch (IOException e2) {
//            e2.printStackTrace();
//            System.out.println(e2.getClass().getSimpleName() + e2.getMessage());
//        } catch (NullPointerException n2){
//            n2.printStackTrace();
//        }


    }


}
