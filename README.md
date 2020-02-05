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

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

