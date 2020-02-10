# Introduction
🗒️ Simple Note App helps to to create your notes. You can 📝 edit and ❌ delete notes too. 
App is written in ✅ kotlin and respects its Mvvm architecture. Android Architecture Components
Part of Android Jetpack. Android architecture components are a collection of libraries that help 
you design robust, testable, and maintainable apps.


<h4>Architecture</h4>

MVVM is one of the architectural patterns which enhances separation of concerns, it allows
separating the user interface logic from the business (or the back-end) logic. Its target 
(with other MVC patterns goal) is to achieve the following principle “Keeping UI code simple 
and free of app logic in order to make it easier to manage”.

<h4>Screenshots</h4>
<table>
<thead>
<tr>
<th align="center">Add Notes</th>
<th align="center">Edit Notes</th>
<th align="center">Delete Notes</th>
</tr>
</thead>
<tbody>
<tr>
<td> <img src="app/src/main/res/drawable/add.gif" width="150" ></td>
<td> <img src="app/src/main/res/drawable/edit2.gif" width="150" ></td>
<td> <img src="app/src/main/res/drawable/delete.gif" width="150" ></td>
</tr>
</tbody>
</table>

<h4>Architecture Components used in the app are as follows</h4>
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



