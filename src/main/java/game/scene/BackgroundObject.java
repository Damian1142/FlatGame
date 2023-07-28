package game.scene;

import game.gameObjects.Camera;
import game.gameObjects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundObject extends GameObject {

    private BufferedImage image;

    public BackgroundObject(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, Camera c) {
        g.drawImage(image, -c.x,-c.y,null);
    }
}
