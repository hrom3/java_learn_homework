package homework08.siteloader;

import homework08.parsers.AlfaParser;
import homework08.parsers.IParser;
import homework08.parsers.NBRBParser;

import java.util.Date;

import static homework08.utils.DateFromArgs.dateToStrNBRB;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class AlphaBankLoader extends SiteLoader{

    private final String BANK = "AlphaBank";

    /**
     * Метод для запуска загрузки курса валют на текущую дату
     *
     * @param currencyName валюта которую мы ищем
     * @return Объект типа курс валюты
     */
    @Override
    public ExchangeRate load(Currency currencyName) {
        return load("https://developerhub.alfabank.by:8273/partner/1.0.0/public/rates",
                currencyName);
    }

    /**
     *  Метод для запуска загрузки курса валют для определнной даты
     *
     * @param currencyName валюта которую мы ищем
     * @param date  дата на которую ищем
     * @return Объект типа курс валюты
     */
    public ExchangeRate load(Currency currencyName, Date date) {
        System.out.println("Нет возможности получить курс на выбранную дату");
        return new ExchangeRate(this.BANK);
    }

    /**
     * Обработка результата загрузки с сайта банка
     *
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected ExchangeRate handle(String content, Currency currencyName) {
        ExchangeRate currency = new ExchangeRate(this.BANK);
        IParser iParser = new AlfaParser();

        if (content != null) {
            iParser.currencyParser(content, currency);
        }
        return currency;
    }
}
