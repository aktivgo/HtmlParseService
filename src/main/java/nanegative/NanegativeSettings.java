package nanegative;

import parser.ParserSettings;

public class NanegativeSettings extends ParserSettings {

    public NanegativeSettings(int startPageOnlineStore, int endPageOnlineStore) {
        startPoint = startPageOnlineStore;
        endPoint = endPageOnlineStore;
        BASE_URL = "https://nanegative.ru/internet-magaziny";
        PREFIX = "page={CurrentId}";
    }
}