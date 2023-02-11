import greenfoot.*;
import java.lang.Math;

public class SchwarzesLoch extends Planet {
    public SchwarzesLoch() {
        super("Schwarzes Loch", "Schwarzes Loch.png");
        planetenLinks[3] = Asteroiden.class;
    }
    
    public void act() {
        Spiel spiel = (Spiel) getWorld();
        int diffX = Math.abs(getX() - spiel.spieler.getX());
        int diffY = Math.abs(getY() - spiel.spieler.getY());
        if (diffX <= 2 && diffY <= 2) Greenfoot.setWorld(new StartBildschirm());
    }
}
