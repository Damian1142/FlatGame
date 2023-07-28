package game;

import game.input.Input;
import game.scene.MenuScene;
import game.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Game extends JPanel{

    public Timer timer;
    private JFrame window;


    private Scene aScene;

    public Game(int s) {
        timer = new Timer(16,this::timerMethod);
        StaticObjects.game = this;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        StaticObjects.fw = gd.getDisplayMode().getWidth();
        StaticObjects.fh = gd.getDisplayMode().getHeight();
        if (s == MENU){
            aScene = new MenuScene();
        }else {
            System.exit(1);
        }
        window = new JFrame();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setUndecorated(true);
        window.pack();
        window.setVisible(true);
        window.add(this);
        Input input = new Input();
        window.addMouseListener(input);
        window.addKeyListener(input);
        window.addMouseMotionListener(input);
        repaint();
    }

    private void timerMethod(ActionEvent ignored) {
        update();
    }

    public void start(){
        timer.start();
    }

    public void paint(Graphics g) {
        try {
            aScene.render(g);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void update(){
        aScene.update();
        repaint();
    }

    public void setScene(Scene scene) {
        aScene = scene;
    }

    public static int MENU = 0;
}
