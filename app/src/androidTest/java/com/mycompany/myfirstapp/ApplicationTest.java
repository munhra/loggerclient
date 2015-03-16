package com.mycompany.myfirstapp;

import android.content.Intent;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.mycompany.rex.messenger.RexMessenger;



/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ServiceTestCase<RexMessenger> {

    public ApplicationTest() {
        super(RexMessenger.class);
    }


    @Override
    protected void setUp() throws Exception {

        super.setUp();

    }

    @Override
    protected void setupService() {
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexMessenger.class);
        startService(startIntent);
        super.setupService();
    }

    @SmallTest
    public void testPreconditions() {
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexMessenger.class);
        startService(startIntent);
    }


    @SmallTest
    public void sendPingAfterOneWeek(){

        assertEquals(false,true);
    }
    /*
    @SmallTest
    public void sendPingAfterOneWeek2(){
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexMessenger.class);
        startService(startIntent);
        assertEquals(false,true);
    }

    @SmallTest
    public void sendPingAfterOneWeek3(){
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexMessenger.class);
        startService(startIntent);
        assertEquals(false,true);
    }


    /*
    @SmallTest
    public void sendPingAfterOtherWeek(){
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexMessenger.class);
        startService(startIntent);        //assertEquals(false,true);
    }*/


    //ApplicationTest testCase = new ApplicationTest();



}