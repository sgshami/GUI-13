package Program4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex4_Panel extends JPanel{
    private Environment env;
    private javax.swing.Timer timer;
    private RunEx_Panel rex;
    
    public Ex4_Panel(int width, int height, RunEx_Panel f){
        env = new Environment(width, height);
        rex = f;
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Eek eek = new Eek();
        addMouseMotionListener(eek);
        addMouseListener(eek);
        timer = new javax.swing.Timer(40, new TimerListener());
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        env.draw(g);
    }
    
    public int numCircles(){
        return env.numCircles();
    }
    
    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            env.update();
            repaint();
            rex.updateDisplay();
        }
    }
    
    private class Eek implements MouseListener, MouseMotionListener{
        public void mouseEntered(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseDragged(MouseEvent e){
            env.add(e.getX(), e.getY());
        }
        public void mouseMoved(MouseEvent e){}
    }
}
