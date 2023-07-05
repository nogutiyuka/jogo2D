package br.ifpr.jogo.principal;


import javax.swing.JFrame;
import br.ifpr.jogo.modelo.FaseUm;

public class Principal extends JFrame{

    public Principal(){
        FaseUm fase = new FaseUm();
        super.add(fase);
        super.setTitle("BLODDY GAME");
        super.setSize(1366, 768);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        Principal principal = new Principal();
    }
}