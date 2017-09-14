package cn.jarod.csd.demo;

import java.util.Date;

public class SystemNowTimeProvider implements TimeProvider {
    @Override
    public Date getNow() {
        return new Date();
    }
}
