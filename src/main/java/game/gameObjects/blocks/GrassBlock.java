package game.gameObjects.blocks;

import game.StaticObjects;
import game.Tools;
import game.gameObjects.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GrassBlock extends Block{

    public static final int ID = 0;
    public static BufferedImage image;

    static {
        try {
            image = Tools.loadImage("/GrassBlock.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GrassBlock(int x, int y) throws IOException {
        super(x,y);
    }

    @Override
    public void render(Graphics g, Camera c) {
        g.drawImage(image,x * 16 * StaticObjects.scale - c.x,y * 16 * StaticObjects.scale - c.y,16 * StaticObjects.scale,16 * StaticObjects.scale,null);
    }
}
