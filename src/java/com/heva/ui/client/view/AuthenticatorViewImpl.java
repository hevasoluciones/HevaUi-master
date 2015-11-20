/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.heva.ui.client.place.SignUpPlace;

/**
 *
 * @author Yasmani
 */
public class AuthenticatorViewImpl extends MessagesPublisherImpl implements AuthenticatorView {

    private static AuthenticatorViewImplUiBinder uiBinder = GWT.create(AuthenticatorViewImplUiBinder.class);
    
    interface AuthenticatorViewImplUiBinder extends UiBinder<Widget, AuthenticatorViewImpl> {
    }
    
    Presenter listener;

    public AuthenticatorViewImpl() {
        //initWidget(uiBinder.createAndBindUi(this));
        initWidget(this.asWidget());
    }

    @Override
    public void setPresenter(Presenter listener) {
        this.listener = listener;
    }
    
    @Override
    public Widget asWidget() {
        Widget widget = uiBinder.createAndBindUi(this);
        init();
        return widget;
    } 
    
    @UiField
    Button btnRegister, btnLogin;
    
    @UiField
    SpanElement spanpsw;
    
    @UiField
    InputElement password, username;
    
    
    @UiHandler("btnRegister")
    void onClickBtnRegister(ClickEvent e) {        
        listener.goTo(new SignUpPlace(""));
    }
    
    @UiHandler("btnLogin")
    void onClickLogin(ClickEvent e) {        
        listener.isValidUser(username.getValue(), password.getValue());
    }
    
    @Override
    public void wrongPassword() {
        spanpsw.setClassName("input-group-addon  parsley-error");
        password.setClassName("form-control  parsley-error");
        showMessage("Error", "La contraseña proporcionada no es correcta", "error");
    }
    
    private void init() {
        //Element body = DOM.getElementById("cuerpo");
        //body.setClassName("texture"); 
        btnRegister.setStyleName("btn btn-default");
        btnLogin.setStyleName("btn btn-primary");
        spanpsw.setClassName("input-group-addon");
        password.setClassName("form-control");
    }
  
}