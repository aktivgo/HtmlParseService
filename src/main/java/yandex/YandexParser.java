package yandex;

import model.Image;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;
import parser.ParserSettings;

import java.io.IOException;
import java.util.ArrayList;

public class YandexParser implements Parser<ArrayList<Image>> {

    @Override
    public ArrayList<Image> Parse(@NotNull Document document, ParserSettings parserSettings) throws IOException, ParseException {
        ArrayList<Image> images = new ArrayList<>();

        Elements elements = document.getElementsByClass("serp-item");
        JSONObject jsonObject;

        for (Element element : elements) {
            if (element.childNodeSize() > 0) {
                jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).attr("href"));
                //String title = element.getElementsByTag("img").attr("alt");
                String title = (String) jsonObject.get("pt");
                String url = (String) jsonObject.get("ou");
                images.add(new Image(title, url));
            }
        }

       /* String imagesUrl = document.getElementsByClass("hdtb-mitem").get(1).getElementsByTag("a").attr("href");
        HtmlLoader.setUrl(ParserSettings.BASE_URL.substring(0, 21) + imagesUrl);
        Document imagesPage = HtmlLoader.getSource();

        Elements imagesEl = imagesPage.getElementsByClass("isv-r PNCib MSM1fd BUooTd");

        for (Element imageEl : imagesEl) {
            String title = imageEl.getElementsByTag("img").attr("alt");
            String url = imageEl.getElementsByTag("a").attr("href");

            images.add(new Image(title, ParserSettings.BASE_URL.substring(0, 21) + url));
        }*/

        return images;
    }
}