public class Vrapuesi extends Atleti{
    private int distanca;
    
    public Vrapuesi(int id, String e, int m, char g, int nM, int d) throws SportistiException{
        super(id, e, m, g, nM);
        if(d < 0){
            throw new SportistiException("Distanca e Vrapuesit gabim!");
        }
        distanca = d;
    }
    
    public boolean garonIndividualisht(){
        return true;
    }
    
    public int getDistanca(){
        return distanca;
    }
    public void setDistanca(int d) throws SportistiException{
        if(d < 0){
            throw new SportistiException("Distanca e Vrapuesit gabim!");
        }
        distanca = d;
    }
    
    public String toString(){
        return "Vrapuesi i distances " + distanca + "m - " + super.toString();
    }
}
