package yandex;

import parser.ParserSettings;

public class YandexSettings extends ParserSettings {

    public YandexSettings(String query, int startPoint, int endPoint) {
        externalStartPoint = startPoint;
        externalEndPoint = endPoint;
        internalStartPoint = 1;
        internalEndPoint = 1;
        BASE_URL = "https://yandex.ru/images/search";
        SEPARATOR = "?";
        PREFIX = "text=" + query + "&p={CurrentId}";
    }
}