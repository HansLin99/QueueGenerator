package CustomerData;


public class Customer implements Interfaces.User {


    public String name = "";
    public int position;
    public String phoneNumber = "";





    @Override
    //MODIFY:this
    //EFFECTS:change the customer's name to the name entered
    public void addName(String name){
        this.name = name;
    }

    @Override
    //MODIFY:this
    //EFFECTS:change the customer's phone number to the phoneNum entered
    public void addPhoneNumber(String phoneNum){
        this.phoneNumber = phoneNum;
    }


    //REQUIRE:position greater than or equal to 0 and less than the size-1
    //MODIFY:nothing
    //EFFECT:return true if the customer need to be seated
    public boolean needToBeSeated(int position){
        //stub
        return false;
    }


    //REQUIRE:nothing
    //MODIFY:nothing
    //EFFECT:get the Info of the customer including name and phone number
    public void getInfoCustomer(Customer c){
        //stub
    }


    //EFFECT:send a text message to inform the customer to be seated
    public void sentText(){
        //stub
    }





}
