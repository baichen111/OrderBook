import java.time.LocalDateTime;

class Order implements Comparable<Order>{
    private Integer quantity;
    private Integer price;
    private String side;
    private String id;
    private String orderType;
    private LocalDateTime time = LocalDateTime.now();

    public Order(Integer quantity, Integer price, String side, String id, String orderType) {
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.id = id;
        this.orderType = orderType;
    }

    public Order(Integer quantity, String side, String id,String orderType) {   // for market order,removing price entry
        this.quantity = quantity;
        this.side = side;
        this.id = id;
        this.orderType = orderType;
    }


    @Override
    public int compareTo(Order o) {
        if (o.getId().equals(this.id)) return 0;    //if two orders' ids are same, then they are the same order.
        int compare = Integer.compare(price, o.price);
        if (compare == 0){
            return o.time.compareTo(time);
        }
        return compare;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", side='" + side + '\'' +
                ", id='" + id + '\'' +
                ", orderType='" + orderType + '\'' +
                ", time=" + time +
                '}';
    }
}

