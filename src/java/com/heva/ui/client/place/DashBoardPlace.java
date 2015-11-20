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
public class DashBoardPlace extends Place {
	
	private String DashBoardName;

	public DashBoardPlace(String token) {
		this.DashBoardName = token;
	}

	public String getDashBoardName() {
		return DashBoardName;
	}

	public static class Tokenizer implements PlaceTokenizer<DashBoardPlace> {

		@Override
		public String getToken(DashBoardPlace place) {
			return place.getDashBoardName();
		}

		@Override
		public DashBoardPlace getPlace(String token) {
			return new DashBoardPlace(token);
		}

	}
}
