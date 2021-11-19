package model;

import org.jetbrains.annotations.NotNull;

public class Feedback {
    private String pros;
    private String cons;
    private String text;

    public Feedback(@NotNull String pros, @NotNull String cons, @NotNull String text) {
        this.pros = pros;
        this.cons = cons;
        this.text = text;
    }

    public @NotNull String getPros() {
        return pros;
    }

    public void setPros(@NotNull String pros) {
        this.pros = pros;
    }

    public @NotNull String getCons() {
        return cons;
    }

    public void setCons(@NotNull String cons) {
        this.cons = cons;
    }

    public @NotNull String getText() {
        return text;
    }

    public void setText(@NotNull String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Плюсы: " + pros + "\nМинусы: " + cons + "\nОтзыв: " + text + "\n";
    }
}