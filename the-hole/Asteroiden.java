import greenfoot.*;

public class Asteroiden extends Planet {
    public Asteroiden() {
        super("Asteroiden", "Asteroiden.png");
        planetenLinks[0] = Mars.class;
    }
    
    public void act() {
        Spiel spiel = (Spiel) getWorld();
        if (Greenfoot.mouseClicked(this)) spiel.missionsVerwalter.asteroidenRessourcenGesammelt();
        int status = spiel.missionsVerwalter.getStatus();
        
        // Alien und Asteroiden Ressourcen gesammelt?
        if (planetenLinks[1] == null && (status & 64+16) == 64+16) {
            planetenLinks[1] = SchwarzesLoch.class;
            spiel.missionsVerwalter.benutzePlanet(Asteroiden.class);
        }
    }
}
