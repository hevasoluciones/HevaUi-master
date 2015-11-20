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
import com.heva.ui.client.place.BeaconsPlace;
import com.heva.ui.client.view.beacons.BeaconsView;
import com.heva.ui.shared.Beacon;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public class BeaconsActivity extends AbstractActivity implements
        BeaconsView.Presenter {

    private ClientFactory clientFactory;
    
    public BeaconsActivity(BeaconsPlace place, ClientFactory clientFactory) {
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
        BeaconsView beaconsView = clientFactory.getBeaconsView();
        beaconsView.setPresenter(this);
        containerWidget.setWidget(beaconsView.asWidget());
        beaconsView.sinkEvents();
        beaconsView.setUserData(clientFactory.getAuthenticatedUser());
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

    @Override
    public void getBeacons() {
        clientFactory.getRpcService().getBeacons(new AsyncCallback<List<Beacon>>() {
            @Override
            public void onFailure(Throwable caught) {
                clientFactory.getBeaconsView().showMessage("Error", "No se pudo leer la lista de beacons", "error");
            }

            @Override
            public void onSuccess(List<Beacon> beaconsList) {
                clientFactory.getBeaconsView().setBeacons(beaconsList);
            }
        });
    }
   
}