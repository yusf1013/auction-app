package model;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;

public class AuctionPanel extends UIComponent {

    private Integer current_bid;
    private String product_name, product_description, highest_bidder, sold_to;
    Random random = new Random();
    ArrayList<Bidder> subscribers = new ArrayList<>();


    public AuctionPanel(AnchorPane panel) {
        super(panel);
        reset();
    }

    public void reset(){
        setCurrent_bid(10);
        setProduct_name(getRandomString());
        setProduct_description(product_name + "\nis very interesting");
        setHighest_bidder("---");
        sold_to = "---";

        for(Bidder b: subscribers) {
            b.init(false);
        }
    }

    public void sell(){
        for(Bidder listener: subscribers) {
            listener.setSold_to(highest_bidder);
        }

        this.getButton("button_sell").setDisable(true);

    }

    public int getCurrent_bid() {
        return current_bid;
    }

    public void setCurrent_bid(Integer current_bid) {
        this.current_bid = current_bid;
        getLabel("current_bid").setText(current_bid.toString());
        getLabel("highest_bid").setText(current_bid.toString());

        for(Bidder listener: subscribers) {
            listener.setCurrent_bid(current_bid);
        }

    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
        getLabel("product_name").setText(product_name);
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
        getLabel("product_description").setText(product_description);
    }

    public void setHighest_bidder(String highest_bidder) {
        this.highest_bidder = highest_bidder;
        getLabel("highest_bidder").setText(highest_bidder);
        for(Bidder listener: subscribers) {
            if(listener.fullName().equals(highest_bidder))
                listener.setYour_bid(current_bid);
        }

        this.getButton("button_sell").setDisable(highest_bidder.equals("---"));

    }


    public String getRandomString() {
        final String[] proper_noun = {"Apple", "Boxes", "Armor", "Sword"};
        int index1 = random.nextInt(proper_noun.length);

        final String[] adjective = {"Red", "Orange", "Medieval", "Very Rare"};
        int index2 = random.nextInt(adjective.length);

        return (adjective[index2] + " " + proper_noun[index1] );
    }
}
