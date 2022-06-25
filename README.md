# VehicleMakes

Sample app for displaying the list of vehicle makes with the possibility to set the selected ones as favorite.

The app consists of three layers: presentation/domain/data.
It is implemented with MVVM architecture and RxJava used for dealing with multithreading topic.

On the presentation layer Jetpack Compose is used for the creation of screens:
- FavoriteCountScreen (+ ViewModel)
- VehicleMakeListScreen (+ ViewModel)
