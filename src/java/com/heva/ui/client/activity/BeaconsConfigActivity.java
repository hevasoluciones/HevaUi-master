/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.heva.ui.client.ClientFactory;
import com.heva.ui.client.place.AuthenticatorPlace;
import com.heva.ui.client.place.BeaconsConfigPlace;
import com.heva.ui.client.view.beacons.BeaconsConfigView;
import com.heva.ui.shared.Beacon;

/**
 *
 * @author Yasmani
 */
public class BeaconsConfigActivity extends AbstractActivity implements
        BeaconsConfigView.Presenter {

    private ClientFactory clientFactory;
    private Beacon beacon;
    
    public BeaconsConfigActivity(BeaconsConfigPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        beacon = place.getBeacon();
        
    }

    /**
     * Invoked by the ActivityManager to start a new Activity
     */
    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        if (!clientFactory.getAuthenticatedUser().isAuthenticated()) {
            goTo(new AuthenticatorPlace(""));
        }
        BeaconsConfigView beaconsConfigView = clientFactory.getBeaconsConfigView();
        beaconsConfigView.setPresenter(this);
        containerWidget.setWidget(beaconsConfigView.asWidget());
        beaconsConfigView.sinkEvents();
        beaconsConfigView.setUserData(clientFactory.getAuthenticatedUser());
        beaconsConfigView.setBeaconData(beacon);
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
   
}