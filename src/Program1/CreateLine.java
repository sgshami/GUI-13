package Program1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateLine extends JPanel{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public CreateLine(Color c){
        setBackground(c);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Eek eek = new Eek();
        addMouseMotionListener(eek);
        addMouseListener(eek);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(x1, y1, x2, y2);
    }
    
    private class Eek implements MouseListener, MouseMotionListener{
        public void mouseEntered(MouseEvent e){}
        public void mousePressed(MouseEvent e){
            x1 = e.getX();
            y1 = e.getY();
        }
        public void mouseReleased(MouseEvent e){
            
        }
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseDragged(MouseEvent e){
            x2 = e.getX();
            y2 = e.getY();
            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " ");
            repaint();
        }
        public void mouseMoved(MouseEvent e){}
    }
}
