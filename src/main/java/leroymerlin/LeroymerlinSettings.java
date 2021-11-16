package leroymerlin;

import parser.ParserSettings;

public class LeroymerlinSettings extends ParserSettings {

    public LeroymerlinSettings(int startPage, int endPage, String category) {
        if (startPage <= 0 || endPage < startPage || category.isEmpty()) {
            throw new IllegalArgumentException("Один из аргументов некорректен");
        }

        externalStartPoint = startPage;
        externalEndPoint = endPage;
        internalStartPoint = 1;
        internalEndPoint = 1;
        BASE_URL = "https://leroymerlin.ru/catalogue/" + category;
        SEPARATOR = "/?";
        PREFIX = "page={CurrentId}";
    }
}
