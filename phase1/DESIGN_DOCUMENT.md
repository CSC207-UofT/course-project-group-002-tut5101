# Updated specification
A restaurant app with the following types of users and user specific functions:

- ## Customers
    - Customers can see prices, pictures, and allergy information of food items
    - Customers can order different quantities of food and see their total price
- ## Kitchen
    - Once the order is placed, kitchen workers can see (be notified?) a list of orders and check off when orders are ready to be served
    - The kitchen can check the ingredients and their status (including freeze or not, freshness) and update the status and remaining amount of ingredients
- ## Delivery Staff
    - Delivery services—takeaway staff who can see the order’s destination, dishes.
- ## Serving Staff
    - Serving staff can get a dish to serve
    - Serving staff can see the dish's name and the table ordered
    - After serving a dish, serving staff will mark the dish as completed
- ## Manager
    - Managers can see the quantity of each dish sold over a customizable period of time
    - Manager can use a timetable to arrange the prices of dishes (special offer) in the following day/week/month/season. They can decide to lower the price of a dish with small demand and raise those with higher demand. They can determine discounts according to specific events or seasons on dishes. 
    - Managers can assign staff to certain tables
- ## Inventory
    - Inventory stores the ingredients of the restaurant, provides search and update functions to check the availability of ingredients and get new ingredients in. 
    - Inventory reads and write to data files to keep track of the inventory status, including the ingredients' type, amount, and status (fresh or frozen, available or used up)
    - Manager can manage the type and quantity of raw materials needed per day and per week (some materials need to be updated daily and some weekly).
- ## Review
    - Customers can provide a review and rate their experience. The review may be anonymous.
    - Customers can provide a complain on stuff. The complain may be anonymous.
    - Review reads and write to data files to keep the customer's reviews.
# Optional UML
# Description of major design decisions
# Brief description of how the project adheres to Clean Architecture
- ## Scenario walk-through
  - Customer is presented with the LoginUI, and logs in. The LoginUI calls on the LoginController, which calls on the logIn method in the LoginInputBoundary to determine if the login was successful. The LoginUseCase, which implements this interface, runs the method. If successful, the Customer is then presented with the CustomerUI, and given several options. The Customer chooses to place an order, so the Menu is printed by calling on the MenuController, which calls on the method in use case DishList to pass the menu as a string. The string menu is passed to the Customer UI, which prints it. Each dish is assigned a corresponding number, and the customer is asked to enter the number of the dishes they wish to order. Once the customer is done ordering, the list of numbers is passed to the MenuController, which takes those numbers and returns the list of dish names corresponding to those numbers. This list of dish names is passed to the OrderController, which calls on the placeOrder method in the interface PlaceOrderInputBoundary. The PlaceOrder use case, which implements this interface, then creates a new Order with the dishes the customer ordered, and adds the order to the OrderQueue for the Kitchen to cook.
# Brief description of SOLID design principles
- ## Single responsibility principle
  - Classes such as LoginUseCase are only responsible for checking if login was successful and returning the result.
- ## Open/closed principle
  - We can add any number of types of orders with different features by extending the Order class. This could be made even easier by having the current two DineIn orders and Delivery orders be subclasses of the Order class, instead of merely attributes of it.
- ## Liskov substitution principle
  - Any class that implements the abstract class User is able to login. The login process does not care which type of user it gets.
- ## Interface segregation principle
  - All interfaces are kept small, with most (such as HasExpiry, HasFreshness) requiring only one method. Some interfaces such as ReadandWrite require two methods, but both these methods are necessary for the functionality.
  - If we consider interface to mean the public methods of a class, then some classes such as Order are a bit large, however most of the methods are getter and setter methods, so it would not make sense to split the class.
- ## Dependency inversion principle
  - There are a few interfaces between the controller and use case layers. For example the LoginController does not directly interact with the LoginUseCase, but instead calls on the logIn method in the LoginInputBoundary interface. Similarly, the OrderController calls on the placeOrder method in the PlaceOrderInputBoundary.
  - However, some controllers such as the MenuController directly interact with the DishList use case, so there is no layer of abstraction. This could be fixed by creating more interfaces, ensuring the use cases can easily be replaced without having to change the controllers.
# Brief description of packaging strategies
# Summary of any design pattern
# Progress report
## Open questions
- 

## What has worked well
- The new Kitchen UI. The decision to abandon to the "view order" functionality and replace it a constant display of the
current order (if there is any) matches the GUI design that will be implemented in the future. In addition, the new 
feature of sending out a notification for Kitchen whenever a new order comes in is much more user-friendly, and helps 
the Kitchen keep track of their work.


## Summary of each group member's work and plan 
### Summary of subgroup 1 progress
#### Design
Our group of three (Dedong, Evelyn, and Raymond) discussed new design for serving staff and delivery staff to split them
into two entity classes and two use case classes. We also talked about the design for Customer UI, Customer controller,
Customer use case, Serving staff UI, Delivery staff UI, Serving staff and delivery staff controller, and Kitchen UI, 
Kitchen controller, and Kitchen use case.

#### Coding
Our group of three (Dedong, Evelyn, and Raymond) implemented or edited the following classes from Oct 18 - Nov 4:
- Entity classes:
  - Serving staff, Delivery staff
  - Order, Dish
- Use case classes:
  - UserList, DishList
  - PlaceOrder
  - Kitchen
  - ServingBuffer, DeliveryBuffer, ServeOrder, DeliveryOrder
- Boundary classes:
  - Delivery, PlaceOrderInputBoundary
- Controller classes:
  - OrderController, StaffController, KitchenController
- UI classes:
  - CustomerUI, DeliveryStaffUI, KitchenUI, ServingStaffUI
- Other:
  - CustomerUIMessage, ItemStatus, KitchenUIMessage, LoginLogoutUIMessage, StaffUIMessage
  - TempKitchenMain

Refactored the directory structure for the entire project.

Created test for some classes shown above.


### Summary of subgroup 2 progress
#### Design
#### Coding

### Summary of subgroup 3 progress
#### Design
#### Coding