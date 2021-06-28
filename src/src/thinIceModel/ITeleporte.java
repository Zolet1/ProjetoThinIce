package thinIceModel;

import java.util.ArrayList;

public interface ITeleporte extends ISala {
	
	public void conecta(ITeleporte B);
	
	public String posiciona(int Xp, int Yp , ILabirinto labirinto);
	
	public ArrayList<String>  Teleporta(IPuffle puffle);
	
	public ArrayList<String> fechaTeleporte();

}
