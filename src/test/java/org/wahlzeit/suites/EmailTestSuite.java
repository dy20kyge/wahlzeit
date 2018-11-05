package org.wahlzeit.suites;

import org.junit.runner.*;
import org.junit.runners.*;



@RunWith(Suite.class)
@Suite.SuiteClasses({
    org.wahlzeit.services.mailing.EmailServiceTest.class,
    org.wahlzeit.services.EmailAddressTest.class
})

public class EmailTestSuite {
    //Do nothing
}