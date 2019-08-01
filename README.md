# Ashok_Developer_Here

Technologies I have used In this Project:
Programming Language: Java
Testing tool: Selenium
FrameWork: Cucumber
DesignPattern: PageObject Model

->Before execute this project make sure Java Installed in your system.

->Make sure Browser name and driver path mentioned in config.properties file in Configuration package.

->make sure Feature file path is correct in CucumberOptions block in Runner class 

* Aim of this project

1.Load https://developer.here.com/documentation and check if page loads properly and angular is initialized

2.Find all links on page that are internal to documentation site (/documentation). Ignore anything that points outside https://developer.here.com/documentation) – external links or links in header/footer that are not related to documentation

3.For each link check if page loads and angular is initialized

4.Fail test if page doesn’t load or angular is not initialized
 
