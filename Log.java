import greenfoot.*;
import java.util.*;
public class Log extends Actor {
    private Random rand;
    
    public Log() {
        this.rand = new Random();
    }
    
    public void act() {
        if(this.getRotation() == 0) {
            this.setLocation(this.getX() - 2, this.getY());    
        }
        if(this.getRotation() == 180) {
            this.setLocation(this.getX() + 2, this.getY());
        }
        if(this.isAtEdge()) {
            if(this.getRotation() == 0) {
                this.setLocation(getWorld().getWidth(), this.getY());
            }
            if(this.getRotation() == 180) {
                this.setLocation(0, this.getY());
            }
        }
    }
}