package thinIceView;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Janela extends JFrame {
	private static final long serialVersionUID = 3591423627162855422L;
	private Painel painel;
	
	public Janela(Klistener KL) {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(990,782);
		setResizable(false);
		addKeyListener(KL);
		
		painel = new Painel();
		add(painel);
		
		setVisible(true);
		
	}
	public Janela(boolean s,int p) {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,80);
		JPanel panel = new JPanel();
		add(panel);
		if(s) {
			panel.add(new JButton("O Puffle saiu do labirinto! Numero de casas derretidas: "+p));
		}
		else {
			panel.add(new JButton("O Puffle se afogou! GAME OVER"));
		}
		setVisible(true);
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void atualiza(int x, int y, String type) {
		painel.atualiza(x, y, type);
		SwingUtilities.updateComponentTreeUI(this);
	}
}
