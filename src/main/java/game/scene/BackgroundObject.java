package game.scene;

import game.gameObjects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundObject extends GameObject {

    private BufferedImage image;

    public BackgroundObject(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image,0,0,null);
    }
}
