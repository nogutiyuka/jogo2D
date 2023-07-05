package br.ifpr.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class TiroEspecial extends ElementoGrafico{
    private static int VELOCIDADE = 10;

    public TiroEspecial(int posicaoPersonagemEmX, int posicaoPersonagemEmY){
        this.setPosicaoX(posicaoPersonagemEmX+65);
        this.setPosicaoY(posicaoPersonagemEmY+20-(this.getAlturaImagem()/2));
        
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo 2d\\jogo2D\\Recursos\\cat.png");
        this.setImagem(carregando.getImage());
    }
    
    public void atualizar(){
        this.setPosicaoX(getPosicaoX() + VELOCIDADE);
    }
}
