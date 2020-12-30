import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
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

        Dictionary gd = new Dictionary(WorkFile.GERMANTRANSLATIONS);
        Dictionary ed = new Dictionary(WorkFile.ENGLISHTRANSLATIONS);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = Helper.openWriter(WorkFile.GERMANOUTPUT);
             BufferedWriter writer2 = Helper.openWriter(WorkFile.NOTFOUNDTEXTS);
             BufferedWriter writer3 = Helper.openWriter(WorkFile.ENGLISHOUTPUT)){
            var germanTexts = gd.getDict();
            var englishTexts = ed.getDict();

            for (String ut : untranslatedTexts)
            {
                System.out.println(ut.toUpperCase()+"\n");
                Map<String, String> result = germanTexts.entrySet()
                        .stream()
                        .filter(map -> map.getValue().equals(ut.toUpperCase()))
                        .collect(Collectors.toMap(map-> map.getKey(),map ->map.getValue()));
                for (var entry:result.entrySet())
                {
                    writer.write(entry.getKey() +"    "+entry.getValue()+"\n");
                    Map<String, String> transferToEnglish = englishTexts.entrySet()
                            .stream()
                            .filter(map -> map.getKey().equals(entry.getKey()))
                            .collect(Collectors.toMap(map->map.getKey(), map->map.getValue()));
                    for (var toEnglish:transferToEnglish.entrySet()){
                        writer3.write(toEnglish.getKey()+"    "+toEnglish.getValue()+"\n");
                    }
                }
                if (result.isEmpty() && !ut.matches(".*\\d+.*"))
                {
                    System.out.println("Not found:"+ ut.toUpperCase());
                    writer.append("****    "+ut+"\n");
                    writer2.write(ut.toUpperCase()+"\n");
                }
            }
        }catch (IOException ioe){
            ioe.getMessage();
        }


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

////        try (BufferedReader aFR = Files.newBufferedReader(WorkFile.ACTUALFILE, StandardCharsets.UTF_8);
////             BufferedWriter aFW = Files.newBufferedWriter(Path.of("./src/files/toBeMapped.txt"), StandardCharsets.ISO_8859_1);) {
////
////                List<String> lineAF = new ArrayList<>();
////                Set<String> definitions = new HashSet<>();
////
////
////            Collections.addAll(lineAF, aFR.readLine().split(" "));
////            while (lineAF.get(lineAF.size()-1).equals("END") != true) {
////                while(lineAF.get(lineAF.size()-1) == null){
////                    lineAF.add(aFR.readLine());
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
