package homework08;


import homework08.siteloader.CurParser;
import utils.json.simple.parser.JSONParser;
import utils.json.simple.parser.ParseException;

public class StrParser {
    public static void main(String[] args) throws ParseException, java.text.ParseException {
        String json = "{\"USD_in\":\"2.5250\",\"USD_out\":\"2.5800\",\"EUR_in\":\"2.9600\",\"EUR_out\":\"3.0400\",\"RUB_in\":\"3.2400\",\"RUB_out\":\"3.3600\",\"GBP_in\":\"3.2400\",\"GBP_out\":\"3.4060\",\"CAD_in\":\"0.0000\",\"CAD_out\":\"0.0000\",\"PLN_in\":\"6.3430\",\"PLN_out\":\"6.7240\",\"UAH_in\":\"6.7000\",\"UAH_out\":\"9.6000\",\"SEK_in\":\"0.0000\",\"SEK_out\":\"0.0000\",\"CHF_in\":\"2.7300\",\"CHF_out\":\"2.8640\",\"USD_EUR_in\":\"0.8306\",\"USD_EUR_out\":\"1.1473\",\"USD_RUB_in\":\"75.1490\",\"USD_RUB_out\":\"0.0126\",\"RUB_EUR_in\":\"0.0107\",\"RUB_EUR_out\":\"88.0950\",\"JPY_in\":\"0.0000\",\"JPY_out\":\"0.0000\",\"CNY_in\":\"3.6820\",\"CNY_out\":\"3.8990\",\"CZK_in\":\"0.0000\",\"CZK_out\":\"0.0000\",\"NOK_in\":\"0.0000\",\"NOK_out\":\"0.0000\",\"filial_id\":\"2504\",\"sap_id\":\"50033151\",\"info_worktime\":\"Пн 9 00 19 00    |Вт 9 00 19 00    |Ср 9 00 19 00    |Чт 9 00 19 00    |Пт 9 00 18 00    |Сб        |Вс        |\",\"street_type\":\"пр.\",\"street\":\"Дзержинского\",\"filials_text\":\"Центр банковских услуг 500\\/Операционная служба\",\"home_number\":\"69\\/1\",\"name\":\"Минск\",\"name_type\":\"г.\"}";

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        System.out.println(obj);
        CurParser euro = new CurParser();
        euro.setCurOffRate(json);
        System.out.println(euro.getCurOffRate());

        CurParser euro2 = new CurParser(json);
        System.out.println(euro2);

    }
}
