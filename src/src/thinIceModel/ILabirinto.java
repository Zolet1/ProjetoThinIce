package thinIceModel;

import java.util.ArrayList;

public interface ILabirinto {
	
	public void criaMapa();

	public String posiciona(int Xp, int Yp, IEntidade entidade);
	public String posiciona(int Xp, int Yp, IPuffle entidade);
	public String posiciona(int Xp, int Yp, Teleporte teleporte);
	
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IEntidade entidade);
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IPuffle entidade);
	
	public boolean verificaAfogamento(int Xp,int Yp, boolean chave);
	
	public int quantasDerretidas();
}
