package homework08.parsers;

import homework08.siteloader.ExchangeRate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlfaParser implements IParser {

    @Override
    public void currencyParser(String content, ExchangeRate currency) {
        if (content == null) {
            return;
        }
        Pattern pattern = Pattern.compile("\\{[\\w\\s.,:\"\\-A-Za-zА-яЁё]+\\}");
 //       content = "{\"rates\":\n" +
//                "[\n" +
//                "{\"sellRate\":88.000000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":93.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-23T10:10:56.000Z\"},\n" +
//                "{\"sellRate\":74.000000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":79.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-23T10:10:56.000Z\"},\n" +
//                "{\"sellRate\":1.160000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":1.200000,\"buyIso\":\"USD\",\"buyCode\":840,\"quantity\":1,\"name\":null,\"date\":\"2020-10-23T10:10:56.000Z\"},\n" +
//                "{\"sellRate\":3.250000,\"sellIso\":\"RUB\",\"sellCode\":643,\"buyRate\":3.400000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":100,\"name\":\"российских рублей\",\"date\":\"2020-10-23T10:10:56.000Z\"},\n" +
//                "{\"sellRate\":2.930000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":3.050000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"евро\",\"date\":\"2020-10-23T10:10:56.000Z\"},\n" +
//                "{\"sellRate\":2.510000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":2.570000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"доллар США\",\"date\":\"2020-10-23T10:10:56.000Z\"}\n" +
//                "]\n" +
//                "}";
        Matcher matcher = pattern.matcher(content);
        String substr;
        while (matcher.find()) {
            substr = matcher.group().substring(matcher.group().indexOf('{') + 1, matcher.group().indexOf('}'));
        }
   }
}
