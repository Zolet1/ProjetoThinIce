package thinIceView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Klistener implements KeyListener{
	private Subject subject;
	
	public Klistener(Subject a) {
		subject = a;
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		subject.comando(e.getKeyCode());
		//System.out.println(e.getKeyCode());
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
