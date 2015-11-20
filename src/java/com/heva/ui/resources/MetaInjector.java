/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.MetaElement;

/**
 *
 * @author Rafa
 */
public class MetaInjector extends AbstractInjector {

	/**
	 * Puts a meta tag with the given name and content into the document header.
	 * 
	 * @param name
	 *            the value of the {@code name} attribute.
	 * @param content
	 *            the value of the {@code content} attribute.
	 */
	public static void inject(String name, String content) {
		HeadElement head = getHead();
		MetaElement element = createMetaElement();
		element.setName(name);
		element.setContent(content);
		head.appendChild(element);
	}

	private static MetaElement createMetaElement() {
		return Document.get().createMetaElement();
	}
}
