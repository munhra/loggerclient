package com.mycompany.rex.messenger;

/**
 * Created by root on 12/03/15.
 */
public class RegisterMessage {

    public static final RegisterState DEFAULT_STATE = RegisterState.NO_REGISTER_SENT;
    private static RegisterMessage instance = null;
    private RegisterState state;
    private boolean roaming;
    private boolean registerDataChanged;
    private RegisterData previousRegisterData;

    protected RegisterMessage(){
        state = RegisterState.NO_REGISTER_SENT;
    }

    public static RegisterMessage getInstance(){
        if (instance == null){
            instance = new RegisterMessage();
        }
        return instance;
    }

    public enum RegisterState{
        NO_REGISTER_SENT,
        REGISTER_SENT,
        REGISTER_PENDING_ROAMING
    }

    public void sendRegister(RegisterData registerData){

        switch (state) {
            case NO_REGISTER_SENT:
                if (!roaming){
                    //TODO implement the method that send the message to the server there can be some network errors here
                    if (sendRegisterMessage()){
                        this.state = RegisterState.REGISTER_SENT;
                    }
                }else{
                    // the device is on roaming, not register message will be sent
                    this.state = RegisterState.REGISTER_PENDING_ROAMING;
                }
                break;
            case REGISTER_SENT:
                //TODO implement a equals to compare if previousData is equal new data
                // register data not changed so no need to send it again
                // the state keeps the same
                if (!registerData.equals(previousRegisterData)){
                    // register data is changed send it again
                    if (roaming){
                        this.state = RegisterState.REGISTER_PENDING_ROAMING;
                    }else{
                        if(!sendRegisterMessage()){
                            this.state = RegisterState.NO_REGISTER_SENT;
                        }
                    }
                }
                break;
            case REGISTER_PENDING_ROAMING:
                if (!roaming){
                    if (sendRegisterMessage()){
                        this.state = RegisterState.REGISTER_SENT;
                    }else{
                        this.state = RegisterState.NO_REGISTER_SENT;
                    }
                }
                break;
        }
    }

    private boolean sendRegisterMessage(){
        //TODO implement sendRegisterMessage;
        return true;
    }

    public void setRoaming(boolean roaming) {
        this.roaming = roaming;
    }

    public boolean isRegisterDataChanged() {
        return registerDataChanged;
    }

    public RegisterState getState() {
        return state;
    }

    public void setState(RegisterState state) {
        this.state = state;
    }
}
