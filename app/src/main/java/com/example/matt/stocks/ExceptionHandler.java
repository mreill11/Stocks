package com.example.matt.stocks;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {

    @SuppressWarnings("deprecation")
    public void uncaughtException(Thread thread, Throwable exception) {
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));

        StringBuilder errorReport = new StringBuilder();
        errorReport.append(stackTrace.toString());

        Log.e("TEST", errorReport.toString());

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }
}