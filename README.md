# Computer Science II
## Project - Database

This project is part of  Computer Science II (CSCE 156) for Fall 2025 
in the [School of Computing](https://computing.unl.edu) 
at the [University of Nebraska-Lincoln](https://www.unl.edu).

## Overview

### Lab Objectives & Topics

After completing this lab, you should be able to:
* Establish a JDBC connection to a database server
* Use JDBC to query and process a result set from a database server
* Use JDBC to insert new data into or delete existing data from a database
* Design database tables in 3NF (Third Normal Form) 


### Peer Programming Pair-Up

At the beginning of each project, you may find a team member on your own.  Please ***sign
up for a group on Canvas*** (`People`, then `Groups`, and then join a group for `Project 2`), and only one group member needs to
submit your project on Canvas.  If you prefer to work on this project by yourself, that is fine too.



## 1. Relation to Project 1

This project is independent of Project 1, although both projects develop Jstgram. You do not need to reuse your code from Project 1. In fact, it is recommended not to use your Project 1 code because of the significant differences between these two projects.


## 2. Social Media Application - Jstgram

In this project, we will design and develop a database version for *Jstgram*. 

### 2.1 Database

All information should be stored on the database server `nuros.unl.edu`. Please write a MySQL initialization script to set up the database before Jstgram starts. The MySQL initialization script creates the tables and inserts the predefined user and post data as specified below.

### 2.2 Users

To simplify the project, your application does not need to support adding or deleting users. Instead, we will use the MySQL initialization script to add a predefined group of users to the database. 

A user can log into Jstgram using their unique username and password. 

Your MySQL initialization script should add the following information to the database before Jstgram starts.
*  Four users with usernames: Alice, Bob, Crystal, and David, and their respective passwords: Alice123, Bob123, Crystal123, and David123.

### 2.3 Posts

To simplify the project, your application only needs to support the text posts. That is, users can publish text posts only (no text art posts as in Project 1).

Your MySQL initialization script must add the following information to the database before Jstgram starts.
  * Alice posted "When's the project due?" at 13:20:00 on November 20, 2025
  * Bob posted "After Thanksgiving" at 13:20:30 on November 20, 2025
  * David posted "Great job, me" at 15:22:00 on November 22, 2025
  * Alice posted "Lab this week?" at 17:24:00 on November 24, 2025
  * Crystal posted "Nope" at 17:24:30 on November 24, 2025

### 2.4 Post Visibility

A user can manage who sees the user's posts by setting a visibility list. A post is visible to those included in this list, as well as to the user who made the post. 

Your MySQL initialization script should add the following visibility lists to the database before Jstgram starts.
  * The visibility list of Alice contains Bob and Crystal. That is, Alice's posts are visible to Bob, Crystal, and Alice.
  * The visibility list of Bob contains Alice and Crystal.
  * The visibility list of Crystal contains Alice.
  * The visibility list of David is empty. That is, David's posts are visible to only David.


  
## 3. Jstgram Windows

### 3.1 Main Window

When Jstgram starts, it should first connect to the database server and retrieve the current number of users in the database (as added by your MySQL initialization script). If successful, it displays that information in the *Main Window* as shown below. 

<p align="center">
<img src="images/main_win.png" alt="Main Window" width="40%"/>
</p>  

It then prompts for the username and password. If these credentials match the information in the database, this user becomes the current user, and Jstgram proceeds to the *Account Window*.

### 3.2 Account Window

The *Account Window* for Alice is shown below as an example. 

<p align="center">
<img src="images/account_win.png" alt="Account Window" width="40%"/>
</p>  
 
The current user can choose to view posts, edit post visibility, or quit the application.

### 3.3 Post Window

The *Post Window* lists all posts visible to the current user in the *ascending* order of post times (i.e., from the oldest post to the latest post). 

Below are examples of the *Post Window* for Alice, Bob, Crystal, and David, respectively, based on the database initialized with the MySQL script. Note that different users see different lists of posts. For example, Crystal can see the posts of Alice, Bob, and Crystal, because both Alice's and Bob's posts are visible to Crystal. 

<p align="center">
<img src="images/post_win_alice.png" alt="Post Window" width="40%"/>
<img src="images/post_win_bob.png" alt="Post Window" width="40%"/>
<img src="images/post_win_crystal.png" alt="Post Window" width="40%"/>
<img src="images/post_win_david.png" alt="Post Window" width="40%"/>
</p>  

The current user can choose to publish a new post, or return back to the *Account Window*. If a new post is published, both the database and the *Post Window* should be updated accordingly.

### 3.4  Visibility Window

The *Visibility Window* shows the visibility list of the current user. 

Below are examples of the Visibility Window for Alice, Bob, Crystal, and David, respectively, based on the database initialized with the MySQL script.

<p align="center">
<img src="images/visibility_win_alice.png" alt="Visibility Window" width="40%"/>
<img src="images/visibility_win_bob.png" alt="Visibility Window" width="40%"/>
<img src="images/visibility_win_crystal.png" alt="Visibility Window" width="40%"/>
<img src="images/visibility_win_david.png" alt="Visibility Window" width="40%"/>
</p>  


The current user can choose to add a user to their visibility list, delete a user from their visibility list, or go back to the account window. If a user is added or deleted, both the database and the *Visibility Window* should be updated accordingly.

Note that, only a user already in the database can be added to the visibility list, and only a user already in the visibility list can be deleted from the visibility list.

## 4. Project Requirement

### 4.1 Database Design

Design a database to capture the following information

  * User details: userID, username, password, visibility list, where userID is unique and username is also unique.
  * Post details: postID, postText, postTime, the user who published the post. 

Feel free to add additional information as needed. Feel free to name your tables and attributes. If you plan to use natural join, ensure at least one common column between the two tables.

Your tables must adhere to the third normal form (3NF), meaning they should have no group of values for an attribute, no partial dependencies, and no transitive dependencies.

You will write the MySQL initialization script from scratch. Name it `dbinit.sql`.

***Recommendation***

  * Utilize `auto_increment` for primary keys to avoid keeping track of the largest integer in Java when inserting new rows.
  * Use `int`, `varchar(n)`, and `char(n)` data types that we have studied and are familiar with.
  * Define postTime (i.e., the date and time of a post) as a `varchar(255)` in the database and as `LocalDateTime` in Java.
     * From database to Java: use `LocalDateTime.parse(String)` to convert a postTime from a string to a `LocalDateTime`.
     * From Java to database: use `postTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")` to convert a postTime from a `LocalDateTime` to a string in the specified format.
     * In addition, use `LocalDateTime.now()` in Java to get the current date and time. 
  * If necessary,  use the more flexible `on` clause for a join select statement. For example, `Table1 natural inner join Table2` is equivalent to `Table1 inner join Table2 on Table1.col=Table2.col` if they have a common column `col`. The `on` clause is more flexible because it can join two tables on columns with different  names or only some common columns.

### 4.2 Java Code Design

Write your Java program to correctly show the necessary information in each window (e.g., list of posts in the *Post Window*). The exact format of the windows can differ from the provided screenshots.

You will write all the code from scratch. You are recommended to follow the JDBC lecture slides to define appropriate Java classes, such as 
* `Main.java` as the main class for ease of execution by LAs
* `Database.java` containing database connection parameters for easy debugging and modification by LAs.
* Two classes (one for data and the other for database access) for each table. For example, `Post.java` and `PostDAO.java` for the Post table. 
* Two classes (one for query result and the other for database access) for each complex query.
* `View.java` for interacting with the users 

```Java
public class Database {
	// JDBC driver parameters
	public final static String hostname = "nuros.unl.edu";
	public final static String username = "xxx"; // your database username
	public final static String password = "xxx"; // your database password
	public final static String url = "jdbc:mysql://"+hostname+"/"+username;

   ...

}
```

Follow the following steps to install a JDBC driver to your project
  * Download the driver at https://dev.mysql.com/downloads/connector/j/
    * Select an `Operating System`, like `Platform Independent`
    * Download the tar or zip file, and open it
  * Add mysql-connector-j-x.x.x.jar to your project
    * Right-click the project, select `New`, select `Folder`, name it `lib`
    * Copy mysql-connector-j-x.x.x.jar to the `lib` file folder
    * Right-click the project, select `Refresh`
    * Right-click the mysql-connector-j-x.x.x.jar file in the `lib` folder of the project, select `Build Path` then `Add to Build Path`




## 5. Grading and Submitting Your Project

 
### 5.1 Submitting to Canvas

Submit the following to Canvas. Our LAs will manually grade them.

1. `Project2.jar`: Follow the instructions below to generate a runnable JAR file that the LAs can execute.
   *  Step 1: Run your project at least once (create a `Launch Configuration` for step 4)
   *  Step 2: Right-click your project, and select `Export ...`
   *  Step 3: In the `Java` folder, select `Runnable JAR file`, then click `Next`
   *  Step 4: In the `Runnable JAR File Specification` dialog
       * select your project in `Launch Configuration`
       * select `Package required libraries into generated JAR` for `Library handling`
       * click the `Browse` button to choose the directory to save your JAR file, and change the filename to `Project2.jar`
       * then click the `Finish` button
   * Type `java -jar Project2.jar` in the command line to test whether your JAR runs correctly. 

   ***Note that please do not change your database password, because the LAs will directly execute your JAR file that uses your database username and password***
   

2. `dbinit.sql`: The MySQL initialization script. The LAs will run it to initialize your database before running your JAR file.  Please include your MySQL password as a comment on the first line of your script so that the LAs can manually type your password when running your script. For example: 
```sql
-- MySQL password: your_password_here
```

3. `Project2.zip`: Follow the instructions below to generate a ZIP file of all project source files that the LAs can read and check.
   *  Step 1: Right-click your project, and select `Export ...`
   *  Step 2: In the `General` folder, select `Archive File`, then click `Next`
   *  Step 3: In the `Export Archive File` dialog
       * click the `Select All` button to select all files of your project
       * ensure `Save in zip format` is selected
       * click the `Browse` button to choose the directory to save your ZIP file, and change the filename to `Project2.zip`
       * then click the `Finish` button 

4. `design.pdf`: Design document as described in the next section.



Again, if you plan to work with one other student on this project, please sign
up for a group on Canvas (`People`, then `Groups`, and then join a group for `Project 2`), and only one group member needs to submit your project on Canvas.

### 5.2 Grading by LAs

#### 5.2.1. Design Document (35 points)

  * Introduction (5 points): Provide a short introduction to your application. For example, what features and functionality does it provide at a high level? Who will use the application?

  * ER Diagram (5 points): Present an Entity-Relational (ER) Diagram illustrating all your database tables and their relationships. You can utilize tools like  MySQL Workbench or free https://drawsql.app/ to automatically generate an ER Diagram from your MySQL code. 

  * 3NF Compliance (5 points): Provide a justification for 3NF compliance of all your database tables. That is, justify that they have no group of values for an attribute, no partial dependencies, and no transitive dependencies.
  
  * UML Diagram (5 points): Display a Unified Modeling Language (UML) diagram to represent all your Java classes and their relationships. The [PlantUML plugin](https://github.com/cbourke/ComputerScienceII/blob/master/resources/uml.md) for Eclipse can be employed to automatically generate a UML diagram from your Java code.

  * Mapping (5 points): Describe the correspondence between database tables and Java classes, including a brief rationale. For example, identify which Java class stores the data of each database table.

  * Post Window (5 points): Describe how you get all posts visible to the current user. There are several different methods. For example, one method involves a single well-designed join select statement to directly retrieve these posts from the database server. Alternatively, one could first use a select statement to retrieve the list of users whose posts are visible to the current user, followed by one or more select statements to retrieve their posts from the database server.     

  * Testing (5 points): Describe how you test each component and the overall application.
    
  * Bonus Features: Describe each bonus feature that you have implemented and how LAs can use these features. 
    
  Note: the mapping and post-window questions are open-ended. 

  [`design.docx`](design.docx) is a Word template for the design document.

#### 5.2.2. MySQL and Java Code (65 points): 

  * Submission (5 points): Submitted all required files: `Project2.jar`, `dbinit.sql`, `Project2.zip`, and `design.pdf`. You will lose these points if the LA has to contact you for missing files. 

  * MySQL Initialization Script (10 points): The first line is your MySQL password, and your script successfully creates the tables and inserts the predefined data into the database.
  
  * Main Window (5 points): Correctly display the current number of users. 

  * Account Window (5 points): Correctly validate the username and password before entering the Account Window. 

  * Post Window (15 points): Correct post display and functionality for new posts.
     * 10 points: Correctly display all posts visible to the current user in the *ascending* order of post times (i.e., from the oldest post to the latest post).
     * 5 points: Correctly publish a new post and update the database accordingly

  * Visibility Window (25 points): Correct visibility list display and functionality for editing the list.
     * 5 points: Correctly display the visibility list of the current user. 
     * 5 points: Correctly add a user to a visibility list. Note that only a user already in the database can be added to the visibility list.
     * 5 points: Correctly delete a user from a visibility list.   Note that only a user already in the visibility list can be deleted from the visibility list.
     * 10 points: Correctly display new post windows after updating visibility lists. For example, after Alice adds David to Alice's visibility list, David can see Alice's posts in David's post window. 

#### 5.2.3. Bonus Features (Additional points)
  
  * Comments and Coding Style (Bonus 5 points): Javadoc-style comments on methods; Class documentation that includes name, date made, and purpose of class; Variable names that match style (meaningful names and camelCase); Appreciate and consistent use of white space (mainly regarding proper use of indention); Not having dead code (i.e., commented out unused code).

  * Create New Accounts (Bonus 5 points): Enable users to create new accounts.
  
  * Delete Accounts (Bonus 5 points): Allow users to delete their current account. Ensure complete removal of user data, including username, password, visibility, and posts, from the database in the correct sequence.  

  * Sorting Posts (Bonus 5 points): Allow users to choose how to sort the posts in the *Post Window*. In addition to the default ascending order of postTime, users can choose from the following additional orderings: descending order of postTime, ascending or descending order of usernames of the posts.  

  * Like Posts (Bonus 20 points):  Enable users to like and unlike posts visible to them. The like information should be visible to all users who can view the post. Design a new table or add a new attribute to existing tables, ensuring continued adherence to 3NF.

  * Admin Accounts (Bonus 10 points): There are two types of users: normal users and admin users. A user is a normal user by default. An admin user can access the *Admin Window*, where the admin user can specify new admin users, create new user accounts, delete any existing accounts, view all posts in the database, and sort the posts in different orderings mentioned above as well as by the number of likes of a post. In our example, make David an admin user.

  * LaTex Report (Bonus 2 points): Write the design document in LaTex (e.g., using www.overleaf.com), which is a typesetting system widely used for creating beautifully formatted documents, especially those containing complex elements like mathematical formulas, tables, and bibliographies. Please submit all your LaTex source files in the Project2.zip file. 
  
You are encouraged to demonstrate the functionality of your Jstgram, particularly the bonus features, to our LAs for feedback and assessment.

Your design document should describe each bonus feature that you have implemented and how LAs can use these features.
 

## Credit

This project was originally designed by Jianghao Wang. David Ryckman, Olwen Nguyen, and Amy Nguyen, helped to revise and improve it. 
