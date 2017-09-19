package cn.jarod.csd.demo.tennis;

import cn.jarod.csd.demo.Contants;

public class TennisSet {

    private TennisPlayer receiver;

    private TennisPlayer server;

    private String advPlayerName;

    public TennisPlayer getReceiver() {
        return receiver;
    }

    public TennisPlayer getServer() {
        return server;
    }


    private String[] scoreArr = {"Love","Fifteen","Thirty","Forty","Win"};

    private TennisSet(String serverName, String receiverName){
        server = new TennisPlayer(serverName);
        receiver = new TennisPlayer(receiverName);
    }


    public String printScore() {
        if (server.getScore() == receiver.getScore() ) {
            return (server.getScore() < Contants.DEUCE_SCORE) ? scoreArr[server.getScore()] + Contants.ALL : Contants.DEUCE;
        }
        if (overDeuceScoreOrNot()){
            return getAdvPlayerName() + (Math.abs(server.getScore() - receiver.getScore()) <  Contants.SET_WIN_SCORE ? Contants.ADV: Contants.WIN_STR) ;
        }
        return scoreArr[server.getScore()]+" "+scoreArr[receiver.getScore()];
    }

    private boolean overDeuceScoreOrNot() {
        if (server.getScore() >  Contants.DEUCE_SCORE || receiver.getScore() > Contants.DEUCE_SCORE ) return true;
        return false;
    }

    private String getAdvPlayerName(){
        return server.getScore()> receiver.getScore()? server.getName() :receiver.getName();
    }


    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet( serverName, receiverName);
    }
}