package org.exoplatform.activitytype;

/**
 * Created by kmenzli on 03/09/2014.
 */

import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.security.ConversationState;
import org.exoplatform.social.core.activity.model.ExoSocialActivityImpl;
import org.exoplatform.social.core.identity.model.Identity;
import org.exoplatform.social.core.identity.provider.OrganizationIdentityProvider;
import org.exoplatform.social.core.manager.ActivityManager;
import org.exoplatform.social.core.manager.IdentityManager;
import org.exoplatform.wiki.mow.api.Page;
import org.exoplatform.wiki.service.listener.PageWikiListener;

public class GenerateMyActivity extends PageWikiListener {

    public static final String ACTIVITY_TYPE = "my-activity-type";

    private void generateActivity() throws Exception {

        // Get current user and assign to ownerStream

        String username = ConversationState.getCurrent().getIdentity().getUserId();

        IdentityManager identityM =

                (IdentityManager) PortalContainer.getInstance().getComponentInstanceOfType(IdentityManager.class);

        Identity userIdentity = identityM.getOrCreateIdentity(OrganizationIdentityProvider.NAME, username, false);

        Identity ownerStream = userIdentity;



        // New activity

        ExoSocialActivityImpl activity = new ExoSocialActivityImpl();

        activity.setUserId(userIdentity.getId());

        activity.setTitle("This is an activity of type <b>" + ACTIVITY_TYPE + "</b>.");

        activity.setBody("This is for testing");

        activity.setType(ACTIVITY_TYPE);



        // Save activity

        ActivityManager activityM =

                (ActivityManager) PortalContainer.getInstance().getComponentInstanceOfType(ActivityManager.class);

        activityM.saveActivityNoReturn(ownerStream, activity);



    }



    @Override

    public void postAddPage(String wikiType, String wikiOwner, String pageId, Page page) throws Exception {



        generateActivity();



    }



    @Override

    public void postDeletePage(String wikiType, String wikiOwner, String pageId, Page page) throws Exception {

        //

    }



    @Override

    public void postUpdatePage(String wikiType, String wikiOwner, String pageId, Page page, String wikiUpdateType) throws Exception {

        //

    }
}
