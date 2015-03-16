package com.mycompany.rex.messenger;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RexMessenger extends IntentService {

    public static final String TAG = "RexMessenger";
    public static final String PING_STATE = "PING_STATE";
    public static final String REX_STATE = "REXSTATE";
    public static final String REGISTER_STATE = "REGISTER_STATE";

    private RegisterMessage registerMessage;
    private PingMessage pingMessage;

    public RexMessenger() {
        super("RexMessenger");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "onHandleIntent");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerMessage = RegisterMessage.getInstance();
        pingMessage = PingMessage.getInstance();


        SharedPreferences sharedprefs = getSharedPreferences(REX_STATE,MODE_PRIVATE);

        int loadedPingState = sharedprefs.getInt(PING_STATE,PingMessage.DEFAULT_STATE.ordinal());
        int loadedRegState = sharedprefs.getInt(REGISTER_STATE,RegisterMessage.DEFAULT_STATE.ordinal());

        pingMessage.setState(PingMessage.PingState.values()[loadedPingState]);
        registerMessage.setState(RegisterMessage.RegisterState.values()[loadedRegState]);


        Log.i(TAG,"onCreate");
    }

    // Always send a message en receive a start command
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        //TODO restore state in some way delegate it to the messages classes
        registerMessage.sendRegister(new RegisterData());
        Log.i(TAG,registerMessage.getState().toString());
        pingMessage.sendPing(new PingData());
        Log.i(TAG,pingMessage.getState().toString());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedprefs = getSharedPreferences(REX_STATE,MODE_PRIVATE);
        sharedprefs.edit().putInt(PING_STATE,pingMessage.getState().ordinal());
        sharedprefs.edit().putInt(REGISTER_STATE,registerMessage.getState().ordinal());
        sharedprefs.edit().commit();
        Log.i(TAG,"onDestroy");
    }


}
