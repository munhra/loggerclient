package com.mycompany.myfirstapp;

import android.content.Intent;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.mycompany.rex.messenger.RexMessenger;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest2 extends ServiceTestCase<RexClientService> {

    public ApplicationTest2() {
        super(RexClientService.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //assertEquals(false,true);
    }

    @Override
    protected void setupService() {
        super.setupService();

    }

    @SmallTest
    public void testPreconditions() {
    }



    @SmallTest
    public void sendPingAfterOneWeek(){
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexClientService.class);
        startService(startIntent);
        assertEquals(false,true);
    }

    @SmallTest
    public void sendPingAfterOneWeek2(){
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexClientService.class);
        startService(startIntent);
        assertEquals(false,true);
    }

    @SmallTest
    public void sendPingAfterOneWeek3(){
        Intent startIntent = new Intent();
        startIntent.setClass(getContext(),RexClientService.class);
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