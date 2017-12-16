package sample;

public class FindTable {
    private static String ID;
    private static String Type;
    private String CompName;
    private String CompID;
    private String Date;


    public FindTable(String ID, String Type,String CompName,String CompID,String Date) {
        this.ID = ID;
        this.Type = Type;
        this.CompName = CompName;
        this.CompID = CompID;
        this.Date = Date;
    }

    public static String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCompName() {
        return CompName;
    }

    public void setCompName(String compName) {
        CompName = compName;
    }

    public String getCompID() {
        return CompID;
    }

    public void setCompID(String compID) {
        CompID = compID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


}
