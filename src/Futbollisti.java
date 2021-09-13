public class Futbollisti extends Sportisti implements Rekuizita{
    private int numri;
    
    public Futbollisti(int id, String e, int m, char g, int nr) throws SportistiException{
        super(id, e, m, g);
        if(nr < 1){
            throw new SportistiException("Numri i Futbollistit gabim!");
        }
        numri = nr;
    }
    
    public String getRekuizita(){
        return "Top";
    }
    
    public boolean garonIndividualisht(){
        return false;
    }
    
    public int getNumri(){
        return numri;
    }
    
    public void setNumri(int nr) throws SportistiException{
        if(nr < 1){
            throw new SportistiException("Numri i Futbollistit gabim!");
        }
        numri = nr;
    }
    
    public String toString(){
        return "Futbollisti: " + super.toString() + " - nr: " + numri;
    }
}
