/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources;

import com.heva.ui.base.Style;
import com.heva.ui.constants.Constants;

/**
 *
 * @author Rafa
 */
public enum ButtonSize implements Style {

	DEFAULT(""), LARGE("large"), SMALL("small"), MINI("mini");

	private String className;

	private ButtonSize(String className) {
		this.className = className;
	}

	public String get() {
		if (className.isEmpty())
			return className;
		else
			return Constants.BTN + "-" + className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}
