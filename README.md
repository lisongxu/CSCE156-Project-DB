# Computer Science II
## Project - Database

This project is part of  Computer Science II (CSCE 156) for Fall 2023 
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
up for a group on Canvas*** (`People` then `Groups`), and only one member of your group needs to
submit your project on Canvas.

## 1. Relation to Project 1

This project is independent of Project 1, although both projects develop Jstgram. You do not need to use use your code from Project 1. In fact it is recommendeded not to use your Project 1 code due to the significant differences between the projects.


## 2. Social Media Application - Jstgram

In this project, we will design and develop a database version for *Jstgram*. 

### 2.1 Database

All information should be stored on the database server `cse-linux-01.unl.edu`. Please write a MySQL initialization script to set up the database, such as creating tables and inserting initial user and post data as specified below, before Jstgram starts.

### 2.1 Users

To simplify the project, your applicaion does not need to support adding or deleting users. Instead, we will use the MySQL initialization script to add a predefined group of users into the database. 

A user can log into Jstgram using their unique username and password. 

Your MySQL initialization script should add the following information to the database before Jstgram starts.
*  Four users with usernames: Alice, Bob, Crystal, and David, and their respective passwords: Alice123, Bob123, Crystal123, David123.

### 2.2 Posts

To simplify the project, your application only needs to support the text posts. User can publish text posts only (no text art posts as in Project 1).

Your MySQL initialization script should add the following information to the database before Jstgram starts.
* Alice posted "Project deadline extended?" at 19:00:00 on October 12, 2023.
* Bob posted "Yep" at 19:01:00 on October 12, 2023.
* David posted "Fall break" at 09:00:00 on October 16, 2023
* Alice posted "Lab due tonight?" at 23:30:00 on October 27, 2023
* Crystal posted "No, it's due next week" at 23:35:00 on October 27, 2023

### 2.3 Post Visibility

Users can control the visibility of thir posts. Posts are alwasy visible to the poster and can be made visible to selected users. Specifcially, each user maintains a visibility list and the posts of the users are visible to the users in the visibility list.

Your MySQL initialization script should add the following information to the database before Jstgram starts.
* Alice's posts are visible to Bob and Crystal
* Bob's posts are visible to Alice and Crystal
* Crystal's posts are visible to Alice
* David's posts are not visible to other users.

  
## 3. Jstgram Windows

### 3.1 Main Window

When Jstgram starts, it should first connect to the database server and retrieve the current number of users in the database (as added by your MySQL initialization script). If successful, it displays that information in the *Main Window* as shown below. 

<p align="center">
<img src="images/main_win.png" alt="Main Window" width="40%"/>
</p>  

It then prompts for the username and password. If these credentials match the information in the database, this user becomes the current user, and Jstgram proceeds to the *Account Window*.

### 3.2 Account Window

The *Account Window* for Alice is shown belown as an example. 

<p align="center">
<img src="images/account_win.png" alt="Account Window" width="40%"/>
</p>  
 
The current user can choose to view posts, edit post visibility, or quit the application.

### 3.3 Post Window

The *Post Window* lists all posts by the current user and all posts visible to them, in the *ascending* order of post times. 

Below are examples of the *Post Window* for Alice, Bob, Crystal, and David, respectively, based on the database initialized with your MySQL script. Note that different users see different lists of posts.

<p align="center">
<img src="images/post_win_alice.png" alt="Post Window" width="30%"/>
<img src="images/post_win_bob.png" alt="Post Window" width="30%"/>
<img src="images/post_win_crystal.png" alt="Post Window" width="30%"/>
<img src="images/post_win_david.png" alt="Post Window" width="30%"/>
</p>  

The current user can choose to publish a new post, or return back to the *Account Window*. If a new post is published, the database and the *Post Window* should be updated accordingly.

### 3.4  Visibility Window

The *Visibility Window* shows the list of users who can see the posts of the current user.

Below are examples of the Visibility Window for Alice, Bob, Crystal, and David, based on the database initialized with your MySQL script.

<p align="center">
<img src="images/visiblity_win_alice.png" alt="Visibility Window" width="30%"/>
<img src="images/visiblity_win_bob.png" alt="Visibility Window" width="30%"/>
<img src="images/visiblity_win_crystal.png" alt="Visibility Window" width="30%"/>
<img src="images/visiblity_win_david.png" alt="Visibility Window" width="30%"/>
</p>  

The current user can choose to add a user to their visibility list, delete a user from their visibility list, or go back to the account window. If a user is added or deleted, the database and the *Visibility Window* should be updated accordingly.

Note that, only a user already in the database can be added to the visibility list, and only a user already in the visibility list can be deleted from the visibility list.

## 4. Project Requirement

### 4.1 Database design

Design a database to capture the following information

* User details: userID, username, password, visibility list, 
* Post details: postID, postText, postTime, the user who published the post

Feel free to add additional information as needed. Feel free to name your tables and attributes. If you plan to use natural join, ensure at least one common column between the two tables.

Your tables must adhere to the third normal form (3NF), meaning they should have no group of values for an attribute, no partial dependencies, and no transitive dependencies.

You will write the MySQL initizliation script from scratch. Name it `dbinit.sql`.

