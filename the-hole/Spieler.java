import greenfoot.*;

public class Spieler extends Actor {
    public Spieler() {
        setImage("Spieler.png");
    }
    
    public void act() {
        boolean sollSichBewegen = true;
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) setRotation(270);
        else if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) setRotation(180);
        else if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) setRotation(90);
        else if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) setRotation(0);
        else sollSichBewegen = false;
        
        if (sollSichBewegen) move(1);
    }
}
