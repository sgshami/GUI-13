package Program4;
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
        for(int i = 0; i<list.size(); i++){
            list.get(i).updateLocation();
            Point2D loc = list.get(i).getCenter();
            list.get(i).slowDown(.0001);
            if(list.get(i).getDx() <= 0 && list.get(i).getDy() <= 0){
                delete(list.get(i).getPoint());
                i--;
                if(i<0){
                    break;
                }
            }
            if(loc.getX() <= 0 || loc.getX() >= width-25)
                list.get(i).setDx(-list.get(i).getDx());
            if(loc.getY() <= 0 || loc.getY() >= height-25)
                list.get(i).setDy(-list.get(i).getDy());
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
    
    public int numCircles(){
        return list.size();
    }
}
