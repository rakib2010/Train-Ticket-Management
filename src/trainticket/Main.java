
package trainticket;

import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       

        mainMenu();


    }

    private static void mainMenu() {


        System.out.println("Which state you ticket to (1: New Jersey, 2: New York )");
        int state = sc.nextInt();
        if (state > 2 || state<1){
            System.out.println("Invalid Choice");
            mainMenu();

        }

        System.out.println("Which ticket class you want to buy ");
        for (int i = 0; i < Tickets.tClass.length; i++) {
            System.out.print((i + 1) + ": " + Tickets.tClass[i] + ", ");
        }

        int tc = sc.nextInt();
        int ticketCount = Tickets.ticketCount(state,tc);
        System.out.println("Available Ticket in " + Tickets.getStateName(state) + " Class " + Tickets.tClass[tc-1]+ " 1" +  ticketCount);

        if ( ticketCount> 0){
            double tprice = Tickets.getPrice(state, tc);
            System.out.println("The Price of " +
                    Tickets.getStateName(state) +
                    " ticket class " +
                    Tickets.tClass[tc - 1] + " is " + tprice);

            buyTicket(state,tc,tprice);
        }else System.out.println(
                Tickets.getStateName(state) +
                " ticket class " +
                Tickets.tClass[tc - 1] + " is SOLD OUT");




        mainMenu();
    }

    private static void buyTicket(int state, int tc, double tprice) {
        System.out.println("pay " + tprice);
        System.out.println("Please put money in the machine");
        ;


        int givenAmount = sc.nextInt();
        double due = tprice ;

        // 18
// 99,50,20,10,5,1,.25,.10,.05
        if (validAmount(givenAmount)) {
            due = tprice - givenAmount;
            if (due <= 0) {
                
               Tickets.kato(state,tc);
                System.out.println();
                System.out.println(
                        Tickets.getStateName(state) +
                                " ticket class " +
                                Tickets.tClass[tc - 1] + " is successfully BOOKED");
                System.out.println("Take back Your money " + due);



            } else {
                buyTicket(state, tc, due);
            }
        } else {
            System.out.println("Rejected");
            buyTicket(state, tc, due);
        }
    }

    private static boolean validAmount(int givenAmount) {
        String sAmounts = "100,50,20,10,5,1,.25,.10,.05";
        if (sAmounts.contains(String.valueOf(givenAmount)))
            return true;
        else return false;
    }


    
}
