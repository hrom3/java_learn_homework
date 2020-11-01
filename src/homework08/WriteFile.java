package homework08;

import homework05.ReadFileToString;
import homework08.siteloader.ExchangeRate;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


public class WriteFile {

    private String path;

    public String getPath() {
        return path;
    }

    public void rateToFile(ExchangeRate cur) {
        String fileName = cur.getBank() + "_" + cur.getCurAbbrev() + ".txt";
        if (this.path == null || path.length() == 0) {
            path = "";
        }
        String pathToReturn = path + fileName;

        writeRateToFile(cur, pathToReturn);
    }


    private void writeRateToFile(ExchangeRate cur, String path) {
        File file = new File(path);

        TreeSet<ExchangeRate> set = new TreeSet<>();

        if (file.exists()) {
            fileToTreeSet(path, set);
        }

        set.add(cur);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {

            if (set == null) {
                System.out.println("Отсутсвуют данные для сохранения");
                return;
            }
            oos.writeObject(set);

        } catch (FileNotFoundException e) {
            System.out.println("Что-то не так с файлом, " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Что-то совсем не так, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public void setFilePath() {
        String path = "";
        System.out.println("Для сохранения файла рядом с программой нажмите Enter");
        System.out.println("для сохранения по другому пути введите путь к файлу " +
                "и нажмите Enter");

        Scanner scanner = new Scanner(System.in);
        this.path = scanner.nextLine();
    }

    public static void printFromFile(String path) {
        TreeSet<ExchangeRate> set = new TreeSet<>();
        fileToTreeSet(path, set);
        for (ExchangeRate exchangeRate : set) {
            System.out.println(exchangeRate.toStringForCons());
        }
    }

    private static void fileToTreeSet(String path, TreeSet<ExchangeRate> set) {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {

            set.addAll((TreeSet<ExchangeRate>) in.readObject());

        } catch (FileNotFoundException e) {
            System.out.println("Что-то не так с файлом, " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Что-то совсем не так, " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("Клас не найден, " + e.getMessage());

        }
    }


}
