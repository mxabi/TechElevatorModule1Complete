package com.techelevator;

public class Television {

        private boolean isOn =false;
        private int currentChannel =3;
        private int currentVolume =2;

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOff(){
        isOn = false;
    }

    public void turnOn(){
        isOn = true;
        currentChannel = 3;
        currentVolume =2;
    }

    public void changeChannel(int channel) {
        if (isOn == true) {
            if (channel >= 3 && channel <= 18) {
                currentChannel = channel;
            }
        }
    }
    public void channelUp() {
        if (isOn == true) {
         currentChannel+=1;
            }
        if (currentChannel >18){
            currentChannel =3;
        }
        }
    public void channelDown() {
        if (isOn == true) {
            currentChannel-=1;
            if (currentChannel < 3) {
                currentChannel = 18;
            }
        }
    }
    public void raiseVolume() {
        if (isOn == true && currentVolume < 10) {
            currentVolume+=1;
        }
    }
    public void lowerVolume() {
        if (isOn == true && currentVolume != 0) {
            currentVolume-=1;
        }
    }
}
