package cn.jarod.csd.demo.tennis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TennisMatch {

    List<String> winPlayer;

    public TennisMatch(){
        if (winPlayer==null){
            winPlayer = new ArrayList<String>();
        }
    }

    public String printMatch() {
        if  (winPlayer.size()>0)
        {
            return "Joseph (1:0) 91";
        }
        return "Joseph (0:0) 91";
    }

    public void addOneSet(String player){
        winPlayer.add(player);
    }
}
