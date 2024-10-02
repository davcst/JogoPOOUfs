import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		GamePanel gamePanel = new GamePanel();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(gamePanel);
		window.setTitle("Cata Frutas");
		window.setResizable(false);
		window.setVisible(true);
		window.pack(); //insere todos os componentes do frame
		window.setLocationRelativeTo(null); //o jogo começa no meio da tela sempre
		
		gamePanel.comecarJogoThread();
		

	}

}