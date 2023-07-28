package game.gameObjects;

import game.StaticObjects;
import game.Tools;
import game.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends GameObject {

    private BufferedImage image;
    private Map map;
    public int xPower = 0,yPower = 0,maxPower = 15;

    public Player(Map map) throws IOException {
        image = Tools.loadImage("/player.png");
        this.map = map;
        x = 3000;
        y = 3000;
    }

    @Override
    public void render(Graphics g, Camera c) {
        g.drawImage(image,x - c.x,y - c.y,(int)(55 * StaticObjects.playerScale),(int)(94 * StaticObjects.playerScale),null);
    }

    @Override
    public void update() {

        x += xPower;
        y += yPower;

        if ((Input.keys[KeyEvent.VK_W] || Input.keys[KeyEvent.VK_UP]) && Math.abs(yPower) < maxPower){
            yPower -= 5;
        }else if ((Input.keys[KeyEvent.VK_S] || Input.keys[KeyEvent.VK_DOWN]) && Math.abs(yPower) < maxPower){
            yPower += 5;
        }else if ((Input.keys[KeyEvent.VK_A] || Input.keys[KeyEvent.VK_LEFT]) && Math.abs(xPower) < maxPower){
            xPower -= 5;
        }else if ((Input.keys[KeyEvent.VK_D] || Input.keys[KeyEvent.VK_RIGHT]) && Math.abs(xPower) < maxPower){
            xPower += 5;
        }else {
            if (xPower < 0){
                xPower += 5;
            } else if (xPower > 0) {
                xPower -= 5;
            }
            if (yPower < 0){
                yPower += 5;
            } else if (yPower > 0) {
                yPower -= 5;
            }
        }

        if (Input.keys[KeyEvent.VK_SHIFT]) {
            maxPower = 30;
        }else{
            maxPower = 15;
        }
        if (Input.keys[KeyEvent.VK_CONTROL]) {
            maxPower = 10000;
        }

        if (x < 0 || x > map.w * 16 * StaticObjects.scale - (int)(55 * StaticObjects.playerScale)){
            xPower = -xPower;
        }
        if (y < 0 || y > map.h * 16 * StaticObjects.scale - (int)(94 * StaticObjects.playerScale)){
            yPower = -yPower;
        }
    }
}
