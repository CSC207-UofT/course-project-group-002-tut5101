# Progress Report
## Dedong Xie
### Design
Worked with Evelyn and Raymond on the design of classes of Staff, ServingStaff, DeliveryStaff, InventoryStaff, PlacedOrderQueue, Order, and Kitchen.

Designed CRC cards of the above classes with Evelyn and Raymond.

Discussed mechanism of Kitchen class with Evelyn and Raymond.
### Coding

Implemented following classes:

- Staff: the parent class of all kinds of staff
  - ServingStaff: subclass of Staff, a staff that sends dishes to tables
  - DeliveryStaff: subclass of Staff, a staff that sends orders for takeout orders
- PlacedOrderQueue: A queue to hold the orders by customers for Kitchen to process

### Testing
Created at least one test for all the methods in all the classes I wrote as described in the coding part.
