import java.util.ArrayList;

public class Joueur{
	protected int compteurPoints;
	protected String pseudo;
	protected ArrayList<Carte> paquet = new ArrayList<Carte>();

    public Joueur(String p, ArrayList<Carte> pa) {
    	pseudo = p;
        paquet = pa;
    }
    
	public Carte tirerUneCarte() {
		Carte C = paquet.get(0);
		paquet.remove(paquet.get(0));
		return  C;
	}
	
	public void ajouterUneCarte(Carte Gagnante) {
		paquet.add(Gagnante);
	}

}
