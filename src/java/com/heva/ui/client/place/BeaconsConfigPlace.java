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
public class BeaconsConfigPlace extends Place {

    private String BeaconsConfigName;
    private Beacon beacon;

    public BeaconsConfigPlace(String token) {
        this.BeaconsConfigName = token;
    }

    public BeaconsConfigPlace(String token, Beacon b) {
        this.BeaconsConfigName = token;
        if (b != null) {
            this.beacon = b;
        }
    }

    public String getBeaconsConfigName() {
        return BeaconsConfigName;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = beacon;
    }

    public static class Tokenizer implements PlaceTokenizer<BeaconsConfigPlace> {

        @Override
        public String getToken(BeaconsConfigPlace place) {
            return place.getBeaconsConfigName();
        }

        @Override
        public BeaconsConfigPlace getPlace(String token) {
            return new BeaconsConfigPlace(token);
        }
    }
}
