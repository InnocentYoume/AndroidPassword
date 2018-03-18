package com.example.qidianxuan.passwordkeeper;

/**
 * Created by Qidianxuan on 2018/2/1.
 */

public class TimeCtrl {
    public static int Tc = 0;
    public static int LockTc = 0;
    public static String Pass = "";
    public static boolean SwitchState = false;

    private static int flag = 1;

    public  int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        flag = flag;
    }
    public TimeCtrl(){

    }

    public  void setSwitchState(boolean switchState) {
        SwitchState = switchState;
    }

    public  boolean getSwitchState() {
        return SwitchState;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public int getTc(){
        return Tc;
    }

    public  int getLockTc() {
        return LockTc;
    }

    public  void setLockTc(int lockTc) {
        LockTc = lockTc;
    }

    public void setTc(int Tc){
        this.Tc = Tc;
    }
}
