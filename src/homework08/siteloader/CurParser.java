package homework08.siteloader;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CurParser {
    @Override
    public String toString() {
        return "CurParser:" +
                "\n Cur_ID = " + Cur_ID +
                "\n Date = " + Date  +
                "\n CurAbbrev = " + CurAbbrev +
                "\n CurScale = " + CurScale +
                "\n CurName = " + CurName +
                "\n CurOffRate = " + CurOffRate;
    }

//    private final String fieldNameCUR_ID = "\"Cur_ID\"";
//    private final String fieldNameDate = "\"Date\"";
//    private final String fieldNameCurAbbrev = "\"Cur_Abbreviation\"";
//    private final String fieldNameCurScale = "\"Cur_Scale\"";
//    private final String fieldNameCurName = "\"Cur_Name\"";
//    private final String fieldNameCurOffRate = "\"Cur_OfficialRate\"";

    private int Cur_ID;
    private Date Date;
    private String CurAbbrev;
    private int CurScale;
    private String CurName;
    private BigDecimal CurOffRate;

    public int getCur_ID() {
        return this.Cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        this.Cur_ID = cur_ID;
    }

    public Date getDate() {
        return this.Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    public String getCurAbbrev() {
        return this.CurAbbrev;
    }

    public void setCurAbbrev(String curAbbrev) {
        this.CurAbbrev = curAbbrev;
    }

    public int getCurScale() {
        return this.CurScale;
    }

    public void setCurScale(int curScale) {
        this.CurScale = curScale;
    }

    public String getCurName() {
        return this.CurName;
    }

    public void setCurName(String curName) {
        this.CurName = curName;
    }

    public BigDecimal getCurOffRate() {
        return this.CurOffRate;
    }

    public void setCurOffRate(BigDecimal curOffRate) {
        this.CurOffRate = curOffRate;
    }

    public CurParser(String str) {
        if (str == null || str.length() <= 6) {
            return;
        }
        String substr = str.substring(str.indexOf('{') + 1, str.indexOf('}'));
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
        this.Cur_ID = Integer.parseInt(substr);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//, Locale.ENGLISH);
        try {
            this.Date = format.parse(arrStr[1].substring(arrStr[1].indexOf(':') + 2, arrStr[1].length() - 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.CurAbbrev = arrStr[2].substring(arrStr[2].indexOf(':') + 2, arrStr[2].length() - 1);

        substr = arrStr[3].substring(arrStr[3].indexOf(':') + 1);
        this.CurScale = Integer.parseInt(substr);

        this.CurName = arrStr[4].substring(arrStr[4].indexOf(':') + 2, arrStr[4].length() - 1);

        substr = arrStr[5].substring(arrStr[5].indexOf(':') + 1);
        this.CurOffRate = new BigDecimal(substr);
    }

    public CurParser() {
    }

    public void setCurOffRate(String str) {
       final String fieldNameCurOffRate1 = "\"Cur_OfficialRate\":";
       String substr = str.substring((str.indexOf("\"Cur_OfficialRate\":") + 19), str.indexOf('}'));
       BigDecimal rate = new BigDecimal(substr);
       this.CurOffRate = rate;
    }
}

