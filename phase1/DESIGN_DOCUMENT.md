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
- ## Manager (Do we still have this?)
    - Managers can see the quantity of each dish sold over a customizable period of time
    - Manager can use a timetable to arrange the prices of dishes (special offer) in the following day/week/month/season. They can decide to lower the price of a dish with small demand and raise those with higher demand. They can determine discounts according to specific events or seasons on dishes. 
    - Managers can assign staff to certain tables
- ## Inventory
    - Inventory stores the ingredients of the restaurant, provides search and update functions to check the availability of ingredients and get new ingredients in. 
    - Inventory reads and write to data files to keep track of the inventory status, including the ingredients' type, amount, and status (fresh or frozen, available or used up)
    - Manager can manage the type and quantity of raw materials needed per day and per week (some materials need to be updated daily and some weekly).
- ## Review
    - Customers can provide a review and rate their experience. The review may be anonymous.
# Optional UML
# Description of major design decisions
# Brief description of how the project adheres to Clean Architecture
# Brief description of SOLID design principles
# Brief description of packaging strategies
# Summary of any design pattern
# Progress report
## Open questions
## What has worked well
## Summary of each group member's work and plan 