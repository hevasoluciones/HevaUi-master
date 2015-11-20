/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.signup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.heva.ui.client.view.MessagesPublisherImpl;

/**
 *
 * @author Yasmani
 */
public class SignUpViewImpl extends MessagesPublisherImpl implements SignUpView {

    private static SignUpViewImplUiBinder uiBinder = GWT.create(SignUpViewImplUiBinder.class);
    Presenter listener;
    @UiField
    Button btnSignUp;

    @Override
    public void setPresenter(Presenter listener) {
        this.listener = listener;
    }

    interface SignUpViewImplUiBinder extends UiBinder<Widget, SignUpViewImpl> {
    }

    public SignUpViewImpl() {
        //initWidget(uiBinder.createAndBindUi(this));
        initWidget(this.asWidget());
    }

    @Override
    public Widget asWidget() {
        Widget widget = uiBinder.createAndBindUi(this);
        init();
        return widget;
    }

    private void init() {
        btnSignUp.setStyleName("btn btn-block btn-success btn-rad btn-lg");
    }

    @UiHandler("btnSignUp")
    void onClickBtnSignUp(ClickEvent e) {
        boolean error = false;
        Element iusername = DOM.getElementById("username");
        String username = iusername.getPropertyString("value");
        Element spanun = DOM.getElementById("spanun");
        if (username.isEmpty()) {//validar username
            error = true;
            spanun.setAttribute("class", "input-group-addon  parsley-error");
            iusername.setAttribute("class", "form-control  parsley-error");
            showMessage("Error", "You must enter a correct username!", "error");
        } else {
            spanun.setAttribute("class", "input-group-addon");
            iusername.setAttribute("class", "form-control");
        }

        Element iemail = DOM.getElementById("email");
        String email = iemail.getPropertyString("value");
        Element spanemail = DOM.getElementById("spanemail");
        String patternStr = ".+@.+\\.[a-z]+";
        RegExp regExp = RegExp.compile(patternStr);
        MatchResult matcher = regExp.exec(email);
        boolean matchFound = (matcher != null);
        if (matchFound) {//validar email
            spanemail.setAttribute("class", "input-group-addon");
            iemail.setAttribute("class", "form-control");
        } else {
            error = true;
            spanemail.setAttribute("class", "input-group-addon  parsley-error");
            iemail.setAttribute("class", "form-control  parsley-error");
            showMessage("Error", "You must enter a correct email!", "error");
        }

        Element pass1 = DOM.getElementById("pass1");
        String pwd1 = pass1.getPropertyString("value");
        Element pass2 = DOM.getElementById("pass2");
        String pwd2 = pass2.getPropertyString("value");
        Element spanp2 = DOM.getElementById("spanp2");
        if (pwd1.equals(pwd2) && !pwd1.isEmpty()) {//validar password
            spanp2.setAttribute("class", "input-group-addon");
            pass2.setAttribute("class", "form-control");
        } else {
            error = true;
            spanp2.setAttribute("class", "input-group-addon  parsley-error");
            pass2.setAttribute("class", "form-control  parsley-error");
            showMessage("Error", "The passwords doesnt match!", "error");
        }
        if (error) {
            showMessage("Error", "You must correct all error.", "error");
        } else {
            listener.signUp(username, email, pwd1);
        }
    }
}