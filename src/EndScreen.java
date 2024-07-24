import greenfoot.*;
public class EndScreen extends World {
    private static final Color c = new Color(0, 0, 72);
    
    private Button playAgain;
    private GreenfootImage text;
    
    public EndScreen(String gameOutcome) {
        super(700, 690, 1); 
        
        text = new GreenfootImage(gameOutcome, 60, Color.WHITE, null);
        
        createScreen();
        Greenfoot.setWorld(new Game());
    }
    
    private void createScreen() {
        playAgain = new Button("Play Again?", Color.WHITE, c, 
            35, 9);
        this.addObject(playAgain, this.getWidth() / 2, this.getHeight() / 2);
        
        GreenfootImage img = new GreenfootImage(this.getWidth(), this.getHeight());
        img.setColor(c);
        img.fill();
        this.setBackground(img);
        img.drawImage(text, this.getWidth() / 3 + 20, this.getHeight() / 3);
    }
}
