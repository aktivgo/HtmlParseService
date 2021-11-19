package kirovportal;

import model.News;
import org.jsoup.nodes.Document;
import parser.Parser;
import parser.ParserSettings;

import java.util.ArrayList;

public class KirovportalParser implements Parser<ArrayList<News>> {

    @Override
    public ArrayList<News> Parse(Document document, ParserSettings parserSettings) throws Exception {
        return null;
    }
}