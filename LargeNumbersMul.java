//https://www.geeksforgeeks.org/multiply-large-numbers-represented-as-strings/
//this class contains large numbbers multiplication and also addition

public class LargeNumbersMul {

    /*
    public static void main(String[] args) {
        String s1 = "492";
        String s2 = "3690";
        System.out.println(add2BigNumbers(s1, s2));
    }
    */

    public static void main(String[] args) {

        String finalres = "";

        String s1 = "654154154151454545415415454";

        String s2 = "63516561563156316545145146514654";

        String s3 = "";

        int len1 = s1.length();

        int len2 = s2.length();





        if(len1 > len2)
        {
            int delta = len1 - len2;

            while (delta >0)
            {

                s2 = "0" + s2;

                delta--;
            }
        }

        else if(len2 > len1)
        {
            int delta = len2 - len1;

            while (delta >0)
            {

                s1 = "0" + s1;
                delta--;
            }


        }


        //System.out.println(s1);
        //System.out.println(s2);



         len1 = s1.length();

         len2 = s2.length();




        String s1rev = "";;





        for(int i= len1-1; i >=0; i--)
        {
            s1rev = s1rev+s1.charAt(i);
        }



        int zeros = 0;


        //System.out.println("s2 is :"+s2);
        //System.out.println("last chhar is :"+s2.charAt(s2.length() - 1));

        for(int j = len2-1; j >= 0; j--)
        {
            int num = s2.charAt(j) - '0';

            //System.out.println("num is:"+num);

            String s2tmp = String.valueOf(s2.charAt(j) - '0');

           // System.out.println("s2tmp is :"+s2tmp);

            int carry = 0;

            s3 = "";

            for(int i=0; i< s1rev.length(); i++)
            {

                //System.out.println(Integer.valueOf(s2tmp));
                //System.out.println((s1rev.charAt(i) - '0'));

                int tempres = carry + ( Integer.valueOf(s2tmp) * (s1rev.charAt(i) - '0'));

                //System.out.println("tempres is:"+tempres);

                if(tempres >= 10)
                {
                    int tempsum = tempres % 10;

                    s3 = s3.concat(String.valueOf(tempsum));
                    carry = tempres / 10;


                }
                else
                {
                    s3 = s3.concat(String.valueOf(tempres));
                    carry = 0;
                }


            }
            if(carry == 1)
                s3 = s3.concat(String.valueOf(carry));


            String s3out = "";


            for(int i= s3.length()-1; i >=0; i--)
            {
                s3out = s3out+(s3.charAt(i));


            }

            for(int k = 0; k < zeros; k++)
            {
                s3out = s3out.concat("0");
            }


            System.out.println(s3out);
            zeros +=1;

            finalres = add2BigNumbers(finalres, s3out);











        }


        System.out.println(finalres);






    }


    public static  String add2BigNumbers(String s1, String s2)
    {
        String resut = "";


        int l1 = s1.length();

        int l2 = s2.length();

        if(l1 == 0)
        {
            return s2;

        }

        else if(l2 == 0)
        {
            return  s1;
        }

        if(l1 > l2)
        {
            int delta = l1 - l2;

            while (delta >0)
            {

                s2 = "0" + s2;

                delta--;
            }
        }

        else if(l2 > l1)
        {
            int delta = l2 - l1;

            while (delta >0)
            {

                s1 = "0" + s1;
                delta--;
            }


        }


        //System.out.println(s1);
       // System.out.println(s2);

        int i = s1.length()-1;

        int j = s2.length() - 1;


        int carry = 0;




        while( i  >=0 &&  j >=0)
        {
            int tempsum = carry + (s1.charAt(i) - '0') + (s2.charAt(j) -'0');

            //System.out.println(tempsum);

            if(tempsum >=10)
            {
                tempsum = tempsum - 10;

                carry = 1;
            }

            else
            {
                tempsum = tempsum;
                carry = 0;
            }

            resut = resut.concat(String.valueOf(tempsum));

            i--;
            j--;



        }

        if(carry == 1) {
            resut = resut.concat(String.valueOf(carry));
        }


        String output  = "";

        for(int k= resut.length()-1; k >=0; k--)
        {
            output = output+(resut.charAt(k));


        }




        return output;


    }




}

