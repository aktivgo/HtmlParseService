package google;

import model.Image;
import org.jsoup.nodes.Document;
import parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleParser implements Parser<ArrayList<Image>> {

    @Override
    public ArrayList<Image> Parse(Document document) throws IOException {
        ArrayList<Image> images = new ArrayList<>();



        return images;
    }
}