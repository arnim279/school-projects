import greenfoot.*;

public class PlanetenText extends Actor {
    public PlanetenText() {
        setzeText("", false);
    }
    
    public void setzeText(String neuerText) {
        setzeText(neuerText, true);
    }
    
    public void setzeText(String neuerText, boolean updatePosition) {
        GreenfootImage image = new GreenfootImage(neuerText, 34, Color.WHITE, new Color(0,0,0,0)); 
        setImage(image);
        
        if (!updatePosition) return;
        Spiel spiel = (Spiel) getWorld();
        setLocation(image.getWidth()/2/spiel.getCellSize() + 1, image.getHeight()/2/spiel.getCellSize());
    }
}
