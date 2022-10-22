package Demo1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MotionPanel extends JPanel{
    private ArrayList<Point> pts = new ArrayList<Point>();
    
    public MotionPanel(){
        setBackground(Color.ORANGE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Eek eek = new Eek();
        addMouseMotionListener(eek);
        addMouseListener(eek);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Point p: pts){
            g.fillOval(p.x-5, p.y-5, 10, 10);
        }
    }
    
    private class Eek implements MouseListener, MouseMotionListener{
        public void mouseEntered(MouseEvent e){
            pts.clear();
            repaint();
        }
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseDragged(MouseEvent e){}
        public void mouseMoved(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            pts.add(new Point(x, y));
            repaint();
        }
    }
}
