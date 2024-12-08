# Plant Application

Plant Mobile Application

## Contents

- [Requirements]()
- [Software Language and Technology]()
- [Structure]()
    - [Folder Structure]()
- [Libraries]()
- [Additional Informations]()
- [API Calls]()

## Requirements

- Gradle Version: 8.9
- AGP Version: 8.7.3
- targetSdk = 34
- minSdk = 21
- compileSdk = 35

## Software Language and Technology

- It is developed in Kotlin language.

## Structure

Folder Structure

```bash  
.
└── PlantApp/
    ├── app/
    │   └── src/
    │       ├── main/
    │       │   ├── AndroidManifest
    │       │   ├── res
    │       │   │      ├── anim
    │       │   │      ├── drawable 
    │       │   │      ├── font
    │       │   │      ├── menu
    │       │   │      └── navigation
    │       │   │                
    │       │   └── java/
    │       │       └── com/
    │       │           └── kardelencetin/
    │       │                       └── plantapp/
    │       │                               ├── core/
    │       │                               │    ├── preferences
    │       │                               │    └── util
    │       │                               └── feature/
    │       │                                     ├── getstarted
    │       │                                     │         ├── model
    │       │                                     │         ├── module 
    │       │                                     │         ├── repository
    │       │                                     │         ├── usecase
    │       │                                     │         ├── view/fragment
    │       │                                     │         └── viewmodel
    │       │                                     ├── homepage
    │       │                                     │        ├── adapter
    │       │                                     │        ├── model
    │       │                                     │        ├── module 
    │       │                                     │        ├── repository
    │       │                                     │        ├── roomdb
    │       │                                     │        │        ├── dao
    │       │                                     │        │        ├── database
    │       │                                     │        │        └── entity
    │       │                                     │        ├── service
    │       │                                     │        ├── usecase
    │       │                                     │        ├── util
    │       │                                     │        ├── view
    │       │                                     │        │      ├── activity
    │       │                                     │        │      └── fragment
    │       │                                     │        └── viewmodel
    │       │                                     ├── main                                
    │       │                                     │      └── view/activity                                                    
    │       │                                     ├── onboarding
    │       │                                     │        ├── adapter
    │       │                                     │        ├── model
    │       │                                     │        ├── module 
    │       │                                     │        ├── repository
    │       │                                     │        ├── usecase
    │       │                                     │        ├── view
    │       │                                     │        │      └── fragment
    │       │                                     │        └── viewmodel
    │       │                                     └── paywall
    │       │                                               ├── adapter
    │       │                                               ├── model
    │       │                                               ├── module 
    │       │                                               ├── repository
    │       │                                               ├── usecase
    │       │                                               ├── view
    │       │                                               │      └── fragment
    │       │                                               └── viewmodel
    │       │
    │       │
    │       │
    │       │── test [unitTest]/
    │       │       └── java/
    │       │             └── com.kardelencetin.plantapp.feature.homepage           
    │       │                                                           └──viewmodel                                
    │       │                      
    │       │        
    │       └── build.gradle
    ├── build.gradle
    └── settings.gradle

```

## Libraries

The libraries used in the project are as follows.

```bash

```

## Additional Informations

- 
 
## 

## API Calls

BASE_URL: "https://dummy-api-jtg6bessta-ey.a.run.app/"

#### Get Category Lists

```
  GET /getCategories"
```

#### Get Question Lists

```
  GET /getQuestions"
```

README.md dosyası [readme.so](https://readme.so/) kullanılarak oluşturulmuştur.




