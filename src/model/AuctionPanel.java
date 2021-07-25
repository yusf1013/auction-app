package model;

import utils.Utils;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;

public class AuctionPanel{

    AnchorPane panel;

    Integer current_bid;
    String product_name, product_description, highest_bidder, sold_to;
    Random random = new Random();
    ArrayList<Subscriber> subscribers = new ArrayList<>();

    UIComponent uiComponent;
    Utils utils = new Utils();


    public AuctionPanel(AnchorPane panel) {
        this.panel = panel;
        uiComponent = new UIComponent(panel);
        reset();
    }

    public void reset(){
        setCurrent_bid(10);
        setProduct_name(utils.getRandomString());
        setProduct_description(product_name + "\nis very interesting");
        setHighest_bidder("---");
        sold_to = "---";

        for(Subscriber subscriber: subscribers) {
            subscriber.reset();
        }
    }

    public void notifySubscribers(){
        for(Subscriber subscriber: subscribers) {
            subscriber.update();
        }
    }

    public void sell(){
        this.sold_to = highest_bidder;
        notifySubscribers();

        uiComponent.getButton("button_sell").setDisable(true);

    }

    public int getCurrent_bid() {
        return current_bid;
    }

    public void setCurrent_bid(Integer current_bid) {
        this.current_bid = current_bid;
        uiComponent.getLabel("current_bid").setText(current_bid.toString());
        uiComponent.getLabel("highest_bid").setText(current_bid.toString());

        notifySubscribers();

    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
        uiComponent.getLabel("product_name").setText(product_name);
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
        uiComponent.getLabel("product_description").setText(product_description);
    }

    public void setHighest_bidder(String highest_bidder) {
        this.highest_bidder = highest_bidder;
        uiComponent.getLabel("highest_bidder").setText(highest_bidder);
        notifySubscribers();

        uiComponent.getButton("button_sell").setDisable(highest_bidder.equals("---"));

    }



}
