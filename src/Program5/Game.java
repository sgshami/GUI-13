package Program5;
import java.awt.*;
import java.util.*;

public class Game{
    private boolean playing = false;
    private int width, height;
    private Player player;
    private ArrayList<Guy> list = new ArrayList<Guy>();
    private int score;

    public Game( int w, int h ){
        width = w;
        height = h;
        player = new Player( 5, height/2 - 10, width, height );
    }

    // sets up the game
    public void init(){
        score = 0;
        player = new Player( 5, height/2 - 10, width, height );
        list.clear();   // removes all elements
    }

    public void updatePlayerMotion( int dx, int dy  ){
        player.setSpeed( dx, dy );
    }

    public void update(){
        player.move();
        double picker = Math.random();
        double random = Math.random();
        if(picker <.1){
            if(random > .5){
                list.add(new Guy(width, ((int)(Math.random() * height+1)), true));
            }else if(random < .5){
                list.add(new Guy(width, ((int)(Math.random()* height+1)), false));
            }
        }
        //  maybe* spawn a new Guy
        //    set x so that it begins just off the right side of the panel
        //    set y to a random value
        //    there should be a 50-50 chance of a Guy being good or bad
        //    add the guy to the array list
        
        // * you do NOT want to add a new Guy every time the update method is called
        
        for(int i = 0; i<list.size(); i++){
            list.get(i).move();
        }
        // loop through the array list of Guy objects and tell each one to move

      
        // look for collisions between the player and the each Guy object
        // The Rectangle class has an intersects method that returns true if two rectangles overlap
        Rectangle player_r = player.getShape();
        for ( int k = list.size() - 1; k >= 0; k-- ){
            Guy guy = list.get( k );
            Rectangle guy_r = guy.getShape();
            if ( player_r.intersects( guy_r ) ){
                if(guy.isGood()){
                    score +=10;
                }else{
                    player.hurt();
                }
                list.remove(k);
                // if the guy is good, increase the score
                // else the guy is bad, call the player's hurt method
                // either way, remove the guy from the list
            }
        }
        for(int i =0; i<list.size(); i++){
            if(list.get(i).getX() <0){
                list.remove(i);
                i--;
            }
        }
        // loop through all the guys and remove any that have moved off the left side of the panel
    }
    
    public boolean keepPlaying(){
        return player.isAlive();
    }
    
    public int getScore(){
        return score;
    }
    
    public void draw( Graphics g ){
        player.draw( g );
        for ( Guy guy : list )
            guy.draw( g );

    }
}