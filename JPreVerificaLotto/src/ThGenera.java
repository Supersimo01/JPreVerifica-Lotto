
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
        
        try {
            while(dc.isEstazEnd1() == true && dc.isEstazEnd2() == true){}
            
            dc.getsEstrai().acquire(2);
            Integer[] rand = new Integer[5];
        for (int i = 0; i < 5; i++) {
            
            rand[i] = 1 + rn.nextInt(89);
            if(i != 0){
            for (int j = 0; j < i; j++) {
                while(rand[i] == rand[j])
                {
                   rand[i] = 1 + rn.nextInt(89); 
                }
            }
            }
            
        }
            dc.setV(rand);
            dc.getsControlla().release(2);
        
        } catch (InterruptedException ex) {
            System.out.print(ex.toString());
        }
        
        
    }
    
}
