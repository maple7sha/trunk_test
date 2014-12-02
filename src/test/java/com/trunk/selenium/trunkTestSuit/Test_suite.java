package com.trunk.selenium.trunkTestSuit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	Trunk_test1_login.class,
	Trunk_test2_upload.class
	Trunk_test3_tuftsNow.class,
	Trunk_test4_communication.class,
	Trunk_test5_mysetting.class,
    Trunk_test6_membership.class,
    Trunk_test7_preference.class
})

public class Test_suite{
}

