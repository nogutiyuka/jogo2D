package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class FaseUm extends Fase {
    private static final int VELOCIDADE_DE_DESLOCAMENTO = 3;

    public FaseUm() {
        super();
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\Jogo 2d\\jogo2D\\Recursos\\fundoo.jpg");
        fundo = carregando.getImage();

        personagem = new Personagem(VELOCIDADE_DE_DESLOCAMENTO);
        personagem.carregar();

        this.inicializaInimigos();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;

        if (emJogo) {
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(personagem.getImagem(), personagem.getPosicaoX(), personagem.getPosicaoY(), this);

            ArrayList<Tiro> tiros = personagem.getTiros();

            for (Tiro tiro : tiros) {
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoX(), tiro.getPosicaoY(), this);
            }

            ArrayList<TiroEspecial> tirosEspeciais = personagem.getTirosEspeciais();
            for (TiroEspecial tiroEspecial : tirosEspeciais) {
                tiroEspecial.carregar();
                graficos.drawImage(tiroEspecial.getImagem(), tiroEspecial.getPosicaoX(), tiroEspecial.getPosicaoY(),
                        this);
            }

            for (Inimigo inimigo : inimigos) {
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoX(), inimigo.getPosicaoY(), this);
            }
        }

        else {
            ImageIcon fimDeJogo = new ImageIcon("C:\\Users\\Aluno\\Desktop\\Jogo 2d\\jogo2D\\Recursos\\gameOver.png");
            graficos.drawImage(fimDeJogo.getImage(), 600, 300, null);
        }
        g.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else if (e.getKeyCode() == KeyEvent.VK_Q)
            personagem.atirarEspecial();
        else
            personagem.mover(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();

        ArrayList<Tiro> tiros = personagem.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.get(i);
            if (tiro.getPosicaoX() > LARGURA_DA_JANELA || !tiro.isEhVisivel())
                tiros.remove(tiro);
            else
                tiro.atualizar();
        }

        ArrayList<TiroEspecial> tirosEspeciais = personagem.getTirosEspeciais();
        for (int i = 0; i < tirosEspeciais.size(); i++) {
            TiroEspecial tiroEspecial = tirosEspeciais.get(i);
            if (tiroEspecial.getPosicaoX() > LARGURA_DA_JANELA || !tiroEspecial.isEhVisivel())
                tirosEspeciais.remove(i);
            else
                tiroEspecial.atualizar();
        }

        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = this.inimigos.get(i);
            if (inimigo.getPosicaoX() < 0 || !inimigo.isEhVisivel())
                inimigos.remove(inimigo);
            else
                inimigo.atualizar();
        }
        this.verficarColisoes();
        repaint();
    }

    @Override

    public void verficarColisoes() {
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if (formaInimigo.intersects(formaPersonagem)) {
                this.personagem.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo = false;
            }

            ArrayList<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                }
            }

            ArrayList<TiroEspecial> tirosEspeciais = this.personagem.getTirosEspeciais();
            for (int a = 0; a < tirosEspeciais.size(); a++) {
                TiroEspecial tiroEspecial = tirosEspeciais.get(a);
                Rectangle formaTiroEspecial = tiroEspecial.getRectangle();
                if (formaInimigo.intersects(formaTiroEspecial)) {
                    inimigo.setEhVisivel(false);
                    tiroEspecial.setEhVisivel(false);
                }
            }
        }

    }
}
