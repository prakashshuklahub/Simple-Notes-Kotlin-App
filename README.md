# Introduction
🗒️ Simple Note App helps to to create your notes. You can 📝 edit and ❌ delete notes too. 
App is written in ✅ kotlin and respects its Mvvm architecture. Android Architecture Components
Part of Android Jetpack. Android architecture components are a collection of libraries that help 
you design robust, testable, and maintainable apps.


# Architecture

MVVM is one of the architectural patterns which enhances separation of concerns, it allows
separating the user interface logic from the business (or the back-end) logic. Its target 
(with other MVC patterns goal) is to achieve the following principle “Keeping UI code simple 
and free of app logic in order to make it easier to manage”.

<h2>ADD NEW NOTE</h2>
<img src="app/src/main/res/drawable/add.gif" width="150" >   
<h2>EDIT NOTE</h2>
<img src="app/src/main/res/drawable/edit2.gif" width="150" ></DIV>
<h2>DELETE NOTE</h2>
<img src="app/src/main/res/drawable/delete.gif" width="150" >

# Architecture Components used in the app are as follows
<ul>
<li>Lifecycles: It manages activity and fragment lifecycles of our app, survives configuration changes,
avoids memory leaks and easily loads data into our UI.</li>
<li>LiveData: It notifies views of any database changes. Use LiveData to build data objects that notify views when
the underlying database changes.</li>
<li>Room: It is a SQLite object mapping library. Use it to Avoid boilerplate code and easily 
convert SQLite table data to Java objects. Room provides compile time checks of SQLite statements
and can return RxJava, Flowable and LiveData observables.</li>
<li>ViewModel: It manages UI-related data in a lifecycle-conscious way. It stores UI-related data
that isn't destroyed on app rotations.</li>
<li>Repository: The repository depends on a persistent data model and a remote backend data source.</li>

<img src="app/src/main/res/drawable/arc.png" width="700" >
<br>

# Thanks for reading
<img src="https://img.shields.io/github/forks/LanguageXX/Simple-Notes-Kotlin-App?style=social" >
<img src="https://img.shields.io/github/stars/LanguageXX/Simple-Notes-Kotlin-App?style=social">
<img src="https://img.shields.io/github/watchers/LanguageXX/Simple-Notes-Kotlin-App?style=social">
<br>
<br>
<br>
<img src="https://img.shields.io/badge/Activity%20Looking%20for%20Android%20Internship-Hi%20%2C%20%20email%20me%20prakashshukla1820%40gmail.com-green" >
