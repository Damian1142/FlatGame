package game.gameObjects.mobs;

import game.StaticObjects;
import game.Tools;
import game.gameObjects.Camera;
import game.gameObjects.GameObject;
import game.gameObjects.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class HappyMob extends GameObject {

    public static BufferedImage[] image;
    private int xPower = 0, yPower = 0,img = 1,maxPower = 15;

    private Random random;

    private Map map;

    private Timer timer;


    public HappyMob(Map map) throws IOException {
        image = new BufferedImage[2];
        image[0] = Tools.loadImage("/happyMob.png");
        image[1] = Tools.loadImage("/happyMob2.png");
        random = new Random();
        this.map = map;
        x = random.nextInt(6000);
        y = random.nextInt(6000);
        timer = new Timer(1000,this::randomXY);
        timer.start();
    }

    private void randomXY(ActionEvent actionEvent) {
        xPower += random.nextInt(20) - 10;
        yPower += random.nextInt(20) - 10;
    }

    public void render(Graphics g, Camera c) {
        //System.out.println("render" + x + " " + y);
        g.drawImage(image[img],x - c.x,y - c.y,16 * StaticObjects.scale,16 * StaticObjects.scale,null);
    }

    public void update() {
        if (xPower > 0){
            img = 1;
        } else if (xPower < 0) {
            img = 0;
        }

        x += xPower;
        y += yPower;
        //System.out.println("YP:" + yPower);
        //System.out.println("XP:" + xPower);

        if (Math.abs(xPower) > maxPower){
            if (xPower > 0){
                xPower = maxPower;
            }
            if (xPower < 0){
                xPower = -maxPower;
            }
        }
        if (Math.abs(yPower) > maxPower){
            if (yPower > 0){
                yPower = maxPower;
            }
            if (xPower < 0){
                yPower = -maxPower;
            }
        }

        if (x < 0 || x > map.w * 16 * StaticObjects.scale - (16 * StaticObjects.scale)){
            xPower = -xPower;
        }
        if (y < 0 || y > map.y * 16 * StaticObjects.scale - (16 * StaticObjects.scale)){
            yPower = -yPower;
        }
    }
}
