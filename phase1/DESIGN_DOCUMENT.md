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
    - Manager can delete reviews with score less than 4.
    - Manager can manage the menu can change the prices of the dishes whose price is less than 10 per serve.
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