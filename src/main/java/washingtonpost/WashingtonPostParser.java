package washingtonpost;

import model.News;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;
import parser.ParserSettings;
import tools.HtmlLoader;

import java.util.ArrayList;
import java.util.Objects;

public class WashingtonPostParser implements Parser<ArrayList<News>> {

    @Override
    public @NotNull ArrayList<News> Parse(@NotNull Document document, @NotNull ParserSettings parserSettings) {
        ArrayList<News> news = new ArrayList<>();

        Elements elements = document.getElementsByClass("story-list-story");

        for (Element element : elements) {
            try {
                String href = Objects.requireNonNull(element.getElementsByClass("story-headline").first()).getElementsByTag("a").attr("href");
                HtmlLoader.setUrl(href);
                Document newsPage = HtmlLoader.getSource();

                String title = newsPage.getElementsByAttributeValue("data-qa", "headline-text").text();
                String date = Objects.requireNonNull(newsPage.getElementsByAttributeValue("data-qa", "display-date").first()).text();
                String text = newsPage.getElementsByClass("remainder-content").text();
                String srcset = newsPage.getElementsByTag("img").attr("srcset");
                String imageUrl = srcset.equals("") ? "" : srcset.substring(0, srcset.indexOf(" "));

                news.add(new News(title, date, text, imageUrl));
            } catch (Exception ignored) {
            }
        }

        return news;
    }
}
