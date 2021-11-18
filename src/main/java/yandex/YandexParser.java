package yandex;

import model.Image;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.Parser;
import parser.ParserSettings;

import java.util.ArrayList;

public class YandexParser implements Parser<ArrayList<Image>> {

    @Override
    public ArrayList<Image> Parse(@NotNull Document document, ParserSettings parserSettings) {
        ArrayList<Image> images = new ArrayList<>();

        Elements elements = document.getElementsByClass("serp-item");
        for (Element element : elements) {
            try {
                String data_bem = element.attr("data-bem");

                String imageUrl = "";
                do {
                    String originNode = data_bem.substring(data_bem.indexOf("\"origin\":") + 9);
                    String urlNode = originNode.substring(originNode.indexOf("\"url\":") + 7);
                    imageUrl = urlNode.substring(0, urlNode.indexOf("\""));
                    data_bem = originNode;
                } while (data_bem.contains("\"origin\":") && imageUrl.lastIndexOf(".") == -1);

                if (imageUrl.isEmpty()) {
                    continue;
                }

                String title = imageUrl.substring(imageUrl.lastIndexOf("/") + 1, imageUrl.lastIndexOf("."));
                images.add(new Image(title, imageUrl));
            } catch (Exception ignored) {
            }
        }
        return images;
    }
}