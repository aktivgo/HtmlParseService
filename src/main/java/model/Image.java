package model;

import org.jetbrains.annotations.NotNull;

public class Image {
    String title = null;
    String url = null;

    public String getTitle() {
        if (title.isEmpty()) {
            throw new NullPointerException("Название не было установлено");
        }

        return title;
    }

    public void setTitle(@NotNull String title) {
        if (title.isEmpty()) {
            throw new NullPointerException("Устанавливаемое название пустое");
        }

        this.title = title;
    }

    public String getUrl() {
        if (url.isEmpty()) {
            throw new NullPointerException("Ссылка не была установлена");
        }

        return url;
    }

    public void setUrl(@NotNull String url) {
        if (url.isEmpty()) {
            throw new NullPointerException("Устанавливаемая ссылка пустая");
        }

        this.url = url;
    }
}