package yandex;

import parser.ParserSettings;

public class YandexSettings extends ParserSettings {

    public static int count = 30;

    public YandexSettings(String query, int count) {
        externalStartPoint = 1;
        externalEndPoint = 1;
        internalStartPoint = 1;
        internalEndPoint = 1;
        BASE_URL = "https://yandex.ru/images/search";
        SEPARATOR = "?";
        PREFIX = "text=" + query + "&page=" + count / 30 + 1;
        YandexSettings.count = count;
    }
}