# Progress Report
## Summary of Specification
This is a restaurant application for a specific restaurant in order to manage the staff and inventory conveniently and
incorporate the traditional service with digital platforms to facilitate the customers' experience. The specific users
include personnel in a restaurant and customers. The users would get their required information faster and easier than
before.
## Summary of CRC Model
We designed the CRC model according to its description and functionality.
We decided that entity in the clean architecture, which are objects that embodies a small set of
Critical Business Rules operating on Critical Business Data, includes User(an abstract class that is the superclass
for Customer, Manager and Staff), Staff(a superclass for ServingStaff, InventoryStaff, DeliveryStaff), Order, Dish, DishList,  RestaurantInfo, Inventory(which is an abstract class and superclass for Product and Material),
Product(which is an abstract class and superclass for Alcohol, SemiFinished, and SoftDrink), SoftDrink, Alcohol, SemiFinished,
Material(which is an abstract class and superclass for Meat, Seafood, Seasoner, VegeFruit, Grain, DairySoy), Meat, Seafood,
Seasoner, Vegefruit, Grain and DairySoy. We decided that use cases in the clean architecture, which is a description of
the way that an automated system affect Entities, includes InventoryList, Review, OrderHistory, PlaceOrderQueue, Kitchen,
DeliveryStaff, ServingStaff, InventoryStaff, Manager and Customer.
We labeled the inheritance relationships between classes and their collaboration and responsibilities, and whether they
are abstract.
We modified our CRC model several times during coding to fit our program.

## Summary of Scenario Walk-through
A dine-in customer ordered dishes from a list then the dishes were served after finish.
## Open Questions
- Struggling on the exact implementation of InventoryList. Considering for the staffs involved in this scenario required
only freshness and quantity, the final decision is hard to made between a single hashmap like structure or two hashmap 
like structures which are easier to use but hard to add more features in the future.
- Extract methods to proper layer based on Clean Architecture.

## Designs that have worked well
- The change from our original design of OrderList and KitchenStaff to only Kitchen with three queue attributes 
simplify the ordering -> food processing -> food serving / delivering process a lot. It also makes the purpose of each 
attribute very clear and easy to comprehend.
- The previous idea of creating simply hashmap of name-freshness and name-quantity was change to a specific class 
InventoryList, which protect the internal information in a hashmap.
- For command-line ui, the current user could log out from the system then another user could log in with credentials 
to view different info.



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

## Summary of Subgroup2 Progress

### General information

Our group have 2 people, Chan Yu and Naihe Xiao. We worked on the design of the User class(which is the
super class for Customer, Manager, Staff and child classes of Staff), Customer class, Manager class,
UserList class, Dish class and DishList class. We included comments for each class and its methods.

We worked on the CRC cards of the classes included above.

We also included the basic progress for a customer to login to his or her account in the RestaurantSystem
class, which is the class we are intending to use as our main operating class in our program.

### Coding of each class

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

### Testing

We also wrote at least an unittest for each class, and an unittest for each method, both overridden and overloading ones.
We left comments including descriptions and responsibilities of each unittest class.


## Summary of Subgroup3 Progress

### General information

Our group have 2 people, Mingyang Li and Shaojie Dong. We worked on the design of the Inventory class(which is the
super class for Product class and Material class), Product class, Material class,
their child classes which can be made as instance, InventoryList class and Review.
We included comments for each class and its methods.

We worked on the CRC cards of the classes included above.


### Coding of each class

- Inventory: the parent abstract class of Product and Material class, whose quantity and used up status can be checked
  and changed by methods.
  - Product: a child abstract class of Inventory whose expiry date can be checked.
    - Alcohol, Semifinished, SoftDrink: Sub class of Product which can be instantiated.
  - Material: a child abstract class of Inventory whose freshness can be checked and changed.

- InventoryList: a class that contains inventory items. Certain information can be checked or set by its name.
- Review: a class that represent the review of customers
  We also added specific descriptions of each class and their methods as comments.

### Testing

Creating unit test for InventoryList class, Product class ,Material class and Review.



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

#### Coding 2021 Oct 10, 11, 14
Implemented the Order class and its getter and setter methods. Discussed with Howard and Chan about
attributes of the Dish class needed for the Order class. Created tests for the Order class methods. Worked on
implementing the command line for kitchen and serving staff with Dedong and Raymond.

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


### Chan Yu
#### Week Sept. 27 - Oct. 15
#### Design efforts
Contributed to project domain decisions and expanded potential functionalities in the ice-break meeting.
Designed the CRC cards with Naihe for the assigned tasks/classes.
Discussed with other subgroups about implementing the Dish class and its attributes type.
Follow the Clean Architecture principle and extracted the placeholder lists (users & dishes) from Use Case classes to Controller class.

#### Coding efforts
Implemented the Customer, Manager, UserList, Dish, DishList, UserList by collaborating with Naihe. 
Designed test cases and JavaDoc for classes mentioned above with Naihe. 
Designed and implemented the RestaurantSystem class with Naihe, including functionalities of user login/logout, cmd-line ui display, and user interactions.

#### Future planning
Upgrade the user login controller based on the demo project provided by instructors. 
Implement and expand methods in the assigned classes. 
Move placeholder lists to file and upgrade the system with file I/O ability. 

### Shaojie Dong
#### Week 2021 Oct 4 - 11
#### Design 2021 Oct 4, 10, 11
Designed the CRC cards of the following classes with Mingyang Li: Inventory,
Material, Product, Alcohol, Semifinished, SoftDrink, Meat, Seafood, Seasoner, VegeFruit, Grain, DairySoy.
Discussed the requirements of InventoryList with Dedong Xie, Evelyn Chou and Raymond Liu and designed the CRC card of
this class.

#### Coding 2021 Oct 10, 11
Implemented the Inventory class, Material class, Product class and their getter and setter methods.
Discussed with Raymond Liu about
attributes of the InventoryList class needed for the Order class. 
Created tests for the methods of Inventory class, Material class, Product class and InventoryList class.

#### Future planning
Design and Implement the InventoryGenerator class which can create Inventory by txt files.


### Mingyang Li
#### Week 2021 Oct 4 - 11
#### Design 2021 Oct 4, 10, 11
Designed the CRC cards of the following classes with Shaojie Dong: Inventory,
Material, Product, Alcohol, Semifinished, SoftDrink, Meat, Seafood, Seasoner, VegeFruit, Grain and DairySoy.
Design the CRC card of Review class
Discussed the requirements of InventoryList with Dedong Xie, Evelyn Chou and Raymond Liu and designed the CRC card of
this class.

#### Coding 2021 Oct 10, 11
Implemented the Review class.
Created tests for the Review class.

#### Future planning
Design and Implement the conversation and link-to-dish features.


