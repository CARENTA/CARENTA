/* This class describes a company customer with the following attributes and methods! */

public class CompanyCustomer extends Customer {

        private String companyName;
        
        public CompanyCustomer(int customerNbr, String IDNbr, String companyName,
                        String adress, String city, String areaCode,
                        String phoneNbr, String mailAdress, int discountLevel) {
                
                super(customerNbr, IDNbr,  adress, city, areaCode, phoneNbr,
                                mailAdress, discountLevel);
                
                this.companyName = companyName;
                
        }


        public String getCompanyName() {
                return companyName;
        }

        public void setCompanyName(String companyName) {
                this.companyName = companyName;
        }
}
