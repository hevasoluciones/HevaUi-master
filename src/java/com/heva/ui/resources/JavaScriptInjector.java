/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;

/**
 *
 * @author Rafa
 */
public class JavaScriptInjector extends AbstractInjector {

	/**
	 * Injects the JavaScript code into a
	 * {@code <script type="text/javascript">...</script>} element in the
	 * document header.
	 * 
	 * @param javascript
	 *            the JavaScript code
	 */
	public static void inject(String javascript) {
		HeadElement head = getHead();
		ScriptElement element = createScriptElement();
		element.setText(javascript);
		head.appendChild(element);
	}

	private static ScriptElement createScriptElement() {
		ScriptElement script = Document.get().createScriptElement();
		script.setAttribute("type", "text/javascript");
        script.setAttribute("charset", "UTF-8");
		return script;
	}

}
