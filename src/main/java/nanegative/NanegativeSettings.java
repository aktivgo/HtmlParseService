package nanegative;

import parser.ParserSettings;

public class NanegativeSettings extends ParserSettings {

    public NanegativeSettings(int startPageOnlineStore, int endPageOnlineStore, int startPageFeedback, int endPageFeedback) {
        if (startPageOnlineStore <= 0 || endPageOnlineStore < startPageOnlineStore || startPageFeedback <= 0 || endPageFeedback < startPageFeedback) {
            throw new IllegalArgumentException("Один из аргументов некорректен");
        }

        externalStartPoint = startPageOnlineStore;
        externalEndPoint = endPageOnlineStore;
        internalStartPoint = startPageFeedback;
        internalEndPoint = endPageFeedback;
        BASE_URL = "https://nanegative.ru/internet-magaziny";
        SEPARATOR = "?";
        PREFIX = "page={CurrentId}";
    }
}