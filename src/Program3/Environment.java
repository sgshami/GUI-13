package Program3;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;

public class Environment {
    private int width, height;
    private ArrayList<Circle> list = new ArrayList<Circle>();
    
    public Environment(int w, int h){
        width = w;
        height = h;
    }
    public void add(int x, int y){
        list.add(new Circle(x, y));
    }
    
    public void update(){
        for(Circle c: list){
            c.updateLocation();
            Point2D loc = c.getCenter();
            if(loc.getX() <= 0 || loc.getX() >= width)
                c.setDx(-c.getDx());
            if(loc.getY() <= 0 || loc.getY() >= height)
                c.setDy(-c.getDy());
        }
    }
    
    public void delete(Point p){
        for(int k = list.size()-1; k>=0; k--){
            if(list.get(k).contains(p))
                list.remove(k);
        }
    }
    
    public void draw(Graphics g){
        for(Circle c: list)
            c.draw(g);
    }
}
