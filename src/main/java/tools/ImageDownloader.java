package tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public abstract class ImageDownloader {

    private static String savePath = "uploads/";

    public static void setSavePath(String savePath) {
        ImageDownloader.savePath = savePath;
        if (new File(ImageDownloader.savePath).mkdirs()) {
            System.out.println("Директория для сохранения изображений успешно создана\n");
        }
    }

    public static void download(String imageUrl) throws Exception {
        BufferedImage input = ImageIO.read(new URL(imageUrl));
        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/"), imageUrl.lastIndexOf("."));
        String afterPoint = imageUrl.substring(imageUrl.lastIndexOf(".") + 1);
        String imageExtension = afterPoint.contains("&") ? afterPoint.substring(0, afterPoint.indexOf("&")) : afterPoint;
        File output = new File(savePath + imageName + "." + imageExtension);
        try {
            ImageIO.write(input, imageExtension, output);
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении изображения " + imageName + ": " + e.getMessage() + "\n");
        }
    }

    public static void download(String imageUrl, String title) throws Exception {
        BufferedImage input = ImageIO.read(new URL(imageUrl));
        String afterPoint = imageUrl.substring(imageUrl.lastIndexOf(".") + 1);
        String imageExtension = afterPoint.contains("&") ? afterPoint.substring(0, afterPoint.indexOf("&")) : afterPoint;
        File output = new File(savePath + title + "." + imageExtension);
        try {
            ImageIO.write(input, imageExtension, output);
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении изображения " + title + ": " + e.getMessage() + "\n");
        }
    }
}