package com.delta.listviews;

/**
 * Created by anthonyang on 3/10/17.
 */

public class PlaceDataStore {

    public static Place[] getPlaceArray() {

        Place[] myPlacesArray = new Place[]{
                new Place("Art House", 78701, "art", "This place is tasteful"),
                new Place("Bike Shop", 78702, "bike", "Cool bikes"),
                new Place("Camera Fix", 78702, "polaroids", "These guys always rip me off"),
                new Place("YETspace", 78702, "radio", "I LOVE this place"),
                new Place("Secret Space Pad", 94103, "rocket", "Not very secret, are they?"),
                new Place("Taylor's Tailor", 60610, "scissors", "Looking good.."),
                new Place("Boathouse", 78701, "shipwheel", "That place is full of pirates!"),
                new Place("Not Apple Store", 78702, "tablet", "Android rules!"),
                new Place("Tool Battleground", 78702, "tools", "That place is dangerous"),
                new Place("Travelpediocity", 78702, "travelerbag", "This is where i booked my summer trip"),
                new Place("UFO Pick-a-part", 90210, "ufo", "Out of this world stuff here."),
                new Place("Spawrk's House", 99999, "volume", "The music is always so good"),

        };
        return myPlacesArray;
    }

    public static String[] getStringArray(){

        String[] myStringArray = new String[]{
                "Art House",
                "Bike Shop",
                "Camera Fix",
                "YETspace",
                "Secret Space Pad",
                "Taylor's Tailor",
                "Boathouse",
                "Not Apple Store",
                "Tool Battleground",
                "Travelpediocity",
                "UFO Pick-a-part",
                "Spawrk's House",
        };
        return myStringArray;
    }
}
