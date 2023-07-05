package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class FaseUm extends Fase{
    //private static final int VELOCIDADE_DE_DESLOCAMENTO = 3;

    public FaseUm() { // Linha adicionada (+)
        super(); // Chamada do construtor da classe super
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\Jogo 2d\\jogo2D\\Recursos\\fundoo.jpg");
        fundo = carregando.getImage();

        //Personagem personagem = new Personagem(VELOCIDADE_DE_DESLOCAMENTO); // + Criação do objeto Personagem
        //personagem.carregar(); // + Carregando as informações do nosso personagem

        this.inicializaInimigos();

        timer = new Timer(DELAY, this); // + Criação do objeto Timer
        timer.start(); // + Iniciando o nosso jogo
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
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(personagem.getImagem(), personagem.getPosicaoX(), personagem.getPosicaoY(), this);

        // Recuperar a nossa lista de tiros (getTiros) e atribuímos para uma variável
        // local chamada tiros.
        ArrayList<Tiro> tiros = personagem.getTiros();

        // Criando um laço de repetição (foreach). Iremos percorrer toda a lista.
        for (Tiro tiro : tiros) {
            // Carregando imagem do objeto tiro pelo método carregar.
            tiro.carregar();
            // Desenhar o tiro na nossa tela.
            graficos.drawImage(tiro.getImagem(), tiro.getPosicaoX(), tiro.getPosicaoY(), this);
        }

        // Criando um laço de repetição (foreach). Iremos percorrer toda a lista.
        for (Inimigo inimigo : inimigos) {
            // Carregando imagem do objeto inimigo pelo método carregar.
            inimigo.carregar();
            // Desenhar o inimigo na nossa tela.
            graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoX(), inimigo.getPosicaoY(), this);
        }

        g.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
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

        // Recuperar a nossa lista de tiros (getTiros) e atribuímos para uma variável
        // local chamada tiros.
        ArrayList<Tiro> tiros = personagem.getTiros();

        // Criando um laço de repetição (for). Iremos percorrer toda a lista.
        for (int i = 0; i < tiros.size(); i++) {
            // Obter o objeto tiro da posicao i do ArrayList
            Tiro tiro = tiros.get(i);
            // Verificar se (if) a posição do x (tiro.getPosicaoEmX()) é maior do que a
            // largura da nossa janela
            if (tiro.getPosicaoX() > LARGURA_DA_JANELA)
                // Remover da lista se estiver fora do campo de visão (LARGURA_DA_JANELA)
                tiros.remove(tiro);
            else
                // Atualizar a posição do tiro.
                tiro.atualizar();
        }
        // Criando um laço de repetição (for). Iremos percorrer toda a lista.
        for (int i = 0; i < this.inimigos.size(); i++) {
            // Obter o objeto inimigo da posicao i do ArrayList
            Inimigo inimigo = this.inimigos.get(i);
            // Verificar se (if) a posição do x (inimigo.getPosicaoEmX()) é maior do que a
            // largura da nossa janela
            if (inimigo.getPosicaoX() < 0)
                // Remover da lista se estiver fora do campo de visão (0)
                inimigos.remove(inimigo);
            else
                // Atualizar a posição do inimigo.
                inimigo.atualizar();
        }
        repaint();
    }
}

