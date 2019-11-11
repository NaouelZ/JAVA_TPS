import java.util.*;

public class Bataille {
	public static void main(String[ ] args) {
		List<Carte> paquetDeCartes  =  new ArrayList<Carte>();
		ArrayList<Carte> paquet1 = new ArrayList<Carte>();
		ArrayList<Carte> paquet2= new ArrayList<Carte>();
		boolean jouer = true;

		//Création du paquet de cartes
     	 for (int v=0; v <13; v++) {
       		 for (int c =0; c <4; c++) {	 
       			 paquetDeCartes.add(new Carte(v,c));
       		 }
       	 }
		Collections.shuffle(paquetDeCartes);
      
        //Création du paquet pour le joueur 1
        for (int i = 0; i<26; i++) {
        	paquet1.add(paquetDeCartes.get(i));
        }
        
        //Création du paquet pour le joueur 2
        for (int j = 26; j<52; j++) {
        	paquet2.add(paquetDeCartes.get(j));
        }
		Joueur j1 = new Joueur("Joueur 1", paquet1);
		Joueur j2 = new Joueur("Joueur 2", paquet2);
		
		System.out.println(String.format("%-16s %-16s %-16s\n", j1.pseudo,j2.pseudo,"GAGNANT"));
		 while(jouer) {
			if(j1.paquet.size() == 27  ) {
				System.out.println("Le " + j1.pseudo + " a gagné");
				jouer = false;
				break  ;
			}
			if(j2.paquet.size() == 27) {
				System.out.println("Le " + j2.pseudo + " a gagné");
				jouer = false;
			    break  ;
			}
			Carte Carte1 = j1.tirerUneCarte();
			Carte Carte2 = j2.tirerUneCarte();			
			if(Carte1.getIndex() > Carte2.getIndex()) {
				j1.ajouterUneCarte(Carte1);
				j1.ajouterUneCarte(Carte2);
				System.out.println(String.format("%-16s %-16s %-16s\n", Carte1.infoCarte(), Carte2.infoCarte(), j1.pseudo));
			}
			else if(Carte1.getIndex() < Carte2.getIndex()) {
				System.out.println(String.format("%-16s %-16s %-16s\n", Carte1.infoCarte(),  Carte2.infoCarte(), j2.pseudo));
				j2.ajouterUneCarte(Carte1);
				j2.ajouterUneCarte(Carte2);
			}
			else if(Carte2.getIndex()  == Carte1.getIndex()){
				System.out.println(String.format("%-16s %-16s %-16s\n",Carte1.infoCarte(), Carte2.infoCarte(),"BATAILLE")); 
                System.out.println(String.format("%-16s %-16s %-16s\n","*********","BATAILLE","*******")); 
                
                	if(j1.paquet.size() < 2) {
                		System.out.println("Le joueur 2 a gagne ! " + j1.pseudo + " n'a plus assez de carte pour continuer");
                		jouer = false;
                		break  ;
                	}	
                	if(j2.paquet.size() < 2) {
                		System.out.println("Le joueur 1  a gagne ! " + j2.pseudo + " n'a plus assez de carte pour continuer");
                		jouer = false;
                		break  ;
                	}
                ArrayList<Carte> bataille = new ArrayList<>(Arrays.asList(Carte1, Carte2, j1.tirerUneCarte(), j2.tirerUneCarte()));
                Carte Bat1 = j1.tirerUneCarte(); 
                Carte Bat2 = j2.tirerUneCarte(); 
                
                    if(Bat1.getIndex() > Bat2.getIndex()){
                        j1.paquet.addAll(bataille); 
                        j1.ajouterUneCarte(Bat1);
                        j1.ajouterUneCarte(Bat2);
                        System.out.println(String.format("%-16s %-16s %-16s\n", Bat1.infoCarte() ,  Bat2.infoCarte(), j1.pseudo));
                    }
                    else if(Bat1.getIndex() < Bat2.getIndex() ){
                        j2.paquet.addAll(bataille); 
                        j2.ajouterUneCarte(Bat1);
                        j2.ajouterUneCarte(Bat2);
                        System.out.println(String.format("%-16s %-16s %-16s\n", Bat1.infoCarte() ,  Bat2.infoCarte(), j2.pseudo));
                    } 
                    else {
                        System.out.println(String.format("%-16s %-16s %-16s\n", Bat1.infoCarte() ,  Bat2.infoCarte(), "EGAUX"));
                        j1.ajouterUneCarte(bataille.get(0));
                        j2.ajouterUneCarte(bataille.get(1));
                        j1.ajouterUneCarte(bataille.get(2));
                        j2.ajouterUneCarte(bataille.get(3));
                        j1.ajouterUneCarte(Bat1);
                        j2.ajouterUneCarte(Bat2);
                    }     
                System.out.println("*******************************************");  
			}
		}
	}
}
