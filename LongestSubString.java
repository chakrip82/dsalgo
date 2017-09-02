// http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/

package com.myntra.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by m01457 on 02/09/17.
 */
public class LongestSubString {

    //longest possible substring having k distinct characters

    public static void main(String[] args)
    {

        //String s = "aaabbbcccc";

        //if k == 1 o/p :- cccc

        //if k ==2 o/p:- bbbcccc

        // if k == 3 o/p:- aaabbbcccc

        //if k ==4 null or empty



        System.out.println("outputList is:"+LongestSubString.longest_substrings("abcdabcdabcdabcd", 3));




    }


    public static List<String> longest_substrings(String inputStr, int k) {

        System.out.println("inputStr length is :"+inputStr.length());

        List<String> outputList = new ArrayList<String>();


        if (inputStr == null || inputStr.isEmpty() || inputStr.length() < k) {
            return null;

        }


        //identify how many unique characters are characters are there in inputStr

        Set<Character> unique_chars_set = new HashSet<Character>();

        for (int i = 0; i < inputStr.length(); i++) {
            if (!unique_chars_set.contains(inputStr.charAt(i))) {
                unique_chars_set.add(inputStr.charAt(i));
            }
        }

        System.out.println(unique_chars_set.size());


        if (k > unique_chars_set.size())
            return null;

        if (k == unique_chars_set.size()) {
            outputList.add(inputStr);
            return  outputList;

        }


        //happy flow


        //generate candidate

        int startPos = 0;

        while(startPos < inputStr.length())
        {
            System.out.println("startpos is :"+startPos);

            String generatedStr = generate_candidate(inputStr, k, startPos);

            if(generatedStr == null)
                break;

            //candidate validation and updation of output list

            if (outputList.isEmpty()) {

                outputList.add(generatedStr);
            }

            else
            {

                if (generatedStr.length() == outputList.get(0).length())
                {
                    outputList.add(generatedStr);
                }
                else if (generatedStr.length() > outputList.get(0).length())
                {

                    outputList.clear();
                    outputList.add(generatedStr);
                }
            }


            //next candidate generation

            //get the startPos of second distinct character in generatedStr

            char start_char = generatedStr.charAt(0);


            int index = startPos;


            for (int j = startPos; j < inputStr.length(); j++)
            {
                if (inputStr.charAt(j)  ==  start_char) {
                    continue;
                }
                else
                {
                    index = j;
                    break;
                }
            }

            if(index == startPos)
                break;
            startPos = index;

        }



        //System.out.println("outputList is:"+outputList);

        return outputList;



    }




    private static String generate_candidate(String inputStr, int k, int startPos) {

        //aaabbbbbbbbcccc


        Set<Character> characterSet = new HashSet<Character>();

        StringBuilder strGenerated = new StringBuilder();


        for(int i= startPos; i< inputStr.length() ; i++)
        {

            Character ch = inputStr.charAt(i);


            int currentSetSize = characterSet.size();


            if(currentSetSize == k)
            {
                if(characterSet.contains(ch))
                {
                    strGenerated.append(ch);
                }
                else
                {
                    break;
                }
            }


            else if(currentSetSize < k)
            {
                characterSet.add(ch);

                strGenerated.append(ch);

            }

            else //got a character ch becoz of which characterSet size > k
            {
                break;
            }
        }

        if(characterSet.size() < k)
        {

            //strGenerated = null;
            return  null;

        }

        System.out.println("generated string is :"+strGenerated.toString());
        return strGenerated.toString();
    }
}

