package cn.jarod.csd.demo;

public class IntSection {

    public IntSection(boolean bmin, int min, int max, boolean bmax) {
        this.limitMax= max;
        this.bmax = bmax;
        this.limitMin= min;
        this.bmin = bmin;
    }

    public IntSection(){

    }

    private int limitMax;

    private boolean bmax;

    private int limitMin;

    private boolean bmin;


    public boolean isInSection(int j){

        if (bmax){
            if (j>limitMax){
                return false;
            }
        }else{
            if (j>=limitMax){
                return false;
            }
        }

        if(bmin){
            if (j<limitMin){
                return false;
            }
        }
        else{
            if (j<=limitMin){
                return false;
            }
        }
        return true;
    }

}
