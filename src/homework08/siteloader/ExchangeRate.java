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
    private boolean isNoData = true;
    private double CurOffSellRate;
    private double CurOffBuyRate;

    public boolean getIsNoData() {
        return isNoData;
    }

    public void setIsNoData(boolean noData) {
        isNoData = noData;
    }

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
        if (date == null) {
            return "Bad date";
        }
        return "Rate of " + curAbbrev +
                " on date " + DATE_FORMAT.format(date) +
                " is " + (curScale * curOffRate.doubleValue());
    }

    public ExchangeRate() {
    }

    public ExchangeRate(String bank) {
        this.bank = bank;
    }

    public void setCurOffRate(String str) {
        this.curOffRate = new BigDecimal(str);
    }
}


