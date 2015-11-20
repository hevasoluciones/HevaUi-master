/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.activity;

import com.heva.ui.client.ClientFactory;
import com.heva.ui.client.place.AuthenticatorPlace;
import com.heva.ui.client.view.AuthenticatorView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.shared.User;

/**
 *
 * @author Yasmani
 */
public class AuthenticatorActivity extends AbstractActivity implements
        AuthenticatorView.Presenter {

    private ClientFactory clientFactory;
    
    public AuthenticatorActivity(AuthenticatorPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    /**
     * Invoked by the ActivityManager to start a new Activity
     */
    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        AuthenticatorView authenticatorView = clientFactory.getAuthenticatorView();
        clientFactory.getAuthenticatedUser().setAuthenticated(false);
        authenticatorView.setPresenter(this);
        containerWidget.setWidget(authenticatorView.asWidget());
        //init metods here     
    }

    @Override
    public void isValidUser(String user, String password) {
        clientFactory.getRpcService().isValidUser(user, password, new AsyncCallback<User>() {
            @Override
            public void onFailure(Throwable caught) {
                clientFactory.getAuthenticatorView().showMessage("Error", "Error grave del servidor", "error");
            }

            @Override
            public void onSuccess(User user) {
                if (user.isAuthenticated()) {
                    clientFactory.getAuthenticatedUser().setAuthenticated(user.isAuthenticated()); 
                    clientFactory.getAuthenticatedUser().setLogin(user.getLogin());
                    clientFactory.getAuthenticatedUser().setName(user.getName());
                    clientFactory.getAuthenticatedUser().setEmail(user.getEmail());
                    //clientFactory.getAuthenticatedUser().setRole(user.getRole());
                    //clientFactory.getAuthenticatedUser().setModules(user.getModules());
                    goTo(new DashBoardPlace(""));
                } else {                    
                    clientFactory.getAuthenticatorView().wrongPassword();    
                }
            }
        });       
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