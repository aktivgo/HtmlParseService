package nanegative;

import model.Feedback;
import model.OnlineStore;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;
import parser.ParserSettings;
import tools.HtmlLoader;

import java.io.IOException;
import java.util.ArrayList;

public class NanegativeParser implements Parser<ArrayList<OnlineStore>> {

    @Override
    public ArrayList<OnlineStore> Parse(@NotNull Document document, @NotNull ParserSettings parserSettings) throws IOException {

        ArrayList<OnlineStore> onlineStores = new ArrayList<>();

        Elements onlineStoresEl = document.getElementsByClass("find-list-box");

        for (Element onlineStoreEl : onlineStoresEl) {
            String name = onlineStoreEl.getElementsByTag("a").text().substring(9);

            String onlineStorePath = onlineStoreEl.getElementsByTag("a").get(0).attr("href");
            ArrayList<Feedback> feedbacks = parseFeedbacks(onlineStorePath, parserSettings);

            onlineStores.add(new OnlineStore(name, feedbacks));
        }

        return onlineStores;
    }

    private @NotNull ArrayList<Feedback> parseFeedbacks(String onlineStorePath, @NotNull ParserSettings parserSettings) throws IOException {
        ArrayList<Feedback> feedbacks = new ArrayList<>();

        for (int i = parserSettings.getInternalStartPoint(); i <= parserSettings.getInternalEndPoint(); i++) {

            HtmlLoader.setUrl(NanegativeSettings.BASE_URL.substring(0, 21) + onlineStorePath + NanegativeSettings.SEPARATOR + NanegativeSettings.PREFIX);
            Document feedbacksPage = HtmlLoader.getSourceByPageId(i);

            Elements feedbacksEl = feedbacksPage.getElementsByClass("reviewers-box");

            for (Element feedbackEl : feedbacksEl) {
                String pros = feedbackEl.getElementsByAttributeValue("itemprop", "pro").text();
                String cons = feedbackEl.getElementsByAttributeValue("itemprop", "contra").text();
                String text = feedbackEl.getElementsByAttributeValue("itemprop", "reviewBody").text();

                feedbacks.add(new Feedback(pros, cons, text));
            }
        }

        return feedbacks;
    }
}