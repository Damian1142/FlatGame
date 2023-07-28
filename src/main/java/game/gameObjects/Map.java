package game.gameObjects;

import game.gameObjects.blocks.Block;
import game.gameObjects.blocks.GrassBlock;

import java.awt.*;
import java.io.IOException;

public class Map extends GameObject {

    public int w,h;
    public Block[][] map;


    public Map(int w, int h) throws IOException {
        this.w = w;
        this.h = h;
        map = new Block[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                map[i][j] = new GrassBlock(i,j);
            }
        }
    }

    @Override
    public void render(Graphics g, Camera c) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                map[i][j].render(g,c);
            }
        }
    }
}
