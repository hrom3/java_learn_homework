package homework08;


import homework08.siteloader.CurParser;
import utils.json.simple.parser.JSONParser;
import utils.json.simple.parser.ParseException;

public class StrParser {
    public static void main(String[] args) throws ParseException, java.text.ParseException {
        String json = "{\"Cur_ID\":292,\"Date\":\"2020-10-18T00:00:00\",\"Cur_Abbreviation\":\"EUR\",\"Cur_Scale\":1,\"Cur_Name\":\"Евро\",\"Cur_OfficialRate\":3.0118}";

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
