package producer;

public class JCompany {
    private String company;
    int tradeNumber;
    String registeredName;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(int tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public JCompany() {}
    public JCompany(String name, int no, String registeredName) {
        this.company = name;
        this.tradeNumber = no;
        this.registeredName = registeredName;
    }
}
