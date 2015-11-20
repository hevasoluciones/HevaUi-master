/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.heva.ui.shared.Beacon;

/**
 *
 * @author Yasmani
 */
public class BeaconsAnalyticsPlace  extends Place {

    private String BeaconsAnalyticsName;
    private Beacon beacon;

    public BeaconsAnalyticsPlace(String token) {
        this.BeaconsAnalyticsName = token;
    }

    public BeaconsAnalyticsPlace(String token, Beacon b) {
        this.BeaconsAnalyticsName = token;
        if (b != null) {
            this.beacon = b;
        }
    }

    public String getBeaconsAnalyticsName() {
        return BeaconsAnalyticsName;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = beacon;
    }

    public static class Tokenizer implements PlaceTokenizer<BeaconsAnalyticsPlace> {

        @Override
        public String getToken(BeaconsAnalyticsPlace place) {
            return place.getBeaconsAnalyticsName();
        }

        @Override
        public BeaconsAnalyticsPlace getPlace(String token) {
            return new BeaconsAnalyticsPlace(token);
        }
    }
}
