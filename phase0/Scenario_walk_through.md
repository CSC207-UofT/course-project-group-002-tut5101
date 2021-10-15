## Scenario Walkthrough
A dine-in UseCase.Customer checks the menu, which obtains a list of dishes and their prices from DishList. When the UseCase.Customer
places an entities.Order on PlaceOrderQueue, the total price is calculated and returned to the UseCase.Customer.

The kitchen will repeatedly ask for orders to be cooked, when they finish a dish, they update the ingredient quantity in
the inventory, and they check if this dish belongs to a delivery order or a dine-in order. If dine-in order, then add
a tuple of table number and dish to a queue for the serving staff. Serving staff repeatedly check if there is any
dish to be served, if yes, they pop the dish and serve it.  