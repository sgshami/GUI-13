package Program3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex3_Panel extends JPanel{
    private Environment env;
    private javax.swing.Timer timer;
    
    public Ex3_Panel(int width, int height){
        env = new Environment(width, height);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Eek eek = new Eek();
        addMouseMotionListener(eek);
        addMouseListener(eek);
        timer = new javax.swing.Timer(40, new TimerListener());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        env.draw(g);
    }
    
    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            env.update();
            repaint();
        }
    }
    
    private class Eek implements MouseListener, MouseMotionListener{
        public void mouseEntered(MouseEvent e){
            timer.start();
        }
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseExited(MouseEvent e){
            timer.stop();
        }
        public void mouseClicked(MouseEvent e){}
        public void mouseDragged(MouseEvent e){
            env.add(e.getX(), e.getY());
        }
        public void mouseMoved(MouseEvent e){
            env.delete(new Point(e.getX(), e.getY()));
        }
    }
}
