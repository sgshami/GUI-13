package Program2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateLine extends JPanel{
    private ArrayList<Point> pts = new ArrayList<Point>();
    
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
        for(int i=0; i<pts.size()-1; i += 2){
            g2.drawLine(pts.get(i).x, pts.get(i).y, pts.get(i+1).x, pts.get(i+1).y);
        }
    }
    
    private class Eek implements MouseListener, MouseMotionListener{
        public void mouseEntered(MouseEvent e){}
        public void mousePressed(MouseEvent e){
            if (SwingUtilities.isLeftMouseButton(e)){
                int x1 = e.getX();
                int y1 = e.getY();
                pts.add(new Point(x1, y1));
            }else{
                pts.removeAll(pts);
                repaint();
            }
            
        }
        public void mouseReleased(MouseEvent e){
            int x2 = e.getX();
            int y2 = e.getY();
            pts.add(new Point(x2, y2));
            if(SwingUtilities.isRightMouseButton(e)){
                pts.removeAll(pts);
            }
            repaint();
        }
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseDragged(MouseEvent e){}
        public void mouseMoved(MouseEvent e){}
    }
}
