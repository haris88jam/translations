import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> untranslatedTexts = new ArrayList<>();
        try (BufferedWriter writer = Helper.openWriter(Path.of("./src/files/testforEncoding.txt"))){
            writer.write("öäüÖÄÜ");
        }catch (IOException e){
            e.getMessage();
        }
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

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = Helper.openWriter(Path.of("./src/files/testOutput.txt"));
             BufferedWriter writer2 = Helper.openWriter(WorkFile.NOTFOUNDTEXTS)){
            var germanTexts = gd.getGermanDict();


            List<String> germanList = new ArrayList<>();
            germanTexts.forEach((key, value) ->
                    germanList.add(value));
            List<String> helpList = new ArrayList<>();




            for (String ut : untranslatedTexts){
                System.out.println(ut.toUpperCase()+"\n");
                if (ut.toUpperCase().equals("VOLLMELDER")){
                    System.out.println(germanTexts.hashCode());
                    String tempMap = germanTexts.get("V228");
                    System.out.println(ut.toUpperCase().equals(germanTexts.get("V228")));
                }
//                if (germanList.contains(ut.toUpperCase())){
//                    System.out.println("German List contains " + ut + ".");
                    Map<String, String> result = germanTexts.entrySet()
                            .stream()
                            .filter(map -> map.getValue().equals(ut.toUpperCase()))
                            .collect(Collectors.toMap(map-> map.getKey(),map ->map.getValue()));
                    for (var entry:result.entrySet()){
                        writer.write(entry.getKey() +"    "+entry.getValue()+"\n");
                    }
                    System.out.println("result:" + result);

                    if (result.isEmpty()) {
                        System.out.println("Not found:"+ ut.toUpperCase());
                        writer2.write(ut.toUpperCase()+"\n");
                    }

//                }
//                else{
//                    System.out.println("Not found:" + ut.toUpperCase());
//                    System.out.println(":>");
//                    writer2.append(ut+"\n");
//                    //String manualText = reader.readLine();
//                    if (manualText == "c")
//                        writer.write("****" + ut);

//                }

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
