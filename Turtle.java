import greenfoot.*;
public class Turtle extends Actor {
    private int diveSpeed;
    private boolean diving;
    private int count;
    
    public Turtle(boolean diving) {
        this.diveSpeed = 30;
        this.diving = diving;
        this.count = 0;
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
        if(count == 150) {
            if(diving) {
                diving = false;    
            }
            else {
                diving = true;
            }
            count = 0;
        }
        if(this.isDiving()) {
            dive();
        }
        else {
            ascend();
        }
        count++;
    }
    public boolean isDiving() {
        return diving;
    }
    public void dive() {
        GreenfootImage image = this.getImage();
        int alpha = image.getTransparency();
        alpha -= diveSpeed;
        if(alpha < 45) {
            return;
        }
        image.setTransparency(alpha);
    }
    public void ascend() {
        GreenfootImage image = this.getImage();
        int alpha = image.getTransparency();
        if(alpha < 255) {
            alpha += diveSpeed;    
        }
        image.setTransparency(alpha);
    }
}