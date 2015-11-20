/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.beacons;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.heva.ui.client.view.MessagesPublisher;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.User;

/**
 *
 * @author Yasmani
 */
public interface BeaconsConfigView  extends IsWidget, MessagesPublisher {
    
    void setPresenter(Presenter listener);

    public void setUserData(User authenticatedUser);

    public void setBeaconData(Beacon beacon);
    
    public void sinkEvents();

    //public void someViewMetod();
   
    public interface Presenter {

        void goTo(Place place);
        
        //public void someBussinesMetod();
    }
}
