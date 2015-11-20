/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.widget.core.client.info.Info;

/**
 *
 * @author yasmani
 */
public class MessagesPublisherImpl extends Composite implements MessagesPublisher {

    //@UiField
    //HTML htmlMessage;
    
    @Override
    public void showMessage(String header, String text, String type) {
        /*
        htmlMessage.setHTML("");
        String staticMessage1 = "<div class=\"alert alert-block alert-";
        String staticMessage2 = "\" style=\"margin-bottom:-10px\" >\n"
                + "<a class=\"close\" data-dismiss=\"alert\" href=\"#\"><i class=\"icon-large icon-remove-circle\"></i></a>\n"
                + "<h4 class=\"alert-heading\">";
        String staticMessage3 = "</h4>\n";
        String staticMessage4 = "\n</div>";

        htmlMessage.setHTML(staticMessage1 + type + staticMessage2 + header + staticMessage3 + text + staticMessage4);
        */
        
        Info.display(header, text);
    }
}
