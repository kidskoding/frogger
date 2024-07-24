import greenfoot.*;
import java.util.*;
public class Frogger extends World {
    private Actor startButton;
    private GreenfootImage text;
    private static List<GreenfootImage> frogs;
    
    public Frogger() {    
        super(700, 690, 1); 
        startButton = new Button("START", Color.GREEN, null, 60, 10);
        text = new GreenfootImage("Frogger!", 45, Color.WHITE, null);
        frogs = new ArrayList<GreenfootImage>();
        makeScreen();
        Greenfoot.start();
    }
    
    private void makeScreen() {
        GreenfootImage bg = new GreenfootImage(this.getWidth(), this.getHeight());
        bg.setColor(Color.BLACK);
        bg.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.setBackground(bg);
        for(int k = 1; k <= 3; k++) {
            frogs.add(new GreenfootImage("lives.png"));
        }
        int x = 275;
        for(GreenfootImage img : frogs) {
            this.getBackground().drawImage(img, x, text.getWidth() + 150);
            x += 50;
        }
        this.getBackground().drawImage(text, 275, 200);
        this.addObject(startButton, 350, 500);
    }
}