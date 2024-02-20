import greenfoot.*;
import java.util.*;
public class Game extends World {
    public static final int frogBeginX = 350;
    public static final int frogBeginY = 645;
    public static List<ImageActor> frogImages;
    
    private Random rand;
    private Frog mainActor;
    private Lives frogLives;
    
    public Game() { 
        super(700, 690, 1);
        
        mainActor = new Frog();
        rand = new Random();
        frogLives = new Lives();
        frogImages = new ArrayList<ImageActor>();
        
        prepareGame();
    }
    
    private void prepareGame() {    
        this.addObject(mainActor, frogBeginX, frogBeginY);
        this.addObject(frogLives, 53, 665);
        this.setPaintOrder(Skull.class, Frog.class, Turtle.class, 
            Log.class, Home.class);
            
        addCars();
        addTurtles();
        addLogs();
        addHomeFrogs();
        
        for(int k = 1; k <= 3; k++) {
            frogImages.add(new ImageActor(mainActor.getImage()));
        }
        int x = 110;
        for(ImageActor img : frogImages) {
            this.addObject(img, x, frogLives.getY());
            x += 30;
        }
    }
    private void addCars() {
        int y = 575;
        for(int num = 1; num <= 3; num++) {
            int startPoint = 25 + rand.nextInt(this.getWidth()) / 3;
            for(int k = startPoint; k < this.getWidth(); k += 170) {
                Car c = new Car();
                switch(num) {
                    case 1:
                        c.setImage(Car.car1);
                        break;
                    case 2:
                        c.setImage(Car.car3);
                        break;
                    case 3:
                        c.setImage(Car.car2);
                        break;
                }
                if(num % 2 == 0) {
                    c.setRotation(180);
                }
                this.addObject(c, k, y);
            }    
            y -= 50;
        }
    }
    private void addTurtles() {
        int y = 310;
        for(int times = 1; times <= 2; times++) {
            int startPoint = 25 + rand.nextInt(this.getWidth()) / 3;
            int count = rand.nextInt(3);
            for(int k = startPoint; k < this.getWidth() - 100; k += 100) {  
                for(int i = 1; i <= 3; i++) {
                    boolean dive = false;
                    if(count % 3 != 0 && count % 3 != 1) {
                        dive = true;
                    }
                    Turtle t = new Turtle(dive);
                    this.addObject(t, k, y);
                    k += 25;
                }
                count++;
            }
            y -= 165;
        }
    }
    private void addLogs() {
        int y = 362;
        for(int times = 1; times <= 3; times++) {
            int startPoint = 25 + rand.nextInt(this.getWidth()) / 2;
            int newSpeed = 1 + rand.nextInt(3);
            for(int k = startPoint; k <= this.getWidth(); k += 170) {
                Log l = new Log();
                if(times != 2) {
                    l.setRotation(180);
                    l.getImage().mirrorVertically();
                }
                this.addObject(l, k, y);
            }
            if(times == 2) {
                y -= 50;
            }
            else {
                y -= 110;    
            }
        } 
    }    
    private void addHomeFrogs() {
        int y = 95;
        for(int k = 57; k <= this.getWidth(); k += 171) {
            Home h = new Home();
            this.addObject(h, k, y);
        }
    }
}