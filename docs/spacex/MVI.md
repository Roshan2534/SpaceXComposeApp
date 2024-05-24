# [MVI (Model-View-Intent) Architecture](https://medium.com/swlh/mvi-architecture-with-android-fcde123e3c4a)

## [Model-View-Intent](https://proandroiddev.com/mvi-architecture-with-kotlin-flows-and-channels-d36820b2028d)

- Model: single source of truth of overall state, immutable to ensure updates are from single source
- View: represents UI, defines user actions and renders state emitted by model
- Intent: intention to perform an action by user or by app itself

## Scenario

```
Develop an app with a configuration screen. It loads existing configuration and needs to toggle
various switches and prepopulate input fields with existing data. After data is loaded user can
modify each of those fields. You would need to keep mutable references for data represented in those
fields so when user changes a value, the reference changes.

This may pose a problem because of immutability of those fields especially with concurrent 
operations or their order. A solution is to make data immutable and combine into state that UI can 
observe. Any changes will be through a reactive data flow. The flow can create a new state 
representing the change and update the UI.

This is how MVI works. The View plays the same role as in MVP/MVVM and the Model holds state of UI,
representing single source of truth. The Intent is represented by any changes that should be made to
the state which will then be updated.

NOTE: this is not a replacement, it's a UI pattern that sits on top of current architecture.
```

## Types of Flows

- MutableStateFlow: emits last value held
    - good for UI, like LiveData
- SharedFlow: is useful for actions
    - as we do not want last action to be emitted twice
- One-shot events: useful when View needs to respond to events in a channel flow to display toast
  alert or handle navigation to new screen
- Flow: continuous stream of data
    - represents sequence of values that can be asynchronously computed and delivered over time
    - way to handle data that arrives at different intervals such as fetching data from a database
      or streaming updates
- StateFlow: represents a value that can be observed over time
    - whenever the value changes you can react to it
    - often used to represent state of UI such as whether a button is pressed or user is logged in
- SharedFlow: multiple observers (listeners) can listen to same stream of data independently
    - useful when you want multiple parts of your application to react to the same data source
      without interfering with each other

## Disadvantages

- Added complexity
- Compose boilerplate
    - `LaunchedEffect`
    - `Channel` for emitting one-off events
