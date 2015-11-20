/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.BeaconStatus;
import com.heva.ui.shared.Campaign;
import com.heva.ui.shared.User;
import com.heva.ui.shared.Visits;
import com.heva.ui.shared.VisitsRegionSpec;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public interface GWTServiceAsync {

    public void isValidUser(String user, String password, AsyncCallback<User> callback);
    
    public void getBeacons(AsyncCallback<List<Beacon>> callback);
    
   // public void getVisitors(AsyncCallback<List<Visits>> callback);
    
    public void getCampaigns(AsyncCallback<List<Campaign>> callback);    
    
    public void signUp(String username, String email, String password, AsyncCallback<String> callback);

    public void deleteCampain(int idCampain, AsyncCallback<String> asyncCallback);

    public void editCampain(int idCampain, String title, String content, String featuredImage, ArrayList<Beacon> beacons, ArrayList<String> tags, AsyncCallback<String> asyncCallback);

    public void createNewCampain(String title, String content, String featuredImage, ArrayList<Beacon> beaconList, ArrayList<String> tagList, AsyncCallback<String> asyncCallback);

    public void getAllBeaconsStatus(String appId, String appToken, AsyncCallback<BeaconStatus> asyncCallback);
   

    public void getAllTags(AsyncCallback<List<String>> asyncCallback);

    public void uniqueVisitorsforRegion(String uuid, AsyncCallback<VisitsRegionSpec> asyncCallback);

    public void visitsforRegion(String uuid, String major, AsyncCallback<VisitsRegionSpec> asyncCallback);

    public void getVisitors(AsyncCallback<List<Visits>> asyncCallback);

    
}
