package Program2v2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateLine extends JPanel{
    private ArrayList<Point> pts = new ArrayList<Point>();
    private int tempx;
    private int tempy;
    private int permx;
    private int permy;
    
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
        if(pts.size()%2 == 0){
            for(int i=0; i<pts.size()-1; i += 2){
                g2.drawLine(pts.get(i).x, pts.get(i).y, permx, permy);
            }
        }else{
            for(int i=0; i<pts.size(); i += 2){
                g2.drawLine(pts.get(i).x, pts.get(i).y, tempx, tempy);
            }
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
            permx = e.getX();
            permy = e.getY();
            pts.add(new Point(0, 0));
            if(SwingUtilities.isRightMouseButton(e)){
                pts.removeAll(pts);
            }
            repaint();
        }
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseDragged(MouseEvent e){
            tempx = e.getX();
            tempy = e.getY();
            repaint();
        }
        public void mouseMoved(MouseEvent e){}
    }
}
