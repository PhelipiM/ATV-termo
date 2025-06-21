import java.util.*;

public class Ranking {

    private List<Player> players;

    public Ranking() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void showRanking() {
        players.sort((a, b) -> b.getScore() - a.getScore());
        System.out.println("--- Ranking ---");
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getScore());
        }
    }
}
