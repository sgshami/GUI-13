package Program4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunEx_Panel extends JFrame{
    private Ex4_Panel p1 = new Ex4_Panel(230, 380, this);
    private Ex4_Panel p2 = new Ex4_Panel(230, 380, this);
    private JLabel c1 = new JLabel("Number of Circles: 0");
    private JLabel c2 = new JLabel("Number of Circles: 0");
    
    public static void main(String[] args) {
        RunEx_Panel rex = new RunEx_Panel();
        rex.display();
    }
    
    public RunEx_Panel(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Graphics");
        JPanel jp = new JPanel();
        jp.setBackground(Color.WHITE);
        jp.setPreferredSize( new Dimension( 500, 450));
        jp.setLayout(null);
        
        c1.setBounds(10, 400, 230, 30);
        p1.setBounds(10, 10, 230, 380);
        p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c2.setBounds(260, 400, 230, 30);
        p2.setBounds(260, 10, 230, 380);
        p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        jp.add(c1);
        jp.add(c2);
        jp.add(p1);
        jp.add(p2);
        getContentPane().add(jp);
        pack();
    }
    
    public void updateDisplay(){
        int x = p1.numCircles();
        int y = p2.numCircles();
        c1.setText("Number of Circles: " + x);
        c2.setText("Number of Circles: " + y);
    }
    
    public Ex4_Panel getter1(){
        return p1;
    }
    
    public Ex4_Panel getter2(){
        return p2;
    }
    
    public void display(){
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                setVisible(true);
            }
        });
    }
}
