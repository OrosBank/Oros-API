package org.apache.fineract.models.accounts.savings;

public class DepositType {

    Integer id;
    String code;
    String value;

    public DepositType() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public boolean isRecurring() {
        return ServerTypes.RECURRING.getId().equals(this.getId());
    }

    public String getEndpoint() {
        return ServerTypes.fromId(getId()).getEndpoint();
    }

    public ServerTypes getServerType() {
        return ServerTypes.fromId(getId());
    }

    @Override
    public String toString() {
        return "DepositType{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    
    public static enum ServerTypes {
        // TODO: Are these all the types?
        SAVINGS(100, "depositAccountType.savingsDeposit", "savingsaccounts"),
        FIXED(200, "depositAccountType.fixedDeposit", "savingsaccounts"),
        RECURRING(300, "depositAccountType.recurringDeposit", "recurringdepositaccounts");

        private Integer id;
        private String code;
        private String endpoint;

        ServerTypes(Integer id, String code, String endpoint) {
            this.id = id;
            this.code = code;
            this.endpoint = endpoint;
        }

        public static ServerTypes fromId(int id) {
            for (ServerTypes type : ServerTypes.values()) {
                if (type.getId().equals(id)) {
                    return type;
                }
            }
            return SAVINGS;
        }

        public Integer getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getEndpoint() {
            return endpoint;
        }
    }
}
