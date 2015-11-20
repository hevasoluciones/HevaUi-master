/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.beacons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.heva.ui.client.place.BeaconsAnalyticsPlace;
import com.heva.ui.client.place.BeaconsConfigPlace;
import com.heva.ui.client.place.BeaconsPlace;
import com.heva.ui.client.place.CampaignPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.view.MessagesPublisherImpl;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.User;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public class BeaconsViewImpl extends MessagesPublisherImpl implements BeaconsView {

    private static BeaconsViewImplUiBinder uiBinder = GWT.create(BeaconsViewImplUiBinder.class);
    @UiField
    TableElement beaconsTable;

    @Override
    public void setBeacons(List<Beacon> beaconsList) {
        int i = 0;
        TableSectionElement tbody = beaconsTable.getTBodies().getItem(0);
        for (final Beacon b : beaconsList) {
            TableRowElement tr = tbody.insertRow(i);
            TableCellElement tcName = tr.insertCell(0);
            Label lName = new Label(b.getName());
            tcName.appendChild(lName.getElement());

            TableCellElement tcProximityUUID = tr.insertCell(1);
            tcProximityUUID.setAttribute("class", "text-right color-success");
            Label lProximityUUID = new Label(b.getProximityUUID());
            tcProximityUUID.appendChild(lProximityUUID.getElement());

            TableCellElement tcMajor = tr.insertCell(2);
            Label lMajor = new Label(String.valueOf(b.getMajor()));
            tcMajor.appendChild(lMajor.getElement());

            TableCellElement tcMinor = tr.insertCell(3);
            Label lMinor = new Label(String.valueOf(b.getMinor()));
            tcMinor.appendChild(lMinor.getElement());

            TableCellElement tcAction = tr.insertCell(4);
            tcAction.setAttribute("class", "text-center");

            HTML beaconConfigView = new HTML("<i class=\"fa fa-cogs\"></i>");
            beaconConfigView.setStyleName("label label-default");
            beaconConfigView.addStyleName("handpointer");
            Element beaconConfigElement = beaconConfigView.getElement();
            tcAction.appendChild(beaconConfigElement);
            Event.sinkEvents(beaconConfigElement, Event.ONCLICK);
            Event.setEventListener(beaconConfigElement, new EventListener() {
                @Override
                public void onBrowserEvent(Event event) {
                    System.out.println("ok");
                    if (Event.ONCLICK == event.getTypeInt()) {
                        listener.goTo(new BeaconsConfigPlace("", b));
                    }
                }
            });

            HTML beaconChartView = new HTML("<i class=\"fa fa-bar-chart-o\"></i>");
            beaconChartView.setStyleName("label label-info");
            beaconChartView.addStyleName("handpointer");
            Element beaconChartViewElement = beaconChartView.getElement();
            tcAction.appendChild(beaconChartViewElement);
            Event.sinkEvents(beaconChartViewElement, Event.ONCLICK);
            Event.setEventListener(beaconChartViewElement, new EventListener() {
                @Override
                public void onBrowserEvent(Event event) {
                    if (Event.ONCLICK == event.getTypeInt()) {
                        listener.goTo(new BeaconsAnalyticsPlace("", b));
                    }
                }
            });
            i++;

            /*
             <input type="checkbox" name="workCompleted" ui:field="mWorkCompleted"
             class="custom" />
                
             Event.sinkEvents(mWorkCompleted, Event.ONCHANGE);
             Event.setEventListener(mWorkCompleted, new EventListener() {

             @Override
             public void onBrowserEvent(Event event) {

             }
             });
             */
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
                
        Element home = DOM.getElementById("home");
        Event.sinkEvents(home, Event.ONCLICK);
        Event.setEventListener(home, new EventListener() {
            @Override
            public void onBrowserEvent(Event event) {
                if (Event.ONCLICK == event.getTypeInt()) {
                    listener.goTo(new DashBoardPlace(""));
                }
            }
        });        
    }

    interface BeaconsViewImplUiBinder extends UiBinder<Widget, BeaconsViewImpl> {
    }
    Presenter listener;
    @UiField
    SpanElement spanName;

    @Override
    public void setUserData(User authenticatedUser) {
        spanName.setInnerText(authenticatedUser.getName());
    }

    public BeaconsViewImpl() {
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
    TableElement table;

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
}