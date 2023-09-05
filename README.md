#  Overview
*  EWA Weather Forecast App
  
#### Screenshot
![EWA-Screenshot 2023-09-05 at 21 21 33](https://github.com/omeryildirim01/EWA/assets/17796968/ae4cb286-d765-40cd-8e23-fcfa63f59aaf)


## Why a weather app ?

An Android app consuming [Weather API](https://open-meteo.com/) to display daily weather forecast
it has been built with clean architecture principles, Repository Pattern and MVVM
pattern as well as Architecture Components. The app displays the current user’s weather also UI elements are managed by a Json
API response. This app demonstrates that how we can handle the mocked API responses by using Mockable API functions and Mock response interceptor which has mentioned below.

## What is the solution for the purpose of ?

*  To be able to get mock response for a spesific API endpoint, just add an annotation( [@Mockable](https://#.#.#/)) for the API function, and import your json mock data file into the assets folder on the project, check it out. Also consider to add firebase remote config flag for this mechanism.
## How to do that ?
###  Step 1 - Add Mock Json File into the assets folder [weather.json](https://github.com/omeryildirim01/EWA/blob/master/app/src/main/assets/weather.json)
###  Step 2 - Annotate your api function ensure that mockEnabled parameter should be true, like this [WeatherService](https://github.com/omeryildirim01/EWA/blob/master/app/src/main/java/com/yildirimomer01/ewa/data/source/network/WeatherService.kt).

```
    @GET(FORECAST_URL)
    @Mockable(fileName = "weather.json", mockEnabled = true)
    suspend fun getWeatherData(@Query("latitude") lat: Double,@Query("longitude") long: Double): Response<WeatherWrapperDto>
```

###  Step 3 - It's done! Now you are ready to use mock json data. Let's have a look at the mock interceptor which is a key class for the solution.
 

*  Mock Interceptor [MockInterceptor.kt](https://github.com/omeryildirim01/EWA/blob/master/app/src/main/java/com/yildirimomer01/ewa/util/MockInterceptor.kt)

```
class MockInterceptor @Inject constructor( private val context: Context, private val mockResponseManager: MockResponseManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain) = prepareResponse(chain)

    private fun prepareResponse(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val mockingParameters = request.tag(Invocation::class.java)?.method()?.getAnnotation(Mockable::class.java)
        return if (mockingParameters?.mockEnabled == true) {
            mockResponseManager.prepareMockResponse(context, request, mockingParameters.fileName)
        } else {
            chain.proceed(request)
        }
    }
}
```

In this branch you'll find:
*   User Interface built with **[Jetpack Compose](https://developer.android.com/jetpack/compose)** 
*   A single-activity architecture, using **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation)**.
*   A presentation layer that contains a Compose screen (View) and a **ViewModel** per screen (or feature).
*   Reactive UIs using **[Flow](https://developer.android.com/kotlin/flow)** and **[coroutines](https://kotlinlang.org/docs/coroutines-overview.html)** for asynchronous operations.
*   A **data layer** with a repository and two data sources (local and a fake remote).
*   UI and Unit tests with Compose UI Test, JUnit, Mockito, MockWebServer, Truth, Turbine.
*   A collection of unit, integration and e2e **tests**, including "shared" tests that can be run on emulator/device.
*   Dependency injection using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android).
*   Networking with [Retrofit](https://square.github.io/retrofit/).
*   CI&CD - EWA uses Github actions [Git Workflow](https://github.com/features/actions), [pipeline.yaml](https://github.com/omeryildirim01/EWA/blob/master/.github/workflows/pipeline.yml) The Pipeline handles kotlin linter and running unit tests on each MASTER Pull Requests.
*   Code Quality, use kotlin linter
    ```
       ./gradlew ktlintCheck
       ./gradlew ktlintFormat

    ```
    
## Architecture

![architecture_flow](https://github.com/omeryildirim01/EWA/assets/17796968/18c8b080-ce27-425f-a47a-65504260ecb9)

The 3 layered architectural approach is majorly guided by clean architecture which provides
a clear separation of concerns with its Abstraction Principle.

![arch_structure](https://github.com/omeryildirim01/EWA/assets/17796968/c7b6bab1-6149-4266-8a26-7e7820c176da)

As the architecture blends MVVM with MVI, there are a three core components described:

```State``` Data class that holds the state content of the corresponding screen. The state is exposed as a Compose runtime MutableState object from that perfectly matches the use-case of receiving continuous updates with initial value.
```Event``` Plain object that is sent through callbacks from the UI to the presentation layer. Events should reflect UI events caused by the user. Event updates are exposed as a MutableSharedFlow type, which is similar to StateFlow and behaves as if in the absence of a subscriber, meaning any posted event will be immediately dropped.
```Effect``` Plain object that signals one-time side-effect actions that should impact the UI (e.g., triggering a navigation action, showing a Toast, SnackBar, etc.). Effects are exposed as ChannelFlow, which behave such that each event is delivered to a single subscriber. An attempt to post an event without subscribers will suspend as soon as the channel buffer becomes full, waiting for a subscriber to appear.


#### Presentation

```app``` contains the UI Components (atomic elements, molecular etc.) which handles representing of the UI elements. Compose UI elements are representing the view by serving data from the viewmodel to the UI.

Preview of the UI Component which has been created by using Jetpack Compose

** Preview of the WeatherCard

![Screenshot 2023-09-05 at 21 40 57](https://github.com/omeryildirim01/EWA/assets/17796968/31d9d578-2ebb-4607-8924-d5df8f4692d9)

** Preview of the DailyWeatherInfoBox 

![Screenshot 2023-09-05 at 21 39 25](https://github.com/omeryildirim01/EWA/assets/17796968/a92d8b41-ab0c-463a-b689-8b4414770c02)

** Preview of the WeatherPreferencesBox

![Screenshot 2023-09-05 at 21 45 23](https://github.com/omeryildirim01/EWA/assets/17796968/807e1b11-b8bb-4a84-8d7e-e3f04d2c4fb8)

** Preview of the WeatherInfoRow

![Screenshot 2023-09-05 at 21 47 34](https://github.com/omeryildirim01/EWA/assets/17796968/91c208ec-c005-455f-9def-f2c9f050ca6f)

** Preview of the TodayWeatherImage

![Screenshot 2023-09-05 at 21 48 24](https://github.com/omeryildirim01/EWA/assets/17796968/e61ebd4a-a76a-4369-b2db-c0cd0a0610a9)

** Preview of the WeatherHighlights

![Screenshot 2023-09-05 at 21 50 12](https://github.com/omeryildirim01/EWA/assets/17796968/65093f06-9551-4610-afe1-6d6136cbd9f8)

** Preview of the EWALazyRow

![Screenshot 2023-09-05 at 21 52 02](https://github.com/omeryildirim01/EWA/assets/17796968/0931313e-6885-4b72-af2c-89092b8a834f)


#### Domain

The ```domain``` module contains domain model classes which represent the
data we will be handling across presentation and data layer.

Use cases are also provided in the domain layer and orchestrate the flow 
of data from the data layer onto the presentation layer and a split into
modular pieces serving one particular purpose.

#### Data

- ```data-mockable-true```

Handles request by using mock data interacting with the network and countiunusly serving mock data to the presentation layer through 
domain object

- ```data-mockable-false```

Handles remote api request by using retrofit and open weather API.

With this separation we can easily swap mock data or real API data.

## Testing

Each module will be including own tests, still in progress.

All server responses in the tests will be served by mock web server by using relative urls as well as mock json assets.

## Spesifications

Minimum Android SDK Version: 26

Target JDK Version: 17

## Notes: 

** Development still in progress

Clone the repository:

```
git clone git@github.com/omeryildirim01/EWA.git
```

### License

```
Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```
