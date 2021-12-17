import java.util.Collections;
import java.util.PriorityQueue;

class orderBook{
    PriorityQueue sellList = new PriorityQueue<Order>();
    PriorityQueue buyList = new PriorityQueue<Order>(Collections.reverseOrder());
    //List sellList = new LinkedList<Order>();
    //List buyList = new LinkedList<Order>();

    public void addOrder(Order order){
        if (order.getSide().equals("B")){
            buyList.add(order);
        }else if (order.getSide().equals("S")){
            sellList.add(order);
        }
    }

    public void cancelOrder(Order order){
        if (order.getSide().equals("B")){
            buyList.remove(order);
        }else if (order.getSide().equals("S")){
            sellList.remove(order);
        }
    }

    @Override
    public String toString() {
        return "orderBook{" +
                "sellList=" + sellList +"\n"+
                ", buyList=" + buyList +
                '}';
    }
}
