/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view.graph;

import ca.nanometrics.gflot.client.Axis;
import ca.nanometrics.gflot.client.DataPoint;
import ca.nanometrics.gflot.client.PlotModel;
import ca.nanometrics.gflot.client.SeriesHandler;
import ca.nanometrics.gflot.client.SimplePlot;
import ca.nanometrics.gflot.client.event.PlotHoverListener;
import ca.nanometrics.gflot.client.event.PlotItem;
import ca.nanometrics.gflot.client.event.PlotPosition;
import ca.nanometrics.gflot.client.jsni.Plot;
import ca.nanometrics.gflot.client.options.AxisOptions;
import ca.nanometrics.gflot.client.options.CanvasTextOptions;
import ca.nanometrics.gflot.client.options.GlobalSeriesOptions;
import ca.nanometrics.gflot.client.options.GridOptions;
import ca.nanometrics.gflot.client.options.LegendOptions;
import ca.nanometrics.gflot.client.options.LineSeriesOptions;
import ca.nanometrics.gflot.client.options.PlotOptions;
import ca.nanometrics.gflot.client.options.PointsSeriesOptions;
import ca.nanometrics.gflot.client.options.TickFormatter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.heva.ui.shared.Visits;
import java.util.List;

/**
 *
 * @author Yasmani
 */
public class DashBoardGraph extends Composite {

    private static DashBoardGraphUiBinder uiBinder = GWT.create(DashBoardGraphUiBinder.class);

    public void redraw() {
        plot.redraw();
    }

    interface DashBoardGraphUiBinder extends UiBinder<Widget, DashBoardGraph> {
    }

    public DashBoardGraph() {
        //initWidget(uiBinder.createAndBindUi(this));
    }
    /**
     * Plot
     */
    @UiField(provided = true)
    SimplePlot plot;
    @UiField
    Label hoverPoint;
    @UiField
    Label cursorPosition;
    private static final String[] MONTH_NAMES = {"jan", "feb", "mar", "apr",
        "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", ""};
    private static final String[] DAY_NAMES = {"sun", "mon", "tue", "wed",
        "thu", "fri", "sat", ""};
    private static final String[] HOUR_NAMES = {"00", "01", "02", "03", "04",
        "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
        "16", "17", "18", "19", "20", "21", "22", "23", ""};

    /**
     * Create plot
     */
    public Widget createPlot(List<Visits> visitList) {
        PlotModel model = new PlotModel();
        PlotOptions plotOptions = new PlotOptions();
        GlobalSeriesOptions gso = new GlobalSeriesOptions()
                .setLineSeriesOptions(
                new LineSeriesOptions().setShow(true).setFill(true));
        plotOptions.setGlobalSeriesOptions(gso);
        gso.setStack(null);


        LegendOptions legendOptions = new LegendOptions();
        legendOptions.setBackgroundOpacity(0.95);
        legendOptions.setPosition(LegendOptions.LegendPosition.NORTH_WEST);
        legendOptions.setShow(false);

        plotOptions.setLegendOptions(legendOptions);

        GridOptions go = new GridOptions();
        go.setClickable(true);
        go.setHoverable(true);
        go.setCanvasText(new CanvasTextOptions().setShow(true));
        go.setBorderColor("white");
        go.setBorderWidth(0);
                
        plotOptions.setGridOptions(go);
        
        plotOptions.getGlobalSeriesOptions()
                .setStack(null);
                        
        plotOptions.addXAxisOptions(new AxisOptions().setShow(false));
        plotOptions.addYAxisOptions(new AxisOptions().setShow(false));
        
        // create a series
        //SeriesHandler handlerTotal = model.addSeries("Total Visits", "#3D566D");
        SeriesHandler handlerBack = model.addSeries("Background Visits", "#D4D5D9");
        SeriesHandler handlerFor = model.addSeries("Foreground Visits", "#31B89B");

        // add data
        int i = 0;
        for (Visits v : visitList) {
            //handlerTotal.add(new DataPoint(i, v.getTotal_visits()));
            handlerFor.add(new DataPoint(i, v.getApp_in_foreground_visits()));
            handlerBack.add(new DataPoint(i, v.getApp_in_background_visits()));
            i++;
        }

        // create the plot
        plot = new SimplePlot(model, plotOptions);
        
        plot.addStyleName("whiteTheme");
        final PopupPanel popup = new PopupPanel();
        final Label label = new Label();
        label.setStyleName("labelHover");
        popup.add(label);

        // add hover listener
        plot.addHoverListener(new PlotHoverListener() {
            @Override
            public void onPlotHover(Plot plot, PlotPosition position, PlotItem item) {
                if (position != null) {
                    //cursorPosition.setText("Position : {x=" + position.getX() + ", y=" + position.getY() + "}");
                }
                if (item != null) {
                    String text = "Visitors of " + item.getDataPoint().getX() + " = " + item.getDataPoint().getY();
                    //hoverPoint.setText(text);
                    label.setText(text);
                    popup.setPopupPosition(item.getPageX() + 10, item.getPageY() - 25);
                    popup.show();
                } else {
                    //hoverPoint.setText("Some descriptive text");
                    popup.hide();
                }
            }
        }, false);

        return uiBinder.createAndBindUi(this);
    }
}