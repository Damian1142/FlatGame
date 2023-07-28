package game.gameObjects.blocks;

import game.StaticObjects;
import game.Tools;
import game.gameObjects.Camera;
import game.gameObjects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Block extends GameObject {
    public Block(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
