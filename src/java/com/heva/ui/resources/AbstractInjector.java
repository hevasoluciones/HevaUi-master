/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources;


import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
/**
 *
 * @author Rafa
 */
public abstract class AbstractInjector {

	private static HeadElement head;

	/**
	 * Gets the document header.
	 * 
	 * @return the document header
	 */
	protected static HeadElement getHead() {
		if (head == null) {
			Element element =
					Document.get().getElementsByTagName("head").getItem(0);
			assert element != null : "HTML Head element required";
			HeadElement head = HeadElement.as(element);
			AbstractInjector.head = head;
		}
		return AbstractInjector.head;
	}
}
