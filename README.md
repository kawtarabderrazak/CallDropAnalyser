# Call Drop Analyzer: A Comprehensive Guide

## Project Overview

Call Drop Analyzer is a web-based application designed to help telecommunications engineers and network analysts identify, diagnose, and address call interruption issues within mobile networks. This tool combines data visualization with analytics to pinpoint problematic zones and improve overall service quality by also validating data types from all levels from database, api to user browser. This implementation is using Spring Boot for the backend, and Leaflet js  for a responsive user interface, using also java and javascript for data type validation by objects implementations, and testing them before sending objects to the user interface.

## Key Features

*   **Interactive Map Visualization**: Displays call drop locations on an interactive map using Leaflet JS, allowing for easy identification of problematic areas.

*   **Data-Driven Analytics**: Provides tools to fetch, filter, and analyze call data within a defined timeframe.

*   **Customizable Timeframe:** Input fields for choosing a specific start and end time for data selection, providing users control over the range of data analysis.

*   **Dynamic Markers with Popups**: Shows the information of every interrupted calls with a tooltip popup with all relevant data from that records object values, data and settings

*   **Default Object Setting Implementations:** Use a default implementation to provide stable objects for data with types to validation that core function do not crash due wrong configuration settings for data or for objects. Those type of validations is also used before access to database layers, and also when displaying it at the html / javascript level.
 
* **Valid object type implementation for Leaflet configurations** if user required to modify path to images, markers, with valid objects, all settings must implemented correct. To not generate a hidden errors related those configurations
    

*   **Robust Data Handling** Uses validation implementation by object types, to ensure that data is correct before performing operations.  Also use default settings object for types, when values are not correct. So the code should not generate an error if a value is not defined or is invalid from database / API / or HTML when mapping objects from javascript

## Technologies Used

*   **Backend:** Java, Spring Boot
*   **Database:** MySQL
*   **Frontend:** HTML, CSS, JavaScript, Leaflet JS
*   **API:**  Spring MVC with Rest Controllers
*   **Dependency Management** Maven.

## Setting Up Your Environment
1.  **Database Configuration**:
    * Create a database and set up tables for `appel` and `zone` with the structure described in the project documentation.
    *   Ensure SQL types from table column are all defined also ( if using string,  integer type ,  time or date etc).
    *  Use the SQL console with ` select * from table ` verify data, format of types are consistent (or if there are null values). It also is good implementation that the type of those values are tested during setup or database object creation
2.   **Java Setup**
    * Import the project in a valid  Java IDE ( Intelij Idea/ Eclipse etc.. ).
    *   Validate that dependency ( from `pom.xml` is correctly configured before the implementation code compilation and that all libraries that you used during project implementation, are available in settings).
    *    Apply correct values on your `application.properties/yml ` for database configuration.
3.  **Project Code Structure:**

    - **src/main/java:** Contains source code (java classes) with main implementation ( models, service and controllers, repositories for database access). Also logging configuration are available for debugging from Java. The objects must implements proper types, from validations
    - **src/main/resources:** Folder for setting up  configuration, public static resources ( all js / css / images / icons), from framework configurations type implementation from  Spring Boot projects ( if static folder is use). All objects used here, must implement valid path
     - all javascript / html, css implementation are inside public.
4.  **API access Validation and Code type implementations**
   - Build and Run the application, by using IDE or `mvn spring-boot:run`
    - Check if api works before  moving for  html testing: Using browser or tools like POSTMAN / or equivalent to validate those URLs and that they all return `200 Ok` ( with a valid json if  an API endpoint). And also the object types during implementation is configured from java (if any logging are present) if object has valid attributes
     - API validations step is to ensure a valid implementation of backend before to access by  html javascript code

## Usage Video

https://github.com/user-attachments/assets/c6b19309-7201-4e8d-9445-45e0011f694f





 
## Usage Guide
1.  **Access the application** by typing ` http://localhost:8080/ ` on your browser (or url, used by your application with the default  ` index.html`  )

 2.  **Set your date range values** using the date / time pickers ( you can use also default implementation ).  This implementation settings uses validated objects, and parameters at html also for input time/date  types for valid javascript setting and for a valid types of String values
     
3.   ** Click `refresh`  ** button to refresh and load and display updated data from the application server by calling the API endpoint and render data based leaflet settings

 **How to Test  and debug for data mapping problems/type problems/ configuration problems**: ( if errors appeared with leaflet/ mapping / data)

* **SQL Validation and tests for database data :** Always by doing SQL queries as you were doing during all project implementation testing steps (using a SQL client). To ensure that type of data you are using / accessing is correct or that  data exist with properties that your classes and java object and jpa queries are using for all those validation type of object mappings. And also that implementation settings works for database layer. ( they must pass using previous setting). If SQL data is invalid. all type data processing and mapping on next implementation layers might fail . So this is required before testing code for other layers also
   

* **Java API validation:** After all data from SQL is validated : use the `/api` to access your methods from the server if they work correctly by object implementation ( where  data , are being type, and object setting by a default implementation with try/catch and also with debugger by stepping line to line when setting objects ).  Also see the implementation if has type problem during framework mapping, java object to json.

*  **HTML / Javascript type check :**  when you use implementations of libraries  also for the  Leaflet API or javascript. Using debugger from browser or  `console.log` ( for a quick test implementation also ). Always set breakpoints before using  ` L.marker ` function. Verify objects  data types from previous steps , object mapping implementations , also configurations are all ok, before you use or create Leaflet elements by Javascript type settings.   That all attributes, properties type of those objects are what you are expecting ( to avoid unexpected behaviour or type errors) . If leaflet library is not configured correctly a default map is not going to appear. And If data values are not properly mapped, leaflet will do a wrong rendering ( or not render anything). So focus on that part of configurations using debugging to view the implementation of those objects and their data types.
*  
