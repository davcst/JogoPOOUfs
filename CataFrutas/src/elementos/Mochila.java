package elementos;
import elementos.frutas.*;

public class Mochila {
	private Fruta frutas[];
	public Mochila(int capacidadeMochila) {
		frutas = new Fruta[capacidadeMochila];
	}
	
	public Fruta[] getFrutas() {
		return this.frutas;
	}
}
