package parser;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface Parser<T> {
    T Parse(Document document, ParserSettings parserSettings) throws IOException;
}