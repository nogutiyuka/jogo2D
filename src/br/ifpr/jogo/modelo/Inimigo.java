package br.ifpr.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Inimigo extends ElementoGrafico{

    private static int VELOCIDADE = 5;

    public Inimigo(int xAleatorio, int yAleatorio) {
        this.setPosicaoX(xAleatorio);
        this.setPosicaoY(yAleatorio);
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\ghost.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getHeight(null));
        this.setLarguraImagem(this.getImagem().getWidth(null));
    }

    public void atualizar() {
    this.setPosicaoX(this.getPosicaoX() - VELOCIDADE);
    }

}
