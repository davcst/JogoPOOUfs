package elementos.arvores;

public abstract class Arvore {
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
