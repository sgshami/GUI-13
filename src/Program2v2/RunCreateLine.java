package Program2v2;
import javax.swing.*;
import java.awt.*;

public class RunCreateLine extends JFrame{
    public static void main(String[] args){
        RunCreateLine rcl = new RunCreateLine();
        rcl.display();
    }
    
    public RunCreateLine(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Graphics");
        JPanel jp = new JPanel();
        jp.setBackground(Color.WHITE);
        jp.setPreferredSize( new Dimension( 390, 360));
        jp.setLayout(null);
        
        CreateLine c1 = new CreateLine(Color.ORANGE);
        CreateLine c2 = new CreateLine(Color.YELLOW);
        c1.setBounds(20, 20, 350, 150);
        c2.setBounds(20, 190, 350, 150);

        jp.add(c1);
        jp.add(c2);
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
