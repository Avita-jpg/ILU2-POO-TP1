package histoire;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ScenarioCasDegradé {
	public static  void main(String[] args) {
		Etal etal = new Etal();
		
//		etal.libererEtal();
//		System.out.println("Fin du test libererEtal");
		Gaulois gaulois = new Gaulois("wicho", 100);
		try {
			etal.acheterProduit(8, gaulois);
		} catch (IllegalArgumentException | IllegalStateException e) {
			e.printStackTrace();
		}
		System.out.println("Fin du test acheterProduit");
	}
}
