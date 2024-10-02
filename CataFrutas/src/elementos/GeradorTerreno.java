package elementos;
import java.lang.Math;
import elementos.solo.*;
public class GeradorTerreno {
	
	private int dimensao;
	private int pedras;
	private int maracujas[];
	private int laranjas[];
	private int abacates[];
	private int cocos[];
	private int acerolas[];
	private int amoras[];
	private int goiabas[];
	private int bichadas[];
	private int capacidadeMochila;
	
	public GeradorTerreno() {
	}
	public void setDimensao(int d) {
		this.dimensao = d;
		return;
	}
	public void setPedras(int p) {
		this.pedras = p;
		return;
	}
	
	public Terreno gerarTerreno() {
		Terreno t = new Terreno(this.dimensao);
		gerarPedras(this.pedras, t);
		gerarGrama(t);
		return t;
	}
	
	private void gerarPedras(int numPedras, Terreno terreno) {
		//TODO: Em alguns casos, ele tá colocando 9 pedras ao invés de 7. Verificar o motivo
		
		int pedrasRestantes = numPedras;
		// distribuir pedras com a mesma chance e ir passando pelo terreno até colocar todas
		float chancePedra = ((float)numPedras / (float)(this.dimensao * this.dimensao));
		while (pedrasRestantes > 0) {
			loopMatriz:
			for (int i = 0; i < dimensao; i++) {
				for (int j = 0; j < dimensao; j++) {
					if (Math.random() < chancePedra) {
						terreno.setCelula(i, j, new Pedra());
						pedrasRestantes--;
						if (pedrasRestantes == 0)
							break loopMatriz;
					}
				}
			}
		}
		return;
	}
	private void gerarGrama(Terreno terreno) {
		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				if (!(terreno.getCelula(i, j) instanceof Pedra)) {
					//Grama onde não há pedra
					terreno.setCelula(i, j, new Grama());
				}
			}
		}
		return;
	}
}
