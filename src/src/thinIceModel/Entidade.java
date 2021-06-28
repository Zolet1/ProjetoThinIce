package thinIceModel;

public abstract class Entidade implements IEntidade {
	protected int Xp;
	protected int Yp;
	protected ILabirinto labirinto;
	protected String Type;
	
	public String posiciona(int Xp, int Yp , ILabirinto labirinto) {
		this.Xp = Xp;
		this.Yp = Yp;
		this.labirinto = labirinto;
		return labirinto.posiciona(Xp, Yp, this);	
	}
	
	public void rePosiciona(int Xi, int Yi,int Xf,int Yf) {
		labirinto.rePosiciona(Xi, Yi, Xf, Yf, this);
	}
	
	public String getType() {
		return this.Type;
	}
}
