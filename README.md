# Projeto Thin Ice

# Descrição Resumida do Projeto
> Thin Ice era um minigame do jogo Club Penguin. Nele, o jogador controla um "Puffle" (animais de estimação do Club Penguin) que está pegando fogo e precisa passar por um labirinto de gelo fino, que derrete quando o Puffle passa. Se o Puffle ficar encurralado entre chão derretido, paredes ou blocos de gelo maciço ele se afoga e o jogador perde. O objetivo é chegar ao final do labirinto derretendo o máximo de casas de gelo possíveis sem se afogar.

# Equipe: 
* Augusto Dante De Carli Zolet - RA: 213356

# Video do projeto:
 `<Ainda não fiz>`
 
# Video de apresentação inicial: 
* https://youtu.be/ijw-gQexONY

# Slides de apresentação inicial:
* https://www.canva.com/design/DAEfIAik5Fw/rA42OPe_Arp-l6nSEckaHw/view?utm_content=DAEfIAik5Fw&utm_campaign=designshare&utm_medium=link&utm_source=sharebutton

# Video de apresentação final:
* Ainda não fiz

# Slides de apresentação final:
* Ainda não fiz

# Relatorio de evolução:
> Depois de criar os componentes, minha dificuldade foi de encontrar um jeito legal de fazer o fluxo de informação entre eles. No inicio tudo funcionava com retorno booleano, mas não era suficiente então passei a usar um retorno de vetor de String, mas também não foi suficiente pelo fato de ter tamanho fixo, então finalmente modifiquei tudo para retornos de Arraylist de Strings e ai sim consegui um fluxo de informação que informava posições, entidades, e outros eventos como afogamentos e vitorias tudo ao mesmo tempo.

# Destaques do codigo:
> Acredito que este trecho seja um destaque porque permite a interface grafica atualizar n casas em apenas um método.
~~~java
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
~~~
# Conclusão e trabalhos futuros:
> Nas ferias eu pretendo tentar melhorar o jogo adicionando coisas que faltaram em comparação com a versão original do Club Penguin, como o bloco arrastavel, maior diversidade de fases e passagens secretas.


# Documentação dos componentes:

# Diagramas:

## Diagrama Geral do Projeto:

![thinIceEsquemaGeral](https://user-images.githubusercontent.com/80828532/123559565-28c2d480-d773-11eb-84d7-465fcc8b36ac.png)


> No diagrama podemos ver como os componentes se comunicam. Note que o Model e o View não interagem entre si.

## Componente thinIceController:
> Recebe endereço para os dados de montagem,monta o jogo, recebe comandos do jogador, solicita movimento do puffle, repassa o que deve ser atualizado pela parte grafica.

![thinIceController](https://user-images.githubusercontent.com/80828532/123559623-87884e00-d773-11eb-83e9-43655f6d7fd3.png)


**Ficha Técnica**
item | detalhamento
----- | -----
Classe | src/src/thinIceController
Autores | Augusto
Interfaces | IControl,IMontador

### Interfaces

Interfaces associadas a esse componente:

![interfaceControle](https://user-images.githubusercontent.com/80828532/123565274-b104a200-d792-11eb-93da-c5b85ef48a77.png)

Em java:
~~~java
public interface IControl {

	public void executaJogo(String endereco)throws FileNotFoundException,NullPointerException,Exception;
	public void executaComandos(int c);
	public void connect(IPuffle p);
	public void connect(ISubject s);
	public void connect(ILabirinto l);
}
~~~

~~~java
public interface IMontador {
	
	public void criaMapa();
	
	public boolean montaMapa(String[][] posicoes, IPuffle puffle)throws NullPointerException;
	
	public void connect(ILabirinto l);
	
}
~~~

## Componente thinIceModel:
> Contem o labirinto que pode ser montado, entidades que podem ser posicionadas no labirinto, puffle que pode receber solicitação de movimento, repassa as atualizações do tabuleiro.

![thinIceModel](https://user-images.githubusercontent.com/80828532/123565322-d85b6f00-d792-11eb-823c-b8eec333ad04.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | src/src/thinIceModel
Autores | Augusto 
Interfaces | IEntidade, IPuffle, ILabirinto, ISala, ITeleporte

### Interfaces

Interfaces associadas a esse componente:

![interfacesModel](https://user-images.githubusercontent.com/80828532/123565423-3425f800-d793-11eb-88e9-1743af2065d0.jpeg)

![ILabirinto](https://user-images.githubusercontent.com/80828532/123565427-39834280-d793-11eb-9397-6e68a6b2da72.jpeg)

Em java:

~~~java
public interface IEntidade {

	public String posiciona(int Xp, int Yp , ILabirinto labirinto);
	
	public void rePosiciona(int Xi, int Yi,int Xf,int Yf);
	
	public String getType();
	
}
~~~
~~~java
public interface ILabirinto {
	
	public void criaMapa();

	public String posiciona(int Xp, int Yp, IEntidade entidade);
	public String posiciona(int Xp, int Yp, IPuffle entidade);
	public String posiciona(int Xp, int Yp, Teleporte teleporte);
	
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IEntidade entidade);
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IPuffle entidade);
	
	public boolean verificaAfogamento(int Xp,int Yp, boolean chave);
	
	public int quantasDerretidas();
}
~~~
~~~java
public interface IPuffle extends IEntidade{

	public ArrayList<String> movimenta(int c);
	
	public void pegaChave();
	
	public boolean getChave();
	
	public int quantasDerretidas();
	
}
~~~
~~~java
public interface ISala {

	public boolean derretidaOuOcupada(boolean chave);
	
	public ArrayList<String> posiciona(IEntidade entidade);
	
	public ArrayList<String> posiciona(IPuffle entidade);
	
	public ArrayList<String> oquePrintar();
	
	public ArrayList<String> desposiciona(IEntidade entidade);
	
	public int getDerretida();
	
}
~~~
~~~java
public interface ITeleporte extends ISala {
	
	public void conecta(ITeleporte B);
	
	public String posiciona(int Xp, int Yp , ILabirinto labirinto);
	
	public ArrayList<String>  Teleporta(IPuffle puffle);
	
	public ArrayList<String> fechaTeleporte();

}

~~~


## Componente thinIceView:
Monta um espelho do labirinto e recebe as atualizações, monta a interface gráfica.

![thinIceView](https://user-images.githubusercontent.com/80828532/123559648-ae468480-d773-11eb-8481-996acf8898d7.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | src/src/thinIceView
Autores | Augusto
Interfaces | ISubject

### Interfaces

Interfaces associadas a esse componente:

![ISubject](https://user-images.githubusercontent.com/80828532/123565509-85ce8280-d793-11eb-8a6c-b9cba813b85c.png)

Em Java:
~~~java
public interface ISubject {

	public void montaEspelho(String[][] posicoes);
	public void print();
	public void atualiza(ArrayList<String>  atualizacao);
	public void connect(IControl c);
	public void fimDeJogo(boolean s,int p);
}
~~~

## Detalhamento das interfaces
### Interface IControl
> Controla o jogo.
~~~java
public interface IControl {

	public void executaJogo(String endereco)throws FileNotFoundException,NullPointerException,Exception;
	public void executaComandos(int c);
	public void connect(IPuffle p);
	public void connect(ISubject s);
	public void connect(ILabirinto l);
}
~~~
Método | Objetivo
-------| --------
executaJogo | "Liga" o jogo, acionando o montador.
executaComandos | Realiza ações no jogo a partir dos comando do teclado.
connect | Serve para conectaro componente thinIceController com outros componentes

### Interface IMontador:
> Cria e monta o labirinto.
~~~java
public interface IMontador {
	
	public void criaMapa();
	
	public boolean montaMapa(String[][] posicoes, IPuffle puffle)throws NullPointerException;
	
	public void connect(ILabirinto l);
	
}
~~~
Método | Objetivo
-------| --------
criaMapa | Cria o labirinto.
montaMapa | Cria e posiciona as entidades no labirinto.
connect | Conecta-se com o Componente thinIceModel.

### Interface IEntidade:
> Fornece os metodos das entidades no labirinto, como posicionar e resposicionar.
~~~java
public interface IEntidade {

	public String posiciona(int Xp, int Yp , ILabirinto labirinto);
	
	public void rePosiciona(int Xi, int Yi,int Xf,int Yf);
	
	public String getType();
	
}
~~~
Método | Objetivo
-------| --------
posiciona | Posiciona a entidade no labirinto.
rePosiciona | Desposiciona a entidade e posiciona novamente.
getType | Fornece a string que define o tipo de entidade.

### Interface IPuffle:
> Coordena as ações do Puffle.
> 
~~~java
public interface IPuffle extends IEntidade{

	public ArrayList<String> movimenta(int c);
	
	public void pegaChave();
	
	public boolean getChave();
	
	public int quantasDerretidas();
	
}
~~~

Método | Objetivo
-------| --------
movimenta | Movimenta o puffle no labirinto.
pegaChave | Puffle pega a chave.
getChave | Retorna se o puffle tem a chave.
quantasDerretidas | Retorna o numero de casas do labirinto que o puffle derreteu.

### Interface ILabirinto:
> Opera os acontecimentos no labirinto.
~~~java
public interface ILabirinto {
	
	public void criaMapa();

	public String posiciona(int Xp, int Yp, IEntidade entidade);
	public String posiciona(int Xp, int Yp, IPuffle entidade);
	public String posiciona(int Xp, int Yp, Teleporte teleporte);
	
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IEntidade entidade);
	public ArrayList<String> rePosiciona(int Xi, int Yi,int Xf,int Yf, IPuffle entidade);
	
	public boolean verificaAfogamento(int Xp,int Yp, boolean chave);
	
	public int quantasDerretidas();
}
~~~
Método | Objetivo
-------| --------
posiciona | Posiciona a entidade/Puffle/Teleporte na coordenada (Xp,Yp) do labirinto.
rePosiciona | Desposiciona a entidade/Puffle da coordenada (Xi,Yi) e posiciona novamente em (Xf,Yf).
verificaAfogamento | Verifica as salas ao redor de (Xp,Yp) e retorna true se o puffle esta encurralado.
quantasDerretidas | Retorna quantas casas do labirinto estão derretidas.

### Interface ISala:
> Opera os mecanismos das salas do labirinto.

~~~java
public interface ISala {

	public boolean derretidaOuOcupada(boolean chave);
	
	public ArrayList<String> posiciona(IEntidade entidade);
	
	public ArrayList<String> posiciona(IPuffle entidade);
	
	public ArrayList<String> oquePrintar();
	
	public ArrayList<String> desposiciona(IEntidade entidade);
	
	public int getDerretida();
	
}
~~~
Método | Objetivo
-------| --------
derretidoOuOcupada| Verifica se a sala está ocupada por outra entidade ou se está derretida.
posiciona | Armazena a entidade/puffle na sala.
oquePrintar | Retorna como a sala deve ser representada pela interface visual.
getDerretida | Retorna se a sala está derretida.

### Interface ITeleporte:
> Opera os mecanismos dos teleportes.

~~~java
public interface ITeleporte extends ISala {
	
	public void conecta(ITeleporte B);
	
	public String posiciona(int Xp, int Yp , ILabirinto labirinto);
	
	public ArrayList<String>  Teleporta(IPuffle puffle);
	
	public ArrayList<String> fechaTeleporte();

}

~~~

Método | Objetivo
-------| --------
conecta| Conecta um portal de teleporte com o outro.
posiciona | Posiciona o teleporte na coordenada (Xp,Yp) do labirinto.
Teleporta | Teleporta o puffle para o outro lado do portal.
fechaTeleporte | Bloqueia a entrada no teleporte após ser atravessado uma vez.

### Interface ISubject:
> Recebe as informações de outros componentes para montar a interface visual.

~~~java
public interface ISubject {

	public void montaEspelho(String[][] posicoes);
	public void print();
	public void atualiza(ArrayList<String>  atualizacao);
	public void connect(IControl c);
	public void fimDeJogo(boolean s,int p);
}
~~~

Método | Objetivo
-------| --------
montaEspelho| Monta uma copia visual e uma copia em matriz do labirinto.
print | Printa a copia no terminal.
atualiza | Atualiza o espelho conforme as mudanças no labirinto.
fimDeJogo | Apresenta a mensagem de fim de jogo.

# Plano de exceções:
> Criei apenas uma exceção nova, as demais eu usei classes de exceções que ja existiam.

Classe | Descrição
----- | -----
ErroDeMontagem | Aponta um erro na hora de posicionar algum dos elementos do labirinto.









