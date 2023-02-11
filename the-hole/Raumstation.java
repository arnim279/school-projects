import greenfoot.*;

public class Raumstation extends Planet {
    public Raumstation() {
        super("Raumstation", "Raumstation.png");
        planetenLinks[1] = Mars.class;
        planetenLinks[2] = Erde.class;
    }
    
    public void act() {
        Spiel spiel = (Spiel) getWorld();
        int status = spiel.missionsVerwalter.getStatus();
        
        // Mars Ressourcen gesammelt?
        if (planetenLinks[3] == null && (status & 4) == 4) {
            planetenLinks[3] = AlienPlanet.class;
            spiel.missionsVerwalter.benutzePlanet(Raumstation.class);
        }
    }
}
