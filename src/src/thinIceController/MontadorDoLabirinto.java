package thinIceController;


import thinIceModel.Bloco;
import thinIceModel.Door;
import thinIceModel.IEntidade;
import thinIceModel.IPuffle;
import thinIceModel.ITeleporte;
import thinIceModel.Key;
import thinIceModel.ILabirinto;
import thinIceModel.Neve;
import thinIceModel.Exit;
import thinIceModel.Teleporte;

public class MontadorDoLabirinto implements IMontador{
	private ILabirinto labirinto;
	private IEntidade entidade;
	private ITeleporte A = null, B = null;
	private String[] vetorAuxiliar = new String[5];
	private String[] vetorAuxiliar2 = new String[2];
	private int Ye,Xe;  //Coordenada Y e coordenada X 
	private String Type;
	
	public MontadorDoLabirinto() {
		
	}
	
	public void connect(ILabirinto l) {
		labirinto = l;
	}
	public void criaMapa() {
		labirinto.criaMapa();
	}
	public boolean montaMapa(String[][] posicoes, IPuffle puffle) throws NullPointerException,ErroDeMontagem1 {
		for(int linha=0; linha<285; linha++) {
			vetorAuxiliar = posicoes[linha][0].split("",0);
			Xe = (Integer.parseInt(vetorAuxiliar[0])*10 + Integer.parseInt(vetorAuxiliar[1]))-1;
			Ye = (Integer.parseInt(vetorAuxiliar[3])*10 + Integer.parseInt(vetorAuxiliar[4]))-1;
			vetorAuxiliar2 = posicoes[linha][1].split("",0);
			Type = vetorAuxiliar2[0];
			switch(Type) {
			
				case "P":
					if(puffle.posiciona(Xe, Ye, labirinto)==null) {
						throw new ErroDeMontagem1("Não foi possivel posicionar o Puffle.");
					}
					break;
				case "B":
					entidade = new Bloco();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						throw new ErroDeMontagem1("Não foi possivel posicionar um bloco.");
					}
					break;
				case "D":
					entidade = new Door();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						throw new ErroDeMontagem1("Não foi possivel posicionar a porta.");
					}
					break;
				case "K":
					entidade = new Key();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						throw new ErroDeMontagem1("Não foi possivel posicionar a chave.");
					}
					break;
				case "N":
					entidade = new Neve();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						throw new ErroDeMontagem1("Não foi possivel posicionar uma neve.");
					}
					break;
				case "T":
					
					if(A==null) {
						A = new Teleporte();
						if(A.posiciona(Xe, Ye, labirinto)==null) {
							throw new ErroDeMontagem1("Não foi possivel posicionar o teleporte.");
						}
					}
					else {
						B = new Teleporte();
						if(B.posiciona(Xe, Ye, labirinto)==null) {
							throw new ErroDeMontagem1("Não foi possivel posicionar o teleporte.");
						}
					}
					break;
				case "E":
					entidade = new Exit();
					if(entidade.posiciona(Xe, Ye, labirinto)==null) {
						throw new ErroDeMontagem1("Não foi possivel posicionar a saida.");
					}
					break;
			}
		}
		if( A!=null && B!= null) {
			A.conecta(B);
			B.conecta(A);
		}
		return true;
		
		
	}
}
