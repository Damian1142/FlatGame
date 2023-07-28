package game.gameObjects.mobs;

import game.StaticObjects;
import game.Tools;
import game.gameObjects.Camera;
import game.gameObjects.GameObject;
import game.gameObjects.blocks.Block;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spawner extends Block {

    public static BufferedImage image;
    private MobsHandler mh;

    static {
        try {
            image = Tools.loadImage("/spawner.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Spawner(int x, int y, MobsHandler mh) {
        super(x,y);
        this.mh = mh;
    }

    @Override
    public void render(Graphics g, Camera c) {
        g.drawImage(image,x * 16 * StaticObjects.scale - c.x,y * 16 * StaticObjects.scale - c.y,16 * StaticObjects.scale,16 * StaticObjects.scale,null);
    }

    private long prTime = System.currentTimeMillis();
    private int spawnerPower = 1;
    private int spawnerMaxTimeSpawn = 10000;

    @Override
    public void update() {
        long acTime = System.currentTimeMillis();
        if (acTime - prTime >= spawnerMaxTimeSpawn / spawnerPower){
            mh.spawn(this,MobType.Knife);
        }
    }
}
