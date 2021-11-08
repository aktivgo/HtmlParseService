package nanegative;

import parser.ParserSettings;

public class NanegativeSettings extends ParserSettings {

    public NanegativeSettings(int startPageOnlineStore, int endPageOnlineStore, int startPageFeedback, int endPageFeedback) {
        startPoint = startPageOnlineStore;
        endPoint = endPageOnlineStore;
        startPointInside = startPageFeedback;
        endPointInside = endPageFeedback;
        BASE_URL = "https://nanegative.ru/internet-magaziny";
        PREFIX = "?page={CurrentId}";
    }
}