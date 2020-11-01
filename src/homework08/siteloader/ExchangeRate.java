package homework08.siteloader;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExchangeRate implements Comparable, Serializable {

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
    public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ExchangeRate that = (ExchangeRate) o;

            return date != null ? date.equals(that.date) : that.date == null;
        }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bank != null ? bank.hashCode() : 0;
        result = 31 * result + curID;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (curAbbrev != null ? curAbbrev.hashCode() : 0);
        result = 31 * result + curScale;
        result = 31 * result + (curOffRate != null ? curOffRate.hashCode() : 0);
        result = 31 * result + (isNoData ? 1 : 0);
        temp = Double.doubleToLongBits(CurOffSellRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(CurOffBuyRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
        return "Bank " + bank +
                ". Rate of " + curAbbrev +
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

    @Override
    public int compareTo(@NotNull Object o) {
        ExchangeRate entry = (ExchangeRate) o;
        if (isNoData) {
            return Integer.MIN_VALUE;
        }
        int result = this.getBank().compareTo(entry.getBank());
        if (result == 0) {
            result = this.curID - entry.curID;
        }
        if (result == 0) {
            return this.getDate().compareTo(entry.getDate());
        }
        return result;
    }
}


