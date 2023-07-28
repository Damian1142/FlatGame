package game.scene;

import game.StaticObjects;
import game.gameObjects.Camera;
import game.gameObjects.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Scene {

    protected int fw = StaticObjects.fw, fh = StaticObjects.fh;

    Camera camera = new Camera();
    protected ArrayList<GameObject> gos;

    public Scene() {
        gos = new ArrayList<>();
    }

    public void update(){
        gos.forEach(GameObject::update);
    }

    public void render(Graphics g) throws IOException {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,StaticObjects.fw,StaticObjects.fh);
        gos.forEach(o -> o.render(g, camera));
    }

    public void add(GameObject obj){
        gos.add(obj);
    }
}
