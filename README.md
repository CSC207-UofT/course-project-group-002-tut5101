## Specifications
### Purpose and Audience
This is an application designed for specific restaurant, not a chain, considering for specific restaurant, there would
be more requirements for systematic and effective management which could be conducted with the help of software.
The specific user could be anyone in a restaurant. From the consumers to the ones working in a restaurant. Every user
would have access to the information they desired, for example, a customer can easier use the menu and make an order
from this app.

### entity.User

A restaurant app with the following types of users and user specific functions:

### use_case.Customers

Customers can see prices, pictures, and allergy information of food items

Customers can order different quantities of food and see their total price

Customers can ask for staff assistance and mark requests as complete

### use_case.Kitchen

Once the order is sent, kitchen workers can see a list of orders and check off when orders are ready to be served

The kitchen can check the ingredients and their status (including freeze or not, freshness) and update the status and their numbers of ingredients

### entity.DeliveryStaff

Deliver services—takeaway people can see the order’s destination, time, dishes, additional requirements, estimated time of arrival.

### entity.ServingStaff

Serving staff can see which tables ordered a certain dish and when the kitchen marks the dish as ready, as well as when the dishes have been delivered to the table

Staff can see when customers require assistance

Staff can choose to only see orders pertaining to the tables they are assigned by the manager

### use_case.UpdateInventory

Check and update the freshness and quantity of inventory items.

### use_case.Manager

Managers can see the quantity of each dish sold over a customizable period of time

use_case.Manager can use a timetable to arrange the prices of dishes (special offer) in the following day/week/month/season. They can decide to lower the price of a dish with small demand and raise those with higher demand. They can determine discounts according to specific events or seasons on dishes.

Managers can assign staff to certain tables

### entity.Inventory

When a product is sold out based on the inventory, the product will show up as sold out on the menu so customers cannot order more

Manager can manage the type and quantity of raw materials needed per day and per week (some materials need to be updated daily and some weekly).

### entity.Review

Customers can provide a review or rating of their experience either anonymously, or leave their contact information if desired 
