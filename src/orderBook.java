import java.util.*;

class orderBook{
    Set sellList = new TreeSet();
    Set buyList = new TreeSet(Collections.reverseOrder());
    //List sellList = new LinkedList<Order>();
    //List buyList = new LinkedList<Order>();

    public void addOrder(Order order){
        if (order.getSide().equals("B")){
            buyList.add(order);
        }else if (order.getSide().equals("S")){
            sellList.add(order);
        }
    }

    public void cancelOrder(String ID){
        Order buyOrder = searchBuyOrder(ID);
        System.out.println(buyOrder);
        if ( buyOrder!= null){
            buyList.remove(buyOrder);
        }

        Order sellOrder = searchSellOrder(ID);
        if (sellOrder != null){
            sellList.remove(sellOrder);
        }
    }

    private Order searchBuyOrder(String ID) {      //find the buy order based on ID
        Iterator<Order> buyIterator = buyList.iterator();  // iterate buylist
        while (buyIterator.hasNext()) {
            Order buyNext = buyIterator.next();
            if (buyNext.getId().equals( ID)) return buyNext;
        }
        return null;
    }

    private Order searchSellOrder(String ID){   //find the sell order based on ID
        Iterator<Order> sellIterator = sellList.iterator();            //iterate selllist
        while (sellIterator.hasNext()){
            Order sellNext = sellIterator.next();
            if (sellNext.getId().equals(ID)) return sellNext;
        }
        return null;
    }

    @Override
    public String toString() {
        return "orderBook{" +
                "sellList=" + sellList +"\n"+
                ", buyList=" + buyList +
                '}';
    }
}
