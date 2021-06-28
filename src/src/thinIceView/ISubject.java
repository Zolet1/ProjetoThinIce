package thinIceView;

import java.util.ArrayList;

import thinIceController.IControl;

public interface ISubject {

	public void montaEspelho(String[][] posicoes);
	public void print();
	public void atualiza(ArrayList<String>  atualizacao);
	public void connect(IControl c);
	public void fimDeJogo(boolean s,int p);
}
