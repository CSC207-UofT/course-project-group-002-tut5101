# Progress Report
## Summary of Specification
## Summary of CRC Model
## Summary of Scenario Walk-through
## Open Questions
## Designs that have worked well
- The change from our original design of OrderList and KitchenStaff to only Kitchen with three queue attributes 
simplify the ordering -> food processing -> food serving / delivering process a lot. It also makes the purpose of each 
attribute very clear and easy to comprehend.

## Summary of Subgroup1 Progress
### Design
Our group of three (Dedong, Evelyn, and Raymond) on the design of classes of Staff, ServingStaff, DeliveryStaff, 
InventoryStaff, PlacedOrderQueue, Order, Kitchen, and RestaurantInfo.

Designed CRC cards of the above classes by our group.

Discussed mechanism of Kitchen class of our group.
### Coding

Implemented following classes:

- Staff: the parent class of all kinds of staff
  - ServingStaff: subclass of Staff, a staff that sends dishes to tables
  - DeliveryStaff: subclass of Staff, a staff that sends orders for takeout orders
  - InventoryStaff
- PlacedOrderQueue: A queue to hold the orders by customers for Kitchen to process
- Order: A class that holds a list of dishes ordered by a customer, the current status of the order,
and the table number/destination of the order. Can return the total price of dishes in the order.
- Kitchen: A class that gets new orders from an instance of PlaceOrderQueue, updates the status of the dishes in the 
order, and depending on the type of the order, add the dish / order to the queues for either delivery staff or serving 
staff to access.
- RestaurantInfo: A class that holds all the information about this restaurant (e.g. name, address, staffs, capacity).

### Testing
Created at least one test for all the methods in all the classes we wrote as described in the coding part.

## Brief Summary of Each Member's Work

### Dedong Xie
#### First Week 2021/10/04-2021/10/11
#### Design 2021/10/04, 2021/10/09-2021/10/10
Worked with Evelyn and Raymond on the design of classes of Staff, ServingStaff, DeliveryStaff, InventoryStaff, 
PlacedOrderQueue, Order, and Kitchen.

Designed CRC cards of the above classes with Evelyn and Raymond.

Discussed mechanism of Kitchen class with Evelyn and Raymond.
#### Coding 2021/10/10-2021/10/11

Implemented following classes:

- Staff: the parent class of all kinds of staff
  - ServingStaff: subclass of Staff, a staff that sends dishes to tables
  - DeliveryStaff: subclass of Staff, a staff that sends orders for takeout orders
- PlacedOrderQueue: A queue to hold the orders by customers for Kitchen to process

#### Testing 2021/10/11
Created at least one test for all the methods in all the classes I wrote as described in the coding part.

#### Future Planning
Update PlacedOrderQueue and Delivery Staff with the destination and distance simulation.


### Raymond Liu
#### Week Oct 4 - 11
#### Design and coding - Oct 4, 10, 11
Discussed and designed the CRC models for the followings Java classes with Dedong Xie and Evelyn Chou: Staff, 
ServingStaff, DeliveryStaff, InventoryStaff, PlacedOrderQueue, Order, Kitchen, and RestaurantInfo.

#### Coding - Oct 10, 11
Implemented the RestaurantInfo and Kitchen class. Created tests for the Kitchen class methods.

#### Future planning
Implement the user interfaces part for the Staffs and Kitchen.


### Evelyn Chou
#### Week 2021 Oct 4 - 11
#### Design 2021 Oct 4, 10, 11
Worked with Raymond Liu and Dedong Xie on the CRC model and implementation of the following classes: Staff,
ServingStaff, DeliveryStaff, InventoryStaff, PlacedOrderQueue, Order, Kitchen, and RestaurantInfo.

#### Coding 2021 Oct 10, 11
Implemented the Order class and its getter and setter methods. Discussed with Howard and Chan about
attributes of the Dish class needed for the Order class. Created tests for the Order class methods.

#### Future planning
Implement the InventoryStaff class once classes associated with the Inventory are complete.


### Naihe Xiao
#### Week Sept 27th to Oct 3
Proposed the restaurant app and HR system domains as major ideas of program, discussed with all other group members
and evaluated the feasibility of each idea with TA to confirm our final decision.

#### Week Oct 4 to Oct 11
#### General efforts
Worked with Chan Yu on the construction of the User class, Manager class, Customer class and their design
and interrelationships. Based on the responsibilities of Manager, extended the DishList class after finishing 
the Dish class, and extended the UserList class after determining the necessity of adding a log in function for users
in our program.

#### Coding efforts
Implemented the Customer class, Manager class, UserList class, Dish class, DishList class, UserList class by 
collaborating with Chan Yu. 
Discussed with TA and decided the methodology of generation of Users and dishes in the DishList and UserList 
classes. 
Designed test cases for classes mentioned above under the test package. Discussed with Chan to determine the exclusion
of main package that we used to implement.
Wrote comments for Customer, Manager, User, UserList, Dish, DishList classes.
Designed the CRC cards for the above classes with Chan Yu.
Discussed the design of inventory classes and ingredient classes.

#### Future planning
Implement the Manager, Customer classes with further details, and expand the DishList and UserList classes to a wider
diversity. Add more test cases for the new changes.

##Summary of subgroup2 Progress

###General information

Our group have 2 people, Chan Yu and Naihe Xiao. We worked on the design of the User class(which is the
super class for Customer, Manager, Staff and child classes of Staff), Customer class, Manager class, 
UserList class, Dish class and DishList class. We included comments for each class and its methods.

We worked on the CRC cards of the classes included above.

We also included the basic progress for a customer to login to his or her account in the RestaurantSystem
class, which is the class we are intending to use as our main operating class in our program.

###Coding of each class

- User: the parent class of all users of the program(app). This includes Customer, Manager, Staff, Kitchen, ServingStaff,
InventoryStaff and DeliveryStaff. A User has a unique id, a username, password, address, gender, phone and email 
information.
  - Customer: a child class of User that stores information about a customer. It has an overridden toString method that returns the string representation of the specific information of
a customer. A Customer can log in to its account with his or hers id and password, where he or she can see the menu,
and make an order. A Customer can also leave an anonymous comment, or a complaint to a particular serving staff. 
  - Manager: a child class of User that stores information about the manager. It is one of the most important classes in 
our program, and a Manager is able to manipulate the prices of dishes, payment of staffs, inventories list and so on.

- UserList: a public class storing all user information using a HashMap, mapping each userid to a User. It can add and 
remove Users, and find the information of a user or modify a specific attribute of a User.
- Dish: a public class storing basic information of a Dish, including its name, price, ingredients, calories, features like 
recommended or not, allergy information and status of preparation. It contains getter and setter methods for each 
attribute, and has an overridden toString method that returns the string representation of the specific information of 
a dish.
- DishList: a public class storing all dish information using an ArrayList. It has a generateDishList method that can generate
an ArrayList of dishes. It is used by the manager to adjust the prices of dishes according to the number of times a dish
is ordered according to the information stored in OrderHistory class.

We also added specific descriptions of each class and their methods as comments.

###Testing

We also wrote at least an unittest for each class, and an unittest for each method, both overridden and overloading ones.
We left comments including descriptions and responsibilities of each unittest class.