package washingtonpost;

import org.jetbrains.annotations.NotNull;
import parser.ParserSettings;

public class WashingtonPostSettings extends ParserSettings {

    public WashingtonPostSettings(@NotNull String category) {
        if (category.isEmpty()) {
            throw new IllegalArgumentException("Неккоректные входные данные");
        }

        externalStartPoint = 1;
        externalEndPoint = 1;
        internalStartPoint = 1;
        internalEndPoint = 1;
        BASE_URL = "https://www.washingtonpost.com";
        SEPARATOR = "/";
        PREFIX = category;
    }
}