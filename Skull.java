import greenfoot.*;
public class Skull extends Actor
{
    private static GreenfootImage skullImg;
    
    private Frog frog;
    private GreenfootImage frogImage;
    
    public Skull() {
        skullImg = this.getImage();
        frog = new Frog();
        frogImage = frog.getImage();
        skullImg.scale(frogImage.getWidth(), frogImage.getHeight() - 10);
    }
}