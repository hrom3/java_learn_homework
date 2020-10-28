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
        String[] string = new String[3];
        int i = 0;
        Pattern pattern = Pattern.compile("\\{[\\w\\s.,:\"\\-A-Za-zА-яЁё]+\\}");
 //       content = "{\"rates\":[{\"sellRate\":2.970000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":3.120000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"евро\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":89.000000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":94.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":1.160000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":1.200000,\"buyIso\":\"USD\",\"buyCode\":840,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":3.270000,\"sellIso\":\"RUB\",\"sellCode\":643,\"buyRate\":3.420000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":100,\"name\":\"российских рублей\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":2.570000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":2.650000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"доллар США\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":75.000000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":80.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"}]}\n";
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String s = matcher.group();
            String d = s.replaceAll("\\{?\"\\}?", "");
            //           if (d.indexOf("933") < 0 || d.indexOf("840") < 0) {
            if (d.indexOf("933") < 0) {
                continue;
            }
            string[i] = d;
            i++;
        }
//        for (String s : string) {
//            Pattern pattern1 = Pattern.compile("sellRate:\\s*[\\d.]+");
//            Matcher matcher1 = pattern1.matcher(s);
//            while (matcher1.find()) {
//                String k = matcher.group();
//                s = k.replaceAll("sellRate:", "");
//            }
//        }



        for (String s : string) {
            System.out.println(s);
        }
   }
}

