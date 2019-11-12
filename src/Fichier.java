import java.io.IOException;

public abstract class Fichier implements Fichiertype {

		private String chemin, extension ;
	
		public Fichier(String c, String e) {
			super();
			this.chemin = c ;
			this.setExtension(e);
		}

		public String getChemin() {
			return chemin;
		}

		public void setChemin(String chemin) {
			this.chemin = chemin;
		}

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}
		
		public abstract void lireLignes() throws IOException;
		 
		public abstract void lireLignesAlEnvers() throws IOException;
		
		public abstract void lecturePalindromique() throws IOException;
		
		public abstract void compareFichiers(Fichier F) throws IOException;
}
