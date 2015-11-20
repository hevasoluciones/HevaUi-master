package com.heva.ui.client.mvp;

import com.heva.ui.client.place.AuthenticatorPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.heva.ui.client.place.BeaconsAnalyticsPlace;
import com.heva.ui.client.place.BeaconsConfigPlace;
import com.heva.ui.client.place.BeaconsPlace;
import com.heva.ui.client.place.CampaignPlace;
import com.heva.ui.client.place.DashBoardPlace;
import com.heva.ui.client.place.EditCampaignPlace;
import com.heva.ui.client.place.NewCampaignPlace;
import com.heva.ui.client.place.SignUpPlace;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the
 *
 * @WithTokenizers annotation or by extending PlaceHistoryMapperWithFactory and
 * creating a separate TokenizerFactory.
 */
@WithTokenizers({AuthenticatorPlace.Tokenizer.class ,
                 SignUpPlace.Tokenizer.class,
                 DashBoardPlace.Tokenizer.class,
                 BeaconsPlace.Tokenizer.class,
                 CampaignPlace.Tokenizer.class,
                 BeaconsConfigPlace.Tokenizer.class,
                 BeaconsAnalyticsPlace.Tokenizer.class,
                 NewCampaignPlace.Tokenizer.class,
                 EditCampaignPlace.Tokenizer.class
                })

public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
