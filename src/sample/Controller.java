package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.AuctionPanel;
import model.Bidder;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button button_again, button_sell;

    @FXML
    AnchorPane auction_panel, pane_bidder1, pane_bidder2, pane_bidder3, pane_bidder4;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AuctionPanel auctionPanel = new AuctionPanel(auction_panel);
        Bidder bidder1 = new Bidder(pane_bidder1), bidder2  = new Bidder(pane_bidder2), bidder3 = new Bidder(pane_bidder3), bidder4 = new Bidder(pane_bidder4);

        bidder1.subscribeTo(auctionPanel);
        bidder2.subscribeTo(auctionPanel);
        bidder3.subscribeTo(auctionPanel);
        bidder4.subscribeTo(auctionPanel);


        button_again.setOnAction(e -> auctionPanel.reset());

        button_sell.setOnAction(e -> auctionPanel.sell());




    }
}

