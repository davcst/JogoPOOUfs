import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	
	static final int UNIT_SIZE = 16; //16x16 pois é o tamanho usado para bonecos em jogos 32bits
	static final int SCALE = 3; //multiplica o tamanho por 3 (para ficar visível nos monitores modernos)
	static final int REAL_SIZE = UNIT_SIZE*SCALE;
	static final int DELAY = 75;
	static final int MAX_HORIZONTAL = 20;
	static final int MAX_VERTICAL = 15;
	static final int SCREEN_WIDTH = REAL_SIZE*MAX_HORIZONTAL;//960p
	static final int SCREEN_HEIGHT = REAL_SIZE*MAX_VERTICAL;//720p
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int frutaX;
	int frutaY;
	Timer timer;  //será usado para estabelecer um tempo por turno
	Random random;//randomizar a posição do maracujá
	
	GamePanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);//reduz flickering e deixa a animação mais suave
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		menuIniciar();
		
	}
	
	public void menuIniciar() {
		
	}

	public void comecarJogo() {
		novaFruta();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void novaFruta() {
		
	}
	
	public void move() {
		
	}
	
	public void fimDeJogo() {
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}

}
