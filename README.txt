README:

Goal:
Implement Jenkins Selenium test suite for Trunk.tufts.edu, first on local machine, eventually on headless server.

Main test items in the test suites:
1. Login
2. Upload files 
3. TuftsNow
4. Communications
5. Mysettings

Implementation Approach:
-pom
-java junit 4
-Selenium Webdriver 2.34.0

Documentation on Maven_opt:

-(motivation)The purpose of using the functionality of Maven_opt is to parameterize the site to be tested, username&password, and sample file locations for easier program reuse.

-(configuration)Go to Jenkins project configuration, under Build, Goals and options, enter the following code:
'compile test -D[paramtername]="value_for_this_parameter"';
#Example Code: 
'compile test -DsakaiHostName="https://trunk-stage.tufts.edu" -DsakaiHostUsername=@haowan -DsakaiHostPassword=nawoah -Dsampletxt_addr=C:\\Users\\VEK\\Desktop\\sample.txt -Dsamplejpg_addr=C:\\Users\\VEK\\Desktop\\sample.jpg'
(Here we have multiple parameters prefixed with -D)

-(method to use the passed in parameters)In the java test files, we can retrieve the value of given parameter in the following way: 
String variable = System.getProperty("parameter_name")
#Example Code (continued from the example above): 
String username = System.getProperty("sakaiHostUsername")