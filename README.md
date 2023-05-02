-------------------------------------------------
The Simpsons
-------------------------------------------------
This is an Android App that loads and displays random details from The Simpsons API based on the parameters set on the end-point definition.



-----------------------------
Libraries and Technologies
-----------------------------
- Dagger-Hilt (Dependency Injection)
- Glide (Image Loading)
- Retrofit2 and OkHTTP3 (HTTP Requests)
- Serialization (Json Parsing)
- MVVM Architecture (Except Domain Layer)
- StateFlow (Handling and Updating Different States)
- AndroidViewModel (Addition of Context in ViewModel)



--------------------------------------------
Recommendations
--------------------------------------------
- Use of KTor Client to make HTTP requests.
- Use of other image loading libraries such as Picasso and Coil.
- Use of MutableStateFlow for handling state.
- Extensive use of Material3 resources to add flavour to the app design.
- Addition of a new 'DetailedScreen' use case.
- Playing around with the parameters of the HTTP request end-point.
- Addition of Caching, Local Storage and Pagination.