package thinIceModel;

import java.util.ArrayList;

public class Sala implements ISala{
	private ArrayList<IEntidade> entidadesNaSala = new ArrayList<IEntidade>();
	private int derretida = 0; // 0 nao derretida, 1 derretida
	
	public Sala() {	
	}   
	
	public boolean derretidaOuOcupada(boolean chave) {
		if(derretida == 1 || ( entidadesNaSala.isEmpty()==false && (entidadesNaSala.get(0).getType().equals("B") || (chave==false && entidadesNaSala.get(0).getType().equals("D") )))) {
			return true;
		}
		return false;
	}   
	
	public ArrayList<String> posiciona(IEntidade entidade) {
		if(entidadesNaSala.size()==0) {
			switch(entidade.getType()) {
				case "B":
					entidadesNaSala.add(entidade);
					return oquePrintar();
				case "N":
					entidadesNaSala.add(entidade);
					return oquePrintar();
				case "D":
					entidadesNaSala.add(entidade);
					return oquePrintar();
				case "K":
					entidadesNaSala.add(entidade);
					return oquePrintar();
				case "E":
					entidadesNaSala.add(entidade);
					return oquePrintar();
			}
		}
		return null;
	}
	public ArrayList<String> posiciona(IPuffle entidade) {
		if(derretida == 1) {
			return null;
		}
		for(int i=0; i<entidadesNaSala.size(); i++ ) {
			switch (entidadesNaSala.get(i).getType()) {
			case "B":
				return null;
			
			case "K":
				entidade.pegaChave();
				derretida = 1;
				entidadesNaSala.remove(i);
				entidadesNaSala.add(entidade);
				return oquePrintar();
			
			case "D":
				if(entidade.getChave()) {
					derretida = 1;
					entidadesNaSala.remove(i);
					entidadesNaSala.add(entidade);
					return oquePrintar();
				}
				return null;
			
			case "N":
				entidadesNaSala.remove(i);
				entidadesNaSala.add(entidade);
				return oquePrintar();
			case "E":
				entidadesNaSala.add(entidade);
				return oquePrintar();
			}
		}
		derretida = 1;
		entidadesNaSala.add(entidade);
		return oquePrintar();
	}
	
	public ArrayList<String> oquePrintar() {  //VERSAO PROVISORIA
		ArrayList<String> oquePrintar = new ArrayList<String>();
		if(entidadesNaSala.isEmpty()) {
			if(derretida == 1) {
				oquePrintar.add(" ");
				return oquePrintar;
				
			}
			else {
				oquePrintar.add("-");
				return oquePrintar;
			}	
		}
		else if(entidadesNaSala.get(0).getType().equals("E") && entidadesNaSala.size()>1) {
			oquePrintar.add("W");
			return oquePrintar;
			
		}
		oquePrintar.add(entidadesNaSala.get(0).getType());
		return oquePrintar;
		
		
	}
	
	public ArrayList<String> desposiciona(IEntidade entidade) {
		for(int i=0;i<entidadesNaSala.size(); i++) {
			if(entidadesNaSala.get(i).getType().equals(entidade.getType())) {
				entidadesNaSala.remove(i);
			}
		}
		return oquePrintar();
	}
	
	public int getDerretida() {
		return derretida;

	}
}
