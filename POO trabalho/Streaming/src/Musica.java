public class Musica {
    private String nome;
    private String autor;
    private int vezesTocada;

    public Musica(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
        this.vezesTocada = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public int getVezesTocada() {
        return vezesTocada;
    }

    public void tocar() {
        vezesTocada++;
    }

    @Override
    public String toString() {
        return nome + " - " + autor;
    }
}
