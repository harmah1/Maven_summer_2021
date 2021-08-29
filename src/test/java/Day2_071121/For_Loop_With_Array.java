package Day2_071121;

public class For_Loop_With_Array {
    public static void main(String[] args) {

        //iterate through different countries value and print them out in for loop
        String[] countries = new String[5];
        countries[0] = "USA";
        countries[1] = "Bangladesh";
        countries[2] = "Pakistan";
        countries[3] = "India";
        countries[4] = "Russia";

        String[] placements = new String[5];
        placements[0] = "First";
        placements[1] = "Second";
        placements[2] = "Third";
        placements[3] = "Fourth";
        placements[4] = "Fifth";

        //using for loop to iterate through these values
        for (int i = 0; i < countries.length; i++){
            //print statement
            System.out.println("My country is " + countries[i] + " and placement is " + placements[i]);
            //to change incrementation to skip every other value on the list we need to redefine the i
            //i = i + 1;
        }//end of for loop

    }//end of main method
}//end of class
