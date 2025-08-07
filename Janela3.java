import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Janela3 {
    public Janela3(JFrame janelaAnterior) {
        JFrame janela3 = new JFrame("Crie sua propria Playlist!");
        
        JLabel Playlist = new JLabel("Nome da sua Playlist"); //Adiciona um Texto a Interface
        Playlist.setBounds(275, 30, 500, 30);

        JTextField campoPlaylist = new JTextField(); //Adiciona um campo onde o Usuario pode digitar seu nome
        campoPlaylist.setBounds(260, 70, 150, 30); //Tamanho do campo

        JLabel NomeMusica1 = new JLabel("Musica 1"); //Adiciona um Texto a Interface
        NomeMusica1.setBounds(310, 120, 500, 30);

        JTextField campoPlaylist2 = new JTextField(); //Adiciona um campo onde o Usuario pode digitar nome da primeira musica
        campoPlaylist2.setBounds(260, 160, 150, 30); //Tamanho do campo

        JLabel NomeMusica2 = new JLabel("Musica 2"); //Adiciona um Texto a Interface
        NomeMusica2.setBounds(310, 220, 500, 30);

        JTextField campoPlaylist3 = new JTextField(); //Adiciona um campo onde o Usuario pode digitar o nome da primeira musica
        campoPlaylist3.setBounds(260, 260, 150, 30); //Tamanho do campo

        JButton botaoSalvar = new JButton("Salvar Playlist");
        botaoSalvar.setBounds(260, 310, 150, 30);
        botaoSalvar.addActionListener(e -> {
            String nomePlaylist = campoPlaylist.getText().trim();
            String musica1 = campoPlaylist2.getText().trim();
            String musica2 = campoPlaylist3.getText().trim();

            if (nomePlaylist.isEmpty()) {
                JOptionPane.showMessageDialog(janela3, "Digite o nome da playlist.");
                return;
            }

            Playlist playlist = new Playlist(nomePlaylist);
            playlist.adicionarMusica(musica1);
            playlist.adicionarMusica(musica2);

            JOptionPane.showMessageDialog(janela3, "Playlist criada com sucesso!\nMúsicas: " + playlist.getMusicas());

});

        janela3.add(botaoSalvar);

        //Jlabels
        janela3.add(Playlist);
        janela3.add(NomeMusica1);
        janela3.add(NomeMusica2);

        //JTextFileds
        janela3.add(campoPlaylist);
        janela3.add(campoPlaylist2);
        janela3.add(campoPlaylist3);

        janela3.setLayout(null); //Permite mudar os tamanhos de todos os elementos do codigo, por exemplo o tamanho das imagens.
        janela3.setVisible(true); //Adiciona a janela
        janela3.setBounds(580, 250, 700, 400); 
        janela3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

