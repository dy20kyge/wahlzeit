package org.wahlzeit.suites;

import org.junit.runner.*;
import org.junit.runners.*;



@RunWith(Suite.class)
@Suite.SuiteClasses({
    org.wahlzeit.model.LocationTest.class,
    org.wahlzeit.suites.EmailTestSuite.class,
    
    org.wahlzeit.handlers.TellFriendTest.class,
    
    org.wahlzeit.model.AccessRightsTest.class,
    org.wahlzeit.model.FlagReasonTest.class,
    org.wahlzeit.model.GenderTest.class,
    org.wahlzeit.model.GuestTest.class,
    org.wahlzeit.model.LocationTest.class,
    org.wahlzeit.model.PhotoFilterTest.class,
    org.wahlzeit.model.LogoPhotoTest.class,
    org.wahlzeit.model.TagsTest.class,
    org.wahlzeit.model.UserStatusTest.class,
    org.wahlzeit.model.ValueTest.class,
    
    org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
    
    org.wahlzeit.services.EmailAddressTest.class,
    org.wahlzeit.services.LogBuilderTest.class,
    
    
    org.wahlzeit.utils.StringUtilTest.class,
    org.wahlzeit.utils.VersionTest.class
})

public class AllTests {
    //Do nothing
}