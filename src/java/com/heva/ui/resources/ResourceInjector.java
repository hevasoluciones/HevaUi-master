/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources;



import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;
import com.heva.ui.config.Configurator;
import com.heva.ui.resources.internal.InternalResourceInjector;
/**
 *
 * @author Rafa
 */
public class ResourceInjector {

    private static final Configurator ADAPTER = GWT.create(Configurator.class);
    
    private static final InternalResourceInjector INJECTOR = GWT.create(InternalResourceInjector.class);

    private static HeadElement head;

    /**
     * Injects the required CSS styles and JavaScript files into the document header.
     * <pre>
     * It's for NoStyle Module.
     * </pre>
     */
    public static void configureWithCssFile() {
        
       /* injectResourceCssAsFile("bootstrap.min.css");
        injectResourceCssAsFile("font-awesome.min.css");*/

        configure();
        
    }
    
    /**
     * Injects the required CSS styles and JavaScript files into the document
     * header.
     */
    public static void configure() {
        INJECTOR.preConfigure();

        Resources res = ADAPTER.getResources();
        if(isNotLoadedJquery()) 
            injectJs(res.jqueryjs());

           injectJs(res.bootstrapminjs());
           injectJs(res.jquerycookiejs());
           injectJs(res.jPushMenujs());
           injectJs(res.nanoscrollerjs());
           injectJs(res.sparklinejs());
           injectJs(res.jqueryuijs());
           injectJs(res.gritterjs());
           injectJs(res.corejs());
           injectJs(res.bootstrapminjs());
           injectJs(res.ckeditorjs());
           injectJs(res.adaptersjs());
           injectJs(res.summernotejs());
           injectJs(res.wysihtml5js());
           injectJs(res.wysihtml5alljs());
           injectJs(res.select2js());
           injectJs(res.jasnybootstrapminjs());
           injectJs(res.jqueryflotjs());
           
           injectJs(res.jqueryflotpiejs());
           injectJs(res.jqueryflotresizejs());
           injectJs(res.jqueryflotlabelsjs());
             
          
         
           

        if (ADAPTER.hasResponsiveDesign())
            activateResponsiveDesign(res);

        INJECTOR.configure();
    }

    private native static boolean isNotLoadedJquery() /*-{
        return !$wnd['jQuery'] || (typeof $wnd['jQuery'] !== 'function');
    }-*/;

    private static void injectCss(TextResource r) {
        StyleInjector.inject(r.getText());
    }

    /**
     * Inject public resource css file as a file.
     * @param filename inject file name
     */
    public static void injectResourceCssAsFile(String filename) {
        LinkElement link = Document.get().createLinkElement();
        link.setType("text/css");
        link.setRel("stylesheet");
        link.setHref(GWT.getModuleBaseURL() + "css/" + filename);
        getHead().appendChild(link);
    }

    private static HeadElement getHead() {
        if (head == null) {
            Element elt = Document.get().getElementsByTagName("head").getItem(0);
            assert elt != null : "The host HTML page does not have a <head> element"
                    + " which is required by StyleInjector";
            head = HeadElement.as(elt);
        }
        return head;
    }

    private static void injectJs(TextResource r) {
        JavaScriptInjector.inject(r.getText());
    }

    private static void activateResponsiveDesign(Resources res) {
        injectCss(res.bootstrap());
        MetaInjector
                .inject("viewport", "width=device-width, initial-scale=1.0");
    }

}
