import greenfoot.*;

public class StartButton extends Actor {
    public StartButton() {
        setImage("Play.png");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Spiel());
        }
    }
}
