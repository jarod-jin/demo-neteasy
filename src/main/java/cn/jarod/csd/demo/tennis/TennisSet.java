package cn.jarod.csd.demo.tennis;

public class TennisSet {

    private static final int LOVE = 0;

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
        if (server.getScore() == receiver.getScore()){
            if (server.getScore() < DEUCE_SCORE)
                return scoreArr[server.getScore()]+" All";
            else
                return "Deuce";
        }
        getPlayerAdvOrNot(server, receiver);
        if ( advPlayer.getScore() > DEUCE_SCORE ){
            if ((advPlayer.getScore() - unAdvPlayer.getScore()) <  WIN_SCORE )
                return advPlayer.getName() + ADV;
            else
                return advPlayer.getName() + WIN;
        }
        return scoreArr[server.getScore()]+" "+scoreArr[receiver.getScore()];

    }

    private void getPlayerAdvOrNot(TennisPlayer player1, TennisPlayer player2) {
        if (player1.getScore() > player2.getScore()){
            advPlayer = player1;
            unAdvPlayer = player2;
        }else{
            advPlayer = player2;
            unAdvPlayer = player1;
        }
    }


    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet( serverName, receiverName);
    }
}