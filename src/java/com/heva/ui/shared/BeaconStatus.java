/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * @author Rafa
 */
public class BeaconStatus implements IsSerializable  {
    
private int countBeaconOff;
private int countBeaconOn;
private int countBeaconAlert;

   

    public int getCountBeaconOff() {
        return countBeaconOff;
    }

    public void setCountBeaconOff(int countBeaconOff) {
        this.countBeaconOff = countBeaconOff;
    }

    public int getCountBeaconOn() {
        return countBeaconOn;
    }

    public void setCountBeaconOn(int countBeaconOn) {
        this.countBeaconOn = countBeaconOn;
    }

    public int getCountBeaconAlert() {
        return countBeaconAlert;
    }

    public void setCountBeaconAlert(int countBeaconAlert) {
        this.countBeaconAlert = countBeaconAlert;
    }




    
}

