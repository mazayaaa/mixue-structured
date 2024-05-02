package UASGASAL_FINALPROJECT;
import java.util.Scanner;
public class MIXUE {

    //PROGRAM SEARCHING

    static int searchData(String[] data, int[] priceData, String search) {
        int indexFound = data.length;
        boolean found = false;

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(search)) {
                found = true;
                System.out.println("Data Found");
                System.out.println(data[i] + " $" + priceData[i]);
                indexFound = i;
            }
        }
        if (found == false) {
            System.out.println("Data Not Found");
        }
        return indexFound;
    }

    static String[] addData(String[] data, String newData) {
        String result[] = new String[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            result[i] = data[i];
        }
        result[data.length] = newData;
        return result;
    }

    static int[] addPrice(int[] price, int newPrice) {
        int result[] = new int[price.length + 1];

        for (int i = 0; i < price.length; i++) {
            result[i] = price[i];
        }
        result[price.length] = newPrice;
        return result;
    }

    static String[] removeData(String[] data, int removeIndex) {
        String result[] = new String[data.length - 1];

        for (int i = 0, newIndex = 0; i < data.length; i++) {
            if (removeIndex != i) {
                result[newIndex++] = data[i];
            }
        }
        return result;
    }

    static int[] removePrice(int[] price, int removeIndex) {
        int hasil[] = new int[price.length - 1];

        for (int i = 0, newIndex = 0; i < price.length; i++) {
            if (removeIndex != i) {
                hasil[newIndex++] = price[i];
            }
        }
        return hasil;
    }

    //PROGRAM SORTING

    static void sortBestSeller(String[] data, int[] priceData, int[] bestSeller) {
        int tempInt;
        String tempString;

        for (int i = 0; i < data.length - 1; i++) {
            if (bestSeller[i] < bestSeller[i + 1]) {
                tempInt = bestSeller[i];
                bestSeller[i] = bestSeller[i + 1];
                bestSeller[i + 1] = tempInt;
                tempInt = priceData[i];
                priceData[i] = priceData[i + 1];
                priceData[i + 1] = tempInt;
                tempString = data[i];
                data[i] = data[i + 1];
                data[i + 1] = tempString;
            }
        }
        System.out.println("================== BEST SELLER MENU ==================");
        System.out.println("No. Menu \t\t\tPrice \t\tItem");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + ". " + data[i] + "\t\t $" + priceData[i] + "\t\t " + bestSeller[i] + "x");
        }
        System.out.println("______________________________________________________");
    }

    //PROGRAM AWAL

    public static void main(String[] args) {

        Scanner Z = new Scanner(System.in);

        String data[] = {"King-Cone", "Boba-Sundae", "Mi-Sundae", "Lucky-Sundae", "Mi-Smoothies", "Mocha-Shake", "Jasmine-Tea", "Oat-Milk-Tea"};
        int priceData[] = {10, 13, 16, 16, 18, 20, 12, 22};
        int bestSeller[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int pin;
        boolean login = false;
        String report[] = {};
        String search = " ",
                newData;
        int selectMode = 1,
                selectMenu = 1,
                indexFound = data.length,
                totalPurchase = 0,
                totalPayment = 0,
                buyerMoney = 0,
                buyerReturn = 0,
                totalPayment1 = 0,
                newPrice = 0;

        System.out.println("=================================================");
        System.out.println("                    M I X U E                    ");
        System.out.println("          SINCE 1997 - ICE CREAM & TEA           ");
        System.out.println("        Share Sweetness, Spread Happiness        ");
        System.out.println("=================================================");
        System.out.println("");

        while (selectMode != 4) {
            System.out.println("");
            System.out.println("================== SELECT MODE ==================");
            System.out.println("");
            System.out.println("1. Admin ");
            System.out.println("2. Cashier ");
            System.out.println("3. Owner ");
            System.out.println("4. Exit ");
            System.out.println("_________________________________________________");
            System.out.print("Select \t\t\t\t\t\t\t\t\t\t: ");
            selectMode = Z.nextInt();
            selectMenu = 1;

            if (selectMode != 5) {
                switch (selectMode) {

                    case 1:
                        //FITUR TAMBAHAN : PIN
                        //mode yang akan diletakkan PIN adalah mode Owner dan Admin

                        do {
                            System.out.println("");
                            System.out.print("Enter PIN = ");
                            pin = Z.nextInt();
                            if (pin == 123456) {
                                System.out.println("PIN is Correct");
                                login = true;
                            } else {
                                System.out.println("Sorry, PIN is Incorrect");
                            }
                        } while (pin != 123456);
                        if (login = true) ;

                        // selectMode 1 = Admin
                        while (selectMenu != 5) {
                            System.out.println("");
                            System.out.println("================== ADMIN MENU ===================");
                            System.out.println("Here is Your Menu : ");
                            System.out.println("1. Show Menu & Price List");
                            System.out.println("2. Add Menu");
                            System.out.println("3. Change Menu");
                            System.out.println("4. Remove Menu");
                            System.out.println("5. Exit");
                            System.out.println("_________________________________________________");
                            System.out.print("Select \t\t\t\t\t\t\t\t\t\t: ");
                            selectMenu = Z.nextInt();
                            System.out.println("");

                            switch (selectMenu) {

                                case 1 :
                                    // selectMenu 1 = Show List Menu & Price
                                    System.out.println("============== MENU AND PRICE LIST ==============");
                                    System.out.println("");
                                    for (int i = 0; i < data.length; i++) {
                                        System.out.println((i + 1) + ". " + data[i] + "\t\t\t\t\t\t\t $" + priceData[i]);
                                    }
                                    System.out.println("");
                                    System.out.println("=================================================");
                                    break;

                                case 2 :
                                    // selectMenu 2 = Add Menu
                                    System.out.print("Enter Menu Name : ");
                                    newData = Z.next();
                                    System.out.print("Enter Menu Price : ");
                                    newPrice = Z.nextInt();
                                    data = addData(data, newData);
                                    priceData = addPrice(priceData, newPrice);
                                    System.out.println("");
                                    System.out.println("Data Successfully Added");
                                    break;

                                case 3 :
                                    // selectMenu 3 = Change Menu
                                    System.out.print("Search Menu : ");
                                    search = Z.next();
                                    System.out.println("");
                                    indexFound = searchData(data, priceData, search);
                                    if(indexFound < data.length){
                                        System.out.print("Enter Menu Name : ");
                                        data[indexFound] = Z.next();
                                        System.out.print("Enter Menu Price : ");
                                        priceData[indexFound]  = Z.nextInt();
                                        System.out.println("");
                                        System.out.println("Data Successfully Changed");
                                    }
                                    break;

                                case 4 :
                                    // selectMenu 4 = Remove Menu
                                    System.out.print("Search Menu : ");
                                    search = Z.next();
                                    System.out.println("");
                                    indexFound = searchData(data, priceData, search);
                                    if(indexFound < data.length){
                                        data = removeData(data, indexFound);
                                        priceData = removePrice(priceData, indexFound);
                                        System.out.println("");
                                        System.out.println("Data Successfully Removed");
                                    }
                                    break;

                            }
                        }
                        break;

                    case 2 :
                        // selectMode 2 = Cashier
                        while(selectMenu != 3){
                            System.out.println("");
                            System.out.println("================== CASHIER MENU ==================");
                            System.out.println("Here is Your Menu : ");
                            System.out.println("1. Search Menu");
                            System.out.println("2. Payment");
                            System.out.println("3. Exit for Other Purchase");
                            System.out.println("__________________________________________________");
                            System.out.print("Select \t\t\t\t\t\t\t\t\t\t: ");
                            selectMenu = Z.nextInt();

                            if(selectMenu == 1){
                                // selectMenu 1 = Search Menu
                                search = "";
                                while(!"x".equals(search)){
                                    System.out.println("");
                                    System.out.println("Type 'x' for exit");
                                    System.out.println("");
                                    System.out.print("Search Menu : ");
                                    search = Z.next();
                                    if(!"x".equals(search)){
                                        System.out.println("");
                                        indexFound = searchData(data, priceData, search);
                                        if(indexFound < data.length){
                                            System.out.println("");
                                            System.out.print("Enter number of menu items : ");
                                            totalPurchase = Z.nextInt();
                                            totalPayment += priceData[indexFound] * totalPurchase;
                                            bestSeller[indexFound] = totalPurchase;
                                            totalPayment1 = totalPayment + totalPayment1;
                                            System.out.println("Data Successfully Added");
                                        }
                                    }
                                }
                            } else if (selectMenu == 2) {
                                // selectMenu 2 = Payment
                                System.out.println("");
                                System.out.println("Total Payment = $" + totalPayment);
                                while(buyerMoney < totalPayment) {
                                    System.out.print("Enter Buyer's Money = $");
                                    buyerMoney = Z.nextInt();
                                    if(buyerMoney < totalPayment){
                                        System.out.println("Sorry, you don't have enough money.");
                                    } else {
                                        buyerReturn = buyerMoney - totalPayment;

                                        if(buyerReturn > 0){
                                            System.out.println("Your Return = $" + buyerReturn);
                                        }
                                        report = addData(report, "Total Payment = $" + totalPayment +  "; Buyer's Money = $" + buyerMoney);
                                        System.out.println("");
                                        System.out.println("=================================================");
                                        System.out.println("                 T H A N K  Y O U                ");
                                        System.out.println("                 ENJOY YOUR DRINK                ");
                                        System.out.println("        PLEASE COME BACK ON THE NEXT DAY!        ");
                                        System.out.println("=================================================");
                                        totalPayment = 0;

                                    }
                                }
                            }
                        }
                        break;

                    case 3 :
                        //FITUR TAMBAHAN : PIN
                        //mode yang akan diletakkan PIN adalah mode Owner dan Admin
                        do {
                            System.out.println("");
                            System.out.print("Enter PIN = ");
                            pin = Z.nextInt();
                            if (pin == 123456) {
                                System.out.println("PIN is Correct");
                                login = true;
                            } else {
                                System.out.println("Sorry, PIN is Incorrect");
                            }
                        } while (pin != 123456);
                        if (login = true) ;

                        // selectMode 3 = Owner
                        while(selectMenu != 3){
                            System.out.println("");
                            System.out.println("================== OWNER MENU ==================");
                            System.out.println("Here is Your Menu : ");
                            System.out.println("1. Sales Report");
                            System.out.println("2. Best Seller Menu");
                            System.out.println("3. Exit");
                            System.out.println("________________________________________________");
                            System.out.print("Select \t\t\t\t\t\t\t\t\t\t: ");
                            selectMenu = Z.nextInt();
                            System.out.println("");

                            if(selectMenu == 1){
                                // selectMenu 1 = Report
                                System.out.println("================== SALES REPORT ==================");
                                if (report.length > 0) {
                                    for (int i = 0; i < report.length; i++) {
                                        System.out.println((i+1) + ". " + report[i]);
                                    }
                                } else {
                                    System.out.println("Report is Empty");
                                }
                                System.out.println("__________________________________________________");
                            } else if(selectMenu == 2){
                                // selectMenu 2 = Barang terlaris
                                sortBestSeller(data, priceData, bestSeller);
                                System.out.println();
                            }
                        }
                        break;

                    case 4:
                        System.out.println("=================================================");
                        System.out.println("                 T H A N K  Y O U                ");
                        System.out.println("=================================================");
                        break;
                }

            }
        }

    }
}