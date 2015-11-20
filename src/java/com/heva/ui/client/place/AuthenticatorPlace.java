package com.heva.ui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AuthenticatorPlace extends Place {
	
	private String authenticatorName;

	public AuthenticatorPlace(String token) {
		this.authenticatorName = token;
	}

	public String getAuthenticatorName() {
		return authenticatorName;
	}

	public static class Tokenizer implements PlaceTokenizer<AuthenticatorPlace> {

		@Override
		public String getToken(AuthenticatorPlace place) {
			return place.getAuthenticatorName();
		}

		@Override
		public AuthenticatorPlace getPlace(String token) {
			return new AuthenticatorPlace(token);
		}

	}
}