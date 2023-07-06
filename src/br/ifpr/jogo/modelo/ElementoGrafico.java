package br.ifpr.jogo.modelo;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class  ElementoGrafico {
    private int posicaoX;
    private int posicaoY;

    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;

    private boolean ehVisivel = true;

    public boolean isEhVisivel() {
        return this.ehVisivel;
    }

    public boolean getEhVisivel() {
        return this.ehVisivel;
    }

    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }

    public abstract void carregar();
    public abstract void atualizar();

    public int getPosicaoX() { 
        return this.posicaoX;
    }

    public void setPosicaoX(int posicaoX) { 
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() { 
        return this.posicaoY;
    }
    public void setPosicaoY(int posicaoY) { 
        this.posicaoY = posicaoY;
    }

    public Image getImagem() { 
        return this.imagem;
    }
    public void setImagem(Image imagem) { 
        this.imagem = imagem;
    }

    public int getLarguraImagem() { 
        return this.larguraImagem;
    }
    public void setLarguraImagem(int larguraImagem) { 
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() { 
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) { 
        this.alturaImagem = alturaImagem;
    }

    public Rectangle getRectangle() {
        return new Rectangle(posicaoX, posicaoY, larguraImagem, alturaImagem);
    }
}
