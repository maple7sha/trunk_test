package com.trunk.selenium.trunkTestSuit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
Trunk_test1_login.class,
Trunk_test2_upload.class,
Trunk_test3_tuftsNow.class,
Trunk_test4_communication.class,
Trunk_test5_mysetting.class,
})

public class Test_suite{
}


/**
import junit.framework.Test;
import junit.framework.TestSuite;
import com.trunk.selenium.trunkTestSuit.*;


public class Test_suite {
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(Trunk_test1_login.class);
    suite.addTestSuite(Trunk_test2_upload.class);
    suite.addTestSuite(Trunk_test3_tuftsNow.class);
    suite.addTestSuite(Trunk_test4_communication.class);
    suite.addTestSuite(Trunk_test5_mysetting.class); 
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}

**/
