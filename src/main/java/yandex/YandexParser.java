package yandex;

import model.Image;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;
import parser.ParserSettings;

import java.io.IOException;
import java.util.ArrayList;

public class YandexParser implements Parser<ArrayList<Image>> {

    @Override
    public ArrayList<Image> Parse(@NotNull Document document, ParserSettings parserSettings) throws IOException {
        ArrayList<Image> images = new ArrayList<>();

        Elements elements = document.getElementsByClass("serp-item");
        for (Element element : elements) {
            String data_bem = element.attr("data-bem");

            String origin = data_bem.substring(data_bem.indexOf("\"origin\":"));
            String imageUrl = origin.substring(origin.indexOf("\"url\":") + 7, origin.indexOf("}") - 1);

            String title = imageUrl.substring(imageUrl.lastIndexOf("/"), imageUrl.lastIndexOf(".") - 1);
            images.add(new Image(title, imageUrl));
        }
        return images;
    }
}