# Kiwi Kwiz

### How well do you know New Zealand!

## Screenshots

![Screenshot](/app/screenshots/Screenshot_Main.png) ![Screenshot](/app/screenshots/Screenshot_Populous.png) ![Screenshot](/app/screenshots/Screenshot_Flag.png) 

![Screenshot](/app/screenshots/Screenshot_Main_es.png) ![Screenshot](/app/screenshots/Screenshot_Populous_es.png) ![Screenshot](/app/screenshots/Screenshot_Flag_es.png) 

## Built With

Android Studio 3.3.1

Gradle 4.10.1

API Level: 16. Android 4.1 (JELLY BEAN)

## Versioning

2.0

## Authors

Joseph McDonald

## License

N/A

## Features 

**Quizzy Engine Class**  For code efficiency, I created the QuizzyEngine.java class to house variables 
and methods used by all question classes. For example, it contains methods for processing the correctness of question attempts and 
advancing to the next question. Since it handles quiz score and question count variables, I no longer
needed to pass these values to each activity. It also handles all toasts for the app. Thought of this during a run!

**Localization**  US Spanish (es-rUS).

**ProgressBar/CountDownTimer**  This feature was used by fellow student and I liked this feature a lot.  I found the process to
implement and change the bar color on StackOverflow.com.

**Google Fira Sans Typeface**  This is the only typeface used throughout the app. (more info below) 

**FontFamily Issue**  Declaring fontFamily on RadioButtons and CheckBoxes within XML has no effect. This known issue 
is addressed at: (https://issuetracker.google.com/issues/63250768)  The workaround is to set the typeface within the 
Java code. Works great. I found the solution on StackOverflow.com.

**HTML Code**  To emphasize correct/incorrect answers, I wanted to have colored text.  I used embedded HTML code to have more than one
font color within a TextView on my SummaryActivity.  I found the solution on StackOverflow.com.

## Acknowledgements

Thanks to Google and Udacity for the opportunity to learn so much in so little time. I actually was excited to code 
this app for the course. I want to learn and code more!

A huge "thank you" to Heather. As a social media authority, she is an excellent resource for me to get ideas 
and feedback on my apps!

The idea behind this app was actually inspired by chance. In 2017, I happened upon a New Zealand cricket match on ESPN3.
 A new sport (for me) to learn! I was hooked. Since then I've learned the squad, most of the laws, strategies, etc. Since
  I needed to make a quiz app for the course, I decided to learn more about New Zealand.

The theme is inspired from the New Zealand All-of-Government Brand.

(https://www.ssc.govt.nz/govt-brand)

For example, their official typeface (Fira Sans) is used throughout this app.

(https://www.govt.nz/about/about-this-website/style-and-design/typography/#typefaces) 

Also, the app's colors are inspired from here.

(https://www.govt.nz/about/about-this-website/style-and-design/colours-and-graphics/#colours)

Black, white, gray and the Māori red are all represented. Loved the red contrast so much so that I used it for 
the app's "colorAccent."  Some info on the Māori flag.

(https://nzhistory.govt.nz/media/photo/national-maori-flag)
