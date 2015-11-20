/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.shared;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author rafael.rosabal@gmail.com
 */
public class VisitsRegionSpec implements IsSerializable {
    
  private  String region;
  private   List<Visits>  visits = new ArrayList<Visits>();     

    public VisitsRegionSpec() {       
       
    }
  
  

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Visits> getVisits() {
        return visits;
    }

    public void setVisits(List<Visits> visits) {
        this.visits = visits;
    } 
    
}
