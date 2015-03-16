package com.mycompany.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RexClientReceiver extends BroadcastReceiver {

    public RexClientReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("RexClientReceiver", "onReceive");
        Intent rexService = new Intent(context,RexClientService.class);
        context.startService(rexService);

    }
}
