/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.campaign;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.heva.ui.client.view.MessagesPublisher;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.User;
import java.util.ArrayList;

/**
 *
 * @author Yasmani
 */
public interface NewCampaignView  extends IsWidget, MessagesPublisher {
    
    void setPresenter(Presenter listener);

    public void setUserData(User authenticatedUser);

    public void sinkEvents();
    
    //public void someViewMetod();
   
    public interface Presenter {

        void goTo(Place place);
        void createNewCampaign(String title, String content, String featuredImage, ArrayList<Beacon> beaconList, ArrayList<String> tagList);
        
        //public void someBussinesMetod();
    }
}
