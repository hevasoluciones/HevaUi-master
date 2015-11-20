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
public class SignUpPlace extends Place {
	
	private String SignUpName;

	public SignUpPlace(String token) {
		this.SignUpName = token;
	}

	public String getSignUpName() {
		return SignUpName;
	}

	public static class Tokenizer implements PlaceTokenizer<SignUpPlace> {

		@Override
		public String getToken(SignUpPlace place) {
			return place.getSignUpName();
		}

		@Override
		public SignUpPlace getPlace(String token) {
			return new SignUpPlace(token);
		}

	}
}