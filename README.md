# cart-kata
Implementing a simple checkout system, 4 products available, each with a price per unit. Some products have a special price when bought in certain quantities (e.g. 3 of product A costs 140, not 150).

Technologies Used
1. Java
2. Jackson Library - Used for consuming Json
3. JUnit - Used for creating and running Test
4. Lombok Annotations - To reduce the boilerplate code and automatically generating the getter and setter methods

How to Set up and Run Prerequisites
* Java JDK 18
* Maven
  
Install Dependencies

```
mvn install
```

Build Project 
```
mvn clean compile
```

Run Main method
```
mvn exec:java 
```

Which will then output £274 in the terminal you ran the program from
