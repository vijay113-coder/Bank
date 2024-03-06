package Bank;
import java.util.HashMap;
/**  options class here it will take over the full bank options */
class Options {
     private HashMap<String,Customer> customers=new HashMap<>();
    /** default users */
     Options(){
         Customer customer1=new Customer("Deepan",41,"Male",10000);
         Customer customer2=new Customer("Surya",44,"Male",16000);
         Customer customer3=new Customer("Lakshmi",30,"Female",20000);
         customers.put(customer1.Account_no,customer1);
         customers.put(customer2.Account_no,customer2);
         customers.put(customer3.Account_no,customer3);
     }
     /***valid methods checks user is exist*/
     private boolean isValid(String account_no,String password) {
         if (!customers.containsKey(account_no) || !customers.get(account_no).getPassword().equals(password)) {
             System.out.println("\t \t Invalid User or account password ");
             return false;
         }
         return true;
     }
     /**add new customers to bank*/
        public void Add_Customer(String name,int age,String gender,int balance){
            Customer customer=new Customer(name,age,gender,balance);
            customers.put(customer.Account_no,customer);
            System.out.println("\t \t  successfully account created");
            System.out.println("\t \t Your Account no : "+ customer.Account_no);
            System.out.println("\t \t  Your Password : "+customer.getPassword());
        }
        /**personal account details*/
        public boolean Account_details(String account_no,String password){
            if(isValid(account_no,password)){
                Customer customer=customers.get(account_no);
                customer.Customer_details();
                return true;
            }
            return false;
        }
        /**deposit money in personal account*/
        public void Deposit(String account_no,String password,int amt) {
            if (isValid(account_no, password)) {
                Customer customer = customers.get(account_no);
                customer.setBalance(customer.getBalance()+amt);
                System.out.println("\t \t  Total Balance : " + customer.getBalance());
                String data = " Credited amount : " + amt;
                customer.setTransaction(data);
            }
        }
        /** withdraw money from personal account*/
    public void withDraw(String account_no,String password,int amt) {
        if (isValid(account_no, password)) {
            Customer customer = customers.get(account_no);
            if (amt > customer.getBalance()) {
                System.out.println("\t Insufficient Balance   | Available Balance :  " + customer.getBalance());
                return;
            }
            customer.setBalance(customer.getBalance() - amt);
            System.out.println("\t \t  Total Balance : " + customer.getBalance());
            String data = "Debited amount : " + amt;
            customer.setTransaction(data);
        }
    }
    /** transactions history*/
     public void Show_Transactions(String account_no,String password){
      if(isValid(account_no,password)){
          Customer customer=customers.get(account_no);
          customer.showTransaction();
         }
     }
     /**transfer money one account to another*/
    public void Transfer(String send_account,String password,String get_account,int amt){
         if(isValid(send_account,password)){
             if(customers.containsKey(get_account)){
                 Customer sender=customers.get(send_account);
                 Customer receiver=customers.get(get_account);
                 if(amt>sender.getBalance()){
                     System.out.println(" \t \t Sender account have Insufficient balance  "+ sender.getBalance());
                 return;
                 }
                 sender.setBalance(sender.getBalance()-amt);
                 receiver.setBalance(receiver.getBalance()+amt);
                 String data="";
                 data="  Debited :  "+amt+" Transfer to "+receiver.Account_no+" ";
                 sender.setTransaction(data);
                 data=" Credited : "+amt+" receive amount form "+sender.Account_no+" ";
                 receiver.setTransaction(data);
                 System.out.println("\t Available amount: "+sender.getBalance());
             }
             else{
                 System.out.println("\t \t Receiver account no Invalid : "+ get_account);
             }
         }
    }
}

