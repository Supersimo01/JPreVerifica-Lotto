
import java.util.Random;

/**
 * @author Simone Mauri
 */
public class ThContr1 extends Thread{
    
    DatiCondivisi dc;
    Random rn = new Random();

    public ThContr1(DatiCondivisi dc) {
        this.dc = dc;
    }
    
    @Override
    public void run(){
        
        try {
            dc.getsControlla().acquire();
            
        for (int i = 0; i < 5; i++) {
            if(dc.getV()[i] == dc.getN1()){            
                dc.setN1find();
            }
        }
            dc.estrazEnded1();
            dc.getsEstrai().release();
        
        } catch (InterruptedException ex) {
            System.out.print(ex.toString());
        }
        
        
    }
    
}
