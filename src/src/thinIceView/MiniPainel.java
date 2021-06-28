package thinIceView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MiniPainel extends JPanel{
	private static final long serialVersionUID = -6775705603678808994L;
	//private static Image groundImage = Toolkit.getDefaultToolkit().getImage("/home/zolet/eclipse-workspace/dale/src/dale/pac01/bloquinhozola.png");
	private Image groundImage = Toolkit.getDefaultToolkit().getImage("/home/zolet/eclipse-workspace/ProjetoThinIce/src/thinIceView/chao.png");
	public MiniPainel() {
		super();
		setPreferredSize(new Dimension(52,52));
		setLayout(null);
	}
	public void setGroundImage(String caminho) {
		groundImage = Toolkit.getDefaultToolkit().getImage(caminho);
	}
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(groundImage, 0, 0, this);
    }

}

