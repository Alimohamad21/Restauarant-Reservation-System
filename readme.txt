-Our restaurant reservation system is a very user friendly,efficient and good looking system.

-Firstly,You are opted to log in with your account, if you have one already, we also added the sign in option If you don't already have an account.

-You are allowed to create as many users as you want through the sign up option , but You can't choose a username that has already been taken,We also
validated the required fields to some degree,Then the account info is added to the input xml file in our system.

-Now back to the log in menu,You need to enter the correct username, password and also select your role in order to proceed to the next screen.

-If you are a customer,You will proceed to the next screen that welcomes you with your name in which you can choose a table.

-We have assumed a maximum of 8 tables in order to make the interface better looking and more efficient (4 smoking,4 non-smoking) 
which are all dynamically loaded from the xml input file.

-The tables look like as if they were arranged in an actual restaurant,Each table with it's maximum number of seats written on it ,If
a table was already reserved , A blank space is in place of it so that it can't be reserved again.

-You have to choose a table in order to proceed to the next screen, otherwise an error message will appear.

-After choosing a table,You are provided with the restaurant's menu which is dynamically loaded from the xml file,We have also assumed
a maximum of 6 main dishes,3 appetizers,3 desserts in order to make the interface look better.

-You have to choose a minimum of n dishes,where n is the number of persons on the table in order to proceeed.

-After confirming your reservation it is appended to the reservations file in our system, and you will move on to the next screen with full description
of your order(ordered dishes,total price of the order).

-If you are a waiter,You will proceed to the employees screen where you can see the name and table number of all reservations.

-If you are a cook,You will proceed to the employees screen where you can see the order dishes and table number of all reservations.

-If you are a manager,You will proceed to the employees screen where you can see the full details of all reservations and the total income of the 
restaurant.

-We have also added some features to the manager like clearing all reservations and removing a certain reservation at a table
(Warning:You need to double click the confirm button in order to see the changes after removing a certain reservation).

-Division of labour:

1)Ali:


-Analyzed the design process.
-logic.Customer classes and Controllers.
-logic.Manager class and Controller.
-Sign up feature.
-appending to reservations file and dealing with it's data.
-logic for calculating.


2)Khaled:

-Created the UML diagram.
-File handling.
-logic.Waiter class and Controller.
-logic.Cook class and Controller.
-Delete reservations feature for the manager.

-In general we split most of the work in half so that we both contributed to everything.
-Note:use cmd commant java -jar JAR-NAME.jar to run jar file




