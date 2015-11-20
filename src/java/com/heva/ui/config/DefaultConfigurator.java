/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.config;

import com.heva.ui.resources.Resources;

/**
 *
 * @author Rafa
 */
public class DefaultConfigurator implements Configurator {

	/**
	 * {@inheritDoc}
	 */
        @Override
	public Resources getResources() {
		return Resources.RESOURCES;
	}

	/**
	 * {@inheritDoc}
	 */
        @Override
	public boolean hasResponsiveDesign() {
		return false;
	}

}