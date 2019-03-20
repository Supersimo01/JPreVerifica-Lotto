
import java.util.Random;

/**
 * @author Simone Mauri
 */
public class ThContr2 extends Thread{
    
    DatiCondivisi dc;
    Random rn = new Random();

    public ThContr2(DatiCondivisi dc) {
        this.dc = dc;
    }
    
    @Override
    public void run(){
        
        try {
            dc.getsControlla().acquire();
            
        for (int i = 0; i < 5; i++) {
            if(dc.getV()[i] == dc.getN2()){            
                dc.setN2find();
            }
        }
            dc.estrazEnded2();
            dc.getPrint().release();
        
        } catch (InterruptedException ex) {
            System.out.print(ex.toString());
        }
        
        
    }
    
}
