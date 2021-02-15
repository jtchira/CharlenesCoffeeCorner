# CharlenesCoffeeCorner


# Assumtions


- Extras are only for coffee.
- A coffee can have only one extra.
- Extras aren't selling alone (must be with a coffee).
- The product values can be in a properties file, but i handled like class constants for simplicity.
- Maybe is posible give some structure for the input in order to proccess better. I prefer left it like the example
- if the fifth beverage has an extra, the free beverage reward includes the extra value.
- The extra discounts are applied in the requested order

# Install

1. Download the maven project. You can use the command "git clone https://github.com/jtchira/CharlenesCoffeeCorner.git"
2. Install the project executing the command "mvn install" in the folder donwloaded (must be a .pom file). It generates a jar file in the folder specified for    your local maven installation. In my case is /home/jorge/.m2/repository/charlenes-coffee-corner/charlenes-coffee-corner/0.0.1-SNAPSHOT.
3. Once installed with maven, in the installation folder a jar file is generated. Run de program with the command java charlenes-coffee-corner-0.0.1-SNAPSHOT and pass the agument parameter with the order request.

Example: 

java charlenes-coffee-corner-0.0.1-SNAPSHOT "Jorge : Small coffee with foamed milk , Medium Coffee , Large Coffee With Special Roast , Bacon Roll , orange juice ; Diego : orange juice ; Jorge : orange juice , Medium Coffee , Medium Coffee , Medium Coffee , Medium Coffee , Large Coffee"



# Request structure

To run the program a String must be passed like parameter argument. This String contains the diferent orders and has the following structure:

CustomerName: Order customer (for the fifth beverage recompensation program)

The products are:
 - Small Coffee
 - Medium Coffee
 - Large Coffee
 - orange juice
 - Bacon roll
 
The extras are:
 - milk
 - foamed milk
 - special roast

if a coffee has an extra, it must specified as the following structure 
$coffee with $extra
Example: "Large Coffee with foamed milk"
  
The structure for the param is as follow:

"$CustomerName : $product , $product ; $CustomerName : $product ; $CustomerName , $product"

Example:

"Jorge : Small coffee with foamed milk , Medium Coffee , Large Coffee With Special Roast , Bacon Roll , orange juice ; Diego : orange juice ; Jorge : orange juice , Medium Coffee , Medium Coffee , Medium Coffee , Medium Coffee , Large Coffee"
