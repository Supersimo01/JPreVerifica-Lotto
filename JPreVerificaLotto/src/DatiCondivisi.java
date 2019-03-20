
import java.util.concurrent.Semaphore;

/**
 *
 * @author Simone Mauri
 */
public class DatiCondivisi {

    private Integer[] v;
    private Integer N1, N2;
    private boolean n1find, n2find;
    private Semaphore sEstrai;
    private Semaphore sControlla,Print,nextRound;

    public DatiCondivisi(Integer n1, Integer n2,int nGiri) {
        this.v = new Integer[5];
        N1 = n1;
        N2 = n2;
        n1find = false;
        n2find = false;
        sEstrai = new Semaphore(1); //doppio semaforo
        sControlla = new Semaphore(0);
        Print = new Semaphore(0);
        nextRound = new Semaphore(nGiri);
    }

    synchronized public Integer[] getV() {
        return v;
    }

    public int getN1() {
        return N1;
    }
    public int getN2() {
        return N2;
    }

    
    public boolean isN1find() {
        return n1find;
    }
    public boolean isN2find() {
        return n2find;
    }

    
    synchronized public void setN1find() {
        this.n1find = true;
    }
     synchronized public void setN2find() {
        this.n2find = true;
    }

     
    synchronized public Semaphore getsEstrai() {
        return sEstrai;
    }
    synchronized public Semaphore getsControlla() {
        return sControlla;
    }

    synchronized public Semaphore getNextRound() {
        return nextRound;
    }
    
    public String Vect() {

        String s = "[" + v[0].toString() + ", "+ v[1].toString() + ", "+ v[2].toString() + ", "+ v[3].toString() + ", "+ v[4].toString() + "]";
        return s;
    }
    
    public void reset(){
        n1find = false;
        n2find = false;
              
    }

    synchronized public void setV(Integer[] v) {
        this.v = v;
    }

    public Semaphore getPrint() {
        return Print;
    }
    
    


}