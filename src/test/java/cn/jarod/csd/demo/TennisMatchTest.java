package cn.jarod.csd.demo;

import cn.jarod.csd.demo.tennis.TennisMatch;
import org.junit.Assert;
import org.junit.Test;

public class TennisMatchTest {

    TennisMatch tennisMatch = new TennisMatch();

    @Test
    public void match_0_0(){
        Assert.assertEquals("Joseph (0:0) 91",tennisMatch.printMatch());
    }

    @Test
    public void match_1_0(){

        Assert.assertEquals("Joseph (1:0) 91",tennisMatch.printMatch());
    }
}
