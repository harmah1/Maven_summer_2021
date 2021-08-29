package Day2_071121;

public class Dynamic_Array {

    public static void main(String[] args) {

        //setup variables for dynamic array
        String[] zipcode, countries, cities, towns;

        zipcode = new String[6];
        zipcode[0] = "11218";
        zipcode[1] = "10001";
        zipcode[2] = "10002";
        zipcode[3] = "11219";
        zipcode[4] = "13337";
        zipcode[5] = "10006";

        countries = new String[6];
        countries[0] = "USA";
        countries[1] = "India";
        countries[2] = "Pakistan";
        countries[3] = "Russia";
        countries[4] = "Canada";
        countries[5] = "England";

        System.out.println("my zipcode is " + zipcode[0]);
        //getting the length of the variable
        System.out.println("my zipcode length is " + zipcode.length);

    }//end of main

}//end of java class
