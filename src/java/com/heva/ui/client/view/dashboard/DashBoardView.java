/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.dashboard;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.heva.ui.client.view.MessagesPublisher;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.Campaign;
import com.heva.ui.shared.User;
import com.heva.ui.shared.Visits;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public interface DashBoardView  extends IsWidget, MessagesPublisher {
    
    void setPresenter(Presenter listener);
    
    public void setBeacons(List<Beacon> beaconList);
    
    public void setCampaigns(List<Campaign> campaignList);
    
    public void setVisitors(List<Visits> visitList);

    public void setUserData(User authenticatedUser);
    
 

    public void sinkEvents();
    //public void someViewMetod();
   
    public interface Presenter {

        void goTo(Place place);
        public void deleteCampaign(int idCmp);
        
        //public void someBussinesMetod();
    }
}
