package cn.jarod.csd.demo.tennis;

public class TennisSet {

    private static final int LOVE = 0;

    public static final int WIN_SCORE = 2;

    public static final int DEUCE_SCORE = 3;

    public static final String WIN = " Win";
    public static final String ADV = " Adv";


    private int serverScore;

    private int receiverScore;

    private String serverName;

    private String receiverName;

    private String[] scoreArr = {"Love","Fifteen","Thirty","Forty"};

    private TennisSet(String serverName, String receiverName){
        this.serverName = serverName;
        this.receiverName = receiverName;
    }


    public void serverGetPoint() {
        serverScore ++;
    }

    public void recieverGetPoint() {
        receiverScore++;
    }

    public String printScore() {
        if (serverScore >= DEUCE_SCORE || receiverScore >= DEUCE_SCORE){
            if (serverScore==receiverScore)
                return "Deuce";
            if (serverScore>receiverScore && serverScore>DEUCE_SCORE){
                if ((serverScore-receiverScore) <  WIN_SCORE )
                    return serverName + ADV;
                else
                    return serverName + WIN;
            }

            if (receiverScore>serverScore && receiverScore>DEUCE_SCORE)
                if ((receiverScore-serverScore) < WIN_SCORE)
                    return receiverName + ADV;
                else
                    return receiverName + WIN;

        }
        if (serverScore== receiverScore && serverScore==LOVE){
            return scoreArr[serverScore]+" All";
        }
        return scoreArr[serverScore]+" "+scoreArr[receiverScore];

    }

    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet( serverName, receiverName);
    }
}