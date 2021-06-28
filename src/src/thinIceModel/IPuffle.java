package thinIceModel;

import java.util.ArrayList;

public interface IPuffle extends IEntidade{

	public ArrayList<String> movimenta(int c);
	
	public void pegaChave();
	
	public boolean getChave();
	
	public int quantasDerretidas();
	
}
