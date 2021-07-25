package model;

import utils.Utils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Bidder extends Subscriber{

    AnchorPane panel;

    private String first_name, last_name, sold_to;
    private  Integer current_bid, your_bid;

    UIComponent uiComponent;
    Utils utils = new Utils();

    public Bidder(AnchorPane panel) {
        this.panel = panel;
        uiComponent = new UIComponent(panel);

        init();
        for(Node node: panel.getChildren()) {
            if(node.getId()!=null && node.getId().equalsIgnoreCase("bid_button"))
                ((Button) node).setOnAction(e -> this.makeBid());
        }
    }

    public void update() {
        setSold_to(auction.sold_to);
        setCurrent_bid(auction.current_bid);
        if(fullName().equals(auction.highest_bidder))
            setYour_bid(current_bid);
    }

    public void init() {
        reset();

        setFirst_name(utils.getRandomFirstName());
        setLast_name(utils.getRandomLastName());

    }

    public void reset() {
        setCurrent_bid(10);
        setYour_bid(0);
        setSold_to("---");
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
        uiComponent.getLabel("name_plate").setText(first_name + " " + last_name);
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
        uiComponent.getLabel("name_plate").setText(first_name + " " + last_name);

    }

    public void setSold_to(String sold_to) {
        this.sold_to = sold_to;
        uiComponent.getLabel("sold_to").setText(sold_to);
        uiComponent.getButton("bid_button").setDisable(!sold_to.equals("---"));
    }

    public void setCurrent_bid(Integer current_bid) {
        this.current_bid = current_bid;
        uiComponent.getLabel("current_bid").setText(current_bid.toString());
    }

    public void setYour_bid(Integer your_bid) {
        this.your_bid = your_bid;
        uiComponent.getLabel("your_bid").setText(your_bid.toString());
    }

    public void subscribeTo(AuctionPanel auctionPanel) {
        this.auction = auctionPanel;
        auctionPanel.subscribers.add(this);
    }

    public void unsubscribe(){
        this.auction = null;
    }

    public boolean makeBid(){
        if(auction == null)
            return false;

        auction.setHighest_bidder(fullName());
        auction.setCurrent_bid(auction.getCurrent_bid() + 10);
        return true;
    }

    public String fullName() {
        return first_name + " " + last_name;
    }


}
