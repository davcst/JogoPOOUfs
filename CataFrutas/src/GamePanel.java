import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;


public class GamePanel extends JPanel  implements Runnable{ //implements ActionListener
	
	static final int UNIT_SIZE = 16; //16x16 pois é o tamanho usado para bonecos em jogos 32bits
	static final int SCALE = 3; //multiplica o tamanho por 3 (para ficar visível nos monitores modernos)
	static final int REAL_SIZE = UNIT_SIZE*SCALE;
	static final int DELAY = 75;
	static final int MAX_HORIZONTAL = 20;
	static final int MAX_VERTICAL = 15;
	static final int SCREEN_LARGURA = REAL_SIZE*MAX_HORIZONTAL;//960p
	static final int SCREEN_ALTURA = REAL_SIZE*MAX_VERTICAL;//720p
	static final int GAME_UNITS = (SCREEN_LARGURA * SCREEN_ALTURA)/UNIT_SIZE;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
//	int frutaX;
//	int frutaY;
//	//Timer timer;  //poderá ser usado para estabelecer um tempo por turno
//	Random random;//randomizar a posição do maracujá
	Thread gameThread; //uma vez que o programa abra, o thread é responsável por gerar o loop que permanece ele rodando
	KeyHandler keyH = new KeyHandler(this);
	public UI ui = new UI(this);
	int FPS = 30;
	
	//Estado do jogo
	public int gameState;
	public final int titleState = 0;
	public final int mapState = 1;

	
	public GamePanel() {
	    this.setPreferredSize(new Dimension(SCREEN_LARGURA, SCREEN_ALTURA));
	    this.setBackground(Color.white);
	    this.setDoubleBuffered(true);
	    this.setFocusable(true);
	    KeyHandler keyHandler = new KeyHandler(this);
	    this.addKeyListener(keyHandler);
	    setupGame();
	}
	
	public void setupGame() {
		gameState = titleState;
	}
	
	public void comecarJogoThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() { 
		//void responsável por atualizar o jogo, utiliza o tempo atual do sistema para determinar o tempo em que o computador executará o loop
		//código não autoral, utilizado apenas para possivelmente animar o terreno, as árvores e os personagens

		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
						
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
				//responsável por atualizar as informações, como posição, frutas, mochila
				update();
				//desenha as novas posições dos objetos
				repaint();
				delta--;
			}
				
		}
	}
	
	public void update() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
//		g2.setColor(Color.green);
//		g2.fillRect(380, 360, SCREEN_WIDTH/4, SCREEN_HEIGHT/6);
//		g2.dispose();
		
		//Menu inicial
		if(gameState == titleState) {
			ui.draw(g2);
		}
//		esse else servirá para rodar o jogo, pois caso o estado do jogo não seja o do menu inicial, o jogo estará rodando
//		else {
//			
//		}
		
	}
	
	public void menuIniciar() {
		
	}

	
	
	public void draw(Graphics g) {
		
	}
	
	public void novaFruta() {
		
	}
	
	public void move() {
		
	}
	
	public void fimDeJogo() {
		
	}



		
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public class MyKeyAdapter extends KeyAdapter {
//		@Override
//		public void keyPressed(KeyEvent e) {
//			
//		}
//	}

}