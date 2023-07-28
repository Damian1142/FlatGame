package game;

import game.scene.BackgroundObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Tools {

    public static BufferedImage loadImage(String resourceName) throws IOException {
        InputStream inputStream = Main.class.getResourceAsStream(resourceName);
        return ImageIO.read(Objects.requireNonNull(inputStream));
    }

    public static BackgroundObject loadImageToBackgroundObject(String resourceName) throws IOException {

        return new BackgroundObject(loadImage(resourceName));
    }
}
