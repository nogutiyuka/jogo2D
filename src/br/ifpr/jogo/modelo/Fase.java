package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements KeyListener, ActionListener{
    private Image fundo;
    private Personagem personagem;
    private Timer timer;

    private static final int DELAY = 5;
    private static final int VELOCIDADE_DE_DESLOCAMENTO = 3;

    private static final int LARGURA_DA_JANELA = 1024;

    public Fase(){
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\jogo 2d\\jogo2D\\Recursos\\background.jpg");
        this.fundo = carregando.getImage();
        personagem = new Personagem(VELOCIDADE_DE_DESLOCAMENTO);
        personagem.carregar();
        addKeyListener(this);
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(personagem.getImagemPersonagem(), personagem.getPosicaoX(), personagem.getPosicaoY(), this);
        ArrayList<Tiro> tiros = personagem.getTiros();
        for (Tiro tiro : tiros){
            tiro.carregar();
            graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
        }
        ArrayList<TiroEspecial> tirosEspeciais = personagem.getTirosEspeciais();
        for (TiroEspecial tiroEspeciais : tirosEspeciais){
            tiroEspeciais.carregarEspecial();
            graficos.drawImage(tiroEspeciais.getImagem(), tiroEspeciais.getPosicaoEmX(), tiroEspeciais.getPosicaoEmY(), this);
        }
        
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    

    @Override
    public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
        personagem.atirar();
    else if(e.getKeyCode() == KeyEvent.VK_Q)
        personagem.atirarEspecial();
    else
        personagem.mover(e);
}

    @Override
    public void keyReleased(KeyEvent e) {
        this.personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.personagem.atualizar();
        ArrayList<Tiro> tiros = personagem.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            if (tiros.get(i).getPosicaoEmX() > LARGURA_DA_JANELA)
                tiros.remove(i);
            else
                tiros.get(i).atualizar();
        }
        ArrayList<TiroEspecial> tirosEspeciais = personagem.getTirosEspeciais();
        for (int i = 0; i < tirosEspeciais.size(); i++) {
            if (tirosEspeciais.get(i).getPosicaoEmX() > LARGURA_DA_JANELA)
                tirosEspeciais.remove(i);
            else
                tirosEspeciais.get(i).atualizarEspecial();
        }
        repaint();
    }
}
