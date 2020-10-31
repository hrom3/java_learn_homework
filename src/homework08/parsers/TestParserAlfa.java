package homework08.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestParserAlfa {
    public static void main(String[] args) {

        String[] string = new String[10];
        String content = "{\"rates\":[{\"sellRate\":2.970000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":3.120000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"евро\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":89.000000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":94.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":1.160000,\"sellIso\":\"EUR\",\"sellCode\":978,\"buyRate\":1.200000,\"buyIso\":\"USD\",\"buyCode\":840,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":3.270000,\"sellIso\":\"RUB\",\"sellCode\":643,\"buyRate\":3.420000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":100,\"name\":\"российских рублей\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":2.570000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":2.650000,\"buyIso\":\"BYN\",\"buyCode\":933,\"quantity\":1,\"name\":\"доллар США\",\"date\":\"2020-10-28T11:55:52.000Z\"},{\"sellRate\":75.000000,\"sellIso\":\"USD\",\"sellCode\":840,\"buyRate\":80.000000,\"buyIso\":\"RUB\",\"buyCode\":643,\"quantity\":1,\"name\":null,\"date\":\"2020-10-28T11:55:52.000Z\"}]}\n";

        int i = 0;
        Pattern pattern = Pattern.compile("\\{[\\w\\s.,:\"\\-A-Za-zА-яЁё]+\\}");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            string[i] = matcher.group();
            i++;
        }
        System.out.println(string.length);
        for (String s : string) {
            System.out.println(s);
        }
    }
}
