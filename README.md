# helios
A tool for illuminating your spending habits.

## To run Helios:
1. Download the jar, helios.jar, to your computer.
2. Open a Terminal window.
3. Navigate to the directory containing helios.jar.
4. Execute "java -jar helios.jar".
  1. The application will start up.
  2. Look for the line "Tomcat started on port(s): 9000 (http)", which indicates the server has completed startup and is ready.
5. Open a browser and navigate to "http://localhost:9000".
### Note: No log file will be generated for Helios but log messages can be viewed in the Terminal window where you launched Helios.

## To shutdown Helios:
  In the Terminal window running Helios, press "Ctrl + c".

## Requirements:
  Helios requires Java 8 and an active internet connection.

## About:
  Helios runs on an embeded Tomcat instance serving the Helios Spring Boot API and acting as a web server for the Angular 2 client. Unfortunately, the client is not fully implemented so some of the navigations options will direct you out of the client and return a raw JSON from the API. In these cases, please use your browser's back button to return to the Helios client.  
