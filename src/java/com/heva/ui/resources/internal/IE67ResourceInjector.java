/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources.internal;

import com.heva.ui.resources.ResourceInjector;

/**
 *
 * @author Rafa
 */
public class IE67ResourceInjector extends LowVersionIEResourceInjector {

    @Override
    public void configure() {
        super.configure();
        ResourceInjector.injectResourceCssAsFile("font-awesome-ie7.css");
    }
}
