package com.mycompany.rex.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.mycompany.myfirstapp.RexClientService;

public class RexMessengerReceiver extends BroadcastReceiver {

    public RexMessengerReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("broadcast receiver","messenger intent");
        Intent rexMessenger = new Intent(context,RexMessenger.class);
        context.startService(rexMessenger);
    }
}
