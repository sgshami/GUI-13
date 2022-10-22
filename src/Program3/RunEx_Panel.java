package Program3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunEx_Panel extends JFrame{
    private Ex3_Panel p1 = new Ex3_Panel(230, 380);
    private Ex3_Panel p2 = new Ex3_Panel(230, 380);
    
    public static void main(String[] args){
        RunEx_Panel rex = new RunEx_Panel();
        rex.display();
    }
    
    public RunEx_Panel(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Graphics");
        JPanel jp = new JPanel();
        jp.setBackground(Color.WHITE);
        jp.setPreferredSize( new Dimension( 500, 400));
        jp.setLayout(null);
        
        p1.setBounds(10, 10, 230, 380);
        p1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p2.setBounds(260, 10, 230, 380);
        p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        jp.add(p1);
        jp.add(p2);
        getContentPane().add(jp);
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
