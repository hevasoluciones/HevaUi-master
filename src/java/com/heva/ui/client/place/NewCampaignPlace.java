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
public class NewCampaignPlace  extends Place {
	
	private String NewCampaignName;

	public NewCampaignPlace(String token) {
		this.NewCampaignName = token;
	}

	public String getNewCampaignName() {
		return NewCampaignName;
	}

	public static class Tokenizer implements PlaceTokenizer<NewCampaignPlace> {

		@Override
		public String getToken(NewCampaignPlace place) {
			return place.getNewCampaignName();
		}

		@Override
		public NewCampaignPlace getPlace(String token) {
			return new NewCampaignPlace(token);
		}

	}
}
