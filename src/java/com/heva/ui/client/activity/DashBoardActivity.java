/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.heva.ui.client.ClientFactory;
import com.heva.ui.client.place.AuthenticatorPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.view.dashboard.DashBoardView;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.BeaconStatus;
import com.heva.ui.shared.Campaign;
import com.heva.ui.shared.Visits;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public class DashBoardActivity extends AbstractActivity implements
        DashBoardView.Presenter {

    private ClientFactory clientFactory;

    public DashBoardActivity(DashBoardPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    /**
     * Invoked by the ActivityManager to start a new Activity
     */
    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        if (!clientFactory.getAuthenticatedUser().isAuthenticated()) {
            goTo(new AuthenticatorPlace(""));
        }
        DashBoardView dashBoardView = clientFactory.getDashBoardView();
        dashBoardView.setPresenter(this);
        containerWidget.setWidget(dashBoardView.asWidget());
        dashBoardView.sinkEvents();
        dashBoardView.setUserData(clientFactory.getAuthenticatedUser());
        getVisitors();
        getCampaigns();
        getBeacons();
    }

    /**
     * Ask user before stopping this activity
     *
     *
     * @Override public String mayStop() { return null;//"Please hold on. This
     * activity is stopping."; }
     */
    /**
     * Navigate to a new Place in the browser
     */
    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

    private void getVisitors() {
        final DashBoardView dashBoardView = clientFactory.getDashBoardView();
        clientFactory.getRpcService().getVisitors(new AsyncCallback<List<Visits>>() {
            @Override
            public void onFailure(Throwable caught) {
                dashBoardView.showMessage("Error", "Error getting the visit list", "error");
            }

            @Override
            public void onSuccess(List<Visits> vlist) {
                dashBoardView.setVisitors(vlist);
            }
        });
    }

    private void getCampaigns() {
        final DashBoardView dashBoardView = clientFactory.getDashBoardView();
        clientFactory.getRpcService().getCampaigns(new AsyncCallback<List<Campaign>>() {
            @Override
            public void onFailure(Throwable caught) {
                clientFactory.getAuthenticatorView().showMessage("Error", "Error getting the campaign list", "error");
            }

            @Override
            public void onSuccess(List<Campaign> clist) {
                dashBoardView.setCampaigns(clist);
            }
        });
        
    }

    private void getBeacons() {
        final DashBoardView dashBoardView = clientFactory.getDashBoardView();
        clientFactory.getRpcService().getBeacons(new AsyncCallback<List<Beacon>>() {
            @Override
            public void onFailure(Throwable caught) {
                clientFactory.getAuthenticatorView().showMessage("Error", "Error getting the beacon list", "error");
            }

            @Override
            public void onSuccess(List<Beacon> blist) {
                dashBoardView.setBeacons(blist);
            }
        });

    }
    
    
        @Override
  public void deleteCampaign(int idCampaign) {
      
      

        final DashBoardView dashBoardView = clientFactory.getDashBoardView();
        clientFactory.getRpcService().deleteCampain(idCampaign, new AsyncCallback<String>() {

           @Override
           public void onFailure(Throwable caught) {
               dashBoardView.showMessage("Error", "Error removed campaign", "error");
           }

           @Override
           public void onSuccess(String result) {
               
               dashBoardView.showMessage("success", result, "info");;
             
           }
       });
      
      
  }
    

}