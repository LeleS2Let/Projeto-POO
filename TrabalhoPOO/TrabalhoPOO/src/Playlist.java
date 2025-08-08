import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable {
    private String nome;
    private List<String> musicas;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(String musica) {
        if (musica != null && !musica.trim().isEmpty()) {
            musicas.add(musica.trim());
        }
    }

    public List<String> getMusicas() {
        return musicas;
    }

    public String getNome() {
        return nome;
    }

    public void listarMusicas() {
        System.out.println("Playlist: " + nome);
        for (String musica : musicas) {
            System.out.println("- " + musica);
        }
    }
}