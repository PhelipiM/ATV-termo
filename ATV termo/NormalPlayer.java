public class NormalPlayer extends Player {

    public NormalPlayer(String name) {
        super(name);
    }

    @Override
    public boolean makeGuess(Question question, String guess) {
        boolean correct = question.makeGuess(guess);
        if (correct) {
            incrementScore();
        }
        return correct;
    }
}
