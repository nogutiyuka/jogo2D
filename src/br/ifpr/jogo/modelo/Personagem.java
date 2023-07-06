package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personagem extends ElementoGrafico{

    private int deslocamentoEmX;
    private int deslocamentoEmY; 

    private int velocidadeDeslocamento;

    private static final int POSICAO_INICIAL_EM_X = 0;
    private static final int POSICAO_INICIAL_EM_Y = 0;

    private ArrayList<Tiro> tiros;
    private ArrayList<TiroEspecial> tirosEspeciais;
    
    public Personagem(int velocidadeDeslocamento){
        this.setPosicaoX(POSICAO_INICIAL_EM_X);
        this.setPosicaoY(POSICAO_INICIAL_EM_Y);
        this.velocidadeDeslocamento = velocidadeDeslocamento;
        this.tiros = new ArrayList<Tiro>();
        this.tirosEspeciais = new ArrayList<TiroEspecial>();
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo 2d\\jogo2D\\Recursos//witch.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getHeight(null));
        this.setLarguraImagem(this.getImagem().getWidth(null));
    }

    public void atualizar(){
        this.setPosicaoX(this.getPosicaoX() + this.deslocamentoEmX);
        this.setPosicaoY(this.getPosicaoY() + this.deslocamentoEmY);
    }

    public void mover(KeyEvent tecla){
        int codigoTecla = tecla.getKeyCode();
        switch (codigoTecla) {
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_W:
                this.deslocamentoEmY = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = this.velocidadeDeslocamento;
                break;

            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = this.velocidadeDeslocamento;
                break;
        }
    }

    public void parar(KeyEvent tecla){
        int codigoTecla = tecla.getKeyCode();
        switch (codigoTecla) {
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_W:
                this.deslocamentoEmY = 0;
                break;

            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = 0;
                break;
        }
    }


    public void atirar() {
        int frenteDaNave = getPosicaoX() + getLarguraImagem();
        int meioDaNave = getPosicaoY() + (getAlturaImagem() /2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void atirarEspecial() {
        int frenteDaNave = getPosicaoX() + getLarguraImagem();
        int meioDaNave = getPosicaoY() + (getAlturaImagem() /2);
        TiroEspecial tiroEspecial = new TiroEspecial(frenteDaNave, meioDaNave);
        this.tirosEspeciais.add(tiroEspecial);
    }

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
    }

    public int getVelocidadeDeslocamento() {
        return this.velocidadeDeslocamento;
    }

    public void setVelocidadeDeslocamento(int velocidadeDeslocamento) {
        this.velocidadeDeslocamento = velocidadeDeslocamento;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public ArrayList<TiroEspecial> getTirosEspeciais() {
        return this.tirosEspeciais;
    }

    public void setTirosEspeciais(ArrayList<TiroEspecial> tirosEspeciais) {
        this.tirosEspeciais = tirosEspeciais;
    }

}
