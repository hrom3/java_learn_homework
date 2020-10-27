package homework08.parsers;

import homework08.siteloader.ExchangeRate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NBRBParser implements IParser {
    @Override
    public void currencyParser(String content, ExchangeRate currency) {

        if (content == null || content.length() <= 6) {
            return;
        }
        String substr = content.substring(content.indexOf('{') + 1, content.indexOf('}'));
        String[] arrStr = new String [6];

        int indexStart = 0;
        int indexEnd;

        for (int i = 0; i < arrStr.length; i++) {
            indexEnd = substr.indexOf(',');
            if (indexEnd == -1 && i == arrStr.length - 1) {
                arrStr[i] = substr;
                continue;
            }
            arrStr[i] = substr.substring(indexStart, indexEnd);
            substr = substr.substring(indexEnd + 1);
        }

        substr = arrStr[0].substring(arrStr[0].indexOf(':') + 1);
        currency.setCurID(Integer.parseInt(substr));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//, Locale.ENGLISH);
        try {
            Date date = format.parse(arrStr[1].substring(arrStr[1].indexOf(':') + 2, arrStr[1].length() - 1));
            currency.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        currency.setCurAbbrev(arrStr[2].substring(arrStr[2].indexOf(':') + 2, arrStr[2].length() - 1));

        substr = arrStr[3].substring(arrStr[3].indexOf(':') + 1);
        currency.setCurScale(Integer.parseInt(substr));

        substr = arrStr[5].substring(arrStr[5].indexOf(':') + 1);
        currency.setCurOffRate(new BigDecimal(substr));
    }

//    public void setCurOffRate(String str) {
//       final String fieldNameCurOffRate1 = "\"Cur_OfficialRate\":";
//       String substr = str.substring((str.indexOf("\"Cur_OfficialRate\":") + 19), str.indexOf('}'));
//       BigDecimal rate = new BigDecimal(substr);
//       this.curOffRate = rate;
//    }
}

