![Hnet com-image](https://user-images.githubusercontent.com/12780152/123890579-d2e65c00-d92d-11eb-9195-10db9c1db2b7.png)




# New York Times Service

External library that provides access to the New York Times API.

---

## Setup

1. Create /libs in the project folder
2. Include the following lines in your project's  `settings.gradle` file

```kotlin
//...
include 'libs:SpotifyData'
findProject(':libs:SpotifyData')?.name = 'spotifydataSubmodule'
include 'libs:spotifydataSubmodule'
//...
```

3. Sync _Gradle_ 
   
   _You may see this option as a pop up in your IDE after modifying the `settings.gradle` file._
4. Include the following line to your project's `build.gradle` file.

```kotlin
compile project(":libs:spotifydataSubmodule")
```
5. Sync _Gradle_ one last time.

---

## Usage

1. Import this module into your project.
```kotlin
//...
import ayds.hera1.NYTimesAPI.NYTimesArticleService
//...
```
2. Initialize an instance:

```kotlin
//...
val NYTArticleService = NYTimesModule.nyTimesArticleService
//...
```

3. Call getArticleFromService(artist: String)
 ```kotlin
//...
NYTInfoService.getArticleFromService("Bool and the gang")
//...
```
 ---
 
 ## Exceptions
 
   getArticle method in NYTimesArticleService interface can throw an `APIException` if the API response is corrupted (service couldn't retrieve certains article attributes). The HTTP response body format is on NYTimes API responsability. Either way, the normal user shouldn't worry about this because this API error is catched and fixed in the submodule via the custom APIException, which prints a console message showing that an API Error has ocurred. In the end, the submodule works perfectly fine from a client-side view.
