/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.signup;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.heva.ui.client.view.MessagesPublisher;

/**
 *
 * @author Yasmani
 */
public interface SignUpView extends IsWidget, MessagesPublisher {

    void setPresenter(Presenter listener);

    //public void someViewMetod();
    public interface Presenter {

        void goTo(Place place);

        //public void someBussinesMetod();
        public void signUp(String username, String email, String pwd1);
    }
}
