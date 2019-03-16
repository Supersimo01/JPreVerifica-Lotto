
import java.util.concurrent.Semaphore;

/**
 *
 * @author Simone Mauri
 */
public class DatiCondivisi {

    private Integer[] v;
    private Integer N1, N2;
    private boolean n1find, n2find;
    private Semaphore sEstrai, sControlla;
    private boolean estazEnd1, estazEnd2;  // serve per far capire al main quando è finita l'estrazione

    public DatiCondivisi(Integer n1, Integer n2) {
        this.v = new Integer[5];
        N1 = n1;
        N2 = n2;
        n1find = false;
        n2find = false;
        estazEnd1 = false;
        estazEnd2 = false;
        sEstrai = new Semaphore(2); //doppio semaforo
        sControlla = new Semaphore(0);
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
    
    
    public boolean isEstazEnd1() {
        return estazEnd1;
    }
    public boolean isEstazEnd2() {
        return estazEnd2;
    }

    
    synchronized public void estrazEnded1() {
        this.estazEnd1 = true;
    }
    synchronized public void estrazEnded2() {
        this.estazEnd2 = true;
    }

    
    public String Vect() {

        String s = "[" + v[0].toString() + ", "+ v[1].toString() + ", "+ v[2].toString() + ", "+ v[3].toString() + ", "+ v[4].toString() + "]";
        return s;
    }
    
    public void reset(){
        estazEnd1 = false;
        estazEnd2 = false;
        n1find = false;
        n2find = false;
              
    }

    synchronized public void setV(Integer[] v) {
        this.v = v;
    }
    
    


}