package Program2v4;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;

public class CreateLine extends JPanel {
    private ArrayList<Point> pts = new ArrayList<Point>();
    private ArrayList<Point> pts2 = new ArrayList<Point>();
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;
    public CreateLine() {
        setBackground( Color.YELLOW);
        setBorder( BorderFactory.createLineBorder(Color.BLACK ) );
        Eek eek = new Eek();
        addMouseMotionListener( eek );
        addMouseListener( eek );
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); 
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        
        for (int i = 0; i<pts.size();i++) {
        g.fillOval( pts.get(i).x-5, pts.get(i).y-5, 10, 10 );  
            for (int j = 0; j<pts2.size();j++) {
            g2.drawLine(pts.get(i).x-5, pts.get(i).y-5, pts2.get(j).x-5, pts2.get(j).y-5);  
            }
        }
        

        
        //g2.drawLine(x1, y1, x2, y2 );

    }

    private class Eek extends MouseAdapter{
        @Override
        public void mouseClicked( MouseEvent e ){
            if (SwingUtilities.isLeftMouseButton(e)){
                int x1 = e.getX();
                int y1 = e.getY();
                x2 = e.getX();
                y2 = e.getY();
                pts.add(new Point(x1, y1));
                repaint();
            }else{
                pts.removeAll(pts);
                pts.removeAll(pts2);
                repaint();
            }
        }

        @Override
        public void mouseDragged( MouseEvent e ){
            if (SwingUtilities.isLeftMouseButton(e)){
                x2 = e.getX();
                y2 = e.getY();
                pts2.add(new Point(x2, y2));
                repaint();
            }else{
                pts.removeAll(pts);
                pts.removeAll(pts2);
                repaint();
            }
        }
    }

}