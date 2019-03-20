
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simone Mauri
 */
public class thPrint extends Thread{
    
    DatiCondivisi dc;

    public thPrint(DatiCondivisi dc) {
        this.dc = dc;
    }

    
    @Override
    public void run(){
        
        while(true){   
            
            try {
                dc.getPrint().acquire(2);
                
                System.out.print("Sono stati estratti i seguenti numeri: ");
                System.out.println(dc.Vect());
                
                if(dc.isN1find())
                {
                    System.out.print("Hai indovinato il primo numero");
                }
                if(dc.isN2find())
                {
                    System.out.print("Hai indovinato il secondo numero");
                }
                
                dc.reset();
                dc.getsEstrai().release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(thPrint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
