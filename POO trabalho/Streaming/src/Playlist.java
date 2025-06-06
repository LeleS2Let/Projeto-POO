import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Musica> musicas;

    public Playlist(String nome){
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(String nome, String autor){
        Musica musicaNova = new Musica(nome, autor);
        musicas.add(musicaNova);
    }

    public void listarMusicas(){
        System.out.println("Playlist: " + nome);
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música na playlist.");
        } else {
            for (int i = 0; i < musicas.size(); i++) {
                System.out.println((i + 1) + ". " + musicas.get(i));
            }
        }
    }
}
