package com.sheng.reflection;

import android.util.Log;

public class ReflectTest {

    public String mPublicStr;
    public int mPublicInt;

    private String mPrivateStr;
    protected String mProtectedStr;

    public ReflectTest() {

    }

    public ReflectTest(String str) {

    }

    private ReflectTest(String str1, String str2) {

    }

    public void testPublicVoidMethod() {
    }

    public void testShowLog(String msg) {
        Log.e("sheng", "testShowLog == " + msg);
    }

    public String testPublicStringMethod() {
        return "";
    }

    private void testPrivateVoidMethod() {
    }
}
