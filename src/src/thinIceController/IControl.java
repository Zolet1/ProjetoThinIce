package thinIceController;

import java.io.FileNotFoundException;

import thinIceModel.ILabirinto;
import thinIceModel.IPuffle;
import thinIceView.ISubject;

public interface IControl {

	public void executaJogo(String endereco)throws FileNotFoundException,NullPointerException,Exception;
	public void executaComandos(int c);
	public void connect(IPuffle p);
	public void connect(ISubject s);
	public void connect(ILabirinto l);
}
