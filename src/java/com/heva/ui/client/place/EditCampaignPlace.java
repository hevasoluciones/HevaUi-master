/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.heva.ui.shared.Beacon;
import com.heva.ui.shared.Campaign;

/**
 *
 * @author Yasmani
 */
public class EditCampaignPlace extends Place {

    private String EditCampaignName;
    private Campaign campaign;

    public EditCampaignPlace(String token) {
        this.EditCampaignName = token;
    }

    public EditCampaignPlace(String token, Campaign c) {
        this.EditCampaignName = token;
        if (c != null) {
            this.campaign = c;
        }
    }

    public String getEditCampaignName() {
        return EditCampaignName;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign c) {
        this.campaign = c;
    }

    public static class Tokenizer implements PlaceTokenizer<EditCampaignPlace> {

        @Override
        public String getToken(EditCampaignPlace place) {
            return place.getEditCampaignName();
        }

        @Override
        public EditCampaignPlace getPlace(String token) {
            return new EditCampaignPlace(token);
        }
    }
}
