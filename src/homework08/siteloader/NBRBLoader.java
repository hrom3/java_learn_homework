package homework08.siteloader;

import homework08.parsers.IParser;
import homework08.parsers.NBRBParser;
import homework08.utils.Converters;

import java.text.SimpleDateFormat;
import java.util.Date;

import static homework08.utils.DateFromArgs.dateToStrNBRB;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class NBRBLoader extends SiteLoader{

    private final String BANK = "NBRB";

    /**
     * Метод для запуска загрузки курса валют на текущую дату
     *
     * @param currencyName валюта которую мы ищем
     * @return Объект типа курс валюты
     */
    @Override
    public ExchangeRate load(SiteLoader.Currency currencyName) {
        return load("https://www.nbrb.by/api/exrates/rates/" +
                currencyName.getCodISO() + "?parammode=1", currencyName);
    }

    /**
     *  Метод для запуска загрузки курса валют для определнной даты
     *
     * @param currencyName валюта которую мы ищем
     * @param date  дата на которую ищем
     * @return Объект типа курс валюты
     */
    public ExchangeRate load(SiteLoader.Currency currencyName, Date date) {
        return load("https://www.nbrb.by/api/exrates/rates/"+
                currencyName.getCodISO() + "?parammode=1&ondate=" +
                dateToStrNBRB(date), currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     *
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected ExchangeRate handle(String content, SiteLoader.Currency currencyName) {
        ExchangeRate currency = new ExchangeRate(this.BANK);
        IParser iParser = new NBRBParser();
        currency.setCurID(Converters.getIntFromString(currencyName.getCodISO()));

        if (content != null) {
            iParser.currencyParser(content, currency);
        }
        return currency;
    }
}
