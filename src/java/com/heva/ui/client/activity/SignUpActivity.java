/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.heva.ui.client.ClientFactory;
import com.heva.ui.client.place.AuthenticatorPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.place.SignUpPlace;
import com.heva.ui.client.view.AuthenticatorView;
import com.heva.ui.client.view.signup.SignUpView;
import com.heva.ui.shared.User;

/**
 *
 * @author Yasmani
 */
public class SignUpActivity extends AbstractActivity implements
        SignUpView.Presenter {

    private ClientFactory clientFactory;

    public SignUpActivity(SignUpPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    /**
     * Invoked by the ActivityManager to start a new Activity
     */
    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        SignUpView signUpView = clientFactory.getSignUpView();
        clientFactory.getAuthenticatedUser().setAuthenticated(false);
        signUpView.setPresenter(this);
        containerWidget.setWidget(signUpView.asWidget());
        //init metods here     
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
    public void signUp(String username, String email, String password) {
        final SignUpView signUpView = clientFactory.getSignUpView();
        final AuthenticatorView authenticatorView = clientFactory.getAuthenticatorView();
        clientFactory.getRpcService().signUp(username, email, password, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                signUpView.showMessage("Error", "Sign up error", "error");
            }

            @Override
            public void onSuccess(String id) {
                goTo(new AuthenticatorPlace(""));
                authenticatorView.showMessage("Success", "The Sign Up was successfully maded", "error");
            }
        });
    }
}