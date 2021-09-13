public abstract class Sportisti {
    private int id;
    private String emri;
    private int mosha;
    private char gjinia;
    
    public Sportisti(int id, String e, int m, char g) throws SportistiException{
        if(id < 0){
            throw new SportistiException("ID e sportistit gabim!");
        }
        if(e == null || e.trim().isEmpty()){
            throw new SportistiException("Emri i Sportistit gabim!");
        }
        if(m < 1){
            throw new SportistiException("Mosha e Sportistit gabim!");
        }
        if(g != 'M' && g != 'F'){
            throw new SportistiException("Gjinia e Sportistit gabim!");
        }
        this.id = id;
        emri = e;
        mosha = m;
        gjinia = g;
    }
    
    public int getId(){
        return id;
    }
    public String getEmri(){
        return emri;
    }
    public int getMosha(){
        return mosha;
    }
    public char getGjinia(){
        return gjinia;
    }
    
    public void setEmri(String e) throws SportistiException{
        if(e == null || e.trim().isEmpty()){
            throw new SportistiException("Emri i Sportistit null!");
        }
        emri = e;
    }
    
    public void setMosha(int m) throws SportistiException{
        if(m < 1){
            throw new SportistiException("Mosha e Sportistit gabim!");
        }
        mosha = m;
    }
    
    public void setGjinia(char g) throws SportistiException{
        if(g != 'M' && g != 'F'){
            throw new SportistiException("Gjinia e Sportistit gabim!");
        }
        gjinia = g;
    }
    
    public abstract boolean garonIndividualisht();
    
    public String toString(){
        return id + " : " + emri + " " + ((gjinia == 'M')?"Mashkull":"Femer") + " " + mosha + " vjeq";
    }
    
    public boolean equals(Object o){
        if(o instanceof Sportisti){
            Sportisti s = (Sportisti)o;
            if(s.getId() == id){
                return true;
            }
        }
        return false;
    }
}
