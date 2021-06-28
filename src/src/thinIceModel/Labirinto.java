package thinIceModel;

import java.util.ArrayList;

public class Labirinto implements ILabirinto {
	private ISala salas[][];
	
	public Labirinto() {
		
	}
	
	public void criaMapa() {
		salas = new ISala[19][15];
		for(int x=0; x<19; x++) {
			for(int y=0; y<15 ; y++) {
				salas[x][y] = new Sala();
			}
		}
	}
	
	public String posiciona(int Xp, int Yp, IEntidade entidade) {
		return salas[Xp][Yp].posiciona(entidade).get(0);
	}
	public String posiciona(int Xp, int Yp, IPuffle puffle) {
		return salas[Xp][Yp].posiciona(puffle).get(0);
	}
	public String posiciona(int Xp, int Yp, Teleporte teleporte) {
		salas[Xp][Yp] = teleporte;
		return "T";
	}
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IEntidade entidade) {
		ArrayList<String> atualizacao = new ArrayList<String>();
		ArrayList<String> aux,aux2;
		atualizacao.add(""+Xi);
		atualizacao.add(""+Yi);
		aux = salas[Xf][Yf].posiciona(entidade);
		if(aux != null) {
			aux2 = salas[Xi][Yi].desposiciona(entidade);
			for(int i = 0; i<aux2.size(); i++) {
				atualizacao.add(aux2.get(i));
			}
			atualizacao.add(""+Xf);
			atualizacao.add(""+Yf);
			for(int i = 0; i<aux.size(); i++) {
				atualizacao.add(aux.get(i));
			}
			
			return atualizacao;
		}
		return null;
	}
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IPuffle entidade) {
		ArrayList<String> atualizacao = new ArrayList<String>();
		ArrayList<String> aux,aux2;
		atualizacao.add(""+Xi);
		atualizacao.add(""+Yi);
		aux = salas[Xf][Yf].posiciona(entidade);
		if(aux != null) {
			aux2 = salas[Xi][Yi].desposiciona(entidade);
			for(int i = 0; i<aux2.size(); i++) {
				atualizacao.add(aux2.get(i));
			}
			atualizacao.add(""+Xf);
			atualizacao.add(""+Yf);
			for(int i = 0; i<aux.size(); i++) {
				atualizacao.add(aux.get(i));
			}
			
			return atualizacao;
		}
		return null;
	}
	public boolean verificaAfogamento(int Xp,int Yp, boolean chave) { // return true-> AFOGOU
		if(salas[Xp+1][Yp].derretidaOuOcupada(chave) && salas[Xp-1][Yp].derretidaOuOcupada(chave) && salas[Xp][Yp+1].derretidaOuOcupada(chave) && salas[Xp][Yp-1].derretidaOuOcupada(chave)) {
			return true;
		}
		return false;
	}
	public int quantasDerretidas(){
		int contadora = 0;
		for(int x=0; x<19; x++) {
			for(int y=0; y<15 ; y++) {
				contadora = contadora + salas[x][y].getDerretida();
			}
		}
		return contadora;
		
	}
	
}
