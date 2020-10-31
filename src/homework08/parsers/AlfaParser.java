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
 //       content = "{\"rates\":[{\"sellRate\":2.970000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":3.120000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"евро\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":89.000000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":94.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":1.160000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":1.200000,\"buyIso\":\"USD\",\"buyCode\":840,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":3.270000,\"sellIso\":\"RUB\",\"sellCode\":643,\"buyRate\":3.420000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":100,\"name\":\"российских рублей\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":2.570000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":2.650000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"доллар США\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":75.000000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":80.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"}]}\n";
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

