package homework08.siteloader;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class NBRBLoader extends SiteLoader{

    private final String BANK = "NBRB";
    private String argsData;


    public NBRBLoader(String argsData) {
        this.argsData = argsData;
    }

    final static SimpleDateFormat formatOfDate = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return Объект типа курс валюты
     */
    @Override
    public CurParserVer2 load(SiteLoader.Currency currencyName) {
        return load("https://www.nbrb.by/api/exrates/rates/" +
                currencyName.getCodISO() + "?parammode=1&ondate=" +
                this.argsData, currencyName);
    }

//    /**
//     *  Метод для запуска загрузки курса валют для определнной даты
//     *
//     * @param currencyName валюта которую мы ищем
//     * @param date дате на которую мы ишем
//     * @return Объект типа курс валюты
//     */
//    public CurParser loadByDate(SiteLoader.Currency currencyName, Date date) {
//        return load("https://www.nbrb.by/api/exrates/rates/"+
//                currencyName.getCodISO() + "?parammode=1&ondate=" +
//                formatOfDate.format(date), currencyName);
//    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected CurParserVer2 handle(String content, SiteLoader.Currency currencyName) {
        CurParserVer2 currency = new CurParserVer2(content, this.BANK);
        return currency;
    }
}
