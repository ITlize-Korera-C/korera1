Current Testing Environment

For Eclipse using : 

1.File -> Import -> Existing Maven Project

2.Redirect the SQL to your own local environment

3.For the first time using this project, please change the values under :
   src/main/recources/db.properties
   hibernate.hbm2ddl.auto=create

   This is because confliction may occur if you do not have the table with the fixed name inside your local database
   After the first time, you will never need to do this again and should change the create to update

4.Maven Upgrade
5.run as -> clean install
6.run on the server ( Tomcat in my case )
7.Using mySQL may have some issue due to Case Sensitive problem
8.Still working on: 1) Fetching all resources using one project ID 2)Have a stable version for MySQL to access 
