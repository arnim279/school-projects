import java.util.HashMap;

public class Häufigkeiten {
    HashMap<Character, Integer> map;
    
    public Häufigkeiten(String input) {
        map = new HashMap();
        for (char c : input.toCharArray()) {
            var count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
    }
    
    public HashMap<Character, Integer> getMap() {
        return map;
    }
    
    public String toString() {
        var output = "";
        for (var e : map.entrySet()) {
            output += " " + e.getKey() + "=" + e.getValue();
        }
        return output;
    }
}