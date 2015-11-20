package com.heva.ui.client;

import com.heva.ui.client.view.AuthenticatorView;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.heva.ui.client.view.beacons.BeaconsAnalyticsView;
import com.heva.ui.client.view.beacons.BeaconsConfigView;
import com.heva.ui.client.view.beacons.BeaconsView;
import com.heva.ui.client.view.campaign.CampaignView;
import com.heva.ui.client.view.campaign.EditCampaignView;
import com.heva.ui.client.view.campaign.NewCampaignView;
import com.heva.ui.client.view.dashboard.DashBoardView;
import com.heva.ui.client.view.signup.SignUpView;
import com.heva.ui.shared.User;

public interface ClientFactory {

    User getAuthenticatedUser();

    GWTServiceAsync getRpcService();

    EventBus getEventBus();

    PlaceController getPlaceController();

    AuthenticatorView getAuthenticatorView();

    public SignUpView getSignUpView();

    public DashBoardView getDashBoardView();

    public BeaconsView getBeaconsView();

    public CampaignView getCampaignView();

    public BeaconsConfigView getBeaconsConfigView();

    public BeaconsAnalyticsView getBeaconsAnalyticsView();

    public NewCampaignView getNewCampaignView();

    public EditCampaignView getEditCampaignView();
    
}
