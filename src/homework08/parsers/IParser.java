package homework08.parsers;

import homework08.siteloader.ExchangeRate;

public interface IParser {
    void currencyParser(String content, ExchangeRate currency);
}
