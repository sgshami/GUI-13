package Program4;
import java.awt.*;
import java.awt.geom.*;

public class Circle {
    private double x, y;
    private double dx, dy;
    public static final int RADIUS = 25;
    private Color color;
    
    public Circle(double x, double y){
        this.x = x;
        this.y = y;
        dx = 5*Math.random()+2;
        dy = 5*Math.random()+2;
        if(Math.random() < .5) dx = -dx;
        if(Math.random() < .5) dy = -dy;
        int red = (int)(256*Math.random());
        int green = (int)(256*Math.random());
        int blue = (int)(256*Math.random());
        int alpha = (int)(256*Math.random());
        color = new Color(red, green, blue, alpha);
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)x, (int)y, RADIUS, RADIUS);
    }

    public Point2D getCenter(){
        return new Point2D.Double(x,y);
    }
    
    public Point getPoint(){
        return new Point((int)x, (int)y);
    }
    
    public boolean contains(Point2D p){
        double diffx2 = (p.getX() - this.x)*(p.getX()-this.x);
        double diffy2 = (p.getY() - this.y)*(p.getY()-this.y);
        return diffx2 + diffy2 <= RADIUS * RADIUS;
    }
    
    public void updateLocation(){
        x += dx;
        y += dy;
    }
    public void changeLocation(double x1, double y1){
        x = x1;
        y = y1;
    }
    
    public double getDx(){
        return dx;
    }
    
    public double getDy(){
        return dy;
    }
    
    public void setDx(double d){
        dx = d;
    }
    
    public void setDy(double d){
        dy = d;
    }
    
    public void slowDown(double amt){
        amt = Math.abs(amt);
        if(Math.abs(dx) <= amt)
            dx = 0;
        else if(dx > 0)
            dx = dx-amt;
        else
            dx = dx + amt;
        if(Math.abs(dx) < .1)
            dx = 0;
        
        if(Math.abs(dy) <= amt)
            dy = 0;
        else if(dy > 0)
            dy = dy-amt;
        else
            dy = dy + amt;
        if(Math.abs(dy) < .1)
            dy = 0;
    }
}
