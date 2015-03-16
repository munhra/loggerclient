package com.mycompany.rex.messenger;

/**
 * Created by root on 12/03/15.
 */
public class PingMessage {

    public static final PingState DEFAULT_STATE = PingState.NO_PING_SENT;
    private static PingMessage instance = null;
    private PingState state;
    private boolean roaming;
    private NetWorkState networkState;

    protected PingMessage(){
        this.state = PingState.NO_PING_SENT;
    }

    public static PingMessage getInstance(){
        if (instance == null){
            instance = new PingMessage();
        }
        return instance;
    }

    public enum NetWorkState{
        WIFI,
        GSM_3G_4G
    }

    public enum PingState{
        NO_PING_SENT,
        PING_PENDING_ROAMING,
        PING_SENT_SCHEDULED_NEXT_WEEK,
        PING_SENT_SCHEDULED_OTHER_WEEK
    }

    public void sendPing(PingData pingData){

        switch (this.state) {

            case PING_SENT_SCHEDULED_NEXT_WEEK:
            case PING_SENT_SCHEDULED_OTHER_WEEK:
            case NO_PING_SENT:
                if (!this.roaming){
                    if(sendPingMessage()){
                        setScheduleType();
                    }else{
                        this.state = PingState.NO_PING_SENT;
                    }
                }else{
                    this.state = PingState.PING_PENDING_ROAMING;
                }
                break;
            case PING_PENDING_ROAMING:
                if (!this.roaming){
                    if(sendPingMessage()){
                        setScheduleType();
                    }else{
                        this.state = PingState.NO_PING_SENT;
                    }
                }
                break;
        }
    }

    private void setScheduleType(){
        if(networkState == NetWorkState.WIFI){
            //WIFI
            this.state = PingState.PING_SENT_SCHEDULED_NEXT_WEEK;
        }else{
            //3G or 4G
            this.state = PingState.PING_SENT_SCHEDULED_OTHER_WEEK;
        }
    }

    public void setRoaming(boolean roaming) {
        this.roaming = roaming;
    }

    public void setNetworkState(NetWorkState networkState) {
        this.networkState = networkState;
    }

    public PingState getState() {
        return state;
    }

    public void setState(PingState state) {
        this.state = state;
    }

    private boolean sendPingMessage(){
        return true;
    }
}
