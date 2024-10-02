import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public KeyHandler(GamePanel gp) {
        this.gp = gp; // Inicializa o GamePanel
    }
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		//config no menu
		if(gp.gameState == gp.titleState) {
			if(gp.ui.tituloState == 0) {
				
				if(tecla == KeyEvent.VK_W) {
					gp.ui.numeroComando--;
					if(gp.ui.numeroComando < 0) {
						gp.ui.numeroComando = 3;
					}
				}
				if(tecla == KeyEvent.VK_S) {
					gp.ui.numeroComando++;
					if(gp.ui.numeroComando > 3) {
					gp.ui.numeroComando = 0;
					}
				}
				
				if(tecla == KeyEvent.VK_ENTER) {
					if(gp.ui.numeroComando == 0) {
						//gp.gameState = gp.gameStart; A SER IMPLEMENTADO
					}
				
					if(gp.ui.numeroComando == 1) {
						//gp.gameState = gp.gameContinue; A SER IMPLEMENTADO
					}
				
					if(gp.ui.numeroComando == 2) {
						gp.ui.tituloState = 2;
						//gp.gameState = gp.gameMap; A SER IMPLEMENTADO
					}
				
					if(gp.ui.numeroComando == 3) {
						System.exit(0);
					}
				}
			}
			
			if(gp.ui.tituloState == 2) {
				
				if(tecla == KeyEvent.VK_W) {
					gp.ui.numeroComando--;
					if(gp.ui.numeroComando < 0) {
						gp.ui.numeroComando = 3;
					}
				}
				if(tecla == KeyEvent.VK_S) {
					gp.ui.numeroComando++;
					if(gp.ui.numeroComando > 7) {
					gp.ui.numeroComando = 0;
					}
				}
				
				if(tecla == KeyEvent.VK_ENTER) {
					
					if(gp.ui.numeroComando == 7) {
						gp.ui.tituloState = 0;
					}
				}
			}
			
		
		}
		
//		if(tecla == KeyEvent.VK_W) {
//			upPressed = true;
//		}
//		if(tecla == KeyEvent.VK_S) {
//			downPressed = true;
//		}
//		if(tecla == KeyEvent.VK_A) {
//			leftPressed = true;
//		}
//		if(tecla == KeyEvent.VK_D) {
//			rightPressed = true;
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int tecla = e.getKeyCode();
		
		if(tecla == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(tecla == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(tecla == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(tecla == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}

}
