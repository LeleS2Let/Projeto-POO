import javax.swing.*;
import java.awt.event.*;

public class StreamingJanela1 {

    public static void main(String[] args) {
        new StreamingJanela1().iniciar();
    }

    private void iniciar() {
        JFrame janela = new JFrame("Bem vindo ao nosso Streaming de Musicas! :)");

        JLabel labelUsuario = new JLabel("Quem é Você?"); //Adiciona um Texto a Interface
        labelUsuario.setBounds(200, 60, 100, 30);

        JTextField campoUsuario = new JTextField(); //Adiciona um campo onde o Usuario pode digitar seu nome
        campoUsuario.setBounds(170, 90, 145, 30); //Tamanho do campo

        JLabel labelUsuario2 = new JLabel("Digite o seu e-mail!"); //Adiciona um Texto a Interface
        labelUsuario2.setBounds(185, 160, 300, 30);

        JTextField campoUsuario2 = new JTextField(); //Adiciona um campo onde o Usuario pode digitar seu nome
        campoUsuario2.setBounds(170, 190, 145, 30);


        //botão
        JButton botao = new JButton("Enviar"); //Criação do botão
        botao.setBounds(190, 290, 100, 40);
        botao.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = campoUsuario.getText().trim();
        String email = campoUsuario2.getText().trim();

        if (nome.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(janela, "Por favor, preencha o nome e o e-mail para continuar.");
            return;
        }

        Usuario usuario = new Usuario(nome, email); // Criando o objeto

        janela.setVisible(false);
        new Janela2(janela, usuario); // Passando o usuário para a próxima janela
    }
});

        janela.add(botao); //Add -> Adicionar o botão
        janela.add(labelUsuario); //Adiciona o "Quem é você?"
        janela.add(campoUsuario); //Adiciona o campo para digitar
        janela.add(labelUsuario2);
        janela.add(campoUsuario2);

        janela.setLayout(null); //Ter total liberdade para definir os tamanhos dos elementos adicionados no codigo.
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setBounds(650, 250, 500, 400);
    }
}