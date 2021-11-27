package model;

import org.jetbrains.annotations.NotNull;
import tools.ImageDownloader;

public class Image {
    private String title;
    private String url;

    public Image(@NotNull String title, @NotNull String url) throws Exception {
        this.title = title;
        this.url = url;

        if (!url.equals("")) {
            ImageDownloader.download(url, title);
        }
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @NotNull String getUrl() {
        return url;
    }

    public void setUrl(@NotNull String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return title + "\n" + url + "\n";
    }
}