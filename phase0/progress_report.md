# Progress Report
## Summary of Specification
## CRC Model
## Scenario Walk-through
## Open Questions
## Designs that have worked well
- The change from our original design of OrderList and KitchenStaff to only Kitchen with three queue attributes 
simplify the ordering -> food processing -> food serving / delivering process a lot. It also makes the purpose of each 
attribute very clear and easy to comprehend.

## Summary of Subgroup Progress
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
Implemented the Order class and it's getter and setter methods. Discussed with Howard and Chan about
attributes of the Dish class needed for the Order class. Created tests for the Order class methods.

#### Future planning
Implement the InventoryStaff class once classes associated with the Inventory are complete.


