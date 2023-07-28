package game.scene;

import game.StaticObjects;
import game.input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MenuScene extends Scene{
    private int bh = fh / 21;
    private GameScene gs;

    @Override
    public void render(Graphics g) throws IOException {
        g.setColor(new Color(0xFF8C00));
        g.fillRect(0,0, fw,fh);
        drawButtonsOnCenterX(g);
        int mx = Input.x, my = Input.y;


        if ((mx > fw * 3 /8 && mx < fw * 5 /8 ) && (my > bh && my < 5 * bh)){
            int borderSize = fw * 2 / 8 / 40;
            g.setColor(Color.red);
            g.fillRect(fw * 3 /8,bh,borderSize,4 * bh);
            g.fillRect(fw * 3 /8,bh,fw * 2 /8,borderSize);
            g.fillRect(fw * 3 /8,bh * 5 - borderSize,fw * 2 /8,borderSize);
            g.fillRect(fw * 5 /8 - borderSize,bh,borderSize,4 * bh);
            if (Input.mClicked) {
                gs = new GameScene();
                StaticObjects.game.setScene(gs);
            }
        }
        g.setFont(new Font("Arial",Font.BOLD,fw * 2 / 8 / 10));
        g.setColor(Color.BLACK);
        g.drawString("NOWA GRA", fw * 3 /8 + fw * 2 / 8 / 5,3 * bh + fw * 2 / 8 / 30);
        if ((mx > fw * 3 /8 && mx < fw * 5 /8 ) && (my > bh * 6 && my < 10 * bh)){
            int borderSize = fw * 2 / 8 / 40;
            g.setColor(Color.red);
            g.fillRect(fw * 3 /8,bh * 6,borderSize,4 * bh);
            g.fillRect(fw * 3 /8,bh * 6,fw * 2 /8,borderSize);
            g.fillRect(fw * 3 /8,bh * 10 - borderSize,fw * 2 /8,borderSize);
            g.fillRect(fw * 5 /8 - borderSize,bh * 6,borderSize,4 * bh);
        }
        g.setColor(Color.BLACK);
        g.drawString("WCZYTAJ GRĘ", fw * 3 /8 + fw * 2 / 8 / 8,8 * bh + fw * 2 / 8 / 30);
        if ((mx > fw * 3 /8 && mx < fw * 5 /8 ) && (my > bh * 11 && my < 15 * bh)){
            int borderSize = fw * 2 / 8 / 40;
            g.setColor(Color.red);
            g.fillRect(fw * 3 /8,bh * 11,borderSize,4 * bh);
            g.fillRect(fw * 3 /8,bh * 11,fw * 2 /8,borderSize);
            g.fillRect(fw * 3 /8,bh * 15 - borderSize,fw * 2 /8,borderSize);
            g.fillRect(fw * 5 /8 - borderSize,bh * 11,borderSize,4 * bh);
        }
        g.setColor(Color.BLACK);
        g.drawString("USTAWIENIA", fw * 3 /8 + fw * 2 / 8 / 6,13 * bh + fw * 2 / 8 / 30);
        if ((mx > fw * 3 /8 && mx < fw * 5 /8 ) && (my > bh * 16 && my < 20 * bh)){
            int borderSize = fw * 2 / 8 / 40;
            g.setColor(Color.red);
            g.fillRect(fw * 3 /8,bh * 16,borderSize,4 * bh);
            g.fillRect(fw * 3 /8,bh * 16,fw * 2 /8,borderSize);
            g.fillRect(fw * 3 /8,bh * 20 - borderSize,fw * 2 /8,borderSize);
            g.fillRect(fw * 5 /8 - borderSize,bh * 16,borderSize,4 * bh);
            if (Input.mClicked) {
                System.exit(0);
            }
        }
        g.setColor(Color.BLACK);
        g.drawString("WYJŚCIE", fw * 3 /8 + fw * 2 / 8 / 4,18 * bh + fw * 2 / 8 / 30);
    }

    private void drawButtonsOnCenterX(Graphics g){
        int y = 0;
        g.setColor(Color.GRAY);
        for (int i = 0; i<4; i++){
            y += bh;
            g.fillRect(fw * 3 /8, y,fw * 2 /8,4 * bh);
            y += bh * 4;
        }
    }
}
