import java.io.IOException;

public class lirefichier {
	public static void main(String[] args) throws IOException {
		Fichier f1 = new FichierTxt("test.txt"); 
		Fichier f2 = new FichierTxt("test2.txt"); 
		System.out.println("Lecture du fichier");
		f1.lireLignes();
		System.out.println(" ");
		System.out.println("Lecteur à l'envers");
		f1.lireLignesAlEnvers();
		System.out.println(" ");
		System.out.println("Lecture Palindromique");
		f1.lecturePalindromique();
		System.out.println();
		System.out.println();
		System.out.println("Comparateur de fichiers");
		f1.compareFichiers(f2);
	} 
}
