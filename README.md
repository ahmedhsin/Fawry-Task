I have assumed that there will be 4 categories of items on the ecommerce like
basic product where it dosen't have expire date or can be shipped ,
and expiry product, shipped product, expired and shipped product.

for calculate of the shipping price i assume that for each 10 grams i will take 0.5$

for each error i have create a custom exception for it to trigger furthor actions in future like logs, analytics, etc

i store the products in the cart in map but for the seek of requirment in the shipping service i repeat insert same product till match its quantity

there can be further validation but for seek of task thats what i have done.