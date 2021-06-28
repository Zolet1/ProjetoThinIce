package thinIceController;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import thinIceModel.ILabirinto;
import thinIceModel.IPuffle;
import thinIceView.ISubject;

public class Controle implements IControl{
	private IMontador montador;
	private String[][] posicaoEntidades;
	private ArrayList<String> atualizacao;
	private IPuffle Puffle;
	private CSVHandling csv; 
	private ISubject subject;
	
	public Controle() {
		montador = new MontadorDoLabirinto();
	}
	
	public void connect(IPuffle puffle) {
		Puffle = puffle;
	}
	public void connect(ISubject sub) {
		subject = sub;	
	}
	public void connect(ILabirinto l) {
		montador.connect(l);
			
	}
	
	public void executaJogo(String endereco) throws FileNotFoundException,NullPointerException,Exception {
		montador.criaMapa();
		csv = new CSVHandling();
		csv.setDataSource(endereco);
		posicaoEntidades = csv.requestCommands();
		try{
			montador.montaMapa(posicaoEntidades, Puffle);
			subject.montaEspelho(posicaoEntidades);
		}
		catch(ErroDeMontagem1 erro) {
			System.out.println("ERRO:"+ erro.getMessage());
			System.exit(0);
		}
	}
	public void executaComandos(int c) {
			atualizacao = Puffle.movimenta(c);
			if( atualizacao != null) {
				if (atualizacao.get(atualizacao.size()-1).equals("rip")) {
					atualizacao.remove(atualizacao.size()-1);
					if(atualizacao.contains("W")) {
						atualizacao.set(atualizacao.indexOf("W"),"E");
						subject.atualiza(atualizacao);
						subject.fimDeJogo(true,Puffle.quantasDerretidas());
						//System.out.println("VOCE GANHOU");
					}
					else {
						subject.atualiza(atualizacao);
						subject.fimDeJogo(false,0);
						//System.out.println("Afogou");
					}
				}
				else if(atualizacao.contains("W")) {
					atualizacao.set(atualizacao.indexOf("W"),"E");
					subject.atualiza(atualizacao);
					subject.fimDeJogo(true,Puffle.quantasDerretidas());
					//System.out.println("VOCE GANHOU");
				}
				else {
					subject.atualiza(atualizacao);
				}
			}
		
	}
}
