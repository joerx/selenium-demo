# selenium-demo
Basic setup for a selenium project using Maven, able to run test in Firefox via Xvfb

- Project setup as in [here](http://www.wunderkraut.com/blog/creating-and-running-a-simple-selenium-webdriver-test/2011-09-15)
- Running headless as described [here](http://www.installationpage.com/selenium/how-to-run-selenium-headless-firefox-in-ubuntu/) - 
  Vagrant box included

## Running Headless Tests

- Boot up vagrant, the ssh into the box: `vagrant up && vagrant ssh`
- Start Xvfb: `sudo Xvfb :10 -ac`, keep it running
- In a new terminal window, ssh into running box:

```
cd /vagrant
export DISPLAY=:10
mvn clean test
```

- Successful test should leave a `screenshot.png` in the project dir