package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Product {
    private String name = null;
    private double price = 0;
    private ArrayList<Feedback> feedbacks;

    public Product() {
        feedbacks = new ArrayList<>();
    }

    public Product(@NotNull String name, double price, ArrayList<Feedback> feedbacks) {
        if (name.isEmpty() || price == 0) {
            throw new NullPointerException("Устанавливаемые значения пустые");
        }

        this.name = name;
        this.price = price;
        this.feedbacks = feedbacks;
    }

    public String getName() {
        if (name.isEmpty()) {
            throw new NullPointerException("Имя не было установлено");
        }

        return name;
    }

    public void setName(@NotNull String name) {
        if (name.isEmpty()) {
            throw new NullPointerException("Устанавливаемое имя пустое");
        }

        this.name = name;
    }

    public double getPrice() {
        if (price == 0) {
            throw new NullPointerException("Стоимость не была установлена");
        }

        return price;
    }

    public void setPrice(int price) {
        if (price == 0) {
            throw new NullPointerException("Устанавливаемая стоимость пустая");
        }

        this.price = price;
    }

    public ArrayList<Feedback> getFeedbacks() {
        if (feedbacks.isEmpty()) {
            throw new NullPointerException("Список отзывов не был установлен");
        }

        return feedbacks;
    }

    public void setFeedbacks(@NotNull ArrayList<Feedback> feedbacks) {
        if (feedbacks.isEmpty()) {
            throw new NullPointerException("Устанавливаемый список отзывов пустой");
        }

        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name + "\n" + price + " руб.\n\n");
        for (Feedback feedback : feedbacks) {
            result.append(feedback.toString()).append("\n");
        }
        return result.toString();
    }
}