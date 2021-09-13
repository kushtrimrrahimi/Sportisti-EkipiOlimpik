public class Karateisti extends Sportisti{
    private String stili;
    public Karateisti(int id, String e, int m, char g, String s) throws SportistiException {
        super(id, e, m, g);
        if(s == null || s.trim().isEmpty()){
            throw new SportistiException("Stili i Karateistit null!");
        }
        stili = s;
    }
    
    public String getStili(){
        return stili;
    }
    
    public void setStili(String s) throws SportistiException{
        if(s == null || s.trim().isEmpty()){
            throw new SportistiException("Stili i Karateistit null!");
        }
        stili = s;
    }
    
    public boolean garonIndividualisht(){
        return true;
    }
    
    public String toString(){
        return "Karateisti me stil " + stili + " - " + super.toString();
    }
}
