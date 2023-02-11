import greenfoot.*;

public class Mars extends Planet {
    public Mars() {
        super("Mars", "Mars.png");
        planetenLinks[3] = Raumstation.class;
    }
    
    public void act() {
        Spiel spiel = (Spiel) getWorld();
        if (Greenfoot.mouseClicked(this)) spiel.missionsVerwalter.marsRessourcenGesammelt();
        
        int status = spiel.missionsVerwalter.getStatus();
        
        // Mars Ressourcen gesammelt?
        if (planetenLinks[2] == null && (status & 4) == 4) {
            planetenLinks[2] = Asteroiden.class;
            spiel.missionsVerwalter.benutzePlanet(Mars.class);
        }
    }
}
