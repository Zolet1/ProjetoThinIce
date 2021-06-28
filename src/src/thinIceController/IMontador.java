package thinIceController;

import thinIceModel.ILabirinto;
import thinIceModel.IPuffle;

public interface IMontador {
	
	public void criaMapa();
	
	public boolean montaMapa(String[][] posicoes, IPuffle puffle)throws NullPointerException;
	
	public void connect(ILabirinto l);
	
}
