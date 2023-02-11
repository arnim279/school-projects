import greenfoot.*;

public class Spiel extends WeltMitGröße {
    
    public final Spieler spieler;
    public final MissionsVerwalter missionsVerwalter;
    
    public Spiel() {
        Greenfoot.setSpeed(36);
        spieler = new Spieler();
        addObject(spieler, 15, 10);
        missionsVerwalter = new MissionsVerwalter(this);
        addObject(missionsVerwalter.planetenText, 0, 0);
        addObject(missionsVerwalter.missionsText, 0, 0);
        missionsVerwalter.benutzePlanet(Erde.class);
    }
}
