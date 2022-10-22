package Program2v3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateLine extends JPanel{
    private ArrayList<Point> begin = new ArrayList<Point>();
    private ArrayList<Point> end = new ArrayList<Point>();
    private int tempx;
    private int tempy;
    
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
        if(begin.size() != end.size() && end.size()>0 && begin.size()>0){
            for(int i=0; i<begin.size()-1; i ++){
                g2.drawLine(begin.get(i).x, begin.get(i).y, end.get(i).x, end.get(i).y);
            }
            g2.drawLine(begin.get(begin.size()-1).x, begin.get(begin.size()-1).y, tempx, tempy);
        }else if(begin.size() == end.size()){
            for(int i=0; i<begin.size(); i ++){
                g2.drawLine(begin.get(i).x, begin.get(i).y, end.get(i).x, end.get(i).y);
            }
        }
    }
    
    private class Eek implements MouseListener, MouseMotionListener{
        public void mouseEntered(MouseEvent e){}
        public void mousePressed(MouseEvent e){
            if (SwingUtilities.isLeftMouseButton(e)){
                int x1 = e.getX();
                int y1 = e.getY();
                begin.add(new Point(x1, y1));
            }else{
                begin.removeAll(begin);
                repaint();
            }
            
        }
        public void mouseReleased(MouseEvent e){
            
            if(SwingUtilities.isLeftMouseButton(e)){
                int x2 = e.getX();
                int y2 = e.getY();
                end.add(new Point(x2, y2));
            }else{
                end.removeAll(end);
                tempx = 0;
                tempy = 0;
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
