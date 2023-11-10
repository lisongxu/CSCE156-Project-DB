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
* Design 3NF tables 


### Peer Programming Pair-Up

At the start of
each project, you may find a team member by yourself or may be randomly paired up with another student by
a lab instructor.  One of you will be designated the *driver* and the other the *navigator*. If you prefer to work on this project by yourself, that is fine too.  Each week you should try to alternate: if you were a driver last week, be a navigator next, etc. 

Note that only one student of each group needs to submit...

## 1. Relation to Project 1

This project is independent of Project 1, although both projects are about Jstgram. You do not need to use use your code from Project 1, and actually you are recommended not to use your code from Project 1 because they are very different.


## 2. Social Media Application - Jstgram


In this project, we will design and develop a database version for *Jstgram*. It supports the following features

* Post publishing: A user can publish text posts.
* Visibility control: A user can control to which users all the posts published by the user are visible.

### 2.0 An Example of Users and Their Relations

Suppose that currently the database has the following information

* There are four users: Alice, Bob, Crystal, and David
* Alice's posts are visible to Bob and Crystal
* Bob's posts are visible to Alice and Crystal
* Crystal's posts are visible to Alice
* David's posts are visible no other users.

Note that the posts of a user are alwasy visible to the user themself.
  

### 2.1 Main Window

When Jstgram starts, it should first connect to the database server and get the current number of users in the database. If successful, it displays that information in the *Main Window* as demonstrated below. 

<p align="center">
<img src="images/main_win.png" alt="Main Window" width="40%"/>
</p>  

It reads the username and password from the keyboard. If the username and password match with the information on the database, it goes to the *Account Window*.

### 2.2 Account Window

The *Account Window* is demonstrated below. 

<p align="center">
<img src="images/account_win.png" alt="Account Window" width="40%"/>
</p>  
 
The user can choose to view the posts, edit visitibility setting, or quit the application.

### 2.3 Post Window

The *Post Window* lists all the posts by the current user and all the posts visible to the current user in the ascending order of the post times. 

<p align="center">
<img src="images/post_win_alice.png" alt="Post Window" width="30%"/>
</p>  

The user can choose to publish a new post, or go back to the account window.

### 2.4  Visibility Window

The *Visibility Window* lists all the users to whom the posts of the current user are visible.

<p align="center">
<img src="images/visivility_win.png" alt="Visibility Window" width="30%"/>
</p>  


## 3. Project Requirement


### 3.1 Database design

You are provided with the following fully completed classes

### 3.2 Java code design

* The . 



## 4. Grading and Submitting Your Project

 
### 4.1 Submitting to Canvas

Submit all Java source code in a zip file to Canvas (not CodePost). Our LAs will manually grade them. You are welcome to demonstrate how your Jstgram works to our LAs, and they can then give you their feedbacks and grade your project.  

Note that, each group only need to submit.

### 4.2 Grading by LAs

* (10 points)
* (Bonus 10 points) Add the following features

## Credit

This project was originally designed by Jianghao Wang. Both David Ryckman and Olwen Nguyen helped to revise and improve it. 
