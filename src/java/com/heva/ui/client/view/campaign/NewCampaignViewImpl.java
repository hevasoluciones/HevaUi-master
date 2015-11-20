/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.campaign;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.heva.ui.client.place.BeaconsPlace;
import com.heva.ui.client.place.CampaignPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.view.MessagesPublisherImpl;

import com.heva.ui.shared.User;

/**
 *
 * @author Yasmani
 */
public class NewCampaignViewImpl extends MessagesPublisherImpl implements NewCampaignView {
    
    private static NewCampaignViewImplUiBinder uiBinder = GWT.create(NewCampaignViewImplUiBinder.class);
    
    interface NewCampaignViewImplUiBinder extends UiBinder<Widget, NewCampaignViewImpl> {
    }
    
    Presenter listener;

    @UiField
    SpanElement spanName;
    
    @Override
    public void setUserData(User authenticatedUser) {
        spanName.setInnerText(authenticatedUser.getName());
    }
    
    public NewCampaignViewImpl() {
        
       
        //initWidget(uiBinder.createAndBindUi(this));
        initWidget(this.asWidget());
     
 
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jasny.bootstrap/extend/js/jasny-bootstrap.min.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject(); 
       
    }
    
        private native static boolean isNotLoadedJquery() /*-{
        return !$wnd['jQuery'] || (typeof $wnd['jQuery'] !== 'function');
    }-*/;

     
        
        public static native void select2Runner() /*-{
           var $select = $wnd.$(".select2").select2({
          width: '100%'
        });
              
             
             }-*/;
        
     public static native void chekedRunner() /*-{
     
     
     
       $wnd.$('textarea.ckeditor').ckeditor();
      CKEDITOR.disableAutoInline = true;
       $wnd.$(".inline-editable").each(function(){
        CKEDITOR.inline( $wnd.$(this)[0]);
      });
    
       $wnd.$('#some-textarea').wysihtml5();
       $wnd.$('#summernote').summernote();
   
             
             }-*/;

    
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
    Button sidebar_collapse;
    
    @UiField
    Element sidebar_collapseIcon;
    
    
    
    private void init() {
        sidebar_collapse.setStyleName("btn btn-default");
        sidebar_collapseIcon.setAttribute("class", "fa fa-angle-left");
    }

    @UiHandler("sidebar_collapse")
    void onClickSidebar_collapse(ClickEvent e) {
        String clase = sidebar_collapseIcon.getAttribute("class");
        Element cl_wrapper = DOM.getElementById("cl-wrapper");
        if (clase.equals("fa fa-angle-left")) {
            sidebar_collapseIcon.setAttribute("class", "fa fa-angle-right");
            cl_wrapper.setAttribute("class", "sb-collapsed");
        } else {
            sidebar_collapseIcon.setAttribute("class", "fa fa-angle-left");
            cl_wrapper.setAttribute("class", "");
        }
    }
    
    @Override
    public void sinkEvents() {
        Element dashBoardView = DOM.getElementById("dashBoardView");
        Event.sinkEvents(dashBoardView, Event.ONCLICK);
        Event.setEventListener(dashBoardView, new EventListener() {
            @Override
            public void onBrowserEvent(Event event) {
                if (Event.ONCLICK == event.getTypeInt()) {
                    listener.goTo(new DashBoardPlace(""));
                }
            }
        });
        
        Element beaconsView = DOM.getElementById("beaconsView");
        Event.sinkEvents(beaconsView, Event.ONCLICK);
        Event.setEventListener(beaconsView, new EventListener() {
            @Override
            public void onBrowserEvent(Event event) {
                if (Event.ONCLICK == event.getTypeInt()) {
                    listener.goTo(new BeaconsPlace(""));
                }
            }
        });
        
        Element campaignView = DOM.getElementById("campaignView");
        Event.sinkEvents(campaignView, Event.ONCLICK);
        Event.setEventListener(campaignView, new EventListener() {
            @Override
            public void onBrowserEvent(Event event) {
                if (Event.ONCLICK == event.getTypeInt()) {
                    listener.goTo(new CampaignPlace(""));
                }
            }
        });
        
        Element campaign = DOM.getElementById("campaign");
        Event.sinkEvents(campaign, Event.ONCLICK);
        Event.setEventListener(campaign, new EventListener() {
            @Override
            public void onBrowserEvent(Event event) {
                if (Event.ONCLICK == event.getTypeInt()) {
                    listener.goTo(new CampaignPlace(""));
                }
            }
        });
    }
}