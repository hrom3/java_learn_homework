package homework08;

import homework08.siteloader.ExchangeRate;

import java.io.*;
import java.util.Scanner;

public class WriteFile {
    public static void rateToFile(ExchangeRate cur) {
        String fileName = cur.getBank()+ "_"  + cur.getCurAbbrev() + ".txt";
        String path = getFilePath() + fileName;

        rateToFile(cur, path);
    }



    private static void rateToFile(ExchangeRate cur, String path) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            if (cur == null) {
                System.out.println("Отсутсвуют данные для сохранения");
                return;
            }
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

    private static String getFilePath() {
        String path = "";
        System.out.println("Для сохранения файла рядом с програмой нажмите Enter");
        System.out.println("для сохранения по другому пути введите путь к файлу " +
                    "и нажмите Enter");

        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();

        return path;
    }
}
