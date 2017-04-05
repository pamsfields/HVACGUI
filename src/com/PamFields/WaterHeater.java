package com.PamFields;
import java.util.Date;
/**
 * Created by Pam on 4/2/2017.
 */
public class WaterHeater extends ServiceCall {
    /* An enum is a group of constants. Since the water heater's type must be one of these, use
an Enum to contain the allowed types.  */
    enum WaterHeaterType {
        Gas_Tanked,
        Electric_Tanked,
        Gas_Tankless,
        Electric_Tankless,
    }
    static int mandatoryCityFee = 20;

    private WaterHeaterType type;

    public WaterHeater(String serviceAddress, String problemDescription, Date date, WaterHeaterType type) {

        super(serviceAddress, problemDescription, date);
        this.type = type;
    }

    @Override
    public String toString() {

        String typeString = type.toString();
        String resolvedDateString = (resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = (this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);


        return "Water Heater Service Call " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription + "\n" +
                "Water Heater Type = " + typeString + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString+ "\n"+
                "$20 mandatory city fee additional fee";
    }
}
