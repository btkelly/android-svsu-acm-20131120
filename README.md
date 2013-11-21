# Android Demo App for SVSU ACM 11/20/2013
=========================

This repo includes 5 projects at various stages of development.

Step 1 - App with basic list view

Step 2 - App with button for moving to the add screen.

Step 3 - App with ability to actually add items to your list

Step 4 - App with ability to delete items by long pressing on an item

Final  - App that will persist list between app launches

Launch app in command line by moving into the root of the step and running the following command:

mvn clean install -Dmaven.test.skip=true android:deploy android:run

Instuctions using Android Studio

1. Open Studio and click import project.
2. Navigate to the root folder todotoal and select it
3. Select import from external model and select Maven
4. On the next screen check the following additional boxes
  -Search for projects recursively
  -Import Maven projects automatically
  -Create module groups for multi-module Maven projects
5. Lastly you will have to create run configurations for each step. Do this using the drop down at the top and click edit configs. Click the + symbol and create a new Maven config. Set the root of the config to the root of the step you would like to build. In the command line section paste the following command.

clean install -Dmaven.test.skip=true android:deploy android:run