***Recommendation***

* Utilize `auto_increment` for primay keys to avoid keeping track of the largest integer in Java when inserting new rows.
* Use only `int`, `varchar(n)`, and `char(n)` data types that we have studied and are famaliar with.
* For postTime (i.e., the date and time of a post), use `LocalDateTime.now()` in Java to get current date and time, formatting it as a string with  `postTime.format(DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm:ss")` for storage in the database. 
* If necessary,  use the more flexible `on` clause for join select statement. For example, `Table1 natural inner join Table2` is equivalent to `Table1 inner join Table2 on Table1.col=Table2.col` if they have a common column `col`. The `on` clause is more flexible because it can join two tables on columns with different  names or only some commnon columns.

### 4.2 Java code design

Write your Java program to correctly show the necessary information in each window (e.g., list of posts in the *Post Window*). The exact format of the windows can differ from the provided screenshots.

You will write all code from scratch. Define appropriate Java classes, such as 
* `Main.java' as the main class for ease of execution by LAs
* `Database.java` containing database connection details as `public final static String` for easy modification by LAs.

```Java
public class Database {
	// JDBC driver parameters
	public final static String hostname = "cse-linux-01.unl.edu";
	public final static String username = "xxx"; // your database username
	public final static String password = "xxx"; // your database password
	public final static String url = "jdbc:mysql://"+hostname+"/"+username;

   ...

}
```

***Recommendation***
* Add comprehensive comments for clarity
* Adhere to good coding practices to be discussed in lab sessions by LAs.
  

## 5. Grading and Submitting Your Project

 
### 5.1 Submitting to Canvas

Submit the following to Canvas (not CodePost). 


1. `Project2.zip`: A Zip file of all source code.
* the MySQL init code named `dbinit.mysql`
* Java source files: The main class named `Main.java`, the database class named `Database.java`, and all other Java source files.

2. Design document named `design.pdf`
* Database: Justify that all your tables conform to 3NF.
* Database: Plot the Entity-Relational (ER) Diagram to show all your database tables and their relations. May use MySQL Workbench or free https://drawsql.app/ to automatically generate an ER Digram from your MySQL code. 
* Java: Plot the Unified Modelling Language (UM) diagram to show all your java classes and their relations. May use the PlantUML plugin fo Eclipse to automatically generate an UML diagram from your Java code. 
* Overall: Describe the mapping between database tables and Java classes. Specifically, for each database table, which Java class is used to store the data of the table?
* Overall: Describe how you synchornize your Java data with database data. For example, when to load which data from the database to Java? when to save which data from Java to database?

***note that, many of the above questions are open ended. That is, there are multiple possible correct solutions. We are looking for your clear descripotion and brief justication of your design choice.***

Again, if you plan to work with one other student for this project, please sign
up for a group on Canvas (`people` then `Groups`), and only one member of your group needs to
submit your project on Canvas.

### 5.2 Grading by LAs

1. (40 points) Design Document
   
* Same points for each bulliten point required for the design document.

2. (60%) Your code

* (10 points) Your MySQL initilization script can succssefully create the tables and insert the predefined information into the database
* (10 points) Main Window: Your code shows the correct number of users in the *Main Window*. 
* (10 points) Account Window: Your code correctly checks the username and password and then show the *Account Window*. 
* (20 points) Post Window: Your code shows the correct list of posts for each user in the *Post Window*. A new post can be succesfylly published.
* (20 points) Visibility Window: Your code shows the correct visibility list for each user in the *Visibility Window*. The visibility can be succesfully edited (i.e., add and delet users).  

3. Bonus points
   You are also welcome to demonstrate how your Jstgram works to our LAs, and they can then give you their feedbacks and grade your project.
   
* (Bonus 5 points) Create new accounts: A user can create a new account.  
* (Bonus 5 points) Delete accounts: A user can successfully delete the current account. All the data of the user, such as username, password, visibility (the user and others), and posts, should be deleted from the database. Note that the data should be deleted from various tables in the correct order.  
* (Bonus 10 points) Comments and coding style: Please attend the lab sessions for more information about grading comments and coding style.
* (Bonus 20 points) Like posts:  A user may like a post visible to the user. The like information of a post should be visible to all the users who can view the post. Please design a new table or add a new attribue to existing tables, and make sure your tables still confirm to 3NF.
 
### 5.2 Grading by the instructor

This accounts for additional 60 bonus points, amd will be graded by the instructor.

Write and submit a separate pdf file `study.pdf` to design and conduct experiments and report and discuss your experiment results.
* Initialize your database to have a large number of randomly generated users, posts, and visibility settings.
* Explore and find methods to (automatically or manually) measure the total database running time and/or total amount of network traffic between the database server and your Java code, and/or other performance metrics confirmed by the instructor.
* Design and conduct experiments to measure the above performance metrics as you increasing the database size, for example, number of randomly generated users/posts varying from 10, to 1000, 100000, or more (be careful not overloading the database server)
* Design and implement several different ways to synchronzize the Java data and database data. 
    

## Credit

This project was originally designed by Jianghao Wang. Both David Ryckman and Olwen Nguyen helped to revise and improve it. 
