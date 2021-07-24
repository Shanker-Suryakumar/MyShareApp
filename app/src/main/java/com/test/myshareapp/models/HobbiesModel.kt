package com.test.myshareapp.models

data class HobbiesModel(var hobbiesTitle: String) {

    object Supplier {
        val hobbiesList = listOf(
                HobbiesModel("Songs"),
                HobbiesModel("Games"),
                HobbiesModel("TV"),
                HobbiesModel("Computer"),
                HobbiesModel("Swimming"),
                HobbiesModel("Cricket"),
                HobbiesModel("Guitar"),
                HobbiesModel("Violin"),
                HobbiesModel("Singing"),
                HobbiesModel("Exercise"),
                HobbiesModel("Gym"),
                HobbiesModel("Cycling"),
                HobbiesModel("Bike Ride"),
                HobbiesModel("Car Trips"),
                HobbiesModel("Smule")
        )
    }
}