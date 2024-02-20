import greenfoot.*;
public class Lives extends Actor {
    private GreenfootImage showLives;
    
    public Lives() {
        showLives = new GreenfootImage("Lives: ", 30, Color.WHITE, null);
        this.setImage(showLives);
    }
}
