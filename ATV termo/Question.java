public class Question implements Loadable {

    private String word;
    private String hint;

    public Question(String word, String hint) {
        this.word = word;
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }

    @Override
    public String getWord() {
        return word;
    }

    public boolean makeGuess(String guess) {
        return word.equalsIgnoreCase(guess);
    }
}
