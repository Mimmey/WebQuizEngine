<br />
<p align="center">

  <h3 align="center">WebQuizEngine</h3>

  <p align="center">
    Awesome engine for creating and solving quizzes
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"></a>
    <br />
    <br />
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a>
      <ul>
        <li>
          <a href="#structures">Specific Structures</a>
          <ul>
            <li><a href="#quiz">Quiz</a></li>
            <li><a href="#answer">Answer</a></li>
            <li><a href="#user">User</a></li>
          </ul>
         </li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#links">Links</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project was made in educational purposes. I really enjoyed while creating and hope you will enjoy using it.

The engine provides multi-user creation, solving and deletion of little web-quizzes using HTTP requests.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [H2 database](https://www.h2database.com)

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* [IntelliJ Idea](https://jetbrains.com/ru-ru/idea/download/#section=windows)
* [IntelliJ Idea Spring plugin](https://jetbrains.com/help/idea/spring-support.html#spring-file-set)
* [IntelliJ Idea Lombok plugin](https://plugins.jetbrains.com/plugin/6317-lombok)
* [Postman](https://postman.com/downloads/)

### Installation

1. Open IntelliJ Idea
2. Click on "Get from VCS" button
3. Enter "https://github.com/Mimmey/WebQuizEngine.git" in the URL field, choose cloning path and click "Clone"
4. Run project
5. Open Postman and enjoy using

<!-- USAGE EXAMPLES -->
## Usage

Program works on port 8889.

Here is a list of requests that you can use:

Method | Request | Params or body | Description | Access
------------ | ------------- | ------------ | ------------ | ------------
GET | api/quizzes | int page _(optional, default 0)_, int pageSize _(optional, default 10)_  | returns paginated list of all quizzes made by all users (paging starts with 0) | only for authorised users
GET | api/quizzes/{id} | — | gets a quiz by its id | for authorised users
GET | api/quizzes/completed |  int page _(optional, default 0)_, int pageSize _(optional, default 10)_ | returns a list of successful solving attempts made by user  (paging starts with 0) | only for authorised users 
POST | api/quizzes | <a href="#quiz">Quiz</a> quiz | publishes a new quiz | only for authorised users
POST | api/quizzes/{id}/solve | <a href="#answer">Answer</a> answer | solves specified quiz | only for authorised users
POST | api/register | <a href="#answer">User</a> user | registers a new user | public
DELETE | api/quizzes/{id} | — | deletes a quiz by its id | only for authorised users

## Quiz
Quiz is a special entity having the following structure:

<pre><code>{
  "title": "<i>title</i>",
  "text": "<i>quiz text</i>",
  "options": [<i>list of options</i>],
  "answer": [<i>list of answers, numeration starts with 0</i>]
}</code></pre>

All of the fields are required, number of _options_ should be equals or more than 2
    
Example:

    {
      "title": "Coffee drinks",
      "text": "Select only coffee drinks.",
      "options": ["Americano","Tea","Cappuccino","Sprite"],
      "answer": [0,2]
    }
    
## Answer    

Answer is an integer array: 

<pre><code>{
  "answer": [<i>list of options</i>]
}</code></pre>

Example:

<pre><code>{
  "answer": [0,2]
}</code></pre>

## User

User is:

<pre><code>{
  "email": "<i>name</i>@<i>second-level-domain</i>.<i>top-level-domain</i>",
  "password": "<i>password</i>"
}</code></pre>
    
Example:

    {
      "email": "test@gmail.com",
      "password": "secret"
    }


<!-- CONTRIBUTING -->
## Contributing

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- CONTACT -->
## Contact
Olga Motyleva - motyolya@gmail.com


<!-- LINKS -->
## Links
Project Link: [https://github.com/Mimmey/WebQuizEngine](https://github.com/Mimmey/WebQuizEngine)
README.md made using: https://github.com/othneildrew/Best-README-Template
