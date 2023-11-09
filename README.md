# Computer Science II
## Project - Database

This is a project used in Computer Science II (CSCE 156) for Fall 2023 
in the [School of Computing](https://computing.unl.edu) 
at the [University of Nebraska-Lincoln](https://www.unl.edu).

## Overview

### Lab Objectives & Topics
Following the lab, you should be able to:
* use classes and objects to write Java programs
* understand Inheritance and design classes and subclasses in Java
* understand and use interfaces and abstract classes in Java
* understand polymorphism in Java


### Peer Programming Pair-Up

At the start of
each project, you may find a team member by yourself or may be randomly paired up with another student by
a lab instructor.  One of you will be designated the *driver* and the other the *navigator*. If you prefer to work on this project by yourself, that is fine too.  Each week you should try to alternate: if you were a driver last week, be a navigator next, etc. 


## 1. Relation to Project 1

This project is independent of Project 1, although both projects are about Jstgram. You do not need to use use your code from Project 1, and actually you are recommended not to use your code from Project 1 because they are very different.


## 2. Social Media Application - Jstgram


In this project, we will design and develop a simple social media application using Java, called *Jstgram*. It supports two basic features

* Account management: A user can create a new account and log into an existing account.  
* Post management: A user can create various types of posts and list the past posts.  


### 2.1 Main Window

When Jstgram starts, it should display the *Main Window* as shown below. This window is displayed by calling `Views.mainWindow()` in the provided `Views` class.

<p align="center">
<img src="images/main_win.png" alt="Main Window" width="30%"/>
</p>  

It reads the user input from the keyboard, and then goes to the *Account Registration Window* or the *Account Login Window*, or quits the application.

### 2.2 Account Registration Window

The *Account Registration Window* is demonstrated below. It asks the user for the account information, and you may creatively ask for more information, such as email and job. This window is displayed by calling `Views.accountRegistrationWindow()`.

<p align="center">
<img src="images/user_registration_win.png" alt="User Registration Window" width="30%"/>
</p>  
 
After creating an account, Jstgram goes back to the *Main Window* so that a user can login or create other new accounts.


### 2.3 Account Login Window

The *Account Login Window* with successful login and failed login are demonstrated below. Jstgaram asks for the username and password, and then compares with the existing account information in `accounts`. This window is displayed by calling `Views.accountLoginWindow()`.


<p align="center">
<img src="images/login_win_succ.png" alt="Login" width="30%"/> 
<img src="images/login_win_failed.png" alt="Login" width="30%"/>
</p>  

If the typed username and password match with an existing account,  this account is the current account and Jstgram goes to the *Post View Window* for the account; otherwise, it goes to the *Main Window*. Note that, at any time, there is at most one current account. 


### 2.4 Post View Window

The *Post View Window* lists all the past posts (by all accounts) in the descending order of the time, and then asks the user to create a new post, logout the current account, or quit the application. Below shows a possible *Post View Window* with a total of 4 posts. This window is displayed by calling `Views.postViewWindow()`.


<p align="center">
<img src="images/post_view_win.png" alt="Post View" width="30%"/>
</p>  

After reading the user input, Jstgram 
* goes to the *New Post Window* to create a new post
* or logs out the current account and goes back to the *Main Window*
* or quits the application. 



### 2.5  New Post Window

The *New Post Window* is shown below, where a user can choose to create either a text post or a text art post. This window is displayed by calling `Views.newPostWindow()`.

<p align="center">
<img src="images/new_post_win.png" alt="New Post" width="30%"/>
</p>  


Below is a demonstration where a user selects `T` and then types a text post.

<p align="center">
<img src="images/txt_post.png" alt="New txt Post" width="30%"/>
</p>  

Below is a demonstration where a user selects `A` and then chooses no 1 in the 4 predefined text art options. These text art options are defined as a `List<String[]>` constant `OPTIONS` in class `TextArtPost`. You are welcome to modify and add more text art options. The window of text art options is displayed by calling `Views.displayTextArtOptions()`.

<p align="center">
<img src="images/textart_post.png" alt="New text art Post" width="30%"/>
</p>  


After creating a post, Jstgram goes back to the *Post View Window*.


  

## 3. Project Requirement


### 3.1 Classes

You are provided with the following fully completed classes
* the `Views` class
* the `Post` class
* the `PostContentFormatter` interface

You will write and complete the following partially complete classes
* the `Account` class
* the `TextPost` class
* the `TextArtPost` class
* the `Main` class, which is the class to run the application

You are free to define and write more methods and/or classes to handle account login, handle account registration, create new post, and list past posts.

### 3.2 Class Requirements

* The `Account` class must have 3 (or more) private data fields: `private String userName`, `private String password`, and `private String phoneNumber` and the corresponding public getter methods. 


* Both the `TextPost` and `TextArtPost` classes extend abstract class `Post` and implement interface `PostContentFormatter`. Their relation is shown in the following UML diagram ([Generated using PlantUML Plugin for Eclispse](https://github.com/cbourke/ComputerScienceII/blob/master/resources/uml.md)).
<p align="center">
<img src="images/post_uml.png" alt="UML of Post Classes" width="50%"/>
</p>  

* Both the `TextPost` and `TextArtPost` classes extend abstract class `Post`, because they use the same data fields, `postTime` and `postAccount`, defined in `Post`.
    * The `TextPost` class should have its own data field to store the text typed by a user.
    * The `TextArtPost` class should have its own data field to store the no of the text art chosen by a user. 


* Both the `TextPost` and `TextArtPost` classes implement interface `PostContentFormatter` to override the `getFormattedContent()` method, which `Views.viewPost()` in the *Post View Window* calls to display each post in the approriate format. 


* Please use a `HashMap` variable `accounts` to keep track of all account information. For each key-value pair, 
the key is the account username, and the value is the corresponding account. For example, statement `accounts.put(userName, new Account(userName, password, phoneNumber))` adds a new account to `accounts`.


* Please use an `ArrayList<Post>` variable `postList` to store all the posts, which is the argument of method `Views.viewPost()`. 


## 4. Grading and Submitting Your Project

### 4.1 Grading by LAs

* (5 points) The `Account` class must have 3 (or more) private data fields: `private String userName`, `private String password`, and `private String phoneNumber` and the corresponding public getter methods. 

* (5 points) Both the `TextPost` and `TextArtPost` classes (not necessarily correctly) override the `getFormattedContent()` method.

* (5 points) A `HashMap` variable `accounts` is used to keep track of all account information

* (5 points) An `ArrayList<Post>` variable `postList` is used to store all the posts. 
  
* (10 points) A user can successfully create a new account (username=Alice, password=pass123), and then successfully log into the account.

* (10 points) Alice can then successfully create a new text post and the *Post View Window* correctly shows the post in the appropriate format as demonstarted above.

* (10 points) Alice can then successfully create a new text art post and the *Post View Window* correctly shows the post in the appropriate format as demonstrated above.

* (10 points) The *Post View Window* correctly shows these two posts in the descending order of their times.

* (10 points) When logging using username=Bob (not created yet), it correctly reports failed login.

* (10 points) A user can successfully create another new account (username=Bob, password=pass456), and then successfully log into the account.

* (10 points) Bob can then successfully create a new text post and a new text art post.

* (10 points) The *Post View Window* correctly shows all the posts in the descending order of their times.

* (Bonus 20 points) Add the following features to the *Main Window*
    * Successfully save all accounts (e.g., Alice and Bob) and all their posts to a text file (feel free to design your file format).
    * After quiting and restarting the application, a user can successfully load the accounts and their posts from a file.


### 4.2 Submitting to Canvas


Submit all Java source code in a zip file to Canvas (not CodePost). Our LAs will manually grade them. You are welcome to demonstrate how your Jstgram works to our LAs, and they can then give you their feedbacks and grade your project.  

Note that, each student must submit the code to Canvas for grading.


## Credit

This project was originally designed by Jianghao Wang. Both David Ryckman and Olwen Nguyen helped to revise and improve it. 
