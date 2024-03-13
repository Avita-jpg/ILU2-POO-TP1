package histoire;
import villagegaulois.Etal;

public class ScenarioCasDegradé {
	public static  void main(String[] args) {
		Etal etal = new Etal();
		
//		etal.libererEtal();
//		System.out.println("Fin du test libererEtal");
		
		try {
			etal.acheterProduit(-1, null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println("Fin du test acheterProduit");
	}
}
