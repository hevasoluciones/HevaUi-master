package com.heva.ui.client.mvp;

import com.heva.ui.client.ClientFactory;
import com.heva.ui.client.activity.AuthenticatorActivity;
import com.heva.ui.client.place.AuthenticatorPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.heva.ui.client.activity.BeaconAnalyticsActivity;
import com.heva.ui.client.activity.BeaconsActivity;
import com.heva.ui.client.activity.BeaconsConfigActivity;
import com.heva.ui.client.activity.CampaignActivity;
import com.heva.ui.client.activity.DashBoardActivity;
import com.heva.ui.client.activity.EditCampaignActivity;
import com.heva.ui.client.activity.NewCampaignActivity;
import com.heva.ui.client.activity.SignUpActivity;
import com.heva.ui.client.place.BeaconsAnalyticsPlace;
import com.heva.ui.client.place.BeaconsConfigPlace;
import com.heva.ui.client.place.BeaconsPlace;
import com.heva.ui.client.place.CampaignPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.place.EditCampaignPlace;
import com.heva.ui.client.place.NewCampaignPlace;
import com.heva.ui.client.place.SignUpPlace;


public class AppActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    /**
     * AppActivityMapper associates each Place with its corresponding
     * {@link Activity}
     *
     * @param clientFactory Factory to be passed to activities
     */
    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    /**
     * Map each Place to its corresponding Activity. This would be a great use
     * for GIN.
     */
    @Override
    public Activity getActivity(Place place) {
        // This is begging for GIN
        if (place instanceof AuthenticatorPlace) {
            return new AuthenticatorActivity((AuthenticatorPlace) place, clientFactory);
        } else if (place instanceof SignUpPlace) {
            return new SignUpActivity((SignUpPlace) place, clientFactory);
        } else if (place instanceof DashBoardPlace) {
            return new DashBoardActivity((DashBoardPlace) place, clientFactory);
        } else if (place instanceof BeaconsPlace) {
            return new BeaconsActivity((BeaconsPlace) place, clientFactory);
        } else if (place instanceof CampaignPlace) {
            return new CampaignActivity((CampaignPlace) place, clientFactory);
        } else if (place instanceof BeaconsConfigPlace) {
            return new BeaconsConfigActivity((BeaconsConfigPlace) place, clientFactory);
        } else if (place instanceof BeaconsAnalyticsPlace) {
            return new BeaconAnalyticsActivity((BeaconsAnalyticsPlace) place, clientFactory);
        } else if (place instanceof NewCampaignPlace) {
            return new NewCampaignActivity((NewCampaignPlace) place, clientFactory);
        } else if (place instanceof EditCampaignPlace) {
            return new EditCampaignActivity((EditCampaignPlace) place, clientFactory);
        }        
        return null;
    }
}
