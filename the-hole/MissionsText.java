import greenfoot.*;

public class MissionsText extends Actor {
    private String aktuellerText;
    
    public MissionsText() {
        setzeText("", false);
        aktuellerText = "";
    }
    
    public void setzeText(String neuerText) {
        setzeText(neuerText, true);
    }
    
    public void setzeText(String neuerText, boolean updatePosition) {
        if (neuerText.equals(aktuellerText)) return;
        aktuellerText = neuerText;
        
        GreenfootImage image = new GreenfootImage(neuerText, 26, Color.WHITE, new Color(0,0,0,0)); 
        setImage(image);
        aktuellerText = neuerText;
        
        if (!updatePosition) return;
        Spiel spiel = (Spiel) getWorld();
        setLocation(image.getWidth()/2/spiel.getCellSize() + 1, spiel.getHeight() - image.getHeight()/2/spiel.getCellSize() - 2);
    }
    
    public void act() {
        
        String text = "Willkommen! Fliege nach rechts wenn du bereit bist. Du kannst mit WASD steuern.";
        
        if (statusHasFlags(1)) text = "Du hast die Raumstation entdeckt!";
        if (statusHasFlags(2)) text = "Willkommen auf dem Mars. Klicke auf den Planeten um Ressourcen abzubauen.";
        if (statusHasFlags(4)) text = "Mit den Ressourcen wurden neue Antriebe entwickelt,\nmit denen neue Planeten von der Raumstation aus erreichbar sind.";
        if (statusHasFlags(8)) text = "Klicke die Asteroiden an um Ressourcen abzubauen.";
        if (statusHasFlags(16)) text = "Die Asteroiden-Ressourcen alleine reichen noch nicht aus. Findest du noch weitere?";
        if (statusHasFlags(32)) text = "Eine neue Welt! Was es hier\nwohl zu entdecken gibt?";
        if (statusHasFlags(64)) text = "Die fremden Materialen sind zwar fortschrittlich,\naber irgendetwas fehlt noch.";
        if (statusHasFlags(64 + 16)) text = "Du kannst jetzt zum schwarzen Loch reisen!";
        
        setzeText(text);
    }
    
    private boolean statusHasFlags(int flags) {
        Spiel spiel = (Spiel) getWorld();
        return (spiel.missionsVerwalter.getStatus() & flags) == flags;
    }
}
