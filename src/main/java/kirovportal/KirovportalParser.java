package kirovportal;

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

public class KirovportalParser implements Parser<ArrayList<News>> {

    @Override
    public @NotNull ArrayList<News> Parse(@NotNull Document document, @NotNull ParserSettings parserSettings) {
        ArrayList<News> news = new ArrayList<>();

        Elements elements = Objects.requireNonNull(document.getElementById("appendPage")).children();

        String date = "";
        for (Element element : elements) {
            try {
                if (element.hasClass("newsDate")) {
                    date = element.text();
                    continue;
                }

                String href = Objects.requireNonNull(element.getElementsByTag("a").first()).attr("href");
                HtmlLoader.setUrl(ParserSettings.BASE_URL.substring(0, 23) + href);
                Document newsPage = HtmlLoader.getSource();

                String title = newsPage.getElementsByClass("robotoBold ").text();
                String text = newsPage.getElementsByClass("newsContent").text();
                String imageUrl = ParserSettings.BASE_URL.substring(0, 23) + newsPage.getElementsByClass("newsPhoto").attr("href");

                news.add(new News(title, date, text, imageUrl));
            } catch (Exception ignored) {
            }
        }

        return news;
    }
}