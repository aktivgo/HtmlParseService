import model.OnlineStore;
import nanegative.NanegativeParser;
import nanegative.NanegativeSettings;
import parser.Completed;
import parser.NewDataOnlineStore;
import parser.ParserWorker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
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
            }
        }
    }

    private static void printMenu() {
        System.out.println("Парсинг:");
        System.out.println("1. https://nanegative.ru/internet-magaziny");
        System.out.println("2. https://leroymerlin.ru/");
        System.out.println("3. Картинки из интеренета");
        System.out.println("0. Выход");
    }

    private static void parseNanegative() throws IOException {
        int startPageOnlineStore = readPagination("Введите начало пагинации интернет-магазинов: ");
        int endPageOnlineStore = readPagination("Введите конец пагинации интернет-магазинов: ");

        int startPageFeedback = readPagination("Введите начало пагинации отзывов: ");
        int endPageFeedback = readPagination("Введите конец пагинации отзывов: ");

        ParserWorker<ArrayList<OnlineStore>> parser = new ParserWorker<>(new NanegativeParser(),
                new NanegativeSettings(startPageOnlineStore, endPageOnlineStore, startPageFeedback, endPageFeedback));

        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewDataOnlineStore());

        System.out.println("\nЗагрузка началась\n\n");
        parser.start();
        parser.abort();
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
}