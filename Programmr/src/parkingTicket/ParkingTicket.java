package parkingTicket;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <code>public class ParkingTicket</code>
 * <p>
 * Solution to Toronto Parking Ticket Problem
 * @author Zach Kaplan
 * @version 1.0
 */
public class ParkingTicket {
    
    /**
     * <code>public static void main({@link String}[] args)</code>
     * <p>
     * Main Method for ParkingTicket
     * Creates a BufferedReader on the file containing parking tickets
     * Reads all lines and adds them into a custom private class TicektMap
     * Prints the street that brought in the most Revenue
     * @param args - standard input from console call (not used in this code)
     */
	public static void main(String[] args) {
        //Declare variables outside of try-catch so they are on the scope of the method
        BufferedReader in;
        TicketMap tickets = new TicketMap(); //Instanstantiate our TicketMap, tickets
        
        try {
            //A BufferedReader is a relatively fast way to read from a file, requires some sort of Reader as a argument (hence FileReader)
            in = new BufferedReader(new FileReader("Parking Ticket data file.txt"));
            
            in.readLine();                          //skip header line in file
            while(in.ready()) {                     //While the BufferedReader is ready (has more lines)
                tickets.addTicket(in.readLine());   //add tickets to tickets of each line
            }
            
            in.close(); //close reader (avoids file corruption and other unwanted errors)
        }catch (IOException ioe) {                                  //Catch IOExcpetions (the only kind that should occur)
            ioe.printStackTrace();                                  //Prints strack trace of error to error console
            System.exit(1);                                         //exits code with err code of 1
        }
        
        System.out.println(tickets.getMaxRevenueStreet()); //Get maxRevenueStreet (the answer) from tickets and print the street
        System.exit(0); //precautionary, ensures system exits; argument of 0 implies no error
	}
    
    /**
     * <code>private class TicketMap</code>
     * <p>
     * Private class to manage and parse tickets
     * Maps street names to total revenue
     * Keeps track of highest revenue street name
     * Has ability to parse new ticket line (line of given CSV file) and add to the app
     * @author Zach Kaplan
     * @version 1.0
     */
    private static class TicketMap {
        
        private HashMap<String, Integer> map;   //Map - Maps Street names to Total Revenue
        private String maxRevenueStreet;        //Street name with largest Revenue
        private int maxRevenue;                 //Revenue at street with largest Revenue
        private static final int STREET = 7,    //Position in CSV line of Street (starting with 0)
                FINE = 4;                       //Position in CSV line of Fine (starting with 0)
        
        /**
         * <code>public TicketMap()</code>
         * <p>
         * Contructor to Initialize a TicketMap
         */
        public TicketMap() { //initialize private variables
            map = new HashMap<String, Integer>();
            maxRevenueStreet = "";
            maxRevenue = 0; //Revenue will always be positive, so 0 is an okay minimum
        }
        
        /**
         * <code>public boolean containsStreet({@link String} street)</code>
         * <p>
         * Returns whether or not a street is already contained in the map
         * @param street - the street in question
         * @return a boolean; true if street is already in the map, false otherwise
         */
        public boolean containsStreet(String street) {
            return map.containsKey(street);
        }
        
        /**
         * <code>public void addTicket({@link String} street, int fine)</code>
         * <p>
         * Adds a ticket's fine to the map
         * @param street - street of ticket
         * @param fine - fine amount of ticket
         */
        public void addTicket(String street, int fine) {
            if(containsStreet(street)) {                    //if street is already in the map
                map.put(street, map.get(street) + fine);    //set value to previous value + new fine
            }else {
                map.put(street, fine);                      //else just set value to new fine
            }
            
            if(map.get(street) > maxRevenue) {      //if revenue at this street is greater than previous max
                maxRevenue = map.get(street);       //set new max to this value
                maxRevenueStreet = street;          //and set street name for max value to this street
            }
        }
        
        /**
         * <code>public void addTicket({@link String} ticketLine)</code>
         * <p>
         * Adds a ticket's fine to the map
         * @param ticketLine - line from CSV file that needs to be parsed before adding to the map
         */
        public void addTicket(String ticketLine) {
            String[] csvSeparated = ticketLine.split(",");              //Split CSV line by commas (Comma Separated Values)
            addTicket(csvSeparated[TicketMap.STREET], 
                    Integer.parseInt(csvSeparated[TicketMap.FINE]));    //Use constants and csvSeparated to call addTicket(street, fine)
        }
        
        /**
         * <code>public String getMaxRevenueStreet()</code>
         * <p>
         * Returns street with largest revenue in map
         * @return the street with the largest revenue
         */
        public String getMaxRevenueStreet() {
            return maxRevenueStreet;
        }
        
    }
	
}
