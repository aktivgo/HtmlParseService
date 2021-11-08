package nanegative;

import model.Feedback;
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
            String name = onlineStoreEl.getElementsByTag("a").text();

            Document onlineStoreDoc = loadOnlineStore(onlineStoreEl);
            ArrayList<Feedback> feedbacks = new ArrayList<>();
            Elements feedbacksEl = onlineStoreDoc.getElementsByClass("reviewers-box");

            for (Element feedbackEl : feedbacksEl) {
                String pros = feedbackEl.getElementsByAttributeValue("itemprop", "pro").text();
                String cons = feedbackEl.getElementsByAttributeValue("itemprop", "contra").text();
                String text = feedbackEl.getElementsByAttributeValue("itemprop", "reviewBody").text();

                feedbacks.add(new Feedback(pros, cons, text));
            }

            onlineStores.add(new OnlineStore(name, feedbacks));
        }

        return onlineStores;
    }

    private @NotNull Document loadOnlineStore(@NotNull Element onlineStoreEl) throws IOException {
        String href = onlineStoreEl.getElementsByTag("a").get(0).attr("href");
        return Jsoup.connect("https://nanegative.ru" + href).get();
    }
}