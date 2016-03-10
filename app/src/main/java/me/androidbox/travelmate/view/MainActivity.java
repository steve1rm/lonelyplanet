package me.androidbox.travelmate.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.androidbox.travelmate.R;

public class MainActivity extends AppCompatActivity {

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

        isPalindrome("noel sees leon.");
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
}
