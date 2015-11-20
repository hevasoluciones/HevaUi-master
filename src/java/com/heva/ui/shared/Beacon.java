/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public class Beacon implements IsSerializable {

    private String name;
    private List<String> tags = new ArrayList<String>();
    private String proximityUUID;
    private String beaconColor;
    private String macAddress;
    private long major;
    private long minor;
    private String secureUUID;
    long battery_life_expectancy_in_days;
    private int status; // 0 = Off, 1 =  On, 2 = Alert

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getProximityUUID() {
        return proximityUUID;
    }

    public void setProximityUUID(String proximityUUID) {
        this.proximityUUID = proximityUUID;
    }

    public String getBeaconColor() {
        return beaconColor;
    }

    public void setBeaconColor(String beaconColor) {
        this.beaconColor = beaconColor;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public long getMajor() {
        return major;
    }

    public void setMajor(long major) {
        this.major = major;
    }

    public long getMinor() {
        return minor;
    }

    public void setMinor(long minor) {
        this.minor = minor;
    }

    public String getSecureUUID() {
        return secureUUID;
    }

    public void setSecureUUID(String secureUUID) {
        this.secureUUID = secureUUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
        public long getBattery_life_expectancy_in_days() {
        return battery_life_expectancy_in_days;
    }

    public void setBattery_life_expectancy_in_days(long battery_life_expectancy_in_days) {
        this.battery_life_expectancy_in_days = battery_life_expectancy_in_days;
    }
    
     public String getBeaconStatus(){
    
    if(this.battery_life_expectancy_in_days==0){
    return "off";
    
    }else if(this.battery_life_expectancy_in_days<=30)   
    {
     return "alert";
    }else{
        
    return "on";     
    }
     }
}
