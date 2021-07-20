package model;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class Bidder extends UIComponent{

    private String first_name, last_name, sold_to;
    private  Integer current_bid, your_bid;
    private AuctionPanel auction;

    public Bidder(AnchorPane panel) {
        super(panel);
        init(true);
        for(Node node: panel.getChildren()) {
            if(node.getId()!=null && node.getId().equalsIgnoreCase("bid_button"))
                ((Button) node).setOnAction(e -> this.makeBid());
        }
    }

    public void init(boolean resetName) {
        setCurrent_bid(10);
        setYour_bid(0);
        setSold_to("---");

        if(resetName)
        {
            setFirst_name(getRandomFirstName());
            setLast_name(getRandomLastName());
        }
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
        getLabel("name_plate").setText(first_name + " " + last_name);
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
        getLabel("name_plate").setText(first_name + " " + last_name);

    }

    public void setSold_to(String sold_to) {
        this.sold_to = sold_to;
        getLabel("sold_to").setText(sold_to);
        this.getButton("bid_button").setDisable(!sold_to.equals("---"));
    }

    public void setCurrent_bid(Integer current_bid) {
        this.current_bid = current_bid;
        getLabel("current_bid").setText(current_bid.toString());
    }

    public void setYour_bid(Integer your_bid) {
        this.your_bid = your_bid;
        getLabel("your_bid").setText(your_bid.toString());
    }

    public String getRandomFirstName() {
        Random random = new Random();
        final String[] name = {"Ethan", "Chris", "Leon", "Carlos"};
        int index = random.nextInt(name.length);

        return name[index];
    }

    public String getRandomLastName() {
        Random random = new Random();
        final String[] name = {"Winters", "Redfield", "S. Kennedy", "Oliveira"};
        int index = random.nextInt(name.length);

        return name[index];
    }

    public void subscribeTo(AuctionPanel auctionPanel) {
        this.auction = auctionPanel;
        auctionPanel.subscribers.add(this);
    }

    public void unSubscribe(){
        this.auction = null;
    }

    public boolean makeBid(){
        if(auction == null)
            return false;

        auction.setCurrent_bid(auction.getCurrent_bid() + 10);
        auction.setHighest_bidder(fullName());
        return true;
    }

    public String fullName() {
        return first_name + " " + last_name;
    }


}
