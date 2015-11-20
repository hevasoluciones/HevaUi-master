/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.heva.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.heva.ui.config.Configurator;

/**
 *
 * @author Rafa
 */
public interface Resources extends ClientBundle {

	public static Resources RESOURCES = GWT.create(Resources.class);

	/**
	 * Returns the Bootstrap CSS file.
	 * <p>
	 * Override this method to use your own CSS file.
	 * 
	 * @return the Bootstrap CSS file
	 */
	// Imported as a TextResource until GWT supports CSS3.
	/*@Source("css/bootstrap.min.css")
	TextResource bootstrapCss();*/
	
	/**
	 * Returns the required jQuery version.
	 * <p>
	 * By default, GWT Bootstrap uses jQuery 1.x. Override this method to
	 * provide a different version of jQuery.
	 * 
	 * @return the jQuery JavaScript Library
	 */
	/*@Source("js/jquery-1.11.0.min.js")
	TextResource jquery();*/

	/**
	 * Returns a version of Bootstrap with all plugins included.
	 * <p>
	 * The first three digits in the GWT Bootstrap version number specify the
	 * provided Bootstrap version. (GWT Bootstrap 2.0.4.0 uses Bootstrap 2.0.2.
	 * GWT Bootstrap 2.1.2.3 will use Bootstrap 2.1.2.)
	 * </p>
	 * <p>
	 * 
	 * Override this method to provide a different version of Bootstrap. You
	 * might want to chose a more lightweight implementation without some of the
	 * plugins. <b>This may break some widgets!</b>
	 * 
	 * @return the Bootstrap JavaScript
	 */
	/*@Source("js/bootstrap.min.js")
	TextResource bootstrapJs();*/

	/**
	 * Returns the responsive extension to Bootstrap.
	 * <p>
	 * The responsive design is neither injected nor activated by default. You
	 * have to implement your own {@link Configurator} and let
	 * {@link Configurator#hasResponsiveDesign()} return {@code true}.
	 * </p>
	 * <p>
	 * 
	 * Override this method to provide a different version of the responsive
	 * extension. <b>This may break some widgets!</b>
	 * 
	 * @return the Bootstrap responsive extension JavaScript
	 */
	@Source("js/bootstrap/dist/css/bootstrap.css")
	TextResource bootstrap();

        @Source("js/jquery.gritter/css/jquery.gritter.css")
	TextResource jquerygrittercss();
        
        @Source("js/jquery.gritter/css/font-awesome.min.css")
	TextResource fontawesomemincss();
        
        @Source("js/jquery.nanoscroller/nanoscroller.css")
	TextResource nanoscrollercss();
        
        
        @Source("js/jquery.codemirror/lib/codemirror.csss")
	TextResource codemirrorcsss();
        
        @Source("js/jquery.codemirror/theme/ambiance.css")
	TextResource ambiancecsss();
        
        @Source("js/jquery.vectormaps/jquery-jvectormap-1.2.2.css")
	TextResource jvectormapcsss();
        
        @Source("js/bootstrap.switch/bootstrap-switch.min.css")
	TextResource bootstrapswitchmincss();
        
        @Source("js/jquery.x-editable/dist/bootstrap3-editable/css/bootstrap-editable.css")
	TextResource bootstrapeditablecss();
        
        @Source("js/jquery.x-editable/src/inputs-ext/typeaheadjs/lib/typeahead.js-bootstrap.css")
	TextResource typeaheadjsbootstrapcss();
        
         @Source("js/jquery.select2/select2.css")
	TextResource select2css();
        
         @Source("js/bootstrap.wysihtml5/dist/bootstrap3-wysihtml5.min.css")
	TextResource wysihtml5css();
        
         @Source("js/bootstrap.summernote/dist/summernote.css")
	TextResource summernotecss();
        
         @Source("js/jasny.bootstrap/extend/css/jasny-bootstrap.min.css")
	TextResource jasnycss();
        
         @Source("css/style.css")
	TextResource stylecss();
        
         @Source("mycss.css")
	TextResource mycss();
        
        
        
        
        
	/**
	 * Returns the GWT-Bootstrap CSS.
	 * <p>
	 * It contains styles that overrides conflicting GWT styles.
	 * </p>
	 * <p>
	 * <b>Don't override this unless you know what you're doing!</b>
	 * </p>
	 * 
	 * @return the GWT-Bootstrap styles
	 */
	/* @Source("css/gwt-bootstrap.css")
	TextResource gwtBootstrapCss();

      @Source("css/font-awesome.min.css")
        TextResource fontAwesomeCss();*/

        
        
        
	@Source("js/jquery.js")
	TextResource jqueryjs();
        
        @Source("js/jquery.cookie/jquery.cookie.js")
	TextResource jquerycookiejs();
        
        @Source("js/jquery.pushmenu/js/jPushMenu.js")
	TextResource jPushMenujs();
        
	@Source("js/jquery.nanoscroller/jquery.nanoscroller.js")
	TextResource nanoscrollerjs();
        
	@Source("js/jquery.sparkline/jquery.sparkline.min.js")
	TextResource sparklinejs();
        
        @Source("js/jquery.ui/jquery-ui.js")
	TextResource jqueryuijs();
        
        @Source("js/jquery.gritter/js/jquery.gritter.js")
	TextResource gritterjs();
        
        @Source("js/behaviour/core.js")
	TextResource corejs();
        
        @Source("js/bootstrap/dist/js/bootstrap.min.js")
	TextResource bootstrapminjs();
        
        @Source("js/ckeditor/ckeditor.js")
	TextResource ckeditorjs();
        
        @Source("js/ckeditor/adapters/jquery.js")
	TextResource adaptersjs();
         
        @Source("js/bootstrap.summernote/dist/summernote.min.js")
	TextResource summernotejs();
        
        @Source("js/bootstrap.wysihtml5/dist/wysihtml5-0.3.0.js")
	TextResource wysihtml5js();
        
        @Source("js/bootstrap.wysihtml5/dist/bootstrap3-wysihtml5.all.min.js")
	TextResource wysihtml5alljs();
        
         @Source("js/jquery.select2/select2.min.js")
	 TextResource select2js();
         
            @Source("js/jasny.bootstrap/extend/js/jasny-bootstrap.min.js")
	 TextResource jasnybootstrapminjs();
         
         @Source("js/jquery.flot/jquery.flot.js")
	TextResource jqueryflotjs();
        
         @Source("js/jquery.flot/jquery.flot.pie.js")
	TextResource jqueryflotpiejs();
        
          @Source("js/jquery.flot/jquery.flot.resize.js")
	TextResource jqueryflotresizejs();
        
          @Source("js/jquery.flot/jquery.flot.labels.js")
	TextResource jqueryflotlabelsjs();
        

}