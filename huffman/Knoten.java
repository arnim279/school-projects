import java.util.HashMap;

public class Knoten {
    public final int anzahl;
    public final Knoten[] knoten;
    
    public Knoten(int anzahl) {
        this(anzahl, new Knoten[0]);
    }
    
    public Knoten(int anzahl, Knoten[] knoten) {
        this.anzahl = anzahl;
        this.knoten = knoten;
    }
    
    public void print() {
        print(0);
    }
    
    void print(int level) {
        System.out.println(" ".repeat(level) + anzahl);
        for (var k : knoten) k.print(level+1);
    }
    
    public void updateDictionary(String current, HashMap<Character, String> dictionary) {
        for (var i = 0; i < knoten.length; i++) knoten[i].updateDictionary(current + i, dictionary);
    }
}