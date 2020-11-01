package homework08.utils;

import homework08.WriteFile;
import homework08.siteloader.AlphaBankLoader;
import homework08.siteloader.ExchangeRate;
import homework08.siteloader.NBRBLoader;
import homework08.siteloader.SiteLoader;

import java.util.Date;
import java.util.TreeSet;

import static homework08.WriteFile.printFromFile;
import static homework08.utils.DateFromArgs.*;

public class Test {
    public static void main(String[] args) {

        WriteFile path = new WriteFile();
        path.setFilePath();
        TreeSet<ExchangeRate> exchangeRateTreeSet = new TreeSet<>();

        boolean isCurrentDate = false;

        TreeSet<Date> dates = new TreeSet<>();

        if (args == null || args.length == 0) {
            isCurrentDate = true;
        } else {
            try {
                dates = dateArrListFromDate(args);
            } catch (BadArgumentException e) {
                isCurrentDate = true;
            }
        }

        if (!isCurrentDate) {
            for (Date date : dates) {
                getRates(new NBRBLoader(), exchangeRateTreeSet, date);
            }
            getRates(new AlphaBankLoader(), exchangeRateTreeSet, dates.first());

        } else {
            getRates(new NBRBLoader(), exchangeRateTreeSet);
            getRates(new AlphaBankLoader(), exchangeRateTreeSet);
        }
        printRates(exchangeRateTreeSet);
        writeRates(exchangeRateTreeSet, path);

        printFromFile("NBRB_USD.txt");


    }

    public static void getRates(SiteLoader loader, TreeSet<ExchangeRate> rate) {
        rate.add(loader.load(SiteLoader.Currency.EUR));
        rate.add(loader.load(SiteLoader.Currency.RUB));
        rate.add(loader.load(SiteLoader.Currency.USD));
    }

    public static void getRates(SiteLoader loader, TreeSet<ExchangeRate> rate, Date date) {
        rate.add(loader.load(SiteLoader.Currency.EUR, date));
        rate.add(loader.load(SiteLoader.Currency.RUB, date));
        rate.add(loader.load(SiteLoader.Currency.USD, date));
    }

    public static void printRates(TreeSet<ExchangeRate> rate) {
        for (ExchangeRate exchangeRate : rate) {
            System.out.println(exchangeRate.toStringForCons());
        }
    }

    public static void writeRates(TreeSet<ExchangeRate> rate, WriteFile path) {
        for (ExchangeRate exchangeRate : rate) {
            path.rateToFile(exchangeRate);
        }
    }

    private static double getRate(ExchangeRate currency, SiteLoader.Currency currencyName) {
        if(currency!=null && currency.getCurAbbrev().equals(currencyName.toString())) {
            return(currency.getCurScale() * currency.getCurOffRate().doubleValue());
        }
        System.err.println("Что-то пошло не так");
        return 0.0;
    }
}
