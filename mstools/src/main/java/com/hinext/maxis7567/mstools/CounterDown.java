package com.hinext.maxis7567.mstools;

import android.os.CountDownTimer;

public class CounterDown {

    private com.hinext.maxis7567.mstools.ITimer ITimer;

    private CountDownTimer countDownTimer;


    public CounterDown( com.hinext.maxis7567.mstools.ITimer ITimer) {

        this.ITimer = ITimer;

    }
    public void setCounter(long Time){
        if (Time>0){
            long counter = Time*1000;

            Timer(counter);
        }

    }
    private void Timer(long counter){
        countDownTimer=new CountDownTimer(counter, 1000) {

            public void onTick(long millisUntilFinished) {
                ITimer.OnTick();
            }

            public void onFinish() {
                ITimer.OnFinish();
            }

        }.start();


    }

    public void Reset(){
        if (countDownTimer!=null) {
            countDownTimer.cancel();
        }
    }
}
