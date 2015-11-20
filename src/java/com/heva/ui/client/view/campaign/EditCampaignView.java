/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.campaign;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.heva.ui.client.view.MessagesPublisher;
import com.heva.ui.shared.User;

/**
 *
 * @author Yasmani
 */
public interface EditCampaignView  extends IsWidget, MessagesPublisher {
    
    void setPresenter(Presenter listener);

    public void setUserData(User authenticatedUser);
    
    public void sinkEvents();

    //public void someViewMetod();
   
    public interface Presenter {

        void goTo(Place place);
        
        //public void someBussinesMetod();
    }
}
