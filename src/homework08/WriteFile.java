package homework08;

import homework08.siteloader.CurParser;

import java.io.*;

public class WriteFile {
    public static void rateToFile(CurParser cur) {
        try {
            FileWriter fos = new FileWriter("data.txt");
            BufferedWriter out = new BufferedWriter(fos);
            StringBuilder str = new StringBuilder(cur.getCurAbbrev());
            str.append(";");
            str.append(cur.getDate());
            str.append(";");
            double rate = cur.getCurScale() * cur.getCurOffRate().doubleValue();
            str.append(rate);
            out.write(str.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Что-то не так с файлом, " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Что-то совсем не так, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
