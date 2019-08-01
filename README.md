Traffic Light Intersection Simulation
UML: https://drive.google.com/file/d/1U0YeZdGE0koc1pUH35MT7z78EqhWiPkI/view?usp=sharing

This program simulates traffic scenarios at a four-way intersection by using objects for 
each entity involved at the traffic intersection.

Car - Class that controls car motion, interaction with a lane sensor, and which lane 
    the car is in.

    Car(Lane lane) - Constructor takes a lane object parameter and returns a car object

    stop() - Orders the car to stop moving and prints where it stops by checking
        to see whether the light is green or red.

    go() - Orders the car to leave the intersection and prints the direction it's
        going  by checking whether the light is green or red.

    getTag() - Returns the direction of the lane.

    getMotion() - Returns true or false if the car is in motion.

    setMotion(boolean bool) - Set to true or false depending on whether the car
         is stopped or going.
         
    getSensor() - Returns true or false depending on whether the car is on a sensor.
    
    setSensor(boolean bool) - Sets onSensor to true or false when a car approaches
         or leaves an intersection.
         
    getLane() - Returns the lane object.
    
    setLane(Lane lane) - Sets the lane that the car is in.
    
CarList - An ArrayList class that keeps track of all cars at the intersection until they leave.
    
    CarList() - Constructor initializes and ArrayList of type Car.

    peek() - Returns first car element in the ArrayList.

    remove() - Removes and returns the first car in the ArrayList.

    add(Car c) - Adds Car object to the ArrayList.

    setList(ArrayList list) - Initializes list.

    advance() - Moves every car in the list 1 closer to head.

    size() - Returns the length of the ArrayList.

Clock - Keeps a global clock by incrementing seconds, minutes and hours.
    
    Clock() - Constructor initializing fields.

    setSeconds(int sec) - Takes an int and adds seconds to clock.

    setMinutes() - Updates minutes based on seconds.

    setHours() - Updates hours based on minutes.

    toString() - Converts ints to Strings and prints the updated time.

Controller - Controls traffic lanes by taking information from lanes's sensors and 
    computing sequence to get all cars through the intersection.

    Controller(Lane[] lanes) - Constructor takes set of lanes and initializes lanes array 
        to the one passed in and initialized laneWithCar to a null value.

    lanesWithCar() - Finds which lanes currently have a car on their sensor and sets
        laneswithCar to the lanes that have a car in them.

    sendcar(int laneToSend) - Sends cars on a specific lane by setting all other
        lanes to red, then this lane to green.

    printLights() - Prints the current state of each lane's lights.

Lane - Initializes lanes with the direction they go.

    Lane(char tag) - Takes parameter tag of the direction of the lane and initializes
        class objects.

    carOnSensor() - Returns true or false depending on whether the car is on a sensor.

    addCar(Car car) - Adds car object to ArrayList.

    removeCar() - Calls remove() from CarList to remove the first car of ArrayList.

    setLight(char color) - Changes traffic light's colors.

    getLight() - Returns the color of the lights.

    getTag() - Returns the direction of the lane.

    printLight() - Prints the states of the traffic lights.

    setTag(char tag) - Initializes the lane's direction.

    getOppTag() - Returns the opposite lanes direction.

    setOppTag() - Initializes the opposite lane's direction.

LightBulb - Class containing enumerated datatypes of traffic light bulbs.

    getState() - returns true or false of whether a bulb is on or off.

    setState(boolean state) - Sets light bulb on or off by whether it is true or false.

Sensor - Traffic lane sensor checks whether a car is present at the light.

    Sensor(CarList l) - Constructor sets CarList object.

    carPresent() - Checks first element of CarList to see if a car is present in lane.

    getCarOnSensor() - Calls carPresent() to see if car is on sensor and returns true
        or false.

Simulator - Simulates traffic scenarios through class ojects.

    main(String[] args) - Performs certain functions: run - No Car sim, 
        run1 - Eastbound Car, help - Prints again, quit - Exits program, 
        and Input Needed.

    run1(String[] args) - Runs the scenario of a car approaching from eastbound lane
        by using class objects and their methods.

    run(String[] args) - Runs the scenario with no cars at the intersection.

Timer - Class timing the traffic light operations of the intersection.

    Timer(int s) - Constructor takes time in seconds the lights should run for.

    getTime() - Returns amount of time to run light timer.
    
    tick(int t) - Subtracts timer's seconds by the amount of seconds that have passed
        by the clock.
        
    setTime(int sec) - Sets timer's time in seconds.
    
TrafficLight - Contains states of all traffic light's colors. Sends information to Controller
    and updates lights based on Controller.
    
    BulbColor - Enum of three states representing the different light states.
    
    TrafficLight() - Constructor default setting all lights to red.
    
    TrafficLight(char color) - Takes first letter character of light color and
        sets the light bulb to that color.
        
    getColor() - returns color of the bulb.
    
    setColor(char color) - Sets the color of the traffic light bulb.
    
    changeLights() - Sets and prints the traffic light state and 
        sets the other light bulbs to false. 

    toString() - Returns a String for light bulb color.

Pedestrian - Pedestrian at a crosswalk for a lane at the intersection.

    Pedestrian(String loc) - Returns a Pedestrian object with a direction set.

    stop() - Orders Pedestrian to stop and prints which crosswalk lane they are
        stopped at.
    
    go() - Orders Pedestrian to walk across the crosswalk.

    getMotion() - Retuns true or false whether the pedestrian is in motion.

    setMotion() - Sets motion to true or false whether the Pedestrian is walking.

    getWait() - Returns true or false whether or not the Pedestrian is 
        at the crosswalk
    
    setWait(boolean bool) - Sets wait to true or false whether the Pedestrian is
        in motion or not.

    getLocation() - Returns a String that is the direction of the Pedestrian.
