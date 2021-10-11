## Scenario 1 
A dine-in Customer checks the menu, which obtains a list of dishes and their prices from DishList. 

If the Inventory lacks ingredients to make a Dish, the Dish is marked as SoldOut. 

The Customer places an Order and the total price is calculated and returned to the Customer. 

The Inventory is updated to remove products needed for Dish in Order. 

The OrderList creates a new Order and adds it to the DineInOrders list. 

The KitchenStaff retrieves the list of Dish and their quantity in the Order, 

cooks the Dish, updates Inventory, marks Dish complete, and the ServingStaff retrieves the Dish to be sent. 

ServingStaff marks Dish as sent. 

Once all Dish in Order are sent, Order is marked awaitingPayment. 

If the Customer makes a second Order, the process repeats. 

Once the Customer is ready to pay, 

the ServingStaff marks Order as complete, and the Order is removed from OrderList.  
 
 
## Scenario 2 
When a customer places an order, it is added to a queue.  

The kitchen will repeatedly ask for orders to cook, when they finished a dish, they check if this dish belongs to a delivery order or a dine-in order. 

- if dine-in order 
  - then add a tuple of table num and dish to a queue for the serving staff. 
  - Serving staff repeatedly check if there is any dish to be served, if yes, they pop the dish and serve it. 
- if delivery order 
	- after kitchen finishes a dish, they call the updateDishStatus method in Order to update the status, and also calls the getOrderStatus() to see if the order is completed, then they push the entire order to a buffer queue for the DeliveryStaff. 
	- DeliveryStaff repeatedly check if there is any order to be delivered, if yes, they pop the order and delivery it. 
