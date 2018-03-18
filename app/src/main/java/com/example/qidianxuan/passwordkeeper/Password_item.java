package com.example.qidianxuan.passwordkeeper;

/**
 * Created by Qidianxuan on 2018/1/22.
 */

public class Password_item {

    /**
     * Web : NULL
     * Id : NULL
     * Pword : NULL
     */

    private static String Web = " ";
    private static String Id= " ";
    private static String Pword= " ";

    public Password_item(){ }

    public Password_item(String Web,String Id){
        this.Web = Web;
        this.Id = Id;
    }
    public String getWeb() {
        return Web;
    }

    public void setWeb(String Web) {
        this.Web = Web;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPword() {
        return Pword;
    }

    public void setPword(String Pword) {
        this.Pword = Pword;
    }
}
