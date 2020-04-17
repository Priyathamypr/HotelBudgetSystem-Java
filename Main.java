import java.util.ArrayList;
import java.util.Scanner;

class Package {
    String location;
    int price;
    int nights;
    int days;
    String hotel;

    public Package(String location, int price, int nights, int days, String hotel) {
        this.location = location;
        this.price = price;
        this.nights = nights;
        this.days = days;
        this.hotel = hotel;
    }

}
public class Main{
    static ArrayList<Package> allPackages = new ArrayList<>();
    static ArrayList<Package> getAvailablePackages(String destination, int max_price){
        ArrayList<Package> eligiblePackage = new ArrayList<>();
        for(Package p : allPackages){
            if(p.location.equals(destination) && p.price <= max_price){
                eligiblePackage.add(p);
            }
        }
        return eligiblePackage;
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int max_price ;
        String destination;
        addPackages();
        boolean y = false;
        System.out.println("Enter the place you want to explore: ");
        destination  = input.nextLine();
        System.out.println("Enter the Max. Amount you are willing to spend: ");
        max_price = input.nextInt();
        ArrayList<Package> availablePackages = getAvailablePackages(destination, max_price);
        System.out.println("No. of available packages = "+availablePackages.size());
        showPackages(availablePackages);
        System.out.println("Choose the package you want (1, 2, 3, ....): ");
        input.nextLine();
        int choose = input.nextInt() - 1;
        Package choosedPackage = availablePackages.get(choose);
        showPackage(choosedPackage);
        System.out.println("Do you want to customize the package (answer in Yes or No): ");
        input.nextLine();
        String x = input.nextLine();
        if (x.equals("Yes") || x.equals("yes"))
            y = true;
        if(y) {
            customizePackage(choosedPackage);
        }
    }

    static void showPackage(Package p){
        System.out.println("************************");
        System.out.println("Choosed Package is");
        System.out.println("-------------------");
        System.out.println("Destination: "+p.location);
        System.out.println("Amount: "+p.price);
        System.out.println("Time Spent: "+p.days+" Days & "+p.nights+" Nights.");
        System.out.println("Hotel: "+p.hotel);
        System.out.println("************************");
    }
    static void showPackages(ArrayList<Package> availablePackages){
        for(Package p : availablePackages){
            System.out.println("Destination: "+p.location);
            System.out.println("Amount: "+p.price);
            System.out.println("Time Spent: "+p.days+" Days & "+p.nights+" Nights.");
            System.out.println("Hotel: "+p.hotel);
            System.out.println("*******************");
        }
    }

    static void customizePackage(Package p){
        Scanner input = new Scanner(System.in);
        int currentDays = p.days;
        String currentHotel = p.hotel;
        int currentPrice = p.price;
        String destination = p.location;
        int oldHotelPrice;
        int newHotelPrice;
        System.out.println("Enter the amount of days you want to travel: ");
        int newDay = input.nextInt();
        System.out.println("Enter the category of hotel you want (for e.g., '1 star', '2 star'): ");
        input.nextLine();
        String newHotel = input.nextLine();
        int diffDays = newDay - currentDays;
        switch (currentHotel){
            case "1 star":
                oldHotelPrice = 500;
                break;
            case "2 star":
                oldHotelPrice = 1000;
                break;
            case "3 star":
                oldHotelPrice = 1500;
                break;
            case "4 star":
                oldHotelPrice = 2000;
                break;
            case "5 star":
                oldHotelPrice = 2500;
                break;
            default:
                oldHotelPrice = 1500;
                break;
        }
        switch (newHotel){
            case "1 star":
                newHotelPrice = 500;
                break;
            case "2 star":
                newHotelPrice = 1000;
                break;
            case "3 star":
                newHotelPrice = 1500;
                break;
            case "4 star":
                newHotelPrice = 2000;
                break;
            case "5 star":
                newHotelPrice = 2500;
                break;
            default:
                newHotelPrice = 1500;
                break;
        }

        int newPrice = currentPrice + (1000 * diffDays) + (oldHotelPrice - newHotelPrice);
        int nights = newDay + 1;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Customized Package is");
        System.out.println("----------------------");
        System.out.println("Destination: "+destination);
        System.out.println("Amount: "+newPrice);
        System.out.println("Time Spent: "+newDay+" Days & "+nights+" Nights.");
        System.out.println("Hotel: "+newHotel);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


    static void addPackages(){
        allPackages.add(new Package("Manali", 4500, 4, 5, "2 star"));
        allPackages.add(new Package("Manali", 7500, 7, 6, "3 star"));
        allPackages.add(new Package("Manali", 7500, 5, 6, "5 star"));
        allPackages.add(new Package("Shimla", 8500, 6, 7, "5 star"));
        allPackages.add(new Package("Shimla", 7500, 5, 6, "3 star"));
        allPackages.add(new Package("Kashmir", 8000, 4, 5, "4 star"));
        allPackages.add(new Package("Kashmir", 6000, 4, 5, "3 star"));
        allPackages.add(new Package("Agra", 4000, 5, 6, "3 star"));
        allPackages.add(new Package("Mumbai", 7000, 3, 4, "4 star"));
        allPackages.add(new Package("Mumbai", 9000, 6, 7, "4 star"));
        allPackages.add(new Package("Delhi", 6000, 5, 6, "3 star"));
        allPackages.add(new Package("Delhi", 7000, 5, 6, "5 star"));
        allPackages.add(new Package("Goa", 9000, 8, 7, "3 star"));
        allPackages.add(new Package("Kochi", 8000, 9, 8, "5 star"));
        allPackages.add(new Package("Darjeeling", 8750, 7, 6, "4 star"));
        allPackages.add(new Package("Amritsar",6500, 5, 4, "3 star"));
        allPackages.add(new Package("Haridwar", 4500, 4, 5, "3 star"));
    }

}
