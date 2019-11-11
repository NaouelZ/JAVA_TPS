import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FichierTxt extends Fichier{

	public FichierTxt(String chem) {
		super(chem, "txt");
	}
	
	public void lireLignes() throws IOException {
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new FileReader(this.getChemin()));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

	String line;
	while((line = reader.readLine()) != null) {
		System.out.println(line);
	}
	}
	
	public void lireLignesAlEnvers() throws IOException {
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new FileReader(this.getChemin()));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

	String line;
	ArrayList<String> alist=new ArrayList<String>();
	while((line = reader.readLine()) != null) {
		alist.add(line);
	}
	for(int i=alist.size()-1; i >= 0; i--) {
		System.out.println(alist.get(i));
	}
}
	
	public void lecturePalindromique() throws IOException{
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(this.getChemin()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line;
		ArrayList<String> tableauLettres = new ArrayList<String>();
		while((line = reader.readLine()) != null) {
			  char[] lettresLigne = line.toCharArray();
			  		for(int i = 0; i < lettresLigne.length; i++) {
			  			tableauLettres.add(Character.toString(lettresLigne[i]));
			  		}
			  tableauLettres.add("\n");
		}
		for(int i = tableauLettres.size()-1;  i >=0; i--) {
			System.out.print(tableauLettres.get(i));
		}
	}

	public void compareFichier() throws IOException {

		
	}

	public void compareFichiers(Fichier F) throws IOException {
		BufferedReader reader = null;
		BufferedReader reader2 = null;
		try {
			reader = new BufferedReader(new FileReader(this.getChemin()));
			reader2 = new BufferedReader(new FileReader(F.getChemin()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		String line2 = null; 
		int nbL = 1;
		while(((line = reader.readLine()) != null) && ((line2 = reader2.readLine())!= null)) {
			if(line.equals(line2)) {
				System.out.println("A la ligne "+ nbL + ", il n'y a aucune différence");
			}
			else {
				System.out.println("A la ligne "+ nbL + ", les fichiers sont différents : ");
				System.out.println("Fichier 1 : " + line);
				System.out.println("Fichier 2 : " + line2);
			}
			nbL++;
		}
		
	}
	
}
