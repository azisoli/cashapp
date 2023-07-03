1.you can tun it in android studio emulator   minSdk 24
2.focus area was on architectures and data flow
3.I am using kotlin language, Retrofit is used to work with api and fetch data.
    dagger Hilt used to bring dependency injection in project.
    MVVM design pattern has been used.
    I am using coroutines and suspend functions to load data in background. 
    observables duty is to let UI know what is happening in background
    on the data's and what is the situation of the api calls.
    I made 3 different calls: for call load stock and empty result and
    malformed call and ui will reflect all results.
    a network helper is checking the internet status.
    i've made a unit test for the api.
4.I spent 5 hours on this project but not continuously. 