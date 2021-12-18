import java.util.*;

class orderBook{
    TreeSet<Order> sellList = new TreeSet();
    TreeSet<Order> buyList = new TreeSet(Collections.reverseOrder());

    public void addOrder(Order order){
        if (order.getSide().equals("B")){
            exeOrder(order,sellList,buyList);
        }else if (order.getSide().equals("S")){
            exeOrder(order,buyList,sellList);
        }
    }

    private void exeOrder(Order order,TreeSet<Order> orderList,TreeSet<Order> opOrderList){  //execute submitted limited orders;orderList store submiited order;opOrderList is opposite order list
        Iterator<Order> orderIterator = orderList.iterator();
        int remain = order.getQuantity();
        while (orderIterator.hasNext()){
            Order orderNext = orderIterator.next();
            remain = orderNext.getQuantity() - remain;
            if (remain > 0){
                orderNext.setQuantity(remain);
                remain = 0;
                break;
            }else if (remain <=0){
                orderIterator.remove();
                remain = -remain;
            }
        }
        order.setQuantity(remain);
        if (order.getQuantity() != 0){
            opOrderList.add(order);
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
