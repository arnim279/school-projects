import greenfoot.*;

public abstract class Planet extends Actor {
    String name;
    
    public Planet(String name, String imageFile) {
        this.name = name;
        setImage(imageFile);
        planetenLinks = new Class[4];
    }
    
    Class[] planetenLinks;
}
