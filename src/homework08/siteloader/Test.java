package homework08.siteloader;

import homework08.WriteFile;
import homework08.siteloader.NBRBLoader;
import homework08.siteloader.SiteLoader;

public class Test {
    public static void main(String[] args) {
        printRates(new NBRBLoader());
    }

    public static void printRates(SiteLoader loader){
        CurParser curEUR = loader.load(SiteLoader.Currency.EUR);
        CurParser curRUB = loader.load(SiteLoader.Currency.RUB);
        CurParser curUSD = loader.load(SiteLoader.Currency.USD);

        WriteFile wrtf = new WriteFile();
        wrtf.rateToFile(curEUR);
        
        System.out.println(getRate(curEUR, SiteLoader.Currency.EUR));
        System.out.println(getRate(curRUB, SiteLoader.Currency.RUB));
        System.out.println(getRate(curUSD, SiteLoader.Currency.USD));
    }



    private static double getRate(CurParser currency, SiteLoader.Currency currencyName) {
        if (currency != null && currency.getCurAbbrev().equals(currencyName.toString())) {
            return (currency.getCurScale() * currency.getCurOffRate().doubleValue());
        }
        System.err.println("Что-то пошло не так");
        return 0.0;
    }
}
