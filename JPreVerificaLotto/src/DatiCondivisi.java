/**
 *
 * @author Simone Mauri
 */
public class DatiCondivisi {
    
    private Integer[] v;
    private Integer N1,N2;
    private boolean n1find,n2find;
    
    
    public DatiCondivisi(Integer n1,Integer n2) {
        this.v = new Integer[5];
        N1 = n1;
        N2 = n2;
        n1find = false;
        n2find = false;
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

    synchronized public void setN1find(boolean n1find) {
        this.n1find = n1find;
    }

    synchronized public void setN2find(boolean n2find) {
        this.n2find = n2find;
    }
    
    
    
}
