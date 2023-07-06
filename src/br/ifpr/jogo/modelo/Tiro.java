package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico {

    private static int VELOCIDADE = 10;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        this.setPosicaoX(posicaoPersonagemEmX );
        this.setPosicaoY(posicaoPersonagemEmY -(this.getAlturaImagem()/2));
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo 2d\\jogo2D\\Recursos\\knife.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getHeight(null));
        this.setLarguraImagem(this.getImagem().getWidth(null));
    }
    
    public void atualizar(){
        this.setPosicaoX(getPosicaoX() + VELOCIDADE);
    }
}