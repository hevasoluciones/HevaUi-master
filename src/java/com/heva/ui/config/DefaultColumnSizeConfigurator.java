/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.config;

import com.heva.ui.constants.Constants;

/**
 *
 * @author Rafa
 */
public class DefaultColumnSizeConfigurator implements ColumnSizeConfigurator {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaximumSpanSize() {
        return Constants.MAXIMUM_SPAN_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumSpanSize() {
        return Constants.MINIMUM_SPAN_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaximumOffsetSize() {
        return getMaximumSpanSize() - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumOffsetSize() {
        return getMinimumSpanSize() -1;
    }

}
