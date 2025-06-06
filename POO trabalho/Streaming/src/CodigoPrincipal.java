import java.util.ArrayList; // Para criar a lista das musicas disponiveis
import java.util.Comparator; //Ordem para o Ranking de quantas vezes o codigo foi executado.
import java.util.Scanner; // Permite que o usuario cadastre e crie sua Playlist.

public class CodigoPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Músicas disponíveis que colocamos 
        Musica m1 = new Musica("Sol", "Willian");
        Musica m2 = new Musica("Drive", "Sam Rivera");
        Musica m3 = new Musica("Zombie", "The Cranberries");
        Musica m4 = new Musica("Lord & Saviour", "Sam Rivera e Limoblaze");

        ArrayList<Musica> musicasFixas = new ArrayList<>();
        musicasFixas.add(m1);
        musicasFixas.add(m2);
        musicasFixas.add(m3);
        musicasFixas.add(m4);

        System.out.println("=== Bem-vindo ao Streaming de Musicas! :) ===");

        // Cadastro do usuário
        System.out.println("\n=== Quem é você? ===");
        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Digite seu e-mail de contato: ");
        String emailUsuario = scanner.nextLine();

        Usuario usuario = new Usuario(nomeUsuario, emailUsuario);

        System.out.println("\nTudo pronto, seja bem vindo!");
        System.out.println(usuario);

        // Interação com músicas disponiveis para escutar
        boolean escutando = true;
        while (escutando) {
            System.out.println("\n=== Musicas ===");
            //Definindo o tamanho da nossa lista de musicas
            for (int i = 0; i < musicasFixas.size(); i++) {
                System.out.println((i + 1) + ". " + musicasFixas.get(i));
            }
            //Caso o usuario queira ouvir a musica ele vai digitar o numero correspondente, se não ele vai escolher o 0 para finalizar.
            System.out.print("Escolha uma música para escutar (0 para parar): ");
            int escolha = -1;
            try {
                escolha = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                escolha = -1;
            } // O usuario precisa escolher um numero de 1 até 4 (a quantidade de musicas escolhidas)

            if (escolha == 0) {
                escutando = false;
                //Se a musica que o usuario escolheu estiver no tamanho correto, vai tocar a musica, se não, ela não vai tocar. 
            } else if (escolha >= 1 && escolha <= musicasFixas.size()) {
                Musica escolhida = musicasFixas.get(escolha - 1);
                escolhida.tocar();
                System.out.println("Tocando: " + escolhida);
            } else {
                System.out.println("Essa musica não está disponivel, digite novamente.");
            }
        }

        // Criar playlist do usuário
        System.out.println("\n=== Crie sua própria playlist! ===");
        System.out.print("Digite o nome da sua playlist: ");
        String nomePlaylist = scanner.nextLine();

        Playlist playlist = new Playlist(nomePlaylist);

        boolean adicionando = true;
        while (adicionando) {
            System.out.print("Digite o nome da música que quer adicionar: ");
            String nomeMusica = scanner.nextLine();

            System.out.print("Digite o autor dessa música: ");
            String autorMusica = scanner.nextLine();

            playlist.adicionarMusica(nomeMusica, autorMusica);

            System.out.print("Deseja adicionar outra música a sua playlist? (s/n): ");
            String resp = scanner.nextLine();
            if (resp.equalsIgnoreCase("n")) {
                adicionando = false;
            }
        }

        System.out.println("\nSua playlist:");
        playlist.listarMusicas();

        // Mostrar ranking das músicas baseado na quantidade de vezes tocadas
        System.out.println("\n=== Quantas vezes a musica escolhida foi tocada: ===");
        musicasFixas.sort(Comparator.comparingInt(Musica::getVezesTocada).reversed());
        for (Musica m : musicasFixas) {
            System.out.println(m + " - Tocada " + m.getVezesTocada() + " vezes");
        }
        // Comparator é usando para comparar uma quantidade e cria regras para organizar, por exemplo por ordem crescente...
        System.out.println("\nObrigado por usar nosso streaming :) , " + usuario.getNome() + "!");

        scanner.close();
    }
}
