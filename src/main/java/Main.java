import kirovportal.KirovportalParser;
import kirovportal.KirovportalSettings;
import kirovportal.NewDataNews;
import leroymerlin.LeroymerlinParser;
import leroymerlin.LeroymerlinSettings;
import leroymerlin.NewDataProducts;
import model.Image;
import model.News;
import model.OnlineStore;
import model.Product;
import nanegative.NanegativeParser;
import nanegative.NanegativeSettings;
import nanegative.NewDataOnlineStores;
import org.jetbrains.annotations.NotNull;
import parser.Completed;
import parser.ParserWorker;
import tools.ImageDownloader;
import washingtonpost.WashingtonPostParser;
import washingtonpost.WashingtonPostSettings;
import yandex.NewDataYandex;
import yandex.YandexParser;
import yandex.YandexSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        int menu = -1;
        while (menu != 0) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            try {
                menu = IN.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка при считывании с клавиатуры, повторите попытку");
            }
            switch (menu) {
                case 0 -> System.out.println("Пока");
                case 1 -> parseNanegative();
                case 2 -> parseLeroymerlin();
                case 3 -> parseYandex();
                case 4 -> parseKirovportal();
                case 5 -> parseWashingtonpost();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Парсинг:");
        System.out.println("1. https://nanegative.ru/internet-magaziny");
        System.out.println("2. https://leroymerlin.ru/");
        System.out.println("3. Картинки из интернета");
        System.out.println("4. https://kirov-portal.ru/news/");
        System.out.println("5. https://www.washingtonpost.com/");
        System.out.println("0. Выход");
    }

    private static void parseNanegative() {
        try {
            int startPageOnlineStore = readPagination("Введите начало пагинации интернет-магазинов: ");
            int endPageOnlineStore = readPagination("Введите конец пагинации интернет-магазинов: ");

            int startPageFeedback = readPagination("Введите начало пагинации отзывов: ");
            int endPageFeedback = readPagination("Введите конец пагинации отзывов: ");

            ParserWorker<ArrayList<OnlineStore>> parser = new ParserWorker<>(new NanegativeParser(),
                    new NanegativeSettings(startPageOnlineStore, endPageOnlineStore, startPageFeedback, endPageFeedback));

            parser.onCompletedList.add(new Completed());
            parser.onNewDataList.add(new NewDataOnlineStores());

            System.out.println("\nЗагрузка началась\n\n");
            parser.start();
            parser.abort();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...\n" + e.getMessage() + "\n");
        }
    }

    private static int readPagination(String message) {
        System.out.print(message);
        int value = 0;
        if (IN.hasNextInt()) {
            value = IN.nextInt();
            if (value > 0) {
                return value;
            }
            System.out.println("Введите целочисленное значение больше 0");
        }
        return value;
    }

    private static void parseLeroymerlin() {
        try {
            System.out.print("Введите категорию товаров транслитом: ");
            String category = IN.next();
            int startPage = readPagination("Введите начало пагинации товаров: ");
            int endPage = readPagination("Введите конец пагинации товаров: ");

            ParserWorker<ArrayList<Product>> parser = new ParserWorker<>(new LeroymerlinParser(),
                    new LeroymerlinSettings(startPage, endPage, category));

            parser.onCompletedList.add(new Completed());
            parser.onNewDataList.add(new NewDataProducts());

            parseWork(parser);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...\n" + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()) + "\n");
        }
    }

    private static void parseYandex() {
        try {
            System.out.print("Введите запрос: ");
            String query = IN.next();

            int startPage = readPagination("Введите начало пагинации: ");
            int endPage = readPagination("Введите конец пагинации: ");

            ImageDownloader.setSavePath("uploads/yandex/" + query + "/");

            ParserWorker<ArrayList<Image>> parser = new ParserWorker<>(new YandexParser(),
                    new YandexSettings(query, startPage - 1, endPage - 1));

            parser.onCompletedList.add(new Completed());
            parser.onNewDataList.add(new NewDataYandex());

            parseWork(parser);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...\n" + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()) + "\n");
        }
    }

    private static void parseKirovportal() {
        try {
            int startPage = readPagination("Введите начало пагинации: ");
            int endPage = readPagination("Введите конец пагинации: ");

            ImageDownloader.setSavePath("uploads/kirovportal/");

            ParserWorker<ArrayList<News>> parser = new ParserWorker<>(new KirovportalParser(),
                    new KirovportalSettings(startPage, endPage));

            parser.onCompletedList.add(new Completed());
            parser.onNewDataList.add(new NewDataNews());

            parseWork(parser);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...\n" + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()) + "\n");
        }
    }

    private static void parseWashingtonpost() {
        try {
            System.out.print("Введите категорию: ");
            String category = IN.next();

            ImageDownloader.setSavePath("uploads/washingtonpost/" + category + "/");

            ParserWorker<ArrayList<News>> parser = new ParserWorker<>(new WashingtonPostParser(),
                    new WashingtonPostSettings(category));

            parser.onCompletedList.add(new Completed());
            parser.onNewDataList.add(new NewDataNews());

            parseWork(parser);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...\n" + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()) + "\n");
        }
    }

    private static void parseWork(@NotNull ParserWorker parser) throws Exception {
        System.out.println("\nЗагрузка началась\n\n");
        parser.start();
        parser.abort();
    }
}