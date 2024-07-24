import greenfoot.*;
public class Frog extends Actor {
    private static GreenfootImage upFrog;
    private static GreenfootImage downFrog;
    private static GreenfootImage leftFrog;
    private static GreenfootImage rightFrog;
    private static GreenfootSound hop;
    private static GreenfootSound squash;
    private static GreenfootSound plunk;
    
    private boolean dead;
    
    public Frog() {
        this.upFrog = new GreenfootImage("player-up.png");
        this.downFrog = new GreenfootImage("player-down.png");
        this.leftFrog = new GreenfootImage("player-left.png");
        this.rightFrog = new GreenfootImage("player-right.png");

        this.plunk = new GreenfootSound("sound-frogger-plunk.wav");
        this.hop = new GreenfootSound("sound-frogger-hop.wav");
        this.squash = new GreenfootSound("sound-frogger-squash.wav");

        this.dead = false;
    }
    public void act() {
        move();

        Car car = (Car) this.getOneIntersectingObject(Car.class);
        Turtle turtle = (Turtle) this.getOneIntersectingObject(Turtle.class);
        Log log = (Log) this.getOneIntersectingObject(Log.class);
        Color blue = new Color(0, 0, 71);

        if(this.isTouching(Home.class)) {
            Greenfoot.delay(30);
            Greenfoot.setWorld(new EndScreen("You Win!"));
        }
        if(car != null) {
            squash.play();
            dead = true;
        }
        if(this.isAtEdge() && this.getY() <= 380
        || turtle != null && turtle.isDiving() 
            && turtle.getImage().getTransparency() < 100) {
            plunk.play();
            dead = true;
        }
        if(getWorld().getColorAt(this.getX(), this.getY()).equals(blue) 
        || getWorld().getColorAt(this.getX(), this.getY()).equals(Color.GREEN)) {
            if(turtle == null && log == null) {
                plunk.play();
                dead = true;    
            }
        }
        if(log != null) {
            helper(log);
        }
        if(turtle != null) {
            helper(turtle);
        }
        if(dead) {
            this.setImage(new Skull().getImage());
            Greenfoot.delay(65);
            
            ImageActor temp = Game.frogImages.get(Game.frogImages.size() - 1);
            getWorld().removeObject(temp);
            Game.frogImages.remove(temp);
            if(Game.frogImages.size() == 0) {
                Greenfoot.setWorld(new EndScreen("You Lose")); 
            }
            else {
                this.setLocation(Game.frogBeginX, Game.frogBeginY);
                this.setImage(upFrog);
                dead = false;    
            }
        }
    }
    public void move() {
        if(Greenfoot.isKeyDown("UP") || Greenfoot.isKeyDown("W")) {
            this.setImage(upFrog);
            this.setLocation(this.getX(), this.getY() - 3);
        }
        else if(Greenfoot.isKeyDown("DOWN") || Greenfoot.isKeyDown("S")) {
            this.setImage(downFrog);
            if(this.getX() != Game.frogBeginX && this.getY() != Game.frogBeginY) { //starting position. frog shouldnt move down when at starting position
                this.setLocation(this.getX(), this.getY() + 3);
            }
        }
        else if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("LEFT")) {
            this.setImage(leftFrog);
            this.setLocation(this.getX() - 3, this.getY());
        }
        else if(Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("RIGHT")) {
            this.setImage(rightFrog);
            this.setLocation(this.getX() + 3, this.getY());
        } 
    }
    private void helper(Actor a) {
        if(a.getRotation() == 0)
            this.setLocation(this.getX() - 2, this.getY());
        else
            this.setLocation(this.getX() + 2, this.getY());
    }
}