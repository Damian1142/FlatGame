package game.scene;

import game.StaticObjects;
import game.gameObjects.Map;
import game.gameObjects.Player;
import game.gameObjects.mobs.HappyMob;
import game.input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameScene extends Scene{

    private Map map;
    private Player player;
    private boolean run = true;

    public GameScene() throws IOException {
        map = new Map(50,50);
        player = new Player(map);
        add(map);
        add(player);
        System.out.println("Game");
        StaticObjects.game.timer.stop();
        int happy =Integer.parseInt(JOptionPane.showInputDialog(null,"Podaj ilość Happy Mobów","Happy Mobs",JOptionPane.QUESTION_MESSAGE));
        StaticObjects.game.timer.start();
        for (int i = 0; i < happy; i++) {
            add(new HappyMob(map));
        }


    }

    private boolean previousStateKeyEscape = false;

    @Override
    public void update() {
        if(run) {
            if (Input.keys[KeyEvent.VK_ESCAPE] && !previousStateKeyEscape){
                run = false;
            }
            super.update();
            super.update();
            camera.x = player.x - StaticObjects.fw / 2;
            camera.y = player.y - StaticObjects.fh / 2;
        }else {
            if (Input.keys[KeyEvent.VK_ESCAPE] && !previousStateKeyEscape){
                run = true;
            }
        }
        previousStateKeyEscape = Input.keys[KeyEvent.VK_ESCAPE];

    }

    @Override
    public void render(Graphics g) throws IOException {
        super.render(g);
        if (!run){
            drawMiniMenu(g);
        }
    }

    private void drawMiniMenu(Graphics g){
        int y = fh / 4;
        int breaksSize = 2 * y / 21;

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD,32));
        g.drawString("PAUZA",fw  * 31 / 64,y);
        y += breaksSize;
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(fw * 6 / 16,y,fw * 4 / 16,4 * breaksSize);

            if ((Input.x > fw * 6 / 16 && Input.x < fw * 10 / 16) && (Input.y > y && Input.y < y + (4 * breaksSize))){
                int borderSize = fw * 2 / 16 / 40;
                g.setColor(Color.red);
                g.fillRect(fw * 6 / 16,y,borderSize,4 * breaksSize);
                g.fillRect(fw * 6 / 16,y,fw * 4 / 16,borderSize);
                g.fillRect(fw * 10 / 16 - borderSize,y,borderSize,4 * breaksSize);
                g.fillRect(fw * 6 / 16,y + 4 * breaksSize - borderSize,fw * 4 / 16,borderSize);
                if (Input.mClicked) {
                    switch (i) {
                        case 0:
                            run = true;
                    }
                }
            }
            y += 5 * breaksSize;
        }
    }
}
