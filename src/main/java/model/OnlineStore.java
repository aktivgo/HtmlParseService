package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OnlineStore {
    private String name = null;
    private ArrayList<String> feedbacks;

    public OnlineStore() {
        feedbacks = new ArrayList<>();
    }

    public OnlineStore(@NotNull String name, ArrayList<String> feedbacks) {
        if (name.isEmpty() || feedbacks.isEmpty()) {
            throw new NullPointerException("Устанавливаемые значения пустые");
        }

        this.name = name;
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

    public ArrayList<String> getFeedbacks() {
        if (feedbacks.isEmpty()) {
            throw new NullPointerException("Список отзывов не был установлен");
        }
        return feedbacks;
    }

    public void setFeedbacks(@NotNull ArrayList<String> feedbacks) {
        if (feedbacks.isEmpty()) {
            throw new NullPointerException("Устанавливаемый список отзывов пустой");
        }
        this.feedbacks = feedbacks;
    }
}