import greenfoot.*;

public class Teleporter extends Actor {
    private Class zielKlasse;
    
    public Teleporter(int richtung, Class zielKlasse) {
        setImage("Teleporter.png");
        setRotation(richtung);
        this.zielKlasse = zielKlasse;
    }
    
    public void act() {
        Spiel spiel = (Spiel) getWorld();
        if (spiel.getObjects(Spieler.class).size() > 0 && intersects(spiel.spieler)) {
            spiel.missionsVerwalter.benutzePlanet(zielKlasse);
        }
    }
    
    public boolean intersects(Spieler spieler) {
        return super.intersects(spieler);
    }
}
