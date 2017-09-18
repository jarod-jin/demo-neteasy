package cn.jarod.csd.demo.tennis;

public class TennisPlayer {

    private String name;

    private int score;

    public TennisPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void playerGetPoint(){
        score ++;
    }
}
