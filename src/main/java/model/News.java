package model;

import org.jetbrains.annotations.NotNull;
import tools.ImageDownloader;

public class News {
    private String title;
    private String date;
    private String text;
    private String imageUrl;

    public News(@NotNull String title, @NotNull String date, @NotNull String text, @NotNull String imageUrl) throws Exception {
        this.title = title;
        this.date = date;
        this.imageUrl = imageUrl;
        this.text = text;

        if (!imageUrl.equals("")) {
            ImageDownloader.download(imageUrl);
        }
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @NotNull String getDate() {
        return date;
    }

    public void setDate(@NotNull String date) {
        this.date = date;
    }

    public @NotNull String getText() {
        return text;
    }

    public void setText(@NotNull String text) {
        this.text = text;
    }

    public @NotNull String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return title + "\n" + date + "\n" + text + "\n" + imageUrl + "\n";
    }
}