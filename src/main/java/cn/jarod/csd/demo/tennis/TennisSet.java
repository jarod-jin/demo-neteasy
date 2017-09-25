package cn.jarod.csd.demo.tennis;

import cn.jarod.csd.demo.Contants;

import java.util.ArrayList;
import java.util.List;

public class TennisSet {

    private static final String WIN = " Win";

    private static final String ADV = " Adv";

    private TennisPlayer receiver;

    private TennisPlayer server;

    public TennisPlayer getReceiver() {
        return receiver;
    }

    public TennisPlayer getServer() {
        return server;
    }


    private String[] scoreArr = {"Love","Fifteen","Thirty","Forty"};

    private TennisSet(String serverName, String receiverName){
        server = new TennisPlayer(serverName);
        receiver = new TennisPlayer(receiverName);
    }


    public String printScore() {
        List<SetRuleAndScore> setRuleAndScores = new ArrayList<SetRuleAndScore>() {{
            add(new SetRuleAndScore(server.isSamePoint(receiver), getScoreText(server.getScore()) + " All"));
            add(new SetRuleAndScore(server.isDeuce(receiver), "Deuce"));
            add(new SetRuleAndScore(server.isAdvantage(receiver), server.getAdvPlayerName(receiver) + ADV));
            add(new SetRuleAndScore(server.isOverDeuceScore(receiver), server.getAdvPlayerName(receiver) + WIN));
            add(new SetRuleAndScore(true, getScoreText(server.getScore()) + " " + getScoreText(receiver.getScore())));
        }};

        return setRuleAndScores.stream().filter(SetRuleAndScore::isMatched).findFirst().get().score();
    }

    private String getScoreText(int score) {
        return (score > scoreArr.length) ? "" : scoreArr[score];
    }

//    public String printScore() {
//        if (server.getScore() == receiver.getScore() )
//            return (server.getScore() < Contants.DEUCE_SCORE) ? scoreArr[server.getScore()] + Contants.ALL : Contants.DEUCE;
//        return overDeuceScoreOrNot() ? getAdvPlayerName() + (Math.abs(server.getScore() - receiver.getScore()) <  Contants.SET_WIN_SCORE ? Contants.ADV: Contants.WIN_STR) : scoreArr[server.getScore()]+" "+scoreArr[receiver.getScore()];
//    }
//
//    private boolean overDeuceScoreOrNot() {
//        if (server.getScore() >  Contants.DEUCE_SCORE || receiver.getScore() > Contants.DEUCE_SCORE ) return true;
//        return false;
//    }
//
//    private String getAdvPlayerName(){
//        return server.getScore()> receiver.getScore()? server.getName() :receiver.getName();
//    }


    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet( serverName, receiverName);
    }
}