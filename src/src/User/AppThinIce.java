package User;

import java.io.FileNotFoundException;
import java.util.Scanner;

import thinIceController.Controle;
import thinIceController.IControl;
import thinIceModel.ILabirinto;
import thinIceModel.IPuffle;
import thinIceModel.Labirinto;
import thinIceModel.Puffle;
import thinIceView.ISubject;
import thinIceView.Subject;

public class AppThinIce {
	public static void main(String args[]){
		Scanner scanf = new Scanner(System.in);
		System.out.println("Digite 1 para o labirinto 1, 2 para do labirinto 2 e 3 para o labirinto 3:");
		String comando = scanf.nextLine();
		while(Integer.parseInt(comando)>3 || Integer.parseInt(comando)<1) {
			System.out.println("Comando invalido! Digite 1 para o labirinto 1, 2 para do labirinto 2 e 3 para o labirinto 3:");
			comando = scanf.nextLine();
		}
		scanf.close();
		IControl controle = new Controle();
		IPuffle puffle = new Puffle();
		ISubject subject = new Subject();
		ILabirinto labirinto = new Labirinto();
		controle.connect(labirinto);
		controle.connect(puffle);
		controle.connect(subject);
		subject.connect(controle);
		try {
		controle.executaJogo("data/LABIRINTO THIN ICE"+comando+".csv");
		}
		catch(FileNotFoundException erro1) {
			System.out.println("Verifique a localização dos arquivos e tente iniciar o programa novamente.");
			System.exit(0);
		}
		catch(NullPointerException erro2) {
			System.out.println("Verifique o formato dos arquivos e tente iniciar o programa novamente.");
			System.exit(0);
		}
		catch(Exception erro3) {	
			System.out.println("Ocorreu um erro desconhecido, verifique o arquivo de montagem e tente rodar o programa novamente.");
			System.exit(0);
		}
	}
	
}
