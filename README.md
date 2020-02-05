# PCShop Tests

This repository contains funcionality tests for the https://www.pcshop.hr/ website.

## Prerequisites

In order to run the test locally on your machine the following is needed:<br /> <br />
[IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)<br />
[Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)<br />
[Maven](https://maven.apache.org/download.cgi)<br />
[Chrome driver](https://chromedriver.chromium.org/)
[GIT](https://git-scm.com/downloads)

## Installing

### 1. Install IntelliJ IDEA

- Go to [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)<br />
- Run the downloaded executable file and follow the instruction to complete the setup <br />
- When the installation is complete, open IntelliJ IDEA and enable auto import for classes (a popup message should appear) <br />

### 2. Install Java JDK

- Go to [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)<br />
- Run the downloaded executable file and follow the instruction to complete the setup <br />

### 3. Install Maven

- Go to [Maven](https://maven.apache.org/download.cgi)<br />
- Download the binary zip archive<br />
- Open the .zip archive and extract it into C:\Program Files<br />
- Go to "This Computer", right click and select "Properties", a popup window will appear<br />
- On the left side search for "Advanced system settings" and open it, another popup window will appear<br />
- Look at the bottom of the window and open "Environment variables", a new popup window will appear<br />
- Under "System variables" search for the one called "Path", click on it and select "Edit"<br />
- Click "Browse" and select the bin folder located in C:\Program Files\apache-maven-x.x.x, click "OK"

### 4. Install Chrome driver

- Check your Chrome browser version<br />
- Go to [Chrome driver](https://chromedriver.chromium.org/)<br />
- Download the chrome driver for your version of chrome<br />
- Go to C:\Program Files and make a new folder called "drivers"<br />
- Place the downloaded chrome driver into your newly created folder<br />

### 5. Install GIT

- Go to [GIT](https://git-scm.com/downloads)<br />
- Run the downloaded executable file and follow the instruction to complete the setup <br />

## Downloading the repository

In order to download the project clone the repository to your Desktop or wherever you prefer.<br />
To do so right click on your prefered destination and chose "GIT Bash here", that will open a terminal.<br />
Inside the terminal paste the following and press enter.<br />
```
git clone https://github.com/hydro1337x/PcShopTests.git
```

## Running the tests

To run the tests open up IntelliJ IDEA and open the previously cloned project. <br />
In the top right corner click the green triangle or simply press Shift + F10<br />
<br />
**Optionaly:**<br />
If you want to automatically generate test reports with the surfire plugin click on "Terminal" located on the bottom of IntelliJ IDEA. Inside the terminal paste the following:<br />
```
mvn test
```
The reportes can be found inside your projects folder under "target\surefire-reports". Inside it, run index.html to view the reports.

## Test descriptions

### Search Test

Finds the search bar element, inside it a sequence of characters (search word) is inserted and the submit button is pressed. The sites opens a new instance of itself and a message label is displayed. If the text inside the message label is equeal to the search word the test passed.

### Add an item to the basket and delete it afterwards

Finds the tablet category and clicks on it, clicks on an item from the category, adds it to the basket, clicks on the basket to view its contents, remove element is pressed and a new instance of the site opens with a message label. If the message label text is equal to the default text it should display when a cart is empty the test passes.

### Registration test

Click on the registration button. A new instance of the site open with the registration form. All fields all filled up. The email is randomly generated so no changes need to be made by the tester to run the tests successfully. Submit button is pressed. The site automatically login the user in if the registration is complete and a sign out button appears. If the sign out button appears the test passes.

### Login test
The login test will always run after the registration test is done since it uses the same email adress as the registration.
Click on the login button. A new instance of the site open with the login form. Email and password fields are filled up. The email is randomly generated so no changes need to be made by the tester to run the tests successfully. Submit button is pressed. If the sign out button appears the test passes.

### Pick category on mouse hover

Hover over a category, select a subcategory and click on it. A new instance of the site opens with a message label. If the message label text is equal to the text which is contained inside the subcategory the test passes.
