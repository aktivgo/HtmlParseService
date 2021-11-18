package model;

import org.jetbrains.annotations.NotNull;
import tools.ImageDownloader;

public class Image {
    String title = null;
    String url = null;

    public Image() {

    }

    public Image(@NotNull String title, String url) throws Exception {
        if (title.isEmpty() || url.isEmpty()) {
            throw new NullPointerException("Устанавливаемые значения пустые");
        }

        this.title = title;
        this.url = url;
        ImageDownloader.download(url, title);
    }

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

    @Override
    public String toString() {
        return title.isEmpty() ? "" : title + "\n" + (url.isEmpty() ? "" : url + "\n");
    }
}