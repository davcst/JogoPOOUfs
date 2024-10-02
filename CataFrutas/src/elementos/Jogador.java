/**
 * 
 */
package elementos;

import elementos.frutas.*;

/**
 * 
 */
public class Jogador {
	private int pontos;
	private int pontosMovimento;
	private int força;
	private int[] posicao;
	private boolean sobArvore;
	private Mochila mochila;
	/**
	 * 
	 */
	public Jogador(int capacidadeMochila) {
		mochila = new Mochila(capacidadeMochila);
	}
	public void comerFruta(Fruta fruta) {
		System.out.println("nom nom nom nom nom");
	}
}
