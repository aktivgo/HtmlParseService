package google;

import model.Image;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;
import parser.ParserSettings;
import tools.HtmlLoader;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleParser implements Parser<ArrayList<Image>> {

    @Override
    public ArrayList<Image> Parse(@NotNull Document document, ParserSettings parserSettings) throws IOException {
        ArrayList<Image> images = new ArrayList<>();

        String imagesUrl = document.getElementsByClass("hdtb-mitem").get(1).getElementsByTag("a").attr("href");
        HtmlLoader.setUrl(ParserSettings.BASE_URL.substring(0, 21) + imagesUrl);
        Document imagesPage = HtmlLoader.getSource();

        Elements imagesEl = imagesPage.getElementsByClass("isv-r PNCib MSM1fd BUooTd");

        for (Element imageEl : imagesEl) {
            String title = imageEl.getElementsByTag("img").attr("alt");
            String url = imageEl.getElementsByTag("a").attr("href");

            images.add(new Image(title, ParserSettings.BASE_URL.substring(0, 21) + url));
        }

        return images;
    }
}