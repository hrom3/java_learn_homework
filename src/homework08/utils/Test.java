package homework08.utils;

import homework08.WriteFile;
import homework08.siteloader.CurParserVer2 ;
import homework08.siteloader.NBRBLoader;
import homework08.siteloader.SiteLoader;
import homework08.utils.BadArgumentException;
import homework08.utils.DateFromArgs;

import java.util.Date;
import java.util.TreeSet;

import static homework08.WriteFile.rateToFile;
import static homework08.utils.DateFromArgs.dateArrListFromDate;
import static homework08.utils.DateFromArgs.dateToStr;

public class Test {
    public static void main(String[] args) {
        TreeSet<Date> dates = new TreeSet<>();
        try {
            dates = dateArrListFromDate(args);
        } catch (BadArgumentException e) {
            dates.add(new Date());
        }
        for (Date date : dates) {
 //           System.out.println(dateToStr(date));
            printRates(new NBRBLoader(dateToStr(date)));
        }

    }

    public static void printRates(SiteLoader loader){
        CurParserVer2 curEUR = loader.load(SiteLoader.Currency.EUR);
        CurParserVer2 curRUB = loader.load(SiteLoader.Currency.RUB);
        CurParserVer2 curUSD = loader.load(SiteLoader.Currency.USD);

//        WriteFile wrtf = new WriteFile();
        rateToFile(curEUR);
        
        System.out.println(curEUR.toStringForCons());
        System.out.println(curRUB.toStringForCons());
        System.out.println(curUSD.toStringForCons());

    }



    private static double getRate(CurParserVer2  currency, SiteLoader.Currency currencyName) {
        if (currency != null && currency.getCurAbbrev().equals(currencyName.toString())) {
            return (currency.getCurScale() * currency.getCurOffRate().doubleValue());
        }
        System.err.println("Что-то пошло не так");
        return 0.0;
    }
}
