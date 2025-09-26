<div id="readme-top"></div>

<br />
<div align="center" style="text-align: center;">
  <a href="https://github.com/JakubNovvak/Mercury">
    <img src="docs/mercury_logo.png" alt="Logo" width="110" height="110">
  </a>

  <h3 align="center">Mercury</h3>

  <p align="center">
    Mobile Chatting App
    <br />
    
</div>

## About The Project
Mercury is an implementation of a simple chatting application. At this stage, Mercury is still more of an interactive prototype than a fully functional app.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Current Stage of Development
Currently, the project serves as an interactive prototype. TextFields do not affect app behavior (e.g., login inputs, sending messages), but navigation works correctly and all screens function as intended, even if connected to real data sources. Data is currently mocked in the "mock" package of the domain layer and accessed via repository interfaces. 
<div align="center" style="text-align: center;">
    <img src="docs/mercury_navigation.gif" alt="mercury navigation gif" width="250"/>
</div>

### Project's Structure
The project follows Clean Architecture principles, separating parts of the project into distinct layers for better maintainability. It uses the MVVM pattern in the presentation layer to organize UI and logic. Dependency Injection is implemented with Hilt, and the Strategy design pattern is used to easily switch between data sources (e.g., mocked or real) via repository interfaces. 

The codebase was organized into four below layers:
- **app**: Application entry point, navigation, and dependency injection setup
- **domain**: Business logic, models, and repository interfaces (with mock data for prototyping)
- **data**: Data source implementations and repository logic
- **presentation**: UI components and screens using Jetpack Compose

### Built With
* [![Kotlin][Kotlin]][Kotlin-url]
* [![AndroidStudio][AndroidStudio]][AndroidStudio-url]
* [![Compose][Compose]][Compose-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Roadmap

- [x] Application's code organized into layers
- [x] Navigation and separate screen, both using Jetpack Compose
- [x] Working and interactable screens - working on mocked data
- [ ] Add support of the Themes
- [ ] Local Realm database, instead of using mocked data
- [ ] Application fully functional:
  - [ ] Adding new messages to chats
  - [ ] Starting new chats by searching through available Users
  - [ ] Logging in as different users 
- [ ] Integration with Firebase through GraphQL

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contact

Jakub Nowak - [@LinkedIn Profile](https://www.linkedin.com/in/jakub-nowak-a245312b7/)
<br/> jakubszymonnowak@gmail.com

Project Link: [github.com/JakubNovvak/Mercury](https://github.com/JakubNovvak/Mercury)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


[AndroidStudio]: https://img.shields.io/badge/Android%20Studio-Narwhal%203-green?style=for-the-badge&logo=androidstudio&logoColor=white&labelColor=006400
[AndroidStudio-url]: https://developer.android.com/studio

[Kotlin]: https://img.shields.io/badge/Kotlin-2.0.21-darkviolet?style=for-the-badge&logo=kotlin&logoColor=white&labelColor=4B0082
[Kotlin-url]: https://kotlinlang.org/

[Compose]: https://img.shields.io/badge/Jetpack%20Compose-2024.09.00-blue?style=for-the-badge&logo=jetpackcompose&logoColor=white&labelColor=1A237E
[Compose-url]: https://developer.android.com/jetpack/compose