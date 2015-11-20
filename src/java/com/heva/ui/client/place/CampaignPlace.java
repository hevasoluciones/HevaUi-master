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
public class CampaignPlace extends Place {
	
	private String CampaignName;

	public CampaignPlace(String token) {
		this.CampaignName = token;
	}

	public String getCampaignName() {
		return CampaignName;
	}

	public static class Tokenizer implements PlaceTokenizer<CampaignPlace> {

		@Override
		public String getToken(CampaignPlace place) {
			return place.getCampaignName();
		}

		@Override
		public CampaignPlace getPlace(String token) {
			return new CampaignPlace(token);
		}

	}
}
