# Progress Log
## Dedong Xie
### First Week 20211004-20211011
#### Design 20211004, 20211009-20211010
Worked with Evelyn and Raymond on the design of classes of Staff, ServingStaff, DeliveryStaff, InventoryStaff, PlacedOrderQueue, Order, and Kitchen.

Designed CRC cards of the above classes with Evelyn and Raymond.

Discussed mechanism of Kitchen class with Evelyn and Raymond.
#### Coding 20211010-20211011

Implemented following classes:

- Staff: the parent class of all kinds of staff
    - ServingStaff: subclass of Staff, a staff that sends dishes to tables
    - DeliveryStaff: subclass of Staff, a staff that sends orders for takeout orders
- PlacedOrderQueue: A queue to hold the orders by customers for Kitchen to process

#### Testing 20211011
Created at least one test for all the methods in all the classes I wrote as described in the coding part.
