import java.io.*;
import java.util.*;

public class Game {

    private List<Question> questions;
    private List<Player> players;
    private Ranking ranking;

    public Game() {
        questions = new ArrayList<>();
        players = new ArrayList<>();
        ranking = new Ranking();
    }

    public void loadQuestions(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                questions.add(new Question(parts[0], parts[1]));
            }
        }
        reader.close();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do jogador: ");
        String nome = scanner.nextLine();
        Player player = new NormalPlayer(nome);
        players.add(player);

        for (Question q : questions) {
            System.out.println("Dica: " + q.getHint());
            System.out.print("Resposta: ");
            String guess = scanner.nextLine();
            boolean correct = player.makeGuess(q, guess);
            System.out.println(correct ? "Correto!" : "Errado! A palavra era: " + q.getWord());
        }

        ranking.addPlayer(player);
        ranking.showRanking();
    }

    public void saveRanking(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Player p : players) {
            writer.write(p.getName() + "," + p.getScore());
            writer.newLine();
        }
        writer.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.loadQuestions("perguntas.txt");
            game.start();
            game.saveRanking("ranking.txt");
        } catch (IOException e) {
            System.out.println("Erro ao carregar ou salvar arquivos: " + e.getMessage());
        }
    }
}
