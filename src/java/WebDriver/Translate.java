package WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Translate extends WBbase{
    final static String filenameOfDict = "/home/aibek/IdeaProjects/TranslateSzder/src/resources/dict.txt";
    final static  String filenameOfTranslateWords = "/home/aibek/IdeaProjects/TranslateSzder/src/resources/words.txt";

    public static void main(String[] args) throws InterruptedException, IOException {

            openWebSite("https://sozdik.kz/");

            String text = textFromFile(filenameOfDict);
            String text2 = textFromFile(filenameOfTranslateWords);

            String[] lines = text.split("\n");

            StringBuilder saveToFile = new StringBuilder();

            for (int i = 0; i <222; i++) {

                String[] line = lines[i].split(",");
                System.out.println((i+1)+") "+line[0]+" - "+ translateKazToRus(line[0]));

                saveToFile.append("{" + "\n" + "\t" + "\"firstWord\": \"")
                        .append(line[0]).append("\",")
                        .append("\n")
                        .append("\t").append("\"translateToKaz\": \"")
                        .append(translateKazToRus(line[0]))
                        .append("\"").append("\n").append("}").append("\n");

            }

            // Change to JSON
            FileWriter writer = new FileWriter(filenameOfTranslateWords);

            if(!text2.equals("")) {

                writer.write(text2 + "\n" + String.valueOf(saveToFile));

            }else{

                writer.write(String.valueOf(saveToFile));

            }

            writer.flush();
            writer.close();
    }

    public static String textFromFile(String filename) throws IOException {
        FileInputStream stream = new FileInputStream(filename);
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);

        String text = new String(data);
        return text;
    }
}
