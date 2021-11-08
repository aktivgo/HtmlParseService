package nanegative;

import model.OnlineStore;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class NanegativeParser implements Parser<ArrayList<OnlineStore>> {

    @Override
    public ArrayList<OnlineStore> Parse(@NotNull Document document) throws IOException {

        ArrayList<OnlineStore> onlineStores = new ArrayList<>();

        Elements onlineStoresEl = document.getElementsByClass("find-list-box");

        for (Element onlineStoreEl : onlineStoresEl) {
            Document onlineStoreDoc = loadOnlineStore(onlineStoreEl);


        }

        return onlineStores;
    }

    private @NotNull Document loadOnlineStore(@NotNull Element onlineStoreEl) throws IOException {
        String href = onlineStoreEl.getElementsByTag("a").get(0).attr("href");
        return Jsoup.connect("https://nanegative.ru" + href).get();
    }
}