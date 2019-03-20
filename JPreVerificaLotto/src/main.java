
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 0.1
 * @author Simone Mauri
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        
        Scanner sc = new Scanner(System.in);
        Integer s1 = 0;
        Integer s2 = 0;
        
        int nRuote = 0;
        
        while(s1 < 1 && s1 <=90)
        {
            System.out.println("Inserisci il primo numero dell'ambo");
            s1 = sc.nextInt();
        }
        
        while((s2 < 1 && s2 <= 90) || s2.equals(s1))
        {
            System.out.println("Inserisci il secondo numero dell'ambo (diverso dal primo)");
            s2 = sc.nextInt();
        }
        
        while(nRuote < 1){
            
            System.out.println("Inserisci il numero di ruote che vuoi giocare");
            nRuote = sc.nextInt();
        
        }
        
        DatiCondivisi dc = new DatiCondivisi(s1,s2,nRuote);
        
        ThGenera th1 = new ThGenera(dc);
        ThContr1 th2 = new ThContr1(dc);
        ThContr2 th3 = new ThContr2(dc);
        thPrint thP = new thPrint(dc);
        
        th1.start();
        th2.start();
        th3.start();
        thP.start();
        
        boolean change = false;
        for (int i = 0; i < nRuote; i++) {
           while(true && change == false){
            if(dc.isEstazEnd1() == true && dc.isEstazEnd2() == true){
                
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
                change = true;
                
            }
            else{
                sleep(100);
                change = false;
            } 
        }
        
        
                
        }
        
    }
    
}
