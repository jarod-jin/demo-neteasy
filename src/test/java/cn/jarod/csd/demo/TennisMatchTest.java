package cn.jarod.csd.demo;

import cn.jarod.csd.demo.tennis.TennisMatch;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class TennisMatchTest {

    TennisMatch tennisMatch = new TennisMatch("Joseph","91");


    private void takePlayerSetNum(String server ,int serverSetNum, String receiver, int receiverSetNum) {
        IntStream.range(0,serverSetNum).forEach(score -> {
            tennisMatch.addOneSet(server+ " Win");
        });
        IntStream.range(0,receiverSetNum).forEach( score -> {
            tennisMatch.addOneSet(receiver+ " Win");
        });
    }


    @Test
    public void match_0_0(){
        takePlayerSetNum("Joseph",0,"91",0);
        Assert.assertEquals("Joseph (0:0) 91",tennisMatch.printMatch());
    }

    @Test
    public void match_1_0(){
        takePlayerSetNum("Joseph",1,"91",0);
        Assert.assertEquals("Joseph (1:0) 91",tennisMatch.printMatch());
    }

    @Test
    public void match_1_1(){
        takePlayerSetNum("Joseph",1,"91",1);
        Assert.assertEquals("Joseph (1:1) 91",tennisMatch.printMatch());
    }

    @Test
    public void match_6_1(){
        takePlayerSetNum("Joseph",6,"91",4);
        Assert.assertEquals("Joseph Win (6:4) 91",tennisMatch.printMatch());
    }

    @Test
    public void match_6_5(){
        takePlayerSetNum("Joseph",6,"91",5);
        Assert.assertEquals("Joseph (6:5) 91",tennisMatch.printMatch());
    }

    @Test
    public void match_7_5(){
        takePlayerSetNum("Joseph",7,"91",5);
        Assert.assertEquals("Joseph Win (7:5) 91",tennisMatch.printMatch());
    }

    @Test
    public void match_5_6(){
        takePlayerSetNum("Joseph",5,"91",6);
        Assert.assertEquals("Joseph (5:6) 91",tennisMatch.printMatch());
    }


    @Test
    public void match_6_7(){
        takePlayerSetNum("Joseph",6,"91",7);
        Assert.assertEquals("Joseph (6:7) 91 Win",tennisMatch.printMatch());
    }

}
