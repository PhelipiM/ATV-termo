public abstract class Player {

    protected String name;
    protected int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    protected void incrementScore() {
        score++;
    }

    public abstract boolean makeGuess(Question question, String guess);
}
