✧🧳₊˚.🎧⋆☾⋆⁺₊✧✧🧳₊˚.🎧⋆☾⋆⁺₊✧✧🧳₊˚.🎧⋆☾⋆⁺₊✧✧🧳₊˚.🎧⋆☾⋆⁺₊✧✧🧳₊˚.🎧⋆☾⋆⁺₊✧
# Travel and Tourism Management System

An integrated desktop-based Travel and Tourism Management System built in Java. Aimed at streamlining travel bookings and management for tourists through a user-friendly interface.

### Features:
- User authentication (i.e login/logout)
- Search, book, and manage travel packages (hotels, package)
- Administrative panel to add/edit packages
- Itinerary overview and management(view user details, view package)
- Data persistence(data stays even after application stops running) using database MySQL

### How to run this project locally:
- Prerequisites
  - Java JDK 8 or higher
  - IDE (Eclipse / IntelliJ IDEA / NetBeans) or terminal
  - MySQL Database installed and running

- To run the project
  - Clone this repository
  - Open terminal
     ```bash
       git clone https://github.com/Tejasvi-Tikoo/Travel-Tourism.git
       cd Travel-Tourism
       ```
  - Open project in IDE
    - Go to File → Open Project and select the cloned folder
    - Wait for dependencies (if any JARs are included) to load
  
  - Set up the database
    - Open MySQL
    - Create a new database (example: travel_tourism)
    - Import the SQL file provided in the project (e.g., travel_tourism.sql)
    - Update your DB credentials in the project (look for a config.properties file or inside the DB connection class)
  
  - Compile and run the project
    - If using IDE → run the Main class (or App.java)
    - If using terminal:
    - ```bash
      javac -cp ".;lib/*" -d bin src/com/yourpackage/*.java
      java -cp "bin;lib/*" com.yourpackage.MainClass
        ```

### Tech Stack  

- **Programming Language:** Java (Core Java, OOP concepts) 
- **Database:** MySQL (JDBC for connectivity) 
- **Build Tool:** IDE build (NetBeans)
- **Version Control:** Git & GitHub 
