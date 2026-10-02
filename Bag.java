import java.util.ArrayList;
import java.util.Collections;

public class Bag {

    private ArrayList<String> blocks = new ArrayList<>();
    
    public Bag() {
        refill();
    }
    public void refill() {
        
        blocks.add("I");
        blocks.add("O");
        blocks.add("T");
        blocks.add("J");
        blocks.add("L");
        blocks.add("S");
        blocks.add("Z");
       
        Collections.shuffle(blocks);
    }
    
    public String getNextBlock() {
        if (blocks.isEmpty()) {
            refill();
        }
        return blocks.remove(0);
    }
}
    