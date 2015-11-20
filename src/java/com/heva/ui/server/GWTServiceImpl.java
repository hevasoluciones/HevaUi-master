/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.heva.ui.client.GWTService;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.BeaconStatus;
import com.heva.ui.shared.Campaign;
import com.heva.ui.shared.User;
import com.heva.ui.shared.Visits;
import com.heva.ui.shared.VisitsRegionSpec;
import com.hevasoluciones.hsws.Campains;
import hevaclientws.HevaClientWs;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasmani
 */
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {

    
     private static final String urlToVMServiceWsdl = "http://rafa-laptop:8080/HevaCloudWebService/CenterCloud?wsdl"; 
    
    @Override
    public User isValidUser(String user, String password) {
        User myUser = new User();

        try {
            //TODO implement this method
            DBConnection dbc = new DBConnection();
            myUser = dbc.getUser(user, password);
            dbc.closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

        return myUser;
    }

     @Override
    public List<Beacon> getBeacons() {
        
        List<Beacon> blist = new ArrayList<Beacon>();
        List<com.hevasoluciones.hsws.Beacon> beaconList = new  ArrayList<com.hevasoluciones.hsws.Beacon>();
        
         try {
            
             beaconList = new HevaClientWs(urlToVMServiceWsdl).getBeacons("insummins","3457a234283407ef10cbca39cf35a8dc");
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        Beacon b = new Beacon();
        
       for(com.hevasoluciones.hsws.Beacon beacon : beaconList){
        
        b.setName(beacon.getName());
      
       for( String tag : beacon.getTags()){
        b.getTags().add(tag);
       }
        b.setProximityUUID(beacon.getUuid());
        b.setBeaconColor(beacon.getColor());
        b.setMacAddress(b.getMacAddress());
        b.setMajor(beacon.getMajor());
        b.setMinor(beacon.getMinor());
        b.setSecureUUID(b.getSecureUUID());
        if(beacon.getBatteryLifeExpectancyInDays()==0) {
            b.setStatus(0);
            } else  if(beacon.getBatteryLifeExpectancyInDays()<=30) {
            b.setStatus(2);
            }
            else {
            
             b.setStatus(1);
            }
        
        blist.add(b);
        b=new Beacon();
       }
        
        
       return blist;
    }
    
  /*  @Override
   public List<Beacon> getBeacons() {
        List<Beacon> blist = new ArrayList<Beacon>();
        Beacon b = new Beacon();
        b.setName("Beacon 1");
        b.getTags().add("bags");
        b.getTags().add("short");
        b.getTags().add("shoes");
        b.setProximityUUID("B9407F30-F5F8-466E-AFF9-25556B57FE6D");
        b.setBeaconColor("Blueberry Pie");
        b.setMacAddress("C5:3B:38:76:7F:23");
        b.setMajor(32547);
        b.setMinor(14454);
        b.setSecureUUID(null);
        b.setStatus(1);

        blist.add(b);

        b = new Beacon();
        b.setName("Beacon 2");
        b.getTags().add("bags");
        b.getTags().add("short");
        b.getTags().add("shoes");
        b.setProximityUUID("B9407F30-F5F8-466E-AFF9-25556B57FE6D");
        b.setBeaconColor("Blueberry Pie");
        b.setMacAddress("C5:3B:38:76:7F:23");
        b.setMajor(32547);
        b.setMinor(14454);
        b.setSecureUUID(null);
        b.setStatus(0);

        blist.add(b);

        b = new Beacon();
        b.setName("Beacon 3");
        b.getTags().add("bags");
        b.getTags().add("short");
        b.getTags().add("shoes");
        b.setProximityUUID("B9407F30-F5F8-466E-AFF9-25556B57FE6D");
        b.setBeaconColor("Blueberry Pie");
        b.setMacAddress("C5:3B:38:76:7F:23");
        b.setMajor(32547);
        b.setMinor(14454);
        b.setSecureUUID(null);
         b.setStatus(1);

        blist.add(b);

        b = new Beacon();
        b.setName("Beacon 4");
        b.getTags().add("bags");
        b.getTags().add("short");
        b.getTags().add("shoes");
        b.setProximityUUID("B9407F30-F5F8-466E-AFF9-25556B57FE6D");
        b.setBeaconColor("Blueberry Pie");
        b.setMacAddress("C5:3B:38:76:7F:23");
        b.setMajor(32547);
        b.setMinor(14454);
        b.setSecureUUID(null);
         b.setStatus(2);

        blist.add(b);

        b = new Beacon();
        b.setName("Beacon 5");
        b.getTags().add("bags");
        b.getTags().add("short");
        b.getTags().add("shoes");
        b.setProximityUUID("B9407F30-F5F8-466E-AFF9-25556B57FE6D");
        b.setBeaconColor("Blueberry Pie");
        b.setMacAddress("C5:3B:38:76:7F:23");
        b.setMajor(32547);
        b.setMinor(14454);
        b.setSecureUUID(null);
        b.setStatus(0);

        blist.add(b);
        
         b = new Beacon();
        b.setName("Beacon 6");
        b.getTags().add("bags");
        b.getTags().add("short");
        b.getTags().add("shoes");
        b.setProximityUUID("B9407F30-F5F8-466E-AFF9-25556B57FE6D");
        b.setBeaconColor("Blueberry Pie");
        b.setMacAddress("C5:3B:38:76:7F:23");
        b.setMajor(32547);
        b.setMinor(14454);
        b.setSecureUUID(null);
        b.setStatus(1);

        blist.add(b);
        
         b = new Beacon();
        b.setName("Beacon 7");
        b.getTags().add("bags");
        b.getTags().add("short");
        b.getTags().add("shoes");
        b.setProximityUUID("B9407F30-F5F8-466E-AFF9-25556B57FE6D");
        b.setBeaconColor("Blueberry Pie");
        b.setMacAddress("C5:3B:38:76:7F:23");
        b.setMajor(32547);
        b.setMinor(14454);
        b.setSecureUUID(null);
        b.setStatus(1);

        blist.add(b);
        
        return blist;
    }*/


    @Override
    public List<Visits> getVisitors() {
        
        /*{"region":"6E28149A-CF12-48B7-B337-0B230C569328:1949:41806",
           "visits":[{
           "app_in_background_visits":0,
           "app_in_foreground_visits":0,
           "total_visits":0,
           "time":"2015-08-31T18:00:00+00:00"},
           {"app_in_background_visits":0,
           "app_in_foreground_visits":0,
           "total_visits":0,
           "time":"2015-08-31T19:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-08-31T20:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-08-31T21:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-08-31T22:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-08-31T23:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T00:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T01:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T02:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T03:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T04:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T05:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T06:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T07:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T08:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T09:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T10:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T11:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T12:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T13:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T14:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T15:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T16:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-01T17:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-01T18:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-01T19:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T20:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T21:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T22:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-01T23:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T00:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T01:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T02:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T03:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T04:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T05:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T06:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T07:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T08:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T09:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T10:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T11:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T12:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T13:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T14:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T15:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T16:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T17:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T18:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T19:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T20:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-02T21:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-02T22:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-02T23:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T00:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T01:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T02:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T03:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T04:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T05:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T06:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T07:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T08:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T09:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T10:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T11:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T12:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T13:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-03T14:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T15:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T16:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T17:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T18:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T19:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":2,"total_visits":2,"time":"2015-09-03T20:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-03T21:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T22:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-03T23:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T00:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T01:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T02:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T03:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T04:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T05:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T06:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T07:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T08:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T09:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T10:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T11:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T12:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T13:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T14:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T15:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T16:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T17:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T18:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":2,"total_visits":2,"time":"2015-09-04T19:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-04T20:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T21:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T22:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-04T23:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T00:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T01:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T02:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T03:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T04:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T05:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T06:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T07:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T08:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T09:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T10:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T11:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T12:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T13:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T14:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T15:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T16:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T17:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T18:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T19:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T20:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T21:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T22:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-05T23:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T00:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T01:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T02:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T03:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T04:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T05:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T06:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T07:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T08:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T09:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T10:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T11:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T12:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T13:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T14:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T15:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T16:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T17:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T18:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T19:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T20:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T21:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T22:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-06T23:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T00:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T01:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T02:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T03:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T04:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T05:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T06:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T07:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T08:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T09:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T10:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T11:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T12:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T13:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T14:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T15:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T16:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":0,"total_visits":0,"time":"2015-09-07T17:00:00+00:00"},{"app_in_background_visits":0,"app_in_foreground_visits":1,"total_visits":1,"time":"2015-09-07T18:00:00+00:00"}]}
        
        * 
        */
        List<Visits> vList = new ArrayList<Visits>();
        Visits v = new Visits();
        
        
        
        v.setTime("0");
        v.setApp_in_background_visits(25);
        v.setApp_in_foreground_visits(83);
        v.setTotal_visits(8);
        vList.add(v);
        
        v = new Visits();
        v.setTime("1");
        v.setApp_in_background_visits(45);
        v.setApp_in_foreground_visits(73);
        v.setTotal_visits(8);
        vList.add(v);

        v = new Visits();
        v.setTime("2");
        v.setApp_in_background_visits(43);
        v.setApp_in_foreground_visits(23);
        v.setTotal_visits(38);
        vList.add(v);

        v = new Visits();
        v.setTime("3");
        v.setApp_in_background_visits(29);
        v.setApp_in_foreground_visits(73);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("4");
        v.setApp_in_background_visits(41);
        v.setApp_in_foreground_visits(83);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("5");
        v.setApp_in_background_visits(61);
        v.setApp_in_foreground_visits(53);
        v.setTotal_visits(85);
        vList.add(v);
             
        v.setTime("6");
        v.setApp_in_background_visits(54);
        v.setApp_in_foreground_visits(36);
        v.setTotal_visits(8);
        vList.add(v);

        v = new Visits();
        v.setTime("7");
        v.setApp_in_background_visits(38);
        v.setApp_in_foreground_visits(63);
        v.setTotal_visits(38);
        vList.add(v);

        v = new Visits();
        v.setTime("8");
        v.setApp_in_background_visits(41);
        v.setApp_in_foreground_visits(34);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("9");
        v.setApp_in_background_visits(91);
        v.setApp_in_foreground_visits(78);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("10");
        v.setApp_in_background_visits(56);
        v.setApp_in_foreground_visits(88);
        v.setTotal_visits(85);
        vList.add(v);

        v = new Visits();
        v.setTime("11");
        v.setApp_in_background_visits(5);
        v.setApp_in_foreground_visits(3);
        v.setTotal_visits(8);
        vList.add(v);

        v = new Visits();
        v.setTime("12");
        v.setApp_in_background_visits(3);
        v.setApp_in_foreground_visits(23);
        v.setTotal_visits(38);
        vList.add(v);

        v = new Visits();
        v.setTime("13");
        v.setApp_in_background_visits(51);
        v.setApp_in_foreground_visits(3);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("14");
        v.setApp_in_background_visits(15);
        v.setApp_in_foreground_visits(45);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("15");
        v.setApp_in_background_visits(91);
        v.setApp_in_foreground_visits(11);
        v.setTotal_visits(85);
        vList.add(v);
             
        v.setTime("16");
        v.setApp_in_background_visits(5);
        v.setApp_in_foreground_visits(3);
        v.setTotal_visits(8);
        vList.add(v);

        v = new Visits();
        v.setTime("17");
        v.setApp_in_background_visits(3);
        v.setApp_in_foreground_visits(23);
        v.setTotal_visits(38);
        vList.add(v);

        v = new Visits();
        v.setTime("18");
        v.setApp_in_background_visits(67);
        v.setApp_in_foreground_visits(35);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("19");
        v.setApp_in_background_visits(78);
        v.setApp_in_foreground_visits(56);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("20");
        v.setApp_in_background_visits(76);
        v.setApp_in_foreground_visits(27);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("21");
        v.setApp_in_background_visits(81);
        v.setApp_in_foreground_visits(36);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("22");
        v.setApp_in_background_visits(71);
        v.setApp_in_foreground_visits(93);
        v.setTotal_visits(85);
        vList.add(v);
        
        v = new Visits();
        v.setTime("23");
        v.setApp_in_background_visits(31);
        v.setApp_in_foreground_visits(63);
        v.setTotal_visits(85);
        vList.add(v);
        

        return vList;
    } 

    
    
  /*  public List<Campaign> getCampaigns() {
        List<Campaign> clist = new ArrayList<Campaign>();
        Campaign c = new Campaign();
        c.setId(67);
        c.setTitle("Some title");
        c.getTags().add("short");
        c.setContent("blah blah blah ah blah blah blah blah ");
        c.setDate("16/07/2015");
        clist.add(c);
        c = new Campaign();
        c.setId(66);
        c.setTitle("Title2");
        c.getTags().add("jean");
        c.setContent("blah blah blah  blah blah blah ");
        c.setDate("16/07/2015");
        clist.add(c);
        return clist;
    } */
    
     @Override
    public List<Campaign> getCampaigns() {
        List<Campaign> clist = new ArrayList<Campaign>();
        Campaign c = new Campaign();
         List<Campains> campaing = new ArrayList<Campains>();
         try {
              campaing = new HevaClientWs(urlToVMServiceWsdl).getCampains();
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        for(Campains cp : campaing) {
        c.setId(cp.getId());
        c.setTitle(cp.getTitle());
        c.setFeaturedImage(cp.getFeaturedImage());
        c.setContent(cp.getContent());
        c.setDate("16/07/2015");
        for(String tags : cp.getTags()){
        c.getTags().add(tags);
        }
        
        Beacon beacon = new Beacon();
        for(com.hevasoluciones.hsws.Beacon b : cp.getBeacons()){
        
       
        beacon.setName(b.getName());
        beacon.setProximityUUID(b.getUuid());
        beacon.setMajor(b.getMajor());
        beacon.setMinor(b.getMinor());
        beacon.setMacAddress(b.getMac());
        beacon.setBeaconColor(b.getColor());
        
        c.getBeacons().add(beacon);
            
        beacon = new Beacon();
        }
        
        
        clist.add(c);
        c = new Campaign();
        }
       
        return clist;
    }

    @Override
    public String signUp(String username, String email, String password) {
        return "2";
    }

    @Override
    public String deleteCampain(int idCampain) {
        String result = null;
        
         try {
              result = new HevaClientWs(urlToVMServiceWsdl).deleteCampain(idCampain);
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         return result;
    }

    @Override
    public String editCampain(int idCampain, String title, String content, String featuredImage, ArrayList<Beacon> beacons, ArrayList<String> tags) {
        
       com.hevasoluciones.hsws.Beacon beacon= new com.hevasoluciones.hsws.Beacon();
       ArrayList<com.hevasoluciones.hsws.Beacon> BList = new ArrayList<com.hevasoluciones.hsws.Beacon>();
        
       for(Beacon b : beacons){
       
        beacon.setName(b.getName());
        beacon.setUuid(b.getProximityUUID());
        beacon.setMajor(b.getMajor());
        beacon.setMinor(b.getMinor());
        beacon.setMac(b.getMacAddress());
        beacon.setColor(b.getBeaconColor());
       
        BList.add(beacon);
        beacon = new com.hevasoluciones.hsws.Beacon();
       }
        
       String result = null;
         try {
             result= new HevaClientWs(urlToVMServiceWsdl).editCampain(idCampain, title, content, featuredImage,BList, tags);
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return result; 
    }

    
    
    @Override
    public String createNewCampain(String title, String content, String featuredImage, ArrayList<Beacon> beaconList, ArrayList<String> tagList) {
       
    com.hevasoluciones.hsws.Beacon beacon= new com.hevasoluciones.hsws.Beacon();
       ArrayList<com.hevasoluciones.hsws.Beacon> BList = new ArrayList<com.hevasoluciones.hsws.Beacon>();
        
       for(Beacon b : beaconList){
       
        beacon.setName(b.getName());
        beacon.setUuid(b.getProximityUUID());
        beacon.setMajor(b.getMajor());
        beacon.setMinor(b.getMinor());
        beacon.setMac(b.getMacAddress());
        beacon.setColor(b.getBeaconColor());
       
        BList.add(beacon);
        beacon = new com.hevasoluciones.hsws.Beacon();
       }
       
       String result = null;
         try {
             result= new HevaClientWs(urlToVMServiceWsdl).createNewCampain(title, content, featuredImage, BList, tagList);
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return result;  
    
    }

    @Override
    public BeaconStatus getAllBeaconsStatus(String appId, String appToken) {
      com.hevasoluciones.hsws.BeaconStatus result = new com.hevasoluciones.hsws.BeaconStatus();
         try {
             result = new HevaClientWs(urlToVMServiceWsdl).getAllBeaconsStatus("insummins", "3457a234283407ef10cbca39cf35a8dc");
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         BeaconStatus bs = new BeaconStatus();
         
         bs.setCountBeaconAlert(result.getCountBeaconAlert());
         bs.setCountBeaconOff(result.getCountBeaconOff());
         bs.setCountBeaconOn(result.getCountBeaconOn());
         
         return bs;
    }

    @Override
    public VisitsRegionSpec uniqueVisitorsforRegion( String uuid) {
       
         List<Visits> vList = new ArrayList<Visits>();
        VisitsRegionSpec VRS= new VisitsRegionSpec();
        Visits v = new Visits();
        
         com.hevasoluciones.hsws.VisitsRegionSpec vfr = new com.hevasoluciones.hsws.VisitsRegionSpec();
         try {
             vfr = new HevaClientWs(urlToVMServiceWsdl).uniqueVisitorsforRegion("insummins","3457a234283407ef10cbca39cf35a8dc",uuid);
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         for( com.hevasoluciones.hsws.Visits visist: vfr.getVisits()){
         
             v.setTime(visist.getTime());
             v.setApp_in_background_visits(visist.getAppInBackgroundVisits());
             v.setApp_in_foreground_visits(v.getApp_in_foreground_visits());
             v.setTotal_visits(visist.getTotalVisits());
           
             vList.add(v);
             
             v= new Visits();
         }
         
         VRS.setRegion(vfr.getRegion());
         VRS.setVisits(vList);
         
         
       
        
            
        
      return VRS;
        
    }

    @Override
    public VisitsRegionSpec visitsforRegion(String uuid, String major) {
          List<Visits> vList = new ArrayList<Visits>();
        VisitsRegionSpec VRS= new VisitsRegionSpec();
        Visits v = new Visits();
        
         com.hevasoluciones.hsws.VisitsRegionSpec vfr = new com.hevasoluciones.hsws.VisitsRegionSpec();
         try {
             vfr = new HevaClientWs(urlToVMServiceWsdl).visitsforRegion("insummins","3457a234283407ef10cbca39cf35a8dc",uuid,major);
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         for( com.hevasoluciones.hsws.Visits visist: vfr.getVisits()){
         
             v.setTime(visist.getTime());
             v.setApp_in_background_visits(visist.getAppInBackgroundVisits());
             v.setApp_in_foreground_visits(v.getApp_in_foreground_visits());
             v.setTotal_visits(visist.getTotalVisits());
           
             vList.add(v);
             
             v= new Visits();
         }
         
         VRS.setRegion(vfr.getRegion());
         VRS.setVisits(vList);
         
         
       
        
            
        
      return VRS;
    
    }

   

    @Override
    public List<String> getAllTags() {
       
         try {
             return new HevaClientWs(urlToVMServiceWsdl).getAllTags();
         } catch (MalformedURLException ex) {
             Logger.getLogger(GWTServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
}
