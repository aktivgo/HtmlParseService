package tools;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public abstract class HtmlLoader {

    private static String url;

    public static void setUrl(@NotNull String url) {
        if (url.isEmpty()) {
            throw new NullPointerException("Устанавливаемая ссылка пустая");
        }
        HtmlLoader.url = url;
    }

    public static @NotNull Document getSource() throws IOException {
        if (url.isEmpty()) {
            throw new NullPointerException("Ссылка не была установлена");
        }
        return Jsoup.connect(url).get();
    }

    public static @NotNull Document getSourceByPageId(int id) throws IOException {
        if (url.isEmpty()) {
            throw new NullPointerException("Ссылка не была установлена");
        }
        String currentUrl = url.replace("{CurrentId}", Integer.toString(id));
        return Jsoup.connect(currentUrl).get();
    }
}