package game.scene;

import game.StaticObjects;
import game.gameObjects.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public abstract class Scene {

    protected int fw = StaticObjects.fw, fh = StaticObjects.fh;


    protected ArrayList<GameObject> gos;

    public Scene() {
        gos = new ArrayList<>();
    }

    public void update(){
        gos.forEach(GameObject::update);
    }

    public void render(Graphics g){
        gos.forEach(o -> o.render(g));
    }

    public void add(GameObject obj){
        gos.add(obj);
    }
}
