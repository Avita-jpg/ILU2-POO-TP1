package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtals);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	private static class Marche {
		private Etal[] etals;
		private int nbEtals;
		
		private Marche(int nbEtals) {
			this.nbEtals = nbEtals;
			etals = new Etal[nbEtals];
			for (int i = 0; i < nbEtals; i++) {
				etals[i] = new Etal();
			}
		}
		
		private void utiliserEtal (int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}
		
		private int trouverEtalLibre() {
			for (int i = 0; i < nbEtals; i++) {
				if (!etals[i].isEtalOccupe()) {
					return i;
				}
			}
			return -1;
		}
		
		private Etal[] trouverEtals(String produit) {
			int nbEtalsProduit = 0;
			for (int i = 0; i < nbEtals; i++) {
				if (etals[i].contientProduit(produit)) {
					nbEtalsProduit++;
				}
			}
			
			Etal[] etalsProduit = new Etal[nbEtalsProduit];
			for (int i = 0; i < nbEtals; i++) {
				if (etals[i].contientProduit(produit)) {
					etalsProduit[i] = etals[i];
				}
			}
			
			return etalsProduit;
		}
		
		 private Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0; i < nbEtals; i++) {
				if (etals[i].getVendeur().equals(gaulois)) {
					return etals[i];
				}
			}
			return null;
		}
		 
		private String afficherMarche() {
			StringBuilder chaineMarche = new StringBuilder();
			for (int i = 0; i < nbEtals; i++) {
				chaineMarche.append(etals[i].afficherEtal());
			}
			int nbEtalVide = 0;
			for (int i = 0; i < nbEtals; i++) {
				if (!etals[i].isEtalOccupe()) {
					nbEtalVide++;
				}
			}
			if (nbEtalVide > 0) {
				chaineMarche.append("Il reste " + nbEtalVide + "étals non utilisés dans le marché.\n");
			}
			
			return chaineMarche.toString();
		}		
		
	}
	
	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
		if (marche.trouverVendeur(vendeur) == null) {
			// le vendeur n'est pas dans le marché alors il peut s'installer
			
			StringBuilder chaine  = new StringBuilder(vendeur + "cherche un endroit pour vendre "+ nbProduit +" "+ produit+".\n");
			int indiceEtal = marche.trouverEtalLibre();
			marche.utiliserEtal(indiceEtal, vendeur, produit, nbProduit);
			chaine.append("Le vendeur " + vendeur + " vend des " + produit + " à l'étal n°"+ indiceEtal+".\n");
			
			return chaine.toString();
		}
		// si le vendeur est déjà dans le marché rien ne se passe
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}