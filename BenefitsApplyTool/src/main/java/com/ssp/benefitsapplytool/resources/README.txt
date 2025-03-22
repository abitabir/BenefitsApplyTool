Scenario
There is a requirement for prototyping a new software system to document and store details for Participants applying for a number of related benefits. The software system will have three specified layers:

* The Presentation Layer - The Web User Interface [ UI ] consisting of JavaScript, HTML and CSS.
* The Business Layer - Java code defining objects, providing relevant data transformation, validation and business logic.
* The Data Layer - A Relational Database Management System [ RBDMS ] primarily queried with SQL.

The requirements specify the ability to store the following key data and details listed below for each Participant, to facilitate applying for current and future benefits:
* National Insurance Number
* Date of Birth
* First Name
* Surname
* Primary Telephone Number
* Primary Email Address
* Primary Address Details
* Primary Bank Account Details

Tasks
Task 1:

For this assessment both the Presentation and Data layers are out of scope, but should be considered for future expansion or if designing interfaces between layers.

Following Object Oriented Programming [ OOP ] principles, please design a Participant Data Storage model for storing validated details adhering to the following acceptance criteria:
Key data and required validation:

* Registration Date - The date the Participant is registered on the system, a mandatory, system generated attribute [ Read Only ].
* National Insurance Number - An optional attribute, a Participant should be able to
be registered as a 'Prospect' if a National Insurance Number [ NINO ] is not initially specified [ Editable ]
* Date Of Birth - A mandatory attribute [ Editable ].

* First Name - A mandatory attribute, validate so only one active First Name can exist [ Editable / Evidence ].
* Surname - A mandatory attribute, validate so only one active Surname can exist [
Editable / Evidence ].
* Primary Telephone Number - An optional attribute, validate so only numbers can be entered and one active Telephone Number can exist if specified [ Editable ].
* Primary Email Address - An optional attribute, validate for basic modern email
standards and so only one active Email Address can exist if specified [ Editable ].
* Primary Address - A mandatory attribute, validate for basic UK postcode format and so only one active Primary Address can exist [ Editable / Evidence ].
* Primary Bank Account - A mandatory attribute, validate so only one active Primary
Bank Account can exist [ Editable / Evidence ].

The model should provide the following functionality and business logic:

* Should provide all data validation as specified above.
* Should return the Participant's National Insurance Number if required.
* Should allow a 'Prospect' indicator to be set if a National Insurance Number is not specified during construction.
* Should allow a 'Prospect' indicator to be removed if a National Insurance Number is specified after construction.
* Should return the Participant's age based on the current date.
* Should return the Participant's active first name and surname if required.
* Should return the Participant's active primary address to facilitate correspondence.
* Should return the Participant's active bank account to facilitate payment.
* Should provide functionality to add new evidence after construction [ First Name, Surname, Primary Address and Primary Bank Account ].
* Should validate so adding any new evidence does not overwrite previous evidence. A history of the Participant's active and historic evidence must be preserved.
Design classes with constructors, relevant attributes, properties and methods following Object Orientated Programming [ OOP ] principles and utilising Java code with relevant syntax and annotations.


Task 2:

Design a suite of Junit tests testing all the relevant functionality specified in the Task 1 acceptance criteria with a view to service support and rectifying faults.


Presentation:

Please prepare a presentation lasting no longer than 10 minutes to showcase your object model to the assessment panel. This will be followed by a question and answer discussion with the panel.

Your answer should include the following:

* A walkthrough of your prototype Participant Data Storage model with an explanation of how you approached the design with reference to your application of modern development standards and techniques.

* A walkthrough of the Participant Data Storage model with an explanation of how you have met the required acceptance criteria specified in the scenario and Task 1.

* A description of your approach to Junit testing the prototype Participant Data Storage model as per specifications in Task 2.

Please be prepared for a Q&A follow-on discussion that will further explore the information set out in your presentation and allow panel members to understand your approach to the exercise.

If you are being asked to deliver a presentation and you choose to present slides, you should share these with the panel and upload a copy of your presentation to you Objective Connect workspace 24 hours in advance of your interview.


