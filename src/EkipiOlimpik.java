
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class EkipiOlimpik {

    private String emri;
    private Hashtable<Integer, Sportisti> sportistet;

    public EkipiOlimpik(String e) throws SportistiException {
        if (e == null || e.trim().isEmpty()) {
            throw new SportistiException("Emri i Ekipit null!");
        }
        emri = e;
        sportistet = new Hashtable<>();
    }

    public void shtoSportistin(Sportisti s) throws SportistiException {
        if (s == null) {
            throw new SportistiException("Sportisti i pa-inicializuar.");
        }
        if (sportistet.containsKey(s.getId())) {
            throw new SportistiException("Sportisti ekziston!");
        }
        sportistet.put(s.getId(), s);
    }

    public List<Vrapuesi> ktheSipasDistances(int distanca) throws SportistiException {
        if (distanca < 0) {
            throw new SportistiException("Distanca e dhene eshte gabim!");
        }

        List<Vrapuesi> lista = new ArrayList<>();
        for (Integer key : sportistet.keySet()) {
            Sportisti s = sportistet.get(key);
            if (s instanceof Vrapuesi) {
                Vrapuesi v = (Vrapuesi) s;
                if (v.getDistanca() == distanca) {
                    lista.add(v);
                }
            }
        }

        if (lista.isEmpty()) {
            System.out.println("Ska asnje Vrapues te kesaj distance!");
            return null;
        }

        return lista;
    }
    
    //Metod qe ska qene kerkese, dmth sipas deshires
    public List<Sportisti> ktheSportistet(String rekuizita) throws SportistiException{        
        List<Sportisti> lista = new ArrayList<>();
        for(Integer key: sportistet.keySet()){
            Sportisti s = sportistet.get(key);
            if(s instanceof Futbollisti){
                Futbollisti f = (Futbollisti)s;
                if(f.getRekuizita().equals(rekuizita)){
                    lista.add(f);
                }
            }
        }
        if(lista.isEmpty()){
            System.out.println("Ska asnje Sportist me rekuizite te tille!");
        }
        return lista;
    }

    public void shtypIndividualet(boolean individual) throws SportistiException {
        if (sportistet.isEmpty()) {
            throw new SportistiException("Ska sportiste ne Tabele.");
        }
        for (Integer key : sportistet.keySet()) {
            Sportisti s = sportistet.get(key);
            if (s.garonIndividualisht() == individual) {
                System.out.println(s);
            }
        }
    }

    public static void main(String args[]) throws SportistiException {
        try {
            EkipiOlimpik eK = new EkipiOlimpik("Kosova Team");
            Futbollisti f1 = new Futbollisti(1, "Filan", 19, 'M', 1);
            Futbollisti f2 = new Futbollisti(2, "Filan1", 21, 'M', 2);
            Futbollisti f3 = new Futbollisti(3, "Fistek", 22, 'M', 3);
            Futbollisti f4 = new Futbollisti(7, "Fisteke", 19, 'F', 7);
            Karateisti k1 = new Karateisti(4, "Filan", 24, 'M', "Isshin-Ryu");
            Karateisti k2 = new Karateisti(5, "Filane", 25, 'F', "Shito-Ryu");
            Karateisti k3 = new Karateisti(6, "Filane", 26, 'F', "Shotokan");
            eK.shtoSportistin(new Vrapuesi(8, "Filane Fisteku", 22, 'F', 3, 150));
            eK.shtoSportistin(new Vrapuesi(9, "Fisteke Fisteku", 22, 'F', 3, 160));
            eK.shtoSportistin(new Vrapuesi(10, "Filan Filani", 27, 'M', 3, 130));
            eK.shtoSportistin(new Vrapuesi(11, "Fistek Filani", 20, 'M', 3, 150));
            eK.shtoSportistin(f1);
            eK.shtoSportistin(f2);
            eK.shtoSportistin(f3);
            eK.shtoSportistin(f4);
            eK.shtoSportistin(k1);
            eK.shtoSportistin(k2);
            eK.shtoSportistin(k3);

            boolean ind = true;
            System.out.println("Sportistet " + (ind ? "" : "jo ") + "individualiste: ");
            eK.shtypIndividualet(ind);

            System.out.println();
            System.out.println("Vrapuesit me distancen: 150m");
            List<Vrapuesi> vrapuesit = eK.ktheSipasDistances(150);
            for (Vrapuesi v : vrapuesit) {
                System.out.println(v);
            }
            
            System.out.println();
            
            List<Sportisti> sportistet = eK.ktheSportistet("Top");
            for(Sportisti s: sportistet){
                System.out.println(s);
            }
        } catch (SportistiException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
