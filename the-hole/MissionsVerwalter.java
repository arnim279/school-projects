import greenfoot.*;

public class MissionsVerwalter {
    private Spiel spiel;
    
    /*
     * 1 = Raumstation besucht
     * 2 = Mars besucht
     * 4 = Mars Ressourcen gesammelt
     * 8 = Asteroiden besucht
     * 16 = Asteroiden Ressourcen gesammelt
     * 32 = Alien Welt besucht
     * 64 = Alien Ressourcen gesammelt
     */
    private int status;
    public final PlanetenText planetenText;
    public final MissionsText missionsText;
    
    private Planet aktuellerPlanet;
    private Planet[] planeten;
    
    private Teleporter[] teleporterListe;
    
    public MissionsVerwalter(Spiel spiel) {
        this.spiel = spiel;
        status = 0;
        planetenText = new PlanetenText();
        missionsText = new MissionsText();
        teleporterListe = new Teleporter[4];
        planeten = new Planet[]{new Erde(), new Raumstation(), new Mars(), new Asteroiden(), new AlienPlanet(), new SchwarzesLoch()};
    }
    
    public int getStatus() {
        return status;
    }
    
    public void benutzePlanet(Class planetenKlasse) {
        if (aktuellerPlanet != null) spiel.removeObject(aktuellerPlanet);
        
        for (Planet planet : planeten) {
            if (!planetenKlasse.isInstance(planet)) continue;
            
            // Aktuelle Objekte entfernen
            int berührterTeleporterIndex = -1;
            for (int i = 0; i < teleporterListe.length; i++) {
                Teleporter teleporter = teleporterListe[i];
                if (teleporter == null) continue;
                if (teleporter.intersects(spiel.spieler)) berührterTeleporterIndex = i;
                spiel.removeObject(teleporter);
            }
            teleporterListe = new Teleporter[4];
            
            // Planet anzeigen
            spiel.addObject(planet, 15, 10);
            
            // Teleporter erstellen
            for (int i = 0; i < planet.planetenLinks.length; i++) {
                if (planet.planetenLinks[i] != null) teleporterListe[i] = new Teleporter(i * 90, planet.planetenLinks[i]);
            }
            
            // Teleporter anzeigen
            if (teleporterListe[0] != null) spiel.addObject(teleporterListe[0], 29, 10);
            if (teleporterListe[1] != null) spiel.addObject(teleporterListe[1], 15, 19);
            if (teleporterListe[2] != null) spiel.addObject(teleporterListe[2], 0, 10);
            if (teleporterListe[3] != null) spiel.addObject(teleporterListe[3], 15, 0);
            
            // Spieler anzeigen
            int spielerX = spiel.spieler.getX();
            int spielerY = spiel.spieler.getY();
            spiel.removeObject(spiel.spieler);
            if (berührterTeleporterIndex == 0) spiel.addObject(spiel.spieler, 1, 10);
            else if (berührterTeleporterIndex == 1) spiel.addObject(spiel.spieler, 15, 1);
            else if (berührterTeleporterIndex == 2) spiel.addObject(spiel.spieler, 28, 10);
            else if (berührterTeleporterIndex == 3) spiel.addObject(spiel.spieler, 15, 18);
            else spiel.addObject(spiel.spieler, spielerX, spielerY);
            
            if (planet instanceof Raumstation) status = status | 1;
            if (planet instanceof Mars) status = status | 2;
            if (planet instanceof Asteroiden) status = status | 8;
            if (planet instanceof AlienPlanet) status = status | 32;
            
            planetenText.setzeText(planet.name);
            
            aktuellerPlanet = planet;
            return;
        }
        
        throw new Error("Kein passender Planet gefunden.");
    }
    
    public void marsRessourcenGesammelt() {
        status = status | 4;
    }
    
    public void asteroidenRessourcenGesammelt() {
        status = status | 16;
    }
    
    public void alienRessourcenGesammelt() {
        status = status | 64;
    }
}