package com.mycompany.myfirstapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mycompany.rex.messenger.RexMessengerReceiver;


public class MyActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       return super.onOptionsItemSelected(item);
    }

    public void cancelRexService(View view){
        Log.i("MyActivity","***** cancelRexService *****");
        if (alarmManager != null){
            alarmManager.cancel(pendingIntent);
        }
    }

    public void startRexService(View view){
        Log.i("MyActivity","****** startRexService *****");

        alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent rexMessenger = new Intent(this,RexMessengerReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,rexMessenger,0);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,5000,5000,pendingIntent);



    }
}
