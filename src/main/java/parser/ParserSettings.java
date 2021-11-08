package parser;

public abstract class ParserSettings {

    // Адрес сайта
    public static String BASE_URL;

    // Префих страницы
    public static String PREFIX;

    // Начало пагинации
    protected int startPoint;

    // Конец пагинации
    protected int endPoint;

    // Начало пагинации внутри
    protected int startPointInside;

    // Конец пагинации внутри
    protected int endPointInside;

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }
}