package parser;

import org.json.simple.parser.ParseException;
import org.jsoup.nodes.Document;

import java.io.IOException;

public interface Parser<T> {
    T Parse(Document document, ParserSettings parserSettings) throws IOException, ParseException;
}