package cn.jarod.csd.demo.tennis;

public class TennisSet {

    public static final int WIN_SCORE = 2;

    public static final int DEUCE_SCORE = 3;

    public static final String WIN = " Win";

    public static final String ADV = " Adv";

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


    private String[] scoreArr = {"Love","Fifteen","Thirty","Forty"};

    private TennisSet(String serverName, String receiverName){
        server = new TennisPlayer(serverName);
        receiver = new TennisPlayer(receiverName);
    }


    public String printScore() {
        if (server.getScore() == receiver.getScore() ) {
            return (server.getScore() < DEUCE_SCORE) ? scoreArr[server.getScore()] + " All":"Deuce";
        }
        if ( overDeuceScoreOrNot(server, receiver)  ){
            return advPlayer.getName() + ((advPlayer.getScore() - unAdvPlayer.getScore()) <  WIN_SCORE ? ADV: WIN) ;
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
        if (advPlayer.getScore() >  DEUCE_SCORE ){
            return true;
        }
        return false;
    }


    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet( serverName, receiverName);
    }
}