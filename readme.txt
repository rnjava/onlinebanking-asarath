//db.dbname.load("C:\mongo_test_data_scripts.js")







URL to login for users

Bank Customer
Tenant1 - HSBC

http://localhost:8080/onlinebanking/customer/login?tenantid=C63A953AE20D404F8BB1F225CBC82CF0


Tenant 2 Bank of america
http://localhost:8080/onlinebanking/customer/login?tenantid=CCCEDA89EC74479AB5C20AF7ACCD789D


Bank Employee (Staff & Admin)

http://localhost:8080/onlinebanking/employee/stafflogin?tenantid=CCCEDA89EC74479AB5C20AF7ACCD789D



Product Admininistrator
http://localhost:8080/onlinebanking/productadmin/adminlogin








Steps to deploy the  new code.
----------------------------------

1. Do SVN update.

2. Use maven to build a new war file  from onlinebanking root folder (where the pom.xml exists)
   mvn clean package

3. Stop tomcat if running. Delete the onlinebaking.war and onlinebaking folder from <TOMCAT_HOME>\webapps\ folder

4. copy <onlinebanking rootfolder>\target\onlinebanking.war to <TOMCAT_HOME>\webapps\ folder

5. start the tomcat by using <TOMCAT_HOME>\bin\startup.bat

6. Make sure mongo is running before login to the application