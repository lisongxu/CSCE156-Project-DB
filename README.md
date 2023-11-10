# Computer Science II
## Project - Database

This is a project used in Computer Science II (CSCE 156) for Fall 2023 
in the [School of Computing](https://computing.unl.edu) 
at the [University of Nebraska-Lincoln](https://www.unl.edu).

## Overview

### Lab Objectives & Topics
Following the lab, you should be able to:
* Make a JDBC connection to a database server
* Use JDBC to query and process a result set from a database server
* Use JDBC to insert new data to or delete existing data from a database
* Design 3NF database tables 


### Peer Programming Pair-Up

At the start of
each project, you may find a team member by yourself or may be randomly paired up with another student by
a lab instructor.  One of you will be designated the *driver* and the other the *navigator*. If you prefer to work on this project by yourself, that is fine too.  Each week you should try to alternate: if you were a driver last week, be a navigator next, etc. 

If you work with another student, please first create your group on Canvas, and then only one of you needs to submit the project for grading.

## 1. Relation to Project 1

This project is independent of Project 1, although both projects are about Jstgram. You do not need to use use your code from Project 1, and actually you are recommended not to use your code from Project 1 because they are very different.


## 2. Social Media Application - Jstgram

In this project, we will design and develop a database version for *Jstgram*. 

### 2.1 Database

All the information is stored on the database server `cse-linux-01.unl.edu`. Please write an MySQL code to initialize the database, such as creating all the tables, and inserting the initial data into these tables.

### 2.1 Users

To simplify the project, your applicaion does not need to support adding or deleting users. Instead, please add a group of users into the database using your MySQL code when initizliing the database. 

A user can log into Jstgram using their unique username and password. 

Below we will consider an example where the database already has the information of a total of four users with usernames: Alice, Bob, Crystal, and David.

### 2.2 Posts

To simplify the project, your application only needs to support the text posts.  That is, a user can publish only text posts.

For our example, assume that the database alreay has the information of the following posts
* Alice posted "Project deadline extended?" at 19:00:00 on October 12, 2023.
* Bob posted "Yep" at 19:01:00 on October 12, 2023.
* David posted "Fall break" at 09:00:00 on October 16, 2023
* Alice posted "Lab due tonight?" at 23:30:00 on October 27, 2023
* Crystal posted "No, it's due next week" at 23:35:00 on October 27, 2023


### 2.3 Post Visibility

A user can choose to which users the posts of the user are visible. Only these users can view the posts published by the user.

For our example, 
* Bob's posts are visible to Alice and Crystal
* Crystal's posts are visible to Alice
* David's posts are visible no other users.

Note that the posts of a user are alwasy visible to the user themself.

  
## 3. Jstgram Windows

### 3.1 Main Window

When Jstgram starts, it should first connect to the database server and get the current number of users in the database. If successful, it displays that information in the *Main Window* as demonstrated below. 

<p align="center">
<img src="images/main_win.png" alt="Main Window" width="40%"/>
</p>  

It reads the username and password from the keyboard. If the username and password match with the information on the database, it goes to the *Account Window*.

### 3.2 Account Window

The *Account Window* is demonstrated below. 

<p align="center">
<img src="images/account_win.png" alt="Account Window" width="40%"/>
</p>  
 
The user can choose to view the posts, edit visitibility setting, or quit the application.

### 3.3 Post Window

The *Post Window* lists all the posts by the current user and all the posts visible to the current user in the ascending order of the post times. 

<p align="center">
<img src="images/post_win_alice.png" alt="Post Window" width="30%"/>
</p>  

The user can choose to publish a new post, or go back to the account window.

### 3.4  Visibility Window

The *Visibility Window* lists all the users to whom the posts of the current user are visible.

<p align="center">
<img src="images/visivility_win.png" alt="Visibility Window" width="30%"/>
</p>  


## 4. Project Requirement


### 4.1 Database design

You are provided with the following fully completed classes

### 4.2 Java code design

* The . 



## 5. Grading and Submitting Your Project

 
### 5.1 Submitting to Canvas

Submit all Java source code in a zip file to Canvas (not CodePost). Our LAs will manually grade them. You are welcome to demonstrate how your Jstgram works to our LAs, and they can then give you their feedbacks and grade your project.  

Note that, each group only need to submit.

### 5.2 Grading by LAs

* (10 points)
* (Bonus 10 points) Add the following features

## Credit

This project was originally designed by Jianghao Wang. Both David Ryckman and Olwen Nguyen helped to revise and improve it. 
