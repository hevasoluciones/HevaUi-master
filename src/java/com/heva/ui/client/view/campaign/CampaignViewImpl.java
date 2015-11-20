/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.campaign;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.heva.ui.client.place.BeaconsPlace;
import com.heva.ui.client.place.CampaignPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.place.EditCampaignPlace;
import com.heva.ui.client.place.NewCampaignPlace;
import com.heva.ui.client.view.MessagesPublisherImpl;
import com.heva.ui.shared.Campaign;
import com.heva.ui.shared.User;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public class CampaignViewImpl extends MessagesPublisherImpl implements CampaignView {

    private static CampaignViewImplUiBinder uiBinder = GWT.create(CampaignViewImplUiBinder.class);

    @UiField
    TableElement campaignTable;
    
    @Override
    public void setCampaignList(List<Campaign> campaignList) {
        int i = 0;
        TableSectionElement tbody = campaignTable.getTBodies().getItem(0);
        for (final Campaign cam : campaignList) {
            TableRowElement tr = tbody.insertRow(i);
            tr.setAttribute("class", "items");
            
            TableCellElement tdName = tr.insertCell(0);
            tdName.setInnerText(cam.getTitle());
            
            TableCellElement tdCat = tr.insertCell(1);
            tdCat.setAttribute("class", "text-right color-success");            
            tdCat.setInnerText(cam.getTags().get(0));
                        
            TableCellElement tcDate = tr.insertCell(2);                        
            tcDate.setInnerText(cam.getDate());
            
            TableCellElement tcOp = tr.insertCell(3);
            tcOp.setClassName("text-center");
            
            AnchorElement aEdit = Document.get().createAnchorElement();
            aEdit.setClassName("label label-default");
            aEdit.setInnerHTML("<i class=\"fa fa-pencil\"></i>");
            
            AnchorElement aDel = Document.get().createAnchorElement(); 
            aDel.setClassName("label label-danger");
            aDel.setInnerHTML("<i class=\"fa fa-times\"></i>");

            tcOp.appendChild(aEdit);
            tcOp.appendChild(aDel);
            
            Event.sinkEvents(aEdit, Event.ONCLICK);
            Event.setEventListener(aEdit, new EventListener() {
                @Override
                public void onBrowserEvent(Event event) {
                    System.out.println("ok");
                    if (Event.ONCLICK == event.getTypeInt()) {                        
                        listener.goTo(new  EditCampaignPlace("", cam));
                    }
                }
            });
            
            Event.sinkEvents(aDel, Event.ONCLICK);
            Event.setEventListener(aDel, new EventListener() {
                @Override
                public void onBrowserEvent(Event event) {
                    if (Event.ONCLICK == event.getTypeInt()) {
                        
                        listener.deleteCampaign(cam.getId());
                        Window.alert("Borrar " + cam.getTitle());
                    }
                }
            });
            i++;            
        }
    }

    interface CampaignViewImplUiBinder extends UiBinder<Widget, CampaignViewImpl> {
    }
    Presenter listener;
    @UiField
    SpanElement spanName;

    @Override
    public void setUserData(User authenticatedUser) {
        spanName.setInnerText(authenticatedUser.getName());
        
    }

    public CampaignViewImpl() {
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
        
        Element newLink = DOM.getElementById("newCampaign");
        Event.sinkEvents(newLink, Event.ONCLICK);
        Event.setEventListener(newLink, new EventListener() {
            @Override
            public void onBrowserEvent(Event event) {
                if (Event.ONCLICK == event.getTypeInt()) {
                    
                    listener.goTo(new NewCampaignPlace(""));
                }
            }
        });
    }
    
      
}