package google;

import parser.ParserSettings;

public class GoogleSettings extends ParserSettings {

    public GoogleSettings(String query) {
        externalStartPoint = 1;
        externalEndPoint = 1;
        internalStartPoint = 1;
        internalEndPoint = 1;
        BASE_URL = "https://www.google.ru/search";
        SEPARATOR = "?";
        PREFIX = "q=" + query;
    }
}