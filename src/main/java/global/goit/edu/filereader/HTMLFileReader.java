package global.goit.edu.filereader;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class HTMLFileReader implements FileReader {

    public static String read(String path) throws IOException {
        StringJoiner result = new StringJoiner("\n");

        File html = new File(path);

       if (html.exists()) {
            Scanner sc = new Scanner(html);
            StringJoiner content = new StringJoiner("\n");

            while (sc.hasNext()) {
                content.add(sc.nextLine());
            }
           return content.toString();
        }
        return result.toString();
    }
}