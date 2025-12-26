package com.example.demo.listener;

public class TestResultListener {
    
    public void onTestSuccess(Object result) {
        System.out.println("Test - PASS");
    }
    
    public void onTestFailure(Object result) {
        System.out.println("Test - FAIL");
    }
    
    public void onTestSkipped(Object result) {
        System.out.println("Test - SKIP");
    }
}
