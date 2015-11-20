/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.BeaconStatus;
import com.heva.ui.shared.Campaign;
import com.heva.ui.shared.User;
import com.heva.ui.shared.Visits;
import com.heva.ui.shared.VisitsRegionSpec;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasmani
 */
@RemoteServiceRelativePath("gwtservice")
public interface GWTService extends RemoteService {

    public User isValidUser(String user, String password);
    
    public List<Beacon> getBeacons();
    
    public List<Visits> getVisitors();
   
   // public VisitsRegionSpec getVisitors(String uuid, String major) throws MalformedURLException ;
    
    public List<Campaign> getCampaigns();
    
    public String deleteCampain(int idCampain);
    
    public String editCampain(int  idCampain,String title, String content, String featuredImage, ArrayList<Beacon> beacons,ArrayList<String> tags);
   
    public String createNewCampain(String title,  String content,  String featuredImage,  ArrayList<Beacon> beaconList,  ArrayList<String> tagList);
   
    public BeaconStatus getAllBeaconsStatus( String appId,  String appToken);
    
    public VisitsRegionSpec uniqueVisitorsforRegion( String uuid);
    
    public VisitsRegionSpec visitsforRegion( String uuid, String major);
  
    public List<String> getAllTags();
    
    
    
    
    
    
    public String signUp(String username, String email, String password);       
}
