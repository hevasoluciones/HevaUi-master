/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 *
 * @author Yasmani
 */
public class BeaconsPlace extends Place {
	
	private String BeaconsName;

	public BeaconsPlace(String token) {
		this.BeaconsName = token;
	}

	public String getBeaconsName() {
		return BeaconsName;
	}

	public static class Tokenizer implements PlaceTokenizer<BeaconsPlace> {

		@Override
		public String getToken(BeaconsPlace place) {
			return place.getBeaconsName();
		}

		@Override
		public BeaconsPlace getPlace(String token) {
			return new BeaconsPlace(token);
		}

	}
}
