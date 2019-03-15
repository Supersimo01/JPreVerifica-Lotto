
import java.util.Random;

/**
 * @author Simone Mauri
 */
public class ThGenera extends Thread{
    
    DatiCondivisi dc;
    Random rn = new Random();

    public ThGenera(DatiCondivisi dc) {
        this.dc = dc;
    }
    
    @Override
    public void run(){
        
        for (int i = 0; i < 5; i++) {
            dc.getV()[i] = 1 + rn.nextInt(89);
        }
        
    }
    
}
