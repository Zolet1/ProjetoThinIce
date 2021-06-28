package thinIceModel;

import java.util.ArrayList;

public interface ISala {

	public boolean derretidaOuOcupada(boolean chave);
	
	public ArrayList<String> posiciona(IEntidade entidade);
	
	public ArrayList<String> posiciona(IPuffle entidade);
	
	public ArrayList<String> oquePrintar();
	
	public ArrayList<String> desposiciona(IEntidade entidade);
	
	public int getDerretida();
	
}
