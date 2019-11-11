public class Carte {
	
	protected static String valeurs[] = { "2" ,"3" ,"4" ,"5" ,"6" ,"7" , "8", "9" ,"10" , "Valet", "Dame" , "Roi", "As"};
	protected static int vals[] = { 2 , 3 , 4, 5 ,6 ,7 ,8 ,9 ,10 , 11, 12 , 13, 14};
	protected static String couleurs[] = { "trefles", "coeurs", "carreaux", "piques"};
	protected int val;
	protected String valeur; 
	protected String couleur;
	protected Joueur Joueur;
	protected int index;
	
	public Carte(int v, int c) {
		val = vals[v];
		couleur = couleurs[c];
		index = v;
	}

	public int getVal() {
		return this.val;
	}
    public String getCouleur() {  
        return  this.couleur ;  
   }
	 public int getIndex() {
		 return this.index;
	 }
	 
	 public String infoCarte() {
		 return this.getVal() + " de " + this.getCouleur();
	 }
}