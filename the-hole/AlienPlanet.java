import greenfoot.*;

public class AlienPlanet extends Planet {
    public AlienPlanet() {
        super("Alien Planet", "Alien Planet.png");
        planetenLinks[1] = Raumstation.class;
    }
    
    public void act() {
        Spiel spiel = (Spiel) getWorld();
        if (Greenfoot.mouseClicked(this)) spiel.missionsVerwalter.alienRessourcenGesammelt();
    }
}
