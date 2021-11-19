package model;

import org.jetbrains.annotations.NotNull;

public class News {
    private String title;
    private String imageUrl;
    private String text;

    public News() {

    }

    public News(@NotNull String title, String imageUrl, String text) {
        if (title.isEmpty() || imageUrl.isEmpty() || text.isEmpty()) {
            throw new NullPointerException("Одно из устанавливаемых значений пустое");
        }

        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
    }


    public String getTitle() {
        if (title == null) {
            throw new NullPointerException("Заголовок не был установлен");
        }
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new NullPointerException("Устанавливаемый заголовок пустой");
        }
        this.title = title;
    }

    public String getImageUrl() {
        if (imageUrl == null) {
            throw new NullPointerException("Изображение не было установлено");
        }
        return imageUrl;
    }

    public String getText() {
        if (text == null) {
            throw new NullPointerException("Текст не был установлен");
        }
        return text;
    }

    public void setText(String text) {
        if (text == null) {
            throw new NullPointerException("Устанавливаемый текст пустой");
        }
        this.text = text;
    }

    @Override
    public String toString() {
        return title + "\n" + text + "\n" + imageUrl + "\n";
    }
}