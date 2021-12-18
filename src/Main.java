import java.util.*;

public class Main {
    public static void main(String[] args) {
        // limit order commnad line has 6 elements : e.g. SUB LO B Ffuj 200 13
        // market order command line has 5 elements: e.g. SUB MO B IZLO 250
        // cancel order command line has 2 elements: e.g. CXL Ffuj
        // end command : e.g. END
        Execution();

    }
    public static void Execution(){
        Scanner scanner = new Scanner(System.in);
        orderBook ob = new orderBook();
        while (true) {
            String input = scanner.nextLine();
            List<String> inputs = Arrays.asList(input.split(" "));
            if (inputs.get(0).equals( "SUB") && inputs.get(1).equals("LO")) {               // limit order submission
                ob.addOrder(new Order(Integer.valueOf(inputs.get(4)),
                                                        Integer.valueOf(inputs.get(5)),
                                                        inputs.get(2),
                                                        inputs.get(3),
                                                        inputs.get(1)));
                System.out.println(ob);
            } else if (inputs.get(0).equals("SUB") && inputs.get(1).equals("MO")) {   // market order submission
                ob.marketOrder(new Order(Integer.valueOf(inputs.get(4)),
                                                                                            inputs.get(2),
                                                                                            inputs.get(3),
                                                                                            inputs.get(1)));
                System.out.println(ob);
            } else if (inputs.get(0).equals("CXL")) {                                                         //cancel an order according to its order id
                ob.cancelOrder(inputs.get(1));
                System.out.println(ob);
            } else if (inputs.get(0).equals("END")) {
                    break;
            }
        }
    }
}


