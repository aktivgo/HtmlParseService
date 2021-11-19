package leroymerlin;

import model.Feedback;
import model.Product;
import nanegative.NanegativeSettings;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;
import parser.ParserSettings;
import tools.HtmlLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class LeroymerlinParser implements Parser<ArrayList<Product>> {

    @Override
    public @NotNull ArrayList<Product> Parse(@NotNull Document document, @NotNull ParserSettings parserSettings) throws IOException {
        ArrayList<Product> products = new ArrayList<>();

        Elements productsEl = document.getElementsByClass("phytpj4_plp largeCard");

        for (Element productEl : productsEl) {
            String name = productEl.getElementsByClass("t9jup0e_plp p1h8lbu4_plp").text();
            double price = Double.parseDouble(productEl.getElementsByClass("t3y6ha_plp xc1n09g_plp p1q9hgmc_plp").text().replace(",", ".").replace(" ", ""));

            String productPath = productEl.getElementsByTag("a").get(0).attr("href");
            ArrayList<Feedback> feedbacks = parseFeedbacks(productPath);

            products.add(new Product(name, price, feedbacks));
        }

        return products;
    }

    private @NotNull ArrayList<Feedback> parseFeedbacks(@NotNull String productPath) throws IOException {
        ArrayList<Feedback> feedbacks = new ArrayList<>();

        HtmlLoader.setUrl(NanegativeSettings.BASE_URL.substring(0, 22) + productPath);
        Document feedbacksPage = HtmlLoader.getSource();

        Elements feedbacksEl = feedbacksPage.getElementsByAttributeValue("itemprop", "review");

        for (Element feedbackEl : feedbacksEl) {
            String pros = "", cons = "";
            if (!feedbackEl.getElementsByAttributeValue("slot", "desc").isEmpty()) {
                pros = feedbackEl.getElementsByAttributeValue("slot", "desc").size() > 0 ? feedbackEl.getElementsByAttributeValue("slot", "desc").get(0).text() : "";
                cons = feedbackEl.getElementsByAttributeValue("slot", "desc").size() > 1 ? feedbackEl.getElementsByAttributeValue("slot", "desc").get(1).text() : "";
            }
            String text = Objects.requireNonNull(feedbackEl.getElementsByAttributeValue("slot", "review-text").first()).ownText();

            feedbacks.add(new Feedback(pros, cons, text));
        }

        return feedbacks;
    }
}
