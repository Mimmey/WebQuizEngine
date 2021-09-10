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
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project was made in educational purposes. I really enjoyed creating it and hope you will enjoy using.

The engine provides multi-user creation, solving and deletion of little web-quizzes using HTTP requests.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [H2 database](https://www.h2database.com)


<!-- USAGE EXAMPLES -->
## Usage

Here is a list of requests that you can use:

Method | Request | Params or body | Description | Access
------------ | ------------- | ------------ | ------------ | ------------
GET | api/quizzes | int page (optional, default 0), int pageSize(optional, default 10)  | returns paginated list of all quizzes made by all users (paging starts with 0) | only for authorised users
GET | api/quizzes/{id} | — | gets a quiz by its id | for authorised users
GET | api/quizzes/completed |  int page (optional, default 0), int pageSize(optional, default 10) | returns a list of successful solving attempts made by user  (paging starts with 0) | only for authorised users 
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
    
Example:

    {
      "title": "Coffee drinks",
      "text": "Select only coffee drinks.",
      "options": ["Americano","Tea","Cappuccino","Sprite"],
      "answer": [0,2]
    }
    
## Answer    

Answer is an integer array: `{"answer": [0,2]}`

## User

User is:

<pre><code>{
  "email": "<i>email</i>",
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



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact
Olga Motyleva - motyolya@gmail.com

Project Link: [https://github.com/Mimmey/WebQuizEngine](https://github.com/Mimmey/WebQuizEngine)