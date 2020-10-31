package homework08.utils;

import homework08.siteloader.AlphaBankLoader;
import homework08.siteloader.ExchangeRate;
import homework08.siteloader.NBRBLoader;
import homework08.siteloader.SiteLoader;

import java.util.Date;
import java.util.TreeSet;

import static homework08.WriteFile.rateToFile;
import static homework08.utils.DateFromArgs.*;

public class Test {
    public static void main(String[] args) {


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
//                System.out.println(dateToStr(date));
                printRates(new NBRBLoader(), date);
            }
            printRates(new AlphaBankLoader(), dates.first());

        } else {
            printRates(new NBRBLoader());
            printRates(new AlphaBankLoader());
        }

    }

    public static void printRates(SiteLoader loader){
        ExchangeRate curEUR = loader.load(SiteLoader.Currency.EUR);
//        ExchangeRate curRUB = loader.load(SiteLoader.Currency.RUB);
//        ExchangeRate curUSD = loader.load(SiteLoader.Currency.USD);

//        WriteFile wrtf = new WriteFile();
        rateToFile(curEUR);
        
        System.out.println(curEUR.toStringForCons());
 //       System.out.println(curRUB.toStringForCons());
 //       System.out.println(curUSD.toStringForCons());

    }

    public static void printRates(SiteLoader loader, Date date){
        ExchangeRate curEUR = loader.load(SiteLoader.Currency.EUR, date);
 //       ExchangeRate curRUB = loader.load(SiteLoader.Currency.RUB, date);
 //       ExchangeRate curUSD = loader.load(SiteLoader.Currency.USD, date);


        rateToFile(curEUR);

        System.out.println(curEUR.toStringForCons());
 //       System.out.println(curRUB.toStringForCons());
 //       System.out.println(curUSD.toStringForCons());

    }



    private static double getRate(ExchangeRate currency, SiteLoader.Currency currencyName) {
        if (currency != null && currency.getCurAbbrev().equals(currencyName.toString())) {
            return (currency.getCurScale() * currency.getCurOffRate().doubleValue());
        }
        System.err.println("Что-то пошло не так");
        return 0.0;
    }
}
