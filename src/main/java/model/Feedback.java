package model;

import org.jetbrains.annotations.NotNull;

public class Feedback {
    private String pros = null;
    private String cons = null;
    private String text = null;

    public Feedback() {

    }

    public Feedback(String pros, String cons, String text) {
        if (pros.isEmpty() || cons.isEmpty() || text.isEmpty()) {
            throw new NullPointerException("Устанавливаемые значения пустые");
        }

        this.pros = pros;
        this.cons = cons;
        this.text = text;
    }

    public String getPros() {
        if (pros.isEmpty()) {
            throw new NullPointerException("Поле плюсов не было установлено");
        }

        return pros;
    }

    public void setPros(@NotNull String pros) {
        if (pros.isEmpty()) {
            throw new NullPointerException("Устанавливаемое поле плюсов пустое");
        }

        this.pros = pros;
    }

    public String getCons() {
        if (cons.isEmpty()) {
            throw new NullPointerException("Поле минусов не было установлено");
        }

        return cons;
    }

    public void setCons(@NotNull String cons) {
        if (cons.isEmpty()) {
            throw new NullPointerException("Устанавливаемое поле минусов пустое");
        }

        this.cons = cons;
    }

    public String getText() {
        if (text.isEmpty()) {
            throw new NullPointerException("Поле отзыва не было установлено");
        }
        return text;
    }

    public void setText(@NotNull String text) {
        if (text.isEmpty()) {
            throw new NullPointerException("Устанавливаемое поле отзыва пустое");
        }
        this.text = text;
    }

    @Override
    public String toString() {
        return "Плюсы: " + pros + "\nМинусы: " + cons + "\nОтзыв: " + text + "\n";
    }
}