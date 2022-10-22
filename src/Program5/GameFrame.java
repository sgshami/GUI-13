package Program5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    private final int WIDTH = 700;
    private final int BTN_LABEL_HEIGHT = 30;
    private final int GAME_HEIGHT = 500;
    private final int PANEL_HEIGHT = GAME_HEIGHT + 2*BTN_LABEL_HEIGHT;

    private Game game = new Game( WIDTH, GAME_HEIGHT );
    private JButton btn = new JButton( "Start" );
    private JLabel lbl = new JLabel("Score: 0");
    private GamePanel gp = new GamePanel( game );
    private javax.swing.Timer timer;

    public GameFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle( "Simple Game" );
        setResizable( false );
        JPanel jp = new JPanel();
        jp.setBackground( Color.YELLOW );
        jp.setPreferredSize( new Dimension( WIDTH, PANEL_HEIGHT ) );
        jp.setLayout( null );
        
        timer = new javax.swing.Timer(10, new Clock());
        
        ButtonListener ears = new ButtonListener();
        btn.addActionListener(ears);
        btn.setBounds(0, 0, WIDTH, 30);
        btn.setBackground(Color.BLACK);
        btn.setOpaque(true);
        btn.setForeground(Color.WHITE);
        
        lbl.setBounds(0, GAME_HEIGHT+30, WIDTH, 30);
        lbl.setBackground(Color.CYAN);
        lbl.setOpaque(true);
        
        gp.setBounds(0, BTN_LABEL_HEIGHT, WIDTH, GAME_HEIGHT);
        
        jp.add(btn);
        jp.add(lbl);
        jp.add( gp );
        getContentPane().add( jp );
        pack(); 

    }

    public void display() {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    setVisible(true);
                }
            });
    }

    private class Clock implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            game.update();
            gp.repaint();   // redraw the panel
            lbl.setText("Score: " + game.getScore());// get the score from the game
            if(!game.keepPlaying()){ // if the game is over, stop the time and display a message
                btn.setText("Reset");
                lbl.setText("Score: " + game.getScore() + " Please Try again and press the reset button!");
                timer.stop();
            }
            // if the game is not over, just display the score.
        }
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(btn.getText().equals("Start")){
                timer.start();
            }else if(btn.getText().equals("Reset")){
                timer.stop();
                btn.setText("Start");
                game.init();
                lbl.setText("Score: 0");
                gp.repaint();
            }
            // if the button says Reset
            //      stop the time
            //      change the text to Start
            //      call the game's init method 
            //      change what is displayed in the label
            //      cause the game panel's paintComponent method to be called

            gp.requestFocusInWindow();
        }
    }
}