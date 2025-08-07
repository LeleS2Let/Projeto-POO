import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

class Janela2 {

    private static Clip clipMusica1;
    private static boolean musica1Tocando = false;

    private static Clip clipMusica2;
    private static boolean musica2Tocando = false;

    private static Clip clipMusica3;
    private static boolean musica3Tocando = false;

    private static Clip clipMusica4;
    private static boolean musica4Tocando = false;

    public Janela2(JFrame janelaAnterior, Usuario usuario) {
        JFrame janela2 = new JFrame("Bem-vindo, " + usuario.getNome() + "! Escute nossas músicas! :D");

        ImageIcon imagemMusica1 = new ImageIcon("Imagens/Musica1.jpg");
        JLabel labelImagem1 = new JLabel(imagemMusica1);
        labelImagem1.setBounds(20, 30, 200, 300);

        JLabel musica1 = new JLabel("Sam Rivera - Limoblaze - Lord_Savior"); //Adiciona um Texto a Interface
        musica1.setBounds(13, 330, 400, 30);

        ImageIcon imagemMusica2 = new ImageIcon("Imagens/Musica2.jpg");
        JLabel labelImagem2 = new JLabel(imagemMusica2);
        labelImagem2.setBounds(280, 30, 220, 300);

        JLabel musica2 = new JLabel("Sam Rivera - Drive");
        musica2.setBounds(340, 330, 400, 30);

        ImageIcon imagemMusica3 = new ImageIcon("Imagens/Musica3.jpg");
        JLabel labelImagem3 = new JLabel(imagemMusica3);
        labelImagem3.setBounds(560, 30, 220, 300);

        JLabel musica3 = new JLabel("The Cranberries - Zombie");
        musica3.setBounds(600, 330, 400, 30);

        ImageIcon imagemMusica4 = new ImageIcon("Imagens/Musica4.jpg");
        JLabel labelImagem4 = new JLabel(imagemMusica4);
        labelImagem4.setBounds(840, 30, 220, 300);

        JLabel musica4 = new JLabel("Willian - Sol");
        musica4.setBounds(920, 330, 400, 30);

        JButton botao1 = new JButton("Tocar"); 
        botao1.setBounds(45, 370, 150, 40);
        botao1.addActionListener(ev -> {
            if (clipMusica1 == null) { 
                clipMusica1 = carregarClip("Audios/musica1.wav");
                if (clipMusica1 != null) {
                    clipMusica1.start();
                    musica1Tocando = true;
                    botao1.setText("Pausar");
                }
            } else {
                if (musica1Tocando) {
                    clipMusica1.stop();
                    musica1Tocando = false;
                    botao1.setText("Tocar");
                } else {
                    clipMusica1.start();
                    musica1Tocando = true;
                    botao1.setText("Pausar");
                }
            }
        });

        JButton botao2 = new JButton("Tocar");
        botao2.setBounds(320, 370, 150, 40);
        botao2.addActionListener(ev -> {
            if (clipMusica2 == null) {
                clipMusica2 = carregarClip("Audios/musica2.wav");
                if (clipMusica2 != null) {
                    clipMusica2.start();
                    musica2Tocando = true;
                    botao2.setText("Pausar");
                }
            } else {
                if (musica2Tocando) {
                    clipMusica2.stop();
                    musica2Tocando = false;
                    botao2.setText("Tocar");
                } else {
                    clipMusica2.start();
                    musica2Tocando = true;
                    botao2.setText("Pausar");
                }
            }
        });

        JButton botao3 = new JButton("Tocar");
        botao3.setBounds(590, 370, 150, 40);
        botao3.addActionListener(ev -> {
            if (clipMusica3 == null) {
                clipMusica3 = carregarClip("Audios/musica3.wav");
                if (clipMusica3 != null) {
                    clipMusica3.start();
                    musica3Tocando = true;
                    botao3.setText("Pausar");
                }
            } else {
                if (musica3Tocando) {
                    clipMusica3.stop();
                    musica3Tocando = false;
                    botao3.setText("Tocar");
                } else {
                    clipMusica3.start();
                    musica3Tocando = true;
                    botao3.setText("Pausar");
                }
            }
        });

        JButton botao4 = new JButton("Tocar");
        botao4.setBounds(870, 370, 150, 40);
        botao4.addActionListener(ev -> {
            if (clipMusica4 == null) {
                clipMusica4 = carregarClip("Audios/musica4.wav");
                if (clipMusica4 != null) {
                    clipMusica4.start();
                    musica4Tocando = true;
                    botao4.setText("Pausar");
                }
            } else {
                if (musica4Tocando) {
                    clipMusica4.stop();
                    musica4Tocando = false;
                    botao4.setText("Tocar");
                } else {
                    clipMusica4.start();
                    musica4Tocando = true;
                    botao4.setText("Pausar");
                }
            }
        });

        JButton botaoPlaylist = new JButton("Criar a propria Playlist");
        botaoPlaylist.setBounds(400, 450, 250, 40);
        botaoPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Executa alguma coisa que o botão faz quando for clicado.
                janela2.setVisible(false);
                new Janela3(janela2); // Abre a terceira janela
            }
        });

        janela2.add(labelImagem1);
        janela2.add(labelImagem2);
        janela2.add(labelImagem3);
        janela2.add(labelImagem4);

        janela2.add(botao1);
        janela2.add(botao2);
        janela2.add(botao3);
        janela2.add(botao4);
        janela2.add(botaoPlaylist);

        janela2.add(musica1);
        janela2.add(musica2);
        janela2.add(musica3);
        janela2.add(musica4);

        janela2.setLayout(null);
        janela2.setVisible(true);
        janela2.setBounds(380, 250, 1095, 550);
        janela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static Clip carregarClip(String caminhoArquivo) {
        try {
            File arquivo = new File(caminhoArquivo);
            if (!arquivo.exists()) {
                JOptionPane.showMessageDialog(null, "Arquivo de áudio não encontrado: " + caminhoArquivo);
                return null;
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(arquivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o som: " + e.getMessage());
            return null;
        }
    }
}