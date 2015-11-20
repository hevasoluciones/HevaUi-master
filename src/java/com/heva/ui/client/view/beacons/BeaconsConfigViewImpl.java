/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.beacons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.heva.ui.client.place.BeaconsPlace;
import com.heva.ui.client.place.CampaignPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.view.MessagesPublisherImpl;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.User;

/**
 *
 * @author Yasmani
 */
public class BeaconsConfigViewImpl extends MessagesPublisherImpl implements BeaconsConfigView {

    private static BeaconsConfigViewImplUiBinder uiBinder = GWT.create(BeaconsConfigViewImplUiBinder.class);

    @Override
    public void setBeaconData(Beacon beacon) {
        Element username = DOM.getElementById("username");
        username.setInnerText(beacon.getName());

        Element tags = DOM.getElementById("tags");
        String stags = "Empty";
        boolean first = true;
        for (String t : beacon.getTags()) {
            if (first) {
                stags = t;
            } else {
                stags = stags + "," + t;
            }
        }
        tags.setInnerText(stags);
        
        Element uuid = DOM.getElementById("uuid");
        uuid.setInnerText(beacon.getProximityUUID());
        
        Element bcolor = DOM.getElementById("bcolor");
        bcolor.setInnerText(beacon.getBeaconColor());
        
        Element bmac = DOM.getElementById("bmac");
        bmac.setInnerText(beacon.getMacAddress());
        
        Element major = DOM.getElementById("major");
        major.setInnerText(String.valueOf(beacon.getMajor()));
        
        Element minor = DOM.getElementById("minor");
        minor.setInnerText(String.valueOf(beacon.getMinor()));
        
        Element secureuuid = DOM.getElementById("secureuuid");
        minor.setInnerText(String.valueOf(beacon.getSecureUUID()));
    }

    interface BeaconsConfigViewImplUiBinder extends UiBinder<Widget, BeaconsConfigViewImpl> {
    }
    Presenter listener;
    @UiField
    SpanElement spanName;

    @Override
    public void setUserData(User authenticatedUser) {
        spanName.setInnerText(authenticatedUser.getName());
    }

    public BeaconsConfigViewImpl() {
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
                
        Element beacon = DOM.getElementById("beacon");
        Event.sinkEvents(beacon, Event.ONCLICK);
        Event.setEventListener(beacon, new EventListener() {
            @Override
            public void onBrowserEvent(Event event) {
                if (Event.ONCLICK == event.getTypeInt()) {
                    listener.goTo(new BeaconsPlace(""));
                }
            }
        });         
    }
}