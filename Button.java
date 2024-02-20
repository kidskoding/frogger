import greenfoot.*;
public class Button extends Actor {
    private GreenfootImage playAgain;
    private GreenfootImage text;
    
    public Button(String phrase, Color fillColor, Color textColor, int x, int y) {
        playAgain = new GreenfootImage(200, 50);
        playAgain.setColor(fillColor);
        playAgain.fill();
        text = new GreenfootImage(phrase, 30, textColor, null);
        playAgain.drawImage(text, x, y);
        this.setImage(playAgain);
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Game());
        }
    }
}
