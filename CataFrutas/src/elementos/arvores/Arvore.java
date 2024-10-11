package elementos.arvores;

/**
 * Classe mãe das árvores que serão postas no terreno do jogo
 * @author breno
 */
public abstract class Arvore {
	/**
	 * tempo (em rodadas) entre cada vez que a arvore vai poder dar uma fruta a um jogador abaixo dela
	 */
	private int cooldown;
	public Arvore() {
		// TODO Auto-generated constructor stub
		this.cooldown = 5;
	}
	abstract public void derrubarFruta();
	public int getCooldown() {
		return this.cooldown;
	}
	public void setCooldown(int num) {
		this.cooldown = num;
	}
}
