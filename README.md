# Customer’s Shopping Cart
## Group Members
- Kyle Frudakis
- Nicholas Giacobbe
- Karl Hezel

# Glossary
[Project Overview] (# Project Overview)
[Minimal Functional Specification] (# Minimal Functional Specification)
[Use Cases] (# Use Cases) 
[Platforms] (# Platforms) 

 
# Project Overview
This is our COP 4331 Project where the application goal is to imitate an online shopping experience. For this project, we will be developing a shopping cart application. When the user opens the application, they will be presented with a login window. Depending on if they have an account or not, they will either log in or sign up. Once an account is created, depending on what kind of account they have (a customer or the seller), the application performs different functions. Customers will be able to purchase items from the seller. Sellers will be able to manage their inventory.

 
# Minimal Functional Specification
A customer logs in with a username and password. If the user does not have an account, they will be invited to sign up for one as a customer. Only one admin should exist as this system is being developed for a single customer. When the customer logs in, a window (frame) opens where he can browse through a list of available products that includes the product name, price, and available quantity. From this window, the customer can select products and add them to the shopping cart by clicking on a plus symbol next to the product name, or they can click on a product name and get the full product description, pricing, and availability (quantity available) in a pop-up window. Exiting this pop-up window will return you back to the home page. The customer can add the product to the shopping cart (quantity), depending on availability. If a selected product is unavailable, the customer will not be able to add it to their shopping cart but can still view the product details. The shopping cart total amount is kept current on the main product browse window. The customer can proceed to checkout at any time. By checking out, a new window is displayed showing the contents of the shopping cart. The shopping cart can be updated on the new checkout window by changing the item count for each product in the cart, keeping in mind the availability of each product in inventory. At checkout, the customer verifies the shopping cart content and pays for the goods by supplying a credit card(simulated). A simulated credit card assumes that the customer has sufficient funds to purchase their goods. The application does not arrange for shipping. 
When the seller logs in, a window opens where the current state of the inventory is shown. The current state shows all products that are available (one or more) and products that are out of stock (0 in inventory). The seller can update the stock by adding products - specifying product name, invoice price, and sell price, and by updating the available quantity by either incrementing or decrementing it. The internal product representation includes ID, type, quantity, invoice price, selling price, and product images. The application must keep track of all costs, revenues, and profits. This information will be on a separate window from the inventory window. The seller can access this information from the application UI.

 
# Use Cases
 
### User Logs In
A User (customer) shall be able to log in to the application with a username and password so that they have access to the application and their shopping cart
An admin (seller) shall be able to log in to the application with a username and password so that they have access to the application and their products. The homepage that will pull up will display information about their product inventories. The admin will be able to add and edit product information on this page. 

### User (customer/seller) enters their username
User enters their password
User submits their username and password
Logged in user is authenticated and confirmed
User is brought to home page depending on their user status(seller or customer)
 
### User signs up
If you are a new user, you will have to create an account. When creating an account. The form will also ask for simple things such as first and last name, email, etc. 
Admin accounts will not be able to be created, only one seller will have access to the product information and be able to edit it. 
 
### New user selects the “Sign Up” button
A window pops-up and the user must fill out a form asking for first and last name, email address, username, and setting password. By default, the account type is the customer. (admin will need to be created manually by a system manager)
The user submits the form and their new account is created
The user is directed back to the login screen.
  
### Customer Adds Items to Shopping Cart
The customer shall be able to click on a button to add items to their shopping cart presented on the homepage. When the customer clicks a button associated with a product, that product shall be added to the currently logged-in user's shopping cart. 
 
### The customer selects the “+” button next to the product name
The product and its quantity of 1 is added to the customer's shopping cart

#### Variant Scenario: Product Inventory Quantity is 0
In the case that when adding a product to the shopping cart, the inventory quantity is 0, a message shall be presented to the customer stating that there is no more of the product in the inventory

### The customer selects the “+” button near the product name and quantity in the shopping cart.
Product inventory quantity value is already 0, send a message to the customer saying:
“This product has been sold out”
Product inventory quantity value stays at 0 and the Customer product shopping cart is not updated with new product

### Customer Adds More Existing Items in Shopping Cart
The customer shall be able to increase the quantity of a specific product in their shopping cart view so that they don’t have to search for the item in the shopping view and click it multiple times

### Customer enters their shopping cart view
The customer selects the “+” button near the product name and quantity in the shopping cart. Increments value by 1.

#### Variant Scenario: Product Inventory Quantity is Max
In the case that when incrementing quantity in the shopping cart, the inventory quantity is equal to the shopping cart quantity, a message shall be presented to the customer stating that there is no more of the product in the inventory

### The customer selects the “+” button near the product name and quantity in the shopping cart.
Product inventory quantity value is already equal to shopping cart qunatity, send a message to the customer saying:
“This product has been maxed out”
 
### Customer Removes Item from Shopping Cart
The customer shall be able to remove items from their shopping cart by clicking a button inside of their shopping cart view so that they can get rid of any items that they end up not wanting to purchase
 
### Customer enters their shopping cart view
The customer selects the “-” button near the product name and quantity in the shopping cart
Shopping cart product quantity is updated by -1
 
#### Variant Scenario: Product Shopping Cart Quantity hits 0
In the event that the customer turns the quantity of a product in their shopping cart to 0, the product listing in the shopping cart will be removed completely. This is to prevent going to -1

### Customer enters their shopping cart view
The customer selects the “-” button near the product name and quantity in the shopping cart
The quantity of the product in the shopping cart is equal to 0 and we remove the product listing from the shopping cart view
 
### Customer Reviews Product Details
The customer shall be able to click on a product name and be shown the details of the selected product so that they can be more informed on what they are buying.
 
### Customer clicks on a product name 
A pop-up window appears that shows details about the product
Details include name, quantity in inventory, selling price, picture of the product, type of product, and invoice price
 
### Customer Reviews/Updates Shopping Cart
The customer shall be able to access a shopping cart window where they will be able to review what products and quantities they have selected. A checkout button shall exist that they may press when they are ready to checkout. A continue shopping button shall exist that will take them back to the homepage if they intend to continue shopping for products. 
 
### Customer clicks on the shopping cart button
A new window appears that displays the contents of the customer's shopping cart
Customer can update their shopping cart information in this window
 
### Customer Checks Out
The checkout page shall show an invoice of what is in the shopping cart. If the user clicks the pay now button, the system shall display a popup window that shall prompt the user to enter payment details. A continue shopping button will take the user back to the homepage. 
The payment details window popout shall include text entries for the billing address and credit card details. There will be an enter button and a cancel button. Cancel shall close the window. Enter will save the transaction and display a success message if all the information has been filled in. The system shall clear the shopping cart and update inventories. The seller shall receive a note of the transaction. 
 
### The customer clicks on the checkout button from the shopping cart window or home shopping window
The customer is directed to an invoice window that displays contents in the shopping cart in a read-only format
Customer clicks on the “Pay Now” button
The customer enters in payment details
Payment details include billing address, card number, card expiration date, and 3-digit security number
The customer clicks “Enter” to confirm the purchase
A confirmation screen appears with “receipt” information
Inventory is updated to reflect changes in stock by decrementing stock quantity by the amount purchased. 
 
#### Variant Scenario: Customer Clicks “Continue Shopping” Button
In the event that the customer clicks on the “Continue Shopping” button instead of the “Pay Now” button, the customer shall be redirected to the home shopping page.

Following step 2, the customer clicks on the “Continue Shopping” button instead of the “Pay Now” button
The customer is redirected to the home shopping page with the shopping cart unchanged

#### Variant Scenario: Customer Clicks “Cancel” Button
In the event that the customer clicks on the “cancel” button instead of the “enter” button, they will close the payment details window and be presented with the invoice window, which was the previous window

Following step 3, the customer enters the payment details window
Customer clicks on the “cancel” button
The payment details window is closed and the customer is presented with the invoice window

### Seller Reviews/Updates/Edits Inventory and Product Information
The seller shall be able to view their inventory as well as update product quantity. This is so that they can better manage their store and keep stock up to date. 
To review products in inventory, the seller shall click on the product name (much like how the customer clicks on a product name to view its details) to see more information about it and update it if needed.
Admin(seller) has logged in and is presented with the admin homepage.
A list of products the seller has imputed will be presented
In each product box, there will be text fields where the user may edit information.
The admin can enter new information in these text fields to update price, quantity, title, and description.
After the admin has filled out these text fields and clicks a submit button, the information will update in the system. 
If a text field is empty the information will not update to nil, it will maintain the current data.
A plus will exist on the product image, pressing this will open up a popup window to select a file to replace the current image.
The admin will select a file and press enter to replace the image
The system will switch out the image file and will close the popup once the image is selected.
The Cancel button will simply close the popup without updating any information
 
### Seller(admin) Adds New Product
The seller shall be able to add new products into inventory so that they can expand their business. When adding new products, they will have to fill out a form that requires a product name, description, type, quantity, invoice price, selling price, and product image.
A button at the top of the seller's home screen will invite them to add a new product. This button leads to a form that asks for product details.
The admin shall press an add product button.
A popup shall present itself to select a file for a product image
The admin shall select a file and press enter
#### Variant branch
 The admin selects the cancel button
 The popup shall close without adding any new information. 
The new product and image will present themselves on the seller(admin homepage)
The admin will use the Reviews/Updates/Edits functions to complete the product information.
 
 
### Seller Removes a Product
The seller shall be able to remove a product from inventory so that they have more control over their business. When a product is selected from inventory, there shall be an option to remove it, which is only accessible to the admin.
The remove button shall be located on a product details screen near the bottom. 
The seller clicks the remove button
The system will remove the item.
 
### Seller Reads About Revenue, Sales, Profit, and Cost 
a. The seller shall be able to check the sales, revenue, profit, and cost by navigating to a sales page.
b. The sales page shall display an excel style table with all the sales information. It will be a standard breakdown with cost, price, quantity sold, total revenue per product, total profit per product, and a bottom row that shows the total revenue and profit for the entire store. 
The seller will click a button on the homepage named Sales information
The system will navigate to the Sales information page.
After the seller is done reviewing the information they shall press a button to return to the seller homepage
The system will navigate back to the homepage

### Website Customer Support 
a. A phone number and email will be available at the bottom of the page with a note displaying “Problems or Comments? Please reach out at 555-555-555 or support@shopping.com” We plan on not implementing a custom messaging system for a small store. 

# Platforms
For this project we will use multiple different platforms and libraries to successfully implement our idea. Below is a list of software and libraries we shall be using to organize our code, create diagrams, sketch out frameworks, and perform certain implementations of our code.
Software

Github
Github shall be used to keep all of our code organized into one place. We will also have accessibility to version control. While using Github, we can all review each others code and make sure it complies with our overarching goals

LucidChart
This software is where we shall create our UML diagrams such as the class diagram, sequence diagram, and state diagram.

Apache Netbeans IDE 14
Netbean will be the most commonly used IDE for this project to compile our code.

Figma
This online free software will allow us to design our frames without adding any functionality to it. Using figma allows us the ability to pick the perfect design for each window

Java
This project will be run by Java and its libraries. As an object Oriented environment, this language is best suited for what we are going to be implementing.

# Instructions

1. run the project in netbeans. 
2. images are displayed via filepaths that are dependent on the machine the program is running on, to see images you must login into the admin account and either edit the items or add new ones. john 12345 is the admin account. everything else should be intuitive. 
3. if no items are displayed it might be a filepath issue add items via the admin account.
4. nick 12345 is a customer account, register function also works to create a new customer account.
5. everything in the gui is intuitive and clearly labeled. 
