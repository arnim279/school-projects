import java.util.HashMap;

public class EndKnoten extends Knoten {
    public final char name;
    
    public EndKnoten(char name,int anzahl) {
        super(anzahl, null);
        this.name = name;
    }
    
    void print(int level) {
        System.out.println(" ".repeat(level) + name + ": " + anzahl);
    }
    
    public void updateDictionary(String current, HashMap<Character, String> dictionary) {
        dictionary.put(name, current);
    }
}