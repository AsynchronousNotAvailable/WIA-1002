import java.util.Scanner;

interface BidInterface {
    /**
     * Returns the name of the company making this bid
     * @return bidder company name
     */
    public String getCompanyName();

    /**
     * Returns the description of the air conditioner that this bid is for.
     * @return aircond description
     */
    public String getDesc();

    /**
     * Returns the capacity of this bid's AC in tons (1 ton = 12,000 BTU).
     * @return AC capacity
     */
    public int getCapacity();

    /**
     * Returns the seasonal efficiency of this bid's AC (SEER).
     * @return seasonal efficiency
     */
    public double getEfficiency();

    /**
     * Returns the cost of this bid's AC.
     * @return AC cost
     */
    public double getACCost();

    /**
     * Returns the cost of installing this bid's AC.
     * @return installation cost
     */
    public double getInstallCost();

    /**
     * Returns the yearly cost of operating this bid's AC.
     * @return yearly cost
     */
    public double getYearlyOpEx();
}

interface BidCollectionInterface {
    /**
     * Adds a bid to this collection.
     * @param b the bid
     */
    public void addBid(BidInterface b);

    /**
     * Returns the bid in this collection with the best yearly cost.
     * @return lowest yearly cost
     */
    public BidInterface bestYearly();

    /**
     * Returns the bid in this collection with the best initial cost. The initial cost will be defined
     * as the unit cost plus the installation cost.
     * @return lowest initial cost
     */
    public BidInterface bestInitial();

    /**
     * Clears all of the items from this collection.
     */
    public void clearBid();

    /**
     * Gets the number of items in this collection.
     * @return item count
     */
    public int bidCount();

    /**
     * Sees whether this collection is empty.
     * @return true if empty
     */
    public boolean isEmpty();
}