import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappingTask implements Runnable{
	/*
	 Pour retourner le résultat des tâches (tasks).
	 task : contient les instructions et les retours.
	 thread : un constructeur qui dirige le set d'instructions indépendamment.
	 */

	List<String> texte = new ArrayList<>();
	Map<String, Integer> mappedTxt = new HashMap<>();

	// Ce booléen va être vu et modifié par plusieurs threads, cela explique le caractère volatile de la variable
	private volatile boolean done = false; 


	public MappingTask(List<String> texte) {
		this.texte = texte;
	}

	@Override
	public void run() {

		System.out.println("début thread");


		try {
			mappedTxt = MapFunction.mapGenerator(texte);
		} catch (IOException e) {
			e.printStackTrace();
		}


		System.out.println("fin thread");

		done = true; // ce qui atteste que le thread est terminé

		synchronized(this) {
			// quand le thread est fini, on réveille le thread en attente (**)
			this.notifyAll();
		}

	}


	public  Map<String, Integer> getMappedText() {

		/* pour savoir si notre thread a fini de s'éxecuter avant de renvoyer le résultat,
		si le thread a fini on return le résultat, sinon on attend qu'il finisse.
		*/
		while (!done) {
			// Pour protéger l'accès à notre objet Task on applique un synchronize sur les blocs wait et notify  
			synchronized(this){ 
				try {
					 // le thread attend
					this.wait();

				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
// (**) thread se réveille ici 
		}
		return mappedTxt;	
	}


}
