public abstract class Atleti extends Sportisti{
    private int nrMedaljeve;
    
    public Atleti(int id, String e, int m, char g, int nM) throws SportistiException{
        super(id, e, m, g);
        if(nM < 0){
            throw new SportistiException("Numri i medaljeve te Atletit gabim!");
        }
        nrMedaljeve = nM;
    }
    
    public abstract boolean garonIndividualisht();
    
    public int getNrMedaljeve(){
        return nrMedaljeve;
    }
    public void setNrMedaljeve(int nM) throws SportistiException{
        if(nM < 0){
            throw new SportistiException("Numri i medaljeve te Atletit gabim!");
        }
        nrMedaljeve = nM;
    }
    
    public String toString(){
        return super.toString() + " me " + nrMedaljeve + " medalje";
    }
}
