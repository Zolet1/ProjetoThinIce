package thinIceModel;

import java.util.ArrayList;

public class Teleporte implements ITeleporte {
	private ArrayList<IEntidade> entidadesNaSala = new ArrayList<IEntidade>();
	private ITeleporte B;
	private int aberto = 1;
	int Xt,Yt;
	
	public Teleporte() {
		
	}
	public ArrayList<String> fechaTeleporte() {
		this.aberto = 0;
		return oquePrintar();
	}
	public void conecta(ITeleporte B) {
		this.B = B;
	}
	public String posiciona(int Xp, int Yp , ILabirinto labirinto) {
		Xt = Xp;
		Yt = Yp;
		return labirinto.posiciona(Xp,Yp,this);
	}
	
	public ArrayList<String>  posiciona(IPuffle puffle) {
		if(aberto==1) {
		return B.Teleporta(puffle);
		}
		return null;
	}
	public ArrayList<String>  posiciona(IEntidade entidade) { //falta fazer
		return null;
		
	}
	
	public ArrayList<String>  Teleporta(IPuffle puffle) {
		entidadesNaSala.add(puffle);
		return oquePrintar();
	}
	public ArrayList<String> oquePrintar(){
		ArrayList<String> oquePrintar = new ArrayList<String>();
		if( aberto==0 ) {
			oquePrintar.add("F");
			oquePrintar.add(""+Xt);
			oquePrintar.add(""+Yt);
			oquePrintar.add("F");
		}
		else if(entidadesNaSala.isEmpty() == false) {
			oquePrintar.add("T");
			oquePrintar.add(""+Xt);
			oquePrintar.add(""+Yt);
			oquePrintar.add(entidadesNaSala.get(0).getType());
			
		}
		return oquePrintar;
	}
	
	public ArrayList<String> desposiciona(IEntidade entidade) {
		for(int i=0;i<entidadesNaSala.size(); i++) {
			if(entidadesNaSala.get(i).getType().equals(entidade.getType())) {
				entidadesNaSala.remove(i);
				if(entidade.getType().equals("P")) {
					this.fechaTeleporte();
					return B.fechaTeleporte();
				}
			}
		}
		return oquePrintar();
	}
	
	public boolean derretidaOuOcupada(boolean chave) {
		if((entidadesNaSala.isEmpty()==false && entidadesNaSala.get(0).getType().equals("B")) || aberto == 0) {
			return true;
		}
		return false;
	}
	public int getDerretida() {
		return 0;
	}
	
	
}
