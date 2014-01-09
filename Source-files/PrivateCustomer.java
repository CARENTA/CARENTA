/* This class describes a private customer with the following attributes and methods! */

public class PrivateCustomer extends Customer {
	
        private String firstName;
        private String lastName;
        
        public PrivateCustomer(int customerNbr, String IDNbr, String firstName, 
                        String lastName, String adress, String city, String areaCode,
                        String phoneNbr, String mailAdress, int discountLevel) {
                
                super(customerNbr, IDNbr, adress, city, areaCode, phoneNbr,
                                mailAdress, discountLevel);
                
           
                this.firstName = firstName;
                this.lastName = lastName;
                
        }


        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }
}
