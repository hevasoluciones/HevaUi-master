/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.campaign;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.heva.ui.client.view.MessagesPublisher;
import com.heva.ui.shared.Campaign;
import com.heva.ui.shared.User;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public interface CampaignView extends IsWidget, MessagesPublisher {
    
    void setPresenter(Presenter listener);

    public void setUserData(User authenticatedUser);
    
    public void sinkEvents();

    public void setCampaignList(List<Campaign> result);
    
   

    //public void someViewMetod();
   
    public interface Presenter {

        void goTo(Place place);
        
        void getCampaignList();
        
        public void deleteCampaign(int idCmp);
    }
}
