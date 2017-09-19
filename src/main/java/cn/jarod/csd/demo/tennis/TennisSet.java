package cn.jarod.csd.demo.tennis;

import cn.jarod.csd.demo.Contants;

public class TennisSet {

    private TennisPlayer receiver;

    private TennisPlayer server;

    private TennisPlayer advPlayer;

    private TennisPlayer unAdvPlayer;

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
        if ( overDeuceScoreOrNot(server, receiver)  ){
            return advPlayer.getName() + ((advPlayer.getScore() - unAdvPlayer.getScore()) <  Contants.SET_WIN_SCORE ? Contants.ADV: Contants.WIN_STR) ;
        }
        return scoreArr[server.getScore()]+" "+scoreArr[receiver.getScore()];
    }

    private boolean overDeuceScoreOrNot(TennisPlayer server, TennisPlayer receiver) {
        if (server.getScore() > receiver.getScore()){
            advPlayer = server;
            unAdvPlayer = receiver;
        }else{
            advPlayer = receiver;
            unAdvPlayer = server;
        }
        if (advPlayer.getScore() >  Contants.DEUCE_SCORE ){
            return true;
        }
        return false;
    }


    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet( serverName, receiverName);
    }
}