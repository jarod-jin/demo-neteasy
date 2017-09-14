package cn.jarod.csd.demo;

import org.junit.Assert;
import org.junit.Test;


public class InSectionTest {

    public static final int LEFT_BOUNDRY = 2;

    public static final int RIGHT_BOUNDRY = 5;

    public static final  boolean OPEN = false;

    public static final  boolean CLOSE = true;



    @Test
    public void inInTest(){
        IntSection intSection = new IntSection(OPEN, LEFT_BOUNDRY, RIGHT_BOUNDRY,CLOSE);
        Assert.assertTrue(intSection.isInSection(4));
    }

    @Test
    public void inInTestMax(){
        IntSection intSection = new IntSection(OPEN, LEFT_BOUNDRY, RIGHT_BOUNDRY,CLOSE);
        Assert.assertTrue(intSection.isInSection(5));
    }


    @Test
    public void inInTestMin(){
        IntSection intSection = new IntSection(OPEN, LEFT_BOUNDRY, RIGHT_BOUNDRY,CLOSE);
        Assert.assertTrue(intSection.isInSection(3));
    }


    @Test
    public void inInTestOutMax(){
        IntSection intSection = new IntSection(OPEN, LEFT_BOUNDRY, RIGHT_BOUNDRY,CLOSE);
        Assert.assertFalse(intSection.isInSection(6));
    }

    @Test
    public void inInTestOutMin(){
        IntSection intSection = new IntSection(OPEN, LEFT_BOUNDRY, RIGHT_BOUNDRY,CLOSE);
        Assert.assertFalse(intSection.isInSection(2));
    }

}
