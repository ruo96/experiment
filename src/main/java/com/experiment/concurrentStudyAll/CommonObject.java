package com.experiment.concurrentStudyAll;

/**
 * @author wuruohong
 * @date 2022-06-20 16:29
 */
public class CommonObject {

    private int privateInt;

    protected  int protectedInt;

    public int publicInt;

    int defaultInt;

    public CommonObject(int privateInt, int protectedInt, int publicInt, int defaultInt) {
        this.privateInt = privateInt;
        this.protectedInt = protectedInt;
        this.publicInt = publicInt;
        this.defaultInt = defaultInt;
    }

    public int getPrivateInt() {
        return privateInt;
    }

    public void setPrivateInt(int privateInt) {
        this.privateInt = privateInt;
    }

    public int getProtectedInt() {
        return protectedInt;
    }

    public void setProtectedInt(int protectedInt) {
        this.protectedInt = protectedInt;
    }

    public int getPublicInt() {
        return publicInt;
    }

    public void setPublicInt(int publicInt) {
        this.publicInt = publicInt;
    }

    public int getDefaultInt() {
        return defaultInt;
    }

    public void setDefaultInt(int defaultInt) {
        this.defaultInt = defaultInt;
    }
}
