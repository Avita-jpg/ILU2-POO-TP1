package histoire;
import villagegaulois.Etal;

public class ScenarioCasDegradé {
	public static  void main(String[] args) {
		Etal etal = new Etal();
		
//		etal.libererEtal();
//		System.out.println("Fin du test libererEtal");
		
		etal.acheterProduit(8, null);
		System.out.println("Fin du test acheterProduit");
	}
}
