<h1>💻 Console Banking System (Java Console Application)</h1>

<h2>📌 About this Project</h2>
<p>
This <strong>Java project</strong>is created to practice and understand essential 
<strong>Core Java</strong> concepts such as OOP, layered architecture, and the <strong>Collections Framework</strong>. 
This project is built completely from scratch as a beginner-to-intermediate Java learner trying to improve logical thinking and project structuring.
</p>

<h2>🏦 Project Description</h2>
<p>
This is a <strong>console-based banking system</strong> where the user can perform basic banking actions. 
There is <strong>no database connected</strong>; all data is stored temporarily using Java Collections inside repository classes.
So once the application stops, all stored data gets removed.
</p>

<h3>✨ Features</h3>
<ul>
  <li>Create a Customer and Account</li>
  <li>Deposit money</li>
  <li>Withdraw money (with balance validation)</li>
  <li>Check available balance</li>
  <li>View complete transaction history</li>
</ul>

<hr/>

<h2>🧠 Core Functionalities</h2>
<table>
  <tr>
    <th>Feature</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Create Account</td>
    <td>Stores new customer and account details using Collections</td>
  </tr>
  <tr>
    <td>Deposit</td>
    <td>Adds money and records the transaction</td>
  </tr>
  <tr>
    <td>Withdraw</td>
    <td>Checks balance availability and processes withdrawal</td>
  </tr>
  <tr>
    <td>Check Balance</td>
    <td>Shows current account balance</td>
  </tr>
  <tr>
    <td>Transaction History</td>
    <td>Displays list of debit and credit operations</td>
  </tr>
</table>

<hr/>

<h2>📂 Project Structure</h2>
<pre>
src/
 ├── app
 │    └── BankingApp.java        // Main class for UI and menu
 ├── bankService
 │     ├── BankService.java      // Interface for service layer
 │     └── impl/BankServiceImpl  // Implementation of bank logic
 ├── domain                      // Entity classes
 │     ├── Account
 │     ├── Customer
 │     ├── Transactions
 │     └── Type (enum)
 └── repository                  // In-memory data storage
       ├── AccountRepository
       ├── customerRepository
       └── transactionRepository
</pre>

<hr/>

<h2>📖 What I Learned</h2>
<ul>
  <li>How to design and structure a project using <strong>layers and packages</strong></li>
  <li>Understanding of <strong>OOP principles</strong> such as Abstraction, Encapsulation, and Interfaces</li>
  <li>How the <strong>Collections Framework</strong> works internally to store and manage data</li>
  <li>Working with real project flow like <em>App → Service → Repository → Domain</em></li>
  <li>Building console user interaction and handling different program flows</li>
  <li>Improved logical thinking and problem-solving skills</li>
</ul>

<hr/>

<h2>🙏 Final Note</h2>
<p>
I am still a <strong>beginner-intermediate Java learner</strong>, and I know this project is not perfect. 
There are many improvements I want to work on such as connecting a real database, adding exception handling, unit testing, 
and maybe migrating to <strong>Spring Boot</strong> in the future. 
</p>
<p>
However, completing this project has given me confidence and motivation to keep learning and improving.
Thank you for taking the time to review my work! 😊
</p>
<p><strong>Any suggestions or feedback are always welcome.</strong></p>
