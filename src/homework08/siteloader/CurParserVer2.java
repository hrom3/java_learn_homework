package homework08.siteloader;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static homework08.utils.DateFromArgs.dateToStr;

public class CurParserVer2 {
    @Override
    public String toString() {
        return "CurParser:" +
                "\n Cur_ID = " + curID +
                "\n Date = " + date +
                "\n CurAbbrev = " + curAbbrev +
                "\n CurScale = " + curScale +
                "\n CurName = " + curName +
                "\n CurOffRate = " + curOffRate;
    }
    public String toStringForCons() {
        return "Rate of " + curAbbrev +
                " on date " + dateToStr(date)  +
                " is " + (curScale * curOffRate.doubleValue());
    }

    private String bank;
    private int curID;
    private Date date;
    private String curAbbrev;
    private int curScale;
    private String curName;
    private BigDecimal curOffRate;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getCurID() {
        return curID;
    }

    public void setCurID(int curID) {
        this.curID = curID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurAbbrev() {
        return curAbbrev;
    }

    public void setCurAbbrev(String curAbbrev) {
        this.curAbbrev = curAbbrev;
    }

    public int getCurScale() {
        return curScale;
    }

    public void setCurScale(int curScale) {
        this.curScale = curScale;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public BigDecimal getCurOffRate() {
        return curOffRate;
    }

    public void setCurOffRate(BigDecimal curOffRate) {
        this.curOffRate = curOffRate;
    }

    public CurParserVer2(String str, String bank) {
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

        this.bank = bank;

        substr = arrStr[0].substring(arrStr[0].indexOf(':') + 1);
        this.curID = Integer.parseInt(substr);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//, Locale.ENGLISH);
        try {
            this.date = format.parse(arrStr[1].substring(arrStr[1].indexOf(':') + 2, arrStr[1].length() - 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.curAbbrev = arrStr[2].substring(arrStr[2].indexOf(':') + 2, arrStr[2].length() - 1);

        substr = arrStr[3].substring(arrStr[3].indexOf(':') + 1);
        this.curScale = Integer.parseInt(substr);

        this.curName = arrStr[4].substring(arrStr[4].indexOf(':') + 2, arrStr[4].length() - 1);

        substr = arrStr[5].substring(arrStr[5].indexOf(':') + 1);
        this.curOffRate = new BigDecimal(substr);
    }

    public CurParserVer2() {
    }

    public void setCurOffRate(String str) {
       final String fieldNameCurOffRate1 = "\"Cur_OfficialRate\":";
       String substr = str.substring((str.indexOf("\"Cur_OfficialRate\":") + 19), str.indexOf('}'));
       BigDecimal rate = new BigDecimal(substr);
       this.curOffRate = rate;
    }
}

