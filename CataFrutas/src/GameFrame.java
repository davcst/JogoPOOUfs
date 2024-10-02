import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

	GameFrame(){
	
		this.add(new GamePanel());
		this.setTitle("Cata Frutas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack(); //insere todos os componentes do frame
		this.setVisible(true);
		this.setLocationRelativeTo(null); //o jogo começa no meio da tela sempre
		
	}


	
}
