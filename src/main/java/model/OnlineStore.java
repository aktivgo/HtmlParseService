package model;

import model.Feedback;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OnlineStore {
    private String name = null;
    private ArrayList<Feedback> feedbacks;

    public OnlineStore() {
        feedbacks = new ArrayList<>();
    }

    public OnlineStore(@NotNull String name, ArrayList<Feedback> feedbacks) {
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
    public String toString(){
        StringBuilder result = new StringBuilder(name + "\n\n");
        for (Feedback feedback : feedbacks) {
            result.append(feedback.toString()).append("\n");
        }
        return result.toString();
    }
}