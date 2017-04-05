package com.PamFields;
import java.util.Date;
/**
 * Created by Pam on 4/2/2017.
 */
public class Furnace extends ServiceCall {

    /* An enum is a group of constants. Since the furnace's type must be one of these, use
    an Enum to contain the allowed types.  */
    enum FurnaceType {
        FORCED_AIR,
        BOILER,
        GRAVITY
    }

    private FurnaceType type;

    public Furnace(String serviceAddress, String problemDescription, Date date, FurnaceType type) {

        super(serviceAddress, problemDescription, date);
        this.type = type;

    }

    @Override
    public String toString() {

        String typeString = type.toString();
        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);


        return "Furnace Service Call " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Furnace Type = " + typeString + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString ;

    }
}


