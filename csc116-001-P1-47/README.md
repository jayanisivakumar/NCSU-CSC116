# csc116-001-P1-47
Name: Jayani Sivakumar

Notes:
While doing system testing, unit and integration tests and debugging, encountered the following:
(a) Output displayed zero infront of hour part of time for hour < 10, hence rectified with
    String formattedHour = finalHour < 10 ? "" + finalHour : "" + finalHour;
        String formattedMin = finalMin < 10 ? "0" + finalMin : "" + finalMin;
    
        return formattedHour + ":" + formattedMin;

(b) Hadn't gotten proper delivery charges due to incorrect formatting from cents to dollars.

(c) Initially forgot to add double delivery time for during busy time and hence rectified with
    if (isBusyTime(hour, min)) {
            if (zipcode == 27605) {
                normaldeliveryTime = 40;
            } else if (zipcode == 27606) {
                normaldeliveryTime = 50;
            } else {
                normaldeliveryTime = 30;
            }
            
        } else {
            if (zipcode == 27605) {
                normaldeliveryTime = 20;
            } else if (zipcode == 27606) {
                normaldeliveryTime = 25;
            } else {
                normaldeliveryTime = 15;
            }
        }

(d) For this test fail  testGetOrderCostNoItems() [X] CoffeeShop.getOrderCost(0, 0, 0, 0, 0, 0) ==> expected: <0>  but was: <200>
I had a added a piece of code to rectify it
int totalItems = smallCoffee + mediumCoffee + largeCoffee + smoothie + shake + tea;
        if (totalItems == 0) {
            return 0;
        }

(e) For this test fail testInvalidMethods() [X] Testing CoffeeShop.getDeliveryTime(false, 276, 6, 30) - exception message ==> expected: <Invalid zipcode> but was: <Invalid time>
if (!onCampus) {
            System.out.print("Please enter your zipcode: ");
            zipcode = scanner.nextInt();
        }

        if (!isValidZipcode(zipcode)) {
            System.out.println("Sorry, we do not deliver to that location.");
            System.exit(1);

switched the if loops such that scanner reads zipcode first and if it is invalid it straight away throws an error.