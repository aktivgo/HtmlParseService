package kirovportal;

import parser.ParserSettings;

public class KirovportalSettings extends ParserSettings {

    public KirovportalSettings(int startPage, int endPage) {
        if (startPage <= 0 || endPage < startPage) {
            throw new IllegalArgumentException("Неккоректные входные данные");
        }

        externalStartPoint = startPage;
        externalEndPoint = endPage;
        internalStartPoint = 1;
        internalEndPoint = 1;
        BASE_URL = "https://kirov-portal.ru/news/";
        SEPARATOR = "?";
        PREFIX = "page={CurrentId}";
    }
}
