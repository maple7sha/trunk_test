package com.trunk.selenium.trunkTestSuit;
import junit.framework.Test;
import junit.framework.TestSuite;
import com.trunk.selenium.trunkTestSuit.*;


public class Test_suite {
  public static TestSuite suite() {
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



