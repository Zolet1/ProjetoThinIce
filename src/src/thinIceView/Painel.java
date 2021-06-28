package thinIceView;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;


public class Painel extends JPanel {
	private static final long serialVersionUID = -5374355313780414837L;
	private MiniPainel[][] miniP;
	
	public Painel() {
		super();
		setPreferredSize(new Dimension(990,782));
		setLayout(new GridLayout(15,19,0,0));

		miniP = new MiniPainel[19][15];
		for (int y = 14; y>-1; y--) {
			for(int x = 0; x<19; x++) {
				miniP[x][y] = new MiniPainel();
				add(miniP[x][y]);
			}
		}
	}
	public void atualiza(int x, int y, String type) {
		switch(type) {
		case "P":
			miniP[x][y].setGroundImage("assets/puffle.png");
			break;
		case "B":
			miniP[x][y].setGroundImage("assets/bloquinho_zola.png");
			break;
		case "D":
			miniP[x][y].setGroundImage("assets/door.png");
			break;
		case "K":
			miniP[x][y].setGroundImage("assets/key.png");
			break;
		case "N":
			miniP[x][y].setGroundImage("assets/neve.png");
			break;
		case "T":
			miniP[x][y].setGroundImage("assets/bloquinho_zola_verde.png");
			break;
		case "E":
			miniP[x][y].setGroundImage("assets/exit.png");
			break;
		case " ":
			miniP[x][y].setGroundImage("assets/agua.png");
			break;
		
		case "-":
			miniP[x][y].setGroundImage("assets/chao.png");
			break;
		case "F":
			miniP[x][y].setGroundImage("assets/Fechado.png");
			break;
		}
		
	}

}