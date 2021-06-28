package thinIceView;

import java.util.ArrayList;
import thinIceController.IControl;

public class Subject implements ISubject{
	private String[][] espelho;
	private int Xe,Ye;
	private String[] vetorAuxiliar;
	private String[] vetorAuxiliar2;
	private Janela janela;
	private Klistener KL;
	private IControl controle;
	
	public Subject() {
		KL = new Klistener(this);
		
	}
	public void connect(IControl c) {
		controle = c;
	}
	
	public void montaEspelho(String[][] posicoes) {
		espelho = new String[19][15];
		janela = new Janela(KL);
		for(int linha=0; linha<285; linha++) {
			vetorAuxiliar = posicoes[linha][0].split("",0);
			Xe = (Integer.parseInt(vetorAuxiliar[0])*10 + Integer.parseInt(vetorAuxiliar[1]))-1;
			Ye = (Integer.parseInt(vetorAuxiliar[3])*10 + Integer.parseInt(vetorAuxiliar[4]))-1;
			vetorAuxiliar2 = posicoes[linha][1].split("",0);
			espelho[Xe][Ye] = vetorAuxiliar2[0];
			janela.atualiza(Xe, Ye, espelho[Xe][Ye]);
		}
	}
	public void atualiza(ArrayList<String>  atualizacao) {
		if(atualizacao!=null) {
			for(int i=0; i<atualizacao.size();i = i + 3) {
				Xe = Integer.parseInt(atualizacao.get(i));
				Ye = Integer.parseInt(atualizacao.get(i+1));
				espelho[Xe][Ye] = atualizacao.get(i+2);
				janela.atualiza(Xe, Ye, espelho[Xe][Ye]);
				}
			}
		}
	public void print() {
		for (int y = 14; y>-1; y--) {
			for(int x = 0; x<19; x++) {
				if(x!=0) {
					System.out.print(" ");
				}
				System.out.print(espelho[x][y]);
				
				if(x==18) {
					System.out.println("");
				}
			}
		}
	}
	public void comando(int c) {
		controle.executaComandos(c);
	}
	public void fimDeJogo(boolean s,int p) {
		//janela.dispatchEvent(new WindowEvent(janela, WindowEvent.WINDOW_CLOSING));
		janela = new Janela(s,p);
		
	}
}
