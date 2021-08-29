package Day2_071121;

public class While_Loop_With_Array {

    public static void main(String[] args) {

        //iterate through different countries value and print them out in for loop
        String[] countries = new String[5];
        countries[0] = "USA";
        countries[1] = "Bangladesh";
        countries[2] = "Pakistan";
        countries[3] = "India";
        countries[4] = "Russia";


        //set the initializer first
        int i = 0;
        //call the while loop and define the end point
        while(i < countries.length){
            System.out.println("My country is " + countries[i]);

            //incrementation
            i = i +1;//same as i++
        }//end of while loop


    }//end of java

}//end of class
