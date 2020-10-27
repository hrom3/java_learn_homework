package homework08.siteloader;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExchangeRate {

    final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    private String bank;
    private int curID;
    private Date date;
    private String curAbbrev;
    private int curScale;
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

    public BigDecimal getCurOffRate() {
        return curOffRate;
    }

    public void setCurOffRate(BigDecimal curOffRate) {
        this.curOffRate = curOffRate;
    }

    @Override
    public String toString() {
        return "CurParser:" +
                "\n Cur_ID = " + curID +
                "\n Date = " + DATE_FORMAT.format(date) +
                "\n CurAbbrev = " + curAbbrev +
                "\n CurScale = " + curScale +
                "\n CurOffRate = " + curOffRate;
    }
    public String toStringForCons() {
        return "Rate of " + curAbbrev +
                " on date " + DATE_FORMAT.format(date)  +
                " is " + (curScale * curOffRate.doubleValue());
    }

    public ExchangeRate(String bank) {
        this.bank = bank;
    }


    public ExchangeRate() {
    }

    public void setCurOffRate(String str) {
       final String fieldNameCurOffRate1 = "\"Cur_OfficialRate\":";
       String substr = str.substring((str.indexOf("\"Cur_OfficialRate\":") + 19), str.indexOf('}'));
       BigDecimal rate = new BigDecimal(substr);
       this.curOffRate = rate;
    }
}

