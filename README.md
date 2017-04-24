# Extract & Compute Kata

## Background

In `src/main/resources` you will find two data files `consumption_data.json` and `consumption_data.csv`. Both contain and identical set of data. This is;

* Electricity consumption data for 3 sensors
* 1 reading per hour on the hour for a single day 
* Date and time information in ISO 8601 format
* Electricity consumption in **Wh**

## The Brief

We would like you to;

1. Load a data file (doesn't matter which)
2. Extract the consumption data for sensor ID `b08c6195-8cd9-43ab-b94d-e0b887dd73d2`
3. Calculate the sensor's total daily consumption in **kWh** (`10.713 kWh`)
4. Calculate the sensor's average hourly consumption from 00:00 to 07:00 inclusive (`0.322875 kWh`)
5. Calculate the sensor's average hourly consumption from 08:00 to 15:00 inclusive (`0.44925 kWh`)
5. Calculate the sensor's average hourly consumption from 16:00 to 23:00 inclusive (`0.567 kWh`)


## Approach

Through this exercise we're looking for the following;

* Scala with clean code and an adherence to functional paradigms
* Test Driven Development. This doesn't have to be dogmatic but we do want you to bake in quality
* The same excellent development practices you use in your day job
* Great communication (Dave is a junior Scala engineer pairing with you)
* Feel free to use the Internet (Google, Travis or libraries / frameworks etc...) Whatever makes your life easier!
