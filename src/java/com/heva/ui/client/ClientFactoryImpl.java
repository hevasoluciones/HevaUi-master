package com.heva.ui.client;

import com.heva.ui.client.event.HevaUiEventBus;
import com.heva.ui.client.view.AuthenticatorView;
import com.heva.ui.client.view.AuthenticatorViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.heva.ui.client.view.beacons.BeaconsAnalyticsView;
import com.heva.ui.client.view.beacons.BeaconsAnalyticsViewImpl;
import com.heva.ui.client.view.beacons.BeaconsConfigView;
import com.heva.ui.client.view.beacons.BeaconsConfigViewImpl;
import com.heva.ui.client.view.beacons.BeaconsView;
import com.heva.ui.client.view.beacons.BeaconsViewImpl;
import com.heva.ui.client.view.campaign.CampaignView;
import com.heva.ui.client.view.campaign.CampaignViewImpl;
import com.heva.ui.client.view.campaign.EditCampaignView;
import com.heva.ui.client.view.campaign.EditCampaignViewImpl;
import com.heva.ui.client.view.campaign.NewCampaignView;
import com.heva.ui.client.view.campaign.NewCampaignViewImpl;
import com.heva.ui.client.view.dashboard.DashBoardView;
import com.heva.ui.client.view.dashboard.DashBoardViewImpl;
import com.heva.ui.client.view.signup.SignUpView;
import com.heva.ui.client.view.signup.SignUpViewImpl;
import com.heva.ui.shared.User;

public class ClientFactoryImpl implements ClientFactory {

    private static final User autenticatedUser = new User();
    private static final EventBus eventBus = new HevaUiEventBus();
    private static final GWTServiceAsync rpcService = GWT.create(GWTService.class);
    private static final PlaceController placeController = new PlaceController(eventBus);
    private static final AuthenticatorView authenticatorView = new AuthenticatorViewImpl();
    private static final SignUpView signUpView = new SignUpViewImpl();
    private static final DashBoardView dashBoardView = new DashBoardViewImpl();
    private static final BeaconsView beaconsView = new BeaconsViewImpl();
    private static final BeaconsConfigView beaconsConfigView = new BeaconsConfigViewImpl();
    private static final BeaconsAnalyticsView beaconsAnalyticsView = new BeaconsAnalyticsViewImpl();    
    private static final CampaignView campaignView = new CampaignViewImpl();
    private static final NewCampaignView newCampaignView = new NewCampaignViewImpl();
    private static final EditCampaignView editCampaignView = new EditCampaignViewImpl();
    
    public ClientFactoryImpl() {
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public AuthenticatorView getAuthenticatorView() {
        // TODO Auto-generated method stub
        return authenticatorView;
    }

    @Override
    public GWTServiceAsync getRpcService() {
        return rpcService;
    }

    @Override
    public User getAuthenticatedUser() {
        return autenticatedUser;
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public SignUpView getSignUpView() {
        return signUpView;
    }

    @Override
    public DashBoardView getDashBoardView() {
        return dashBoardView;
    }

    @Override
    public BeaconsView getBeaconsView() {
        return beaconsView;
    }

    @Override
    public CampaignView getCampaignView() {
        return campaignView;
    }

    @Override
    public BeaconsConfigView getBeaconsConfigView() {
        return beaconsConfigView;
    }

    @Override
    public BeaconsAnalyticsView getBeaconsAnalyticsView() {
        return beaconsAnalyticsView;
    }

    @Override
    public NewCampaignView getNewCampaignView() {
        return newCampaignView;
    }

    @Override
    public EditCampaignView getEditCampaignView() {
        return editCampaignView;
    }

}
