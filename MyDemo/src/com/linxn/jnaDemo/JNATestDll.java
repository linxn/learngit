package com.linxn.jnaDemo;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by linxn on 2017/4/16.
 */
public interface JNATestDll extends Library {
    JNATestDll instanceDll = (JNATestDll) Native.loadLibrary("Win32MakeDll",JNATestDll.class);
    public double Add(double a, double b);

}
