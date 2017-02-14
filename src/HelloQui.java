
public class HelloQui {
	public static void main(String[] args){
		Qui qui = new Qui();
		qui.setNom("Aubert");
		qui.setPrenom("Jean-Luc");
		
		qui.presenteToi();
		
		QuiNew toi = new QuiNew();
		toi.nom("Durant").prenom("Paul");
		toi.presenteToi();
	}
}
