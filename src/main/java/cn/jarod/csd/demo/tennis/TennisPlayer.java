package cn.jarod.csd.demo.tennis;

import cn.jarod.csd.demo.Contants;

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

    public boolean isThisPlayer(String _name){
        return name.equals(_name)? true : false;
    }

    private boolean isWinMatch(int score, int antherScore) {
        return score > Contants.TIE_BREAK || (score == Contants.TIE_BREAK && antherScore < Contants.NEED_7);
    }

    public String getMatchNameString(int antherscore) {
        return isWinMatch(score, antherscore)? name + Contants.WIN_STR : name;
    }

}
