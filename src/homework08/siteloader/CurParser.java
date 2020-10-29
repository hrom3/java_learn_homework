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
    private boolean isNoData = true;
    private double CurOffSellRate;
    private double CurOffBuyRate;

    public boolean isNoData() {
        return isNoData;
    }

    public void setNoData(boolean noData) {
        isNoData = noData;
    }

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

    public CurParser() {
    }

    public void setCurOffRate(String str) {
       final String fieldNameCurOffRate1 = "\"Cur_OfficialRate\":";
       String substr = str.substring((str.indexOf("\"Cur_OfficialRate\":") + 19), str.indexOf('}'));
       BigDecimal rate = new BigDecimal(substr);
       this.CurOffRate = rate;
    }
}

