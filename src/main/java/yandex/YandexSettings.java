package yandex;

import parser.ParserSettings;

public class YandexSettings extends ParserSettings {

    public YandexSettings(String query) {
        externalStartPoint = 1;
        externalEndPoint = 1;
        internalStartPoint = 1;
        internalEndPoint = 1;
        BASE_URL = "https://yandex.ru/images/search";
        SEPARATOR = "?";
        PREFIX = "text=" + query;
    }
}