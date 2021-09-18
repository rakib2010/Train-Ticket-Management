
package trainticket;


public class Tickets {
    public static String getClassName;
    static String[] tClass = {"A", "B", "C"};
    static double[] nJersey = {20.90, 17.75, 15,};
    static double[] nYork = {22.50, 19.75, 17.50};
    static int[] availableTicketNewJersey = {10, 10, 10};
    static int[] availableTicketNewYork = {10, 10, 10};

    public static double getPrice(int state, int tc) {
        if (state == 1) {
            return nJersey[tc - 1];
        } else if (state == 2) {
            return nYork[tc - 1];
        } else return 0;
    }

    public static String getStateName(int state) {
        if (state == 1) return "New Jersey";
        else if (state == 2) return "New York";
        else return null;
    }


    public static void kato(int state, int tc) {
        if (state == 1) {
            availableTicketNewJersey[tc - 1]--;
        } else if (state == 2) availableTicketNewYork[tc - 1]--;

    }


    public static int ticketCount(int state, int tc) {

        if (state == 1) {
            return availableTicketNewJersey[tc - 1];
        } else if (state == 2) return availableTicketNewYork[tc - 1];

        return 0;
    }
    
}
