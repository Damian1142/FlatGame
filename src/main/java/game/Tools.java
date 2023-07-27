package game;

import game.scene.BackgroundObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Tools {

    public static BufferedImage loadImage(String resourceName) throws IOException {
        InputStream inputStream = Tools.class.getResourceAsStream(resourceName);
        return ImageIO.read(inputStream);
    }

    public static BackgroundObject loadImageToBackgroundObject(String resourceName) throws IOException {

        return new BackgroundObject(loadImage(resourceName));
    }
}
