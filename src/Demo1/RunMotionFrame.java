package Demo1;
import javax.swing.*;
import java.awt.*;

public class RunMotionFrame extends JFrame{
    public static void main(String[] args){
        RunMotionFrame f = new RunMotionFrame();
        f.display();
    }
    public RunMotionFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Graphics");
        MotionPanel mp = new MotionPanel();
        mp.setPreferredSize(new Dimension(400, 400));
        getContentPane().add(mp);
        pack();
    }
    
    public void display(){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                setVisible(true);
            }
        });
    }
}
