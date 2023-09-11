# PPA-assignment
Take-home coding assignment for java back-end/full-stack developer position in Police and Border Guard Board.

## Description

The aim of this assignment was to create a simple Java application with REST services, that is able to do two number addition and to query from previous additions.\
The project was done in VS code with Java Extension Pack and Spring Boot Extension Pack.

## Usage

Run the Spring Boot application. It will expose the `/liida` and `/otsing` endpoints. Based on the GET method and inputs the program will behave as follows:

### /liida
Accepts two integer inputs labelled `"arv1"` and `"arv2"`. Checks the input validity based on the constraints of the assignment `(0-100)` and throws an error if one of the inputs is wrong.\
Adds two numbers together and displays the numbers and sum object.\
Ex. case:\
`/liida?arv1=10&arv2=20`

### /otsing
Accepts one optional integer input `"arv"` and one mandatory input `"jarjestus"`. Checks the input validity based on the constraints of the assignment `(0 <= arv <= 100)` and `(jarjestus = "kasvav" || "kahanev")` and throws an error if one of the inputs is wrong.\
Displays the history of the additions in the current session in either ascending/decending order and if optional integer is present, then all the equations where the integer is not present in any of the operands or result will be filtered out.\
Ex. case:\
`/otsing?jarjestus=kasvav`\
`/otsing?arv=10&jarjestus=kahanev`

#### Additional Comments
As I was not sure whether to use estonian or english programming terminology, then please excuse the amalgamation of both you may find in the source code.