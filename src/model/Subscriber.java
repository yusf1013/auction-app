package model;

public abstract class Subscriber {
    public AuctionPanel auction;

    public abstract void update();
    public abstract void reset();
    public abstract void subscribeTo(AuctionPanel auctionPanel);
    public abstract void unsubscribe();


}
