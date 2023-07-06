package br.ifpr.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class TiroEspecial extends ElementoGrafico{
    private static int VELOCIDADE = 10;

    public TiroEspecial(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        this.setPosicaoX(posicaoPersonagemEmX);
        this.setPosicaoY(posicaoPersonagemEmY-(this.getAlturaImagem()/2));
        
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo 2d\\jogo2D\\Recursos\\cat.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getHeight(null));
        this.setLarguraImagem(this.getImagem().getWidth(null));
    }
    
    public void atualizar(){
        this.setPosicaoX(getPosicaoX() + VELOCIDADE);
    }
}
