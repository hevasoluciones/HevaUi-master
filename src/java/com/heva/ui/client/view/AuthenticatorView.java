/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 *
 * @author Yasmani
 */
public interface AuthenticatorView extends IsWidget, MessagesPublisher {

    void setPresenter(Presenter listener);

    public void wrongPassword();

    public interface Presenter {

        void goTo(Place place);

        void isValidUser(String user, String password);
    }
}