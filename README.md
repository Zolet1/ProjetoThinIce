# Projeto Thin Ice

# Descrição Resumida do Projeto/Jogo
> Thin Ice era um minigame do jogo Club Penguin. Nele, o jogador controla um "Puffle" (animais de estimação do Club Penguin) que está pegando fogo e precisa passar por um labirinto de gelo fino, que derrete quando o Puffle passa. Se o Puffle ficar encurralado entre chão derretido,paredes ou blocos de gelo maciço ele se afoga e o jogador perde. O objetivo é chegar ao final do labirinto derrente o máximo de casas de gelo possiveis sem se afogar.

# Equipe: 
* Augusto Dante De Carli Zolet - RA: 213356

# Video do projeto:
 `<Ainda não fiz>`
 
# Video de apresentação: 
* https://youtu.be/ijw-gQexONY

# Slides de apresentação:
* https://www.canva.com/design/DAEfIAik5Fw/rA42OPe_Arp-l6nSEckaHw/view?utm_content=DAEfIAik5Fw&utm_campaign=designshare&utm_medium=link&utm_source=sharebutton

# Documentação dos componentes:

# Diagramas:

## Diagrama Geral do Projeto:

![Diagrama geral](https://user-images.githubusercontent.com/80828532/122484010-31185400-cfaa-11eb-810e-68cb5725aa4d.png)

> No diagrama podemos ver como os componentes se comunicam. Note que o Model e o View não interagem entre si.

## Componente thinIceController:
> Recebe endereço para os dados de montagem,monta o jogo, recebe comandos do jogador, solicita movimento do puffle, repassa o que deve ser atualizado pela parte grafica.

![thinIceController](https://user-images.githubusercontent.com/80828532/122484953-337bad80-cfac-11eb-8ffa-90808741eaff.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | src/src/thinIceController
Autores | Augusto
Interfaces | IControl,IMontador

### Interfaces

Interfaces associadas a esse componente:

![interfacesController](https://user-images.githubusercontent.com/80828532/122494126-30d68380-cfbf-11eb-837a-f221eccbff65.png)



## Componente thinIceModel:
> Contem o labirinto que pode ser montado, entidades que podem ser posicionadas no labirinto, puffle que pode receber solicitação de movimento, repassa as atualizações do tabuleiro.
> 
![thinIceModel](https://user-images.githubusercontent.com/80828532/122484995-4aba9b00-cfac-11eb-9b33-5a5eeebfb8fd.png)
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | src/src/thinIceModel
Autores | Augusto 
Interfaces | IEntidade,IPuffle,IMapa

### Interfaces

Interfaces associadas a esse componente:

![InterfacesModel](https://user-images.githubusercontent.com/80828532/122494158-3b911880-cfbf-11eb-84ea-312e4f8f45ef.png)



## Componente thinIceView:
Monta um espelho do labirinto e recebe as atualizações, monta a interface gráfica.

![thinIceView](https://user-images.githubusercontent.com/80828532/122485008-50b07c00-cfac-11eb-9d9e-ab02b25d142b.png)
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | src/src/thinIceView
Autores | Augusto
Interfaces | ISubject

### Interfaces

Interfaces associadas a esse componente:

![interfaceView](https://user-images.githubusercontent.com/80828532/122494211-53689c80-cfbf-11eb-9801-3c0dc3af53ff.png)

