package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;
public abstract class Fase extends JPanel implements ActionListener, KeyListener {
    public static final int DELAY = 5;
    public static final int LARGURA_DA_JANELA = 1366;
    public static final int QTDE_DE_INIMIGOS = 40;

    protected boolean emJogo = true;

    public boolean isEmJogo() {
        return this.emJogo;
    }

    public boolean getEmJogo() {
        return this.emJogo;
    }

    public void setEmJogo(boolean emJogo) {
        this.emJogo = emJogo;
    }

    public Image getFundo() {
        return this.fundo;
    }

    public void setFundo(Image fundo) {
        this.fundo = fundo;
    }

    public Personagem getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public ArrayList<Inimigo> getInimigos() {
        return this.inimigos;
    }

    public void setInimigos(ArrayList<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    protected Image fundo;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected Timer timer;

    public Fase() {
        setFocusable(true); 
        setDoubleBuffered(true); 
        addKeyListener(this); 
    }

    public abstract void inicializaInimigos();
    public abstract void verficarColisoes();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
}

