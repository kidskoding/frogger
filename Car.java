import greenfoot.*;
public class Car extends Actor {
    public static GreenfootImage car1;
    public static GreenfootImage car2;
    public static GreenfootImage car3;
    public static GreenfootImage car4;
    
    public Car() {
        car1 = new GreenfootImage("car1.png");
        car2 = new GreenfootImage("car2.png");
        car3 = new GreenfootImage("car3.png");
        car4 = new GreenfootImage("car4.png");
        car4.mirrorHorizontally();
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