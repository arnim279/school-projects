import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanCode {
    Knoten tree;
    HashMap<Character, String> dictionary;
    String input;
    
    public HuffmanCode (String input) {
        var h = new Häufigkeiten(input).getMap();
        
        var knoten = new ArrayList<Knoten>();
        for (var e : h.entrySet()) {
            knoten.add(
                new EndKnoten(e.getKey(), e.getValue())
            );
        }
        
        dictionary = new HashMap();
        while (knoten.size() > 1) {
            var kleinstes = knoten.get(0);
            var zweitkleinstes = knoten.get(1);
            
            for (var i = 2; i < knoten.size(); i++) {
                var k = knoten.get(i);
                
                if (k.anzahl < kleinstes.anzahl) {
                    kleinstes = k;
                } else if (k.anzahl < zweitkleinstes.anzahl) {
                    zweitkleinstes = k;
                }
            }
            
            knoten.remove(kleinstes);
            knoten.remove(zweitkleinstes);
            var n = new Knoten(
                kleinstes.anzahl + zweitkleinstes.anzahl,
                new Knoten[] {kleinstes, zweitkleinstes}
            );
            n.updateDictionary("", dictionary);
            knoten.add(n);
        }
        
        tree = knoten.get(0);
        this.input = input;
    }

    void printTree() {
        System.out.println("\nHuffman-Baum für '" + input + "':");
        tree.print();
    }
    
    void printDictionary() {
        System.out.println("\nHuffman-Kodierung für '" + input + "':");
        for (var e : dictionary.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }
    
    String kodiereInput() {
        try {
            return kodiere(input);
        } catch (Exception e) {
            return ""; // passiert nie
        }
    }
    
    String kodiere(String input) throws Exception {
        var output = "";
        for (var c : input.toCharArray()) {
            var code = dictionary.get(c);
            if (code == null) throw new Exception("Zeichen '" + c + "' nicht in '" + this.input + "' enthalten.");
            output += code;
        }        
        return output;
    }
    
    void printAll() {
        printTree();
        printDictionary();
        System.out.println("\n" + input + "=" + kodiereInput());
    }
}