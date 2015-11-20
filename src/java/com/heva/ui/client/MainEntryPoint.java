/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.heva.ui.client.mvp.AppActivityMapper;
import com.heva.ui.client.mvp.AppPlaceHistoryMapper;
import com.heva.ui.client.place.AuthenticatorPlace;




/**
 * Main entry point.
 *
 * @author Yasmani
 */
public class MainEntryPoint implements EntryPoint {

    private Place defaultPlace = new AuthenticatorPlace("Authenticator");
    private SimplePanel appWidget = new SimplePanel();

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        
        
       
        // Create ClientFactory using deferred binding so we can replace with
        // different
        // impls in gwt.xml 
        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();
        
        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper,
                eventBus);
        activityManager.setDisplay(appWidget);
        
        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT
                .create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
                historyMapper);
        
        historyHandler.register(placeController, eventBus, defaultPlace);
        
        RootPanel.get().clear();
        RootPanel.get().add(appWidget);
        
        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();
        
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
 
            
      
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.cookie/jquery.cookie.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
            
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.pushmenu/js/jPushMenu.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
            
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.nanoscroller/jquery.nanoscroller.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.sparkline/jquery.sparkline.min.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        
          ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.ui/jquery-ui.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
       
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.gritter/js/jquery.gritter.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/behaviour/core.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
              
          
          
         ScriptInjector.fromUrl( "http://rafa-laptop:8080/HevaUi/js/bootstrap/dist/js/bootstrap.min.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
            
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl( "http://rafa-laptop:8080/HevaUi/js/ckeditor/ckeditor.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl( "http://rafa-laptop:8080/HevaUi/js/ckeditor/adapters/jquery.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
            
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl( "http://rafa-laptop:8080/HevaUi/js/bootstrap.summernote/dist/summernote.min.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/bootstrap.wysihtml5/dist/wysihtml5-0.3.0.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl( "http://rafa-laptop:8080/HevaUi/js/bootstrap.wysihtml5/dist/bootstrap3-wysihtml5.all.min.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
                         
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.select2/select2.min.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
               
                 
            }   
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();

        
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jasny.bootstrap/extend/js/jasny-bootstrap.min.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
     
        
        ScriptInjector.fromString(" $(\".select2\").select2({ width: '100%'}); ").inject();
       
        
        
        /* String wysuhtml="$('#some-textarea').wysihtml5();";
         String summernote="$('#summernote').summernote();";
         ScriptInjector.fromString(wysuhtml)
        .setRemoveTag(false)
        .setWindow(ScriptInjector.TOP_WINDOW)
        .inject();
     
         ScriptInjector.fromString(summernote)
        .setRemoveTag(false)
        .setWindow(ScriptInjector.TOP_WINDOW)
        .inject();
         
         String scriptBody = "var foo = $('#some-textarea').wysihtml5();";
        ScriptInjector.fromString(scriptBody).setRemoveTag(false)
        .setWindow(ScriptInjector.TOP_WINDOW).inject();
         String scriptBod = "var foo = $('#summernote').summernote();";
        ScriptInjector.fromString(scriptBod).setRemoveTag(false)
        .setWindow(ScriptInjector.TOP_WINDOW).inject(); */
     
        
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.flot/jquery.flot.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
           
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
       
           ScriptInjector.fromUrl( "http://rafa-laptop:8080/HevaUi/js/jquery.flot/jquery.flot.pie.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
              
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.flot/jquery.flot.resize.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
        
        ScriptInjector.fromUrl("http://rafa-laptop:8080/HevaUi/js/jquery.flot/jquery.flot.labels.js").setCallback(new Callback<Void, Exception>() {

            @Override
            public void onFailure(Exception reason) {
              Window.alert("Script load failed.");
            }

            @Override
            public void onSuccess(Void result) {
                
                
      
             
            }
        }).setWindow(ScriptInjector.TOP_WINDOW).inject();
       
       
      
 
    }

 
      
       
 
    
        private native static boolean isNotLoadedJquery() /*-{
        return !$wnd['jQuery'] || (typeof $wnd['jQuery'] !== 'function');
    }-*/;

     
        
        public static native void select2Runner() /*-{
           var $select = $wnd.$(".select2").select2({
          width: '100%'
        });
              
             
             }-*/;
        
     public static native void chekedRunner() /*-{
     
     
     
       $wnd.$('textarea.ckeditor').ckeditor();
      CKEDITOR.disableAutoInline = true;
       $wnd.$(".inline-editable").each(function(){
        CKEDITOR.inline( $wnd.$(this)[0]);
      });
    
       $wnd.$('#some-textarea').wysihtml5();
       $wnd.$('#summernote').summernote();
   
             
             }-*/;
}