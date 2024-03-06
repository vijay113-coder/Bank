package Bank;
import java.util.ArrayList;
class Customer {
     public String Account_no="TNAB04";    /** customer class here  it has all data member related to customer details     */
     private static int Code=1001,Pin=101;
     private String Name,Gender,Password="AB04";
      private int  Age,Balance;
      private ArrayList<String> Transaction=new ArrayList<>();
          /*** customer class constructor assign values when add  new customers  */
      Customer(String name,int age,String gender,int balance){
         Name=name;
         Age=age;
         Gender=gender;
         Balance=balance;
         Account_no+=Code;
         Password+=Pin;
         Code++;
         Pin++;
     }
     /** password generate auto mode get password*/
    public String getPassword() {
        return Password;
    }
    /** update and get balance */
     public int getBalance() {
        return Balance;
    }
    public void setBalance(int balance) {
        Balance = balance;
    }
    /** set transaction datas*/
    public void setTransaction(String datas) {
        Transaction.add(datas);
    }

    /** customer details print */
    public void Customer_details(){
        System.out.println("\t \t \t Account details");
        System.out.println("Account No: "+Account_no+"\t "+"Customer Name: "+Name);
        System.out.println("Age: "+Age+"\t"+" Gender: "+Gender);
        System.out.println("Total Balance :  "+Balance);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }
    /**  transactions details*/
    public void showTransaction(){
         if(Transaction.isEmpty()){
             System.out.println("\t \t  No Transaction History ");
         return;
         }
         for(String datas:Transaction){
             System.out.println(datas);
         }
    }
}
