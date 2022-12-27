public class Score {
    private String Name;
    private int score;

    public Score(String Name, int score) {
        this.Name = Name;
        this.score = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
