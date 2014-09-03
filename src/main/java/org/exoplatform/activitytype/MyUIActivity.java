package org.exoplatform.activitytype;

/**
 * Created by kmenzli on 03/09/2014.
 */
import org.exoplatform.webui.core.lifecycle.UIFormLifecycle;

import org.exoplatform.webui.config.annotation.ComponentConfig;

import org.exoplatform.social.webui.activity.BaseUIActivity;


@ComponentConfig(

        lifecycle = UIFormLifecycle.class,

        template = "classpath:groovy/org/exoplatform/activitytype/MyUIActivity.gtmpl"

)
public class MyUIActivity  extends BaseUIActivity {

}
