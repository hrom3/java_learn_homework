package homework08.parsers;

import homework08.siteloader.ExchangeRate;
import homework08.utils.Converters;
import homework08.utils.DateFromArgs;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlfaParser implements IParser {

    @Override
    public void currencyParser(String content, ExchangeRate currency) {
        if (content == null) {
            return;
        }

        String string = "";
        int i;

        Pattern pattern = Pattern.compile("\\{[\\w\\s.,:\"\\-A-Za-zА-яЁё]+\\}");
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String s = matcher.group().replaceAll("\\{?\"\\}?", "");
            if (!s.contains("933") || !s.contains(Integer.toString(currency.getCurID()))) {
                continue;
            }
            string = s;
        }

        currency.setCurOffRate(getValueFromString(string,
                "buyRate:\\s*[\\d.]+", "\\w+:\\s*"));

        currency.setCurAbbrev(getValueFromString(string,
                "sellIso:\\s*\\w+", "sellIso:\\s*"));

        currency.setCurScale(Converters.getIntFromString(getValueFromString(string,
                "quantity:\\s*\\d+", "\\w+:\\s*")));


        currency.setDate(DateFromArgs.strToDateAlfa(getValueFromString(string,
                "date:\\s*\\d*\\-\\d*\\-\\d*", "date:\\s*")));

        currency.setIsNoData(false);

   }

   public static String getValueFromString(String content, String stringToFound, String stringToReplace) {
       Pattern pattern = Pattern.compile(stringToFound);
       Matcher matcher = pattern.matcher(content);
       if (matcher.find()) {
            return matcher.group().replaceAll(stringToReplace, "");
       }
       return "";
   }
}

