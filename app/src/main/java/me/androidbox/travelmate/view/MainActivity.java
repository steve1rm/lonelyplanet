package me.androidbox.travelmate.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.androidbox.travelmate.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_fragment_container, new MainFragment(), "MainFragment");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }

       // isPalindrome("noel sees leon.");
 //       Object[] a = new Object[] {3, 4, 2, -3, 6, -2, 9, 5};
  //      reverseArray(a);

       // Log.d(TAG,  " " + countWords("The fox jumped over 10 fences"));
    }

    public Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */
        Object[] rev = new Object[a.length];
        int k = 0;
        for(int i = a.length; i > -1; i--) {
            rev[k++] = a[i];
        }

        Log.d(TAG, "finished");

        return rev;
    }

    public int getClosestToZero(int[] a) {
        /*
          Please implement this method to
          return the number in the array that is closest to zero.
          If there are two equally close to zero elements like 2 and -2
          - consider the positive element to be "closer" to zero.
         */

        /* 3, 4, 2, -3, 6, -2, 9, 5 */

        int closestPositive = a[0];
        int closeNegative = a[0];
        int closestZero = 0;

        /* Find the closest positive */
        for(int i = 1; i < a.length; i++) {
            if(a[i] > 0) {
                if(a[i] < closestPositive) {
                    closestPositive = a[i];
                }
            }
        }

        /* Put the first negative number in for comparsion */
        for(int i = 0; i < a.length; i++) {
            if(a[i] < 0) {
                closeNegative = a[i];
                break;
            }
        }

        /* Find the closest negative */
        for(int i = 0; i < a.length; i++) {
            /* Check for the negative numbers */
            if(a[i] < 0) {
                if(closeNegative < a[i]) {
                    closeNegative = a[i];
                }
            }
        }

        /* Compare the results */
        int negativeABS = Math.abs(closeNegative);
        if(closestPositive <= negativeABS) {
            closestZero = negativeABS;
        }

        Log.d(TAG, "closeZero: " + closestZero);

        return closestZero;
    }

    /* noelseesleon */
    /* Noel sees leon. */
    public static boolean isPalindrome(String s) {
        /* Clean the string of all non-words */
        final String strOrgClean = s.replaceAll("\\W", "");
        char[] strRev = new char[strOrgClean.length()];

        /* put string in reverse order */
        for(int i = strOrgClean.length() - 1; i > -1; i--) {
            /* Ignore all spaces and force stops */
            strRev[i] = strOrgClean.charAt(i);
        }

        boolean isPlaindine = false;
        /* Check by doing a simple string comparison */
        if(strOrgClean.equalsIgnoreCase(String.valueOf(strRev))) {
            isPlaindine = true;
        }

        return isPlaindine;
      //  throw new UnsupportedOperationException("Waiting to be implemented.");
    }


    public int[] removeDuplicates(int[] a) {
        /*
          Please implement this method to
          remove all duplicates from the original array. Retain the order of the elements and
          always retain the first occurrence of the duplicate elements.
          For example, parameter: {2,1,2,3}, result: {2,1,3}
         */

        int[] sorted = new int[a.length];

        List<Integer> org = new ArrayList<>();
        for(int num : a) {
            org.add(num);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer number : org) {
            /* Check do we have this number already */
            if(map.containsKey(number)) {
                Integer count = map.get(number);
                /* Increment how many times its been duplicated */
                count++;
                map.put(number, count);
            }
            else {
                map.put(number, 0);
            }
        }

        int i = 0;
        /* Now add to a new array */
        for(Map.Entry entry : map.entrySet()) {
            /* Always add the first one */
            if(i == 0) {
                sorted[i] = (int) entry.getKey();
                i++;
                continue;
            }

            if(entry.getValue() == 0) {
                sorted[i] = (int)entry.getKey();
            }
            i++;
        }

        return sorted;

    }

    /*
An anagram is a word formed from another by rearranging its letters, using all the original letters exactly once; for example, orchestra can be rearranged into carthorse.
Write a function that checks if two words are each other's anagrams.
For example, areAnagrams("momdad", "dadmom") should return true as arguments are anagrams.
*/

    public static boolean areAnagrams(String a, String b) {
        return true;
        // throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int[] positiveNumbers() {
        int[] a = new int[] {2, -41, -5, 3, 7, 43, 34, 0, 2};
        List<Integer> sortedInt = new ArrayList<>();
        Integer[] intsSorted = new Integer[a.length];

        for(int number : a) {
            if(number > 0) {
                sortedInt.add(number);
            }
        }

        Collections.sort(sortedInt);

        sortedInt.toArray(intsSorted);

        return null;
    }

    public int countWords(String s) {
        /*
          Please implement this method to
          return the word count in a given String.
          Assume that the parameter String can only contain spaces and alphanumeric characters.
         "the fox jumped over 10 fences"
         */

        int wordCount = 1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                wordCount++;
            }
        }

        return wordCount;
    }

    public List<Integer> getPerfectNumbers(int from, int to) {
        /*
          Please implement this method to
          return a list of all perfect numbers in the given range inclusively.
          A perfect number is defined as a positive integer which is the sum of its positive divisors not including the number itself.
          For example: 6 is a perfect number because 6 = 1 + 2 + 3 (1, 2, 3 are divisors of 6)
          28 is also a perfect number: 28 = 1 + 2 + 4 + 7 + 14

         2, 3, 4, 5, 6, 7, 8, 9, 10, 11
         */

        return new ArrayList<>();
    }

    public Object[] reverseArray2(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */

        Object[] rev = new Object[a.length];
        int k = 0;
        for(int i = a.length; i > -1; i--) {
            rev[k++] = a[i];
        }

        return rev;
    }

    public static String capitalizeFirstLetters(String s) {
        /*
          Please implement this method to
          capitalize all first letters of the words in the given String.
          All other symbols shall remain intact. If a word starts not with a letter, it shall remain intact too.
          Assume that the parameter String can only contain spaces and alphanumeric characters.

          NOTE: please keep in mind that the words can be divided by single or multiple spaces.
          The spaced also can be found at the beginning or the end of the parameter string,
          and you need to preserve them.

          " the fox jumped  over 10 fences "
         */
        char[] spaces = new char[s.length()];
        char[] words = new char[s.length()];

        List<String> sentence = new ArrayList<>();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                spaces[k] = ' ';
                k++;
            }
            else {
                if(spaces.length > 0) {
                    sentence.add(spaces.toString());
                }
                k = 0;

            }
        }

        return "";
    }
}
