package thinIceModel;

import java.util.ArrayList;

public class Puffle extends Entidade implements IPuffle{
	private boolean chave = false;

	public Puffle() {
		super();
		Type = "P";
	}
	
	public String posiciona(int Xp, int Yp , ILabirinto labirinto) {
		this.Xp = Xp;
		this.Yp = Yp;
		this.labirinto = labirinto;
		return labirinto.posiciona(Xp, Yp, this);	
	}
	
	public void pegaChave() {
		chave = true;
	}
	
	public boolean getChave() {
		return chave;
	}
	public int quantasDerretidas() {
		return labirinto.quantasDerretidas();
	}
	
	public ArrayList<String> movimenta(int c) {
		ArrayList<String> atualizacao =null;
		int index=0;
		switch(c){
		
		case 87://"w":
			atualizacao = labirinto.rePosiciona(Xp, Yp, Xp, Yp+1, this);
			if(atualizacao!= null) {
				if(atualizacao.contains("P")) {
					index = atualizacao.indexOf("P");
				}
				else if (atualizacao.contains("W")) {
					index = atualizacao.indexOf("W");
				}
				Xp= Integer.parseInt(atualizacao.get(index-2));
				Yp= Integer.parseInt(atualizacao.get(index-1));
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					atualizacao.add("rip"); 
				}
				
			}
				break;
		case 65://"a":
			atualizacao = labirinto.rePosiciona(Xp, Yp, Xp-1, Yp, this);
			if(atualizacao!= null) {
				if(atualizacao.contains("P")) {
					index = atualizacao.indexOf("P");
				}
				else if (atualizacao.contains("W")) {
					index = atualizacao.indexOf("W");
				}
				Xp= Integer.parseInt(atualizacao.get(index-2));
				Yp= Integer.parseInt(atualizacao.get(index-1));
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					atualizacao.add("rip"); 
				}
			}
				break;
		case 83://"s":
			atualizacao = labirinto.rePosiciona(Xp, Yp, Xp, Yp-1, this);
			if(atualizacao!= null) {
				if(atualizacao.contains("P")) {
					index = atualizacao.indexOf("P");
				}
				else if (atualizacao.contains("W")) {
					index = atualizacao.indexOf("W");
				}
				Xp= Integer.parseInt(atualizacao.get(index-2));
				Yp= Integer.parseInt(atualizacao.get(index-1));
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					atualizacao.add("rip"); 
				}
			}
				break;
		case 68://"d":
			atualizacao = labirinto.rePosiciona(Xp, Yp, Xp+1, Yp, this);
			if(atualizacao!= null) {
				if(atualizacao.contains("P")) {
					index = atualizacao.indexOf("P");
				}
				else if (atualizacao.contains("W")) {
					index = atualizacao.indexOf("W");
				}
				Xp= Integer.parseInt(atualizacao.get(index-2));
				Yp= Integer.parseInt(atualizacao.get(index-1));
				if(labirinto.verificaAfogamento(Xp,Yp,chave)) {
					atualizacao.add("rip"); 
				}
			}
				break;
			
		}
		return atualizacao;
		
	}
}
