# KeywordMatcher

**KeywordMatcher** is a simple, efficient desktop GUI tool built in Java using Swing. It helps job seekers quickly identify whether a job description aligns with their personal skills and keywords. This project automates the manual filtering process, saving hours during job applications by instantly matching keywords against job descriptions.

---

## Features

- Real-time keyword matching and highlighting
- Count of keyword occurrences in job descriptions
- Easy-to-use keyword add/remove interface
- User-friendly Java Swing GUI
- Saves time by automating job application filtering

---

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Bradltr95/KeywordMatcher.git
cd KeywordMatcher
```

### 2. Run the Application
Open the project in your IDE of choice (e.g., IntelliJ IDEA or Eclipse) and run the App.java file located in:
```
/src/main/java/com/bradltr/keywordmatcher/App.java
```

Additionally, you can run the following command from the readme.

```bash
cd keywordmatcher/src/main/java/com/bradltr/keywordmatcher  
javac App.java
java App.java
```

## How It Works
### Add Keywords
Use the input field in the top-left corner.

Type your keyword and click the ➕ button.

Keywords will be added to the list and highlighted below.

You can remove a keyword by selecting it and clicking the ➖ button.

### Paste a Job Description
Paste the job description text into the main text box.

### Match and Analyze
Click the "Match" button to compare the job description against your keyword list.

The app will:

Highlight matched keywords

Display a count of how many times each appears

## Project Status
In Progress — Actively maintained with plans for:

Keyword list persistence

Drag-and-drop job description support

Exporting results to PDF