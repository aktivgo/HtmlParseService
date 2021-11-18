package parser;

import org.jsoup.nodes.Document;
import tools.HtmlLoader;

import java.io.IOException;
import java.util.ArrayList;

public class ParserWorker<T> {

    private Parser<T> parser;
    private final ParserSettings parserSettings;
    private boolean isActive;

    public ArrayList<OnNewDataHandler<T>> onNewDataList = new ArrayList<>();
    public ArrayList<OnCompleted> onCompletedList = new ArrayList<>();

    public ParserWorker(Parser<T> parser, ParserSettings parserSettings) {
        this.parser = parser;
        this.parserSettings = parserSettings;
    }

    public Parser<T> getParser() {
        return parser;
    }

    public void setParser(Parser<T> parser) {
        this.parser = parser;
    }

    public void start() throws Exception {
        isActive = true;
        parse();
    }

    public void abort() {
        isActive = false;
    }

    private void parse() throws Exception {
        for (int i = parserSettings.getExternalStartPoint(); i <= parserSettings.getExternalEndPoint(); i++) {
            if (!isActive) {
                onCompletedList.get(0).onCompleted(this);
                return;
            }
            Document document;
            HtmlLoader.setUrl(ParserSettings.BASE_URL + ParserSettings.SEPARATOR + ParserSettings.PREFIX);
            if (ParserSettings.PREFIX.contains("text=")) {
                document = HtmlLoader.getSource();
            } else {
                document = HtmlLoader.getSourceByPageId(i);
            }
            T result = parser.Parse(document, parserSettings);
            onNewDataList.get(0).onNewData(this, result);
        }
        onCompletedList.get(0).onCompleted(this);
        isActive = false;
    }
}