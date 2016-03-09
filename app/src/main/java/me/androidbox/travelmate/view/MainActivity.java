package me.androidbox.travelmate.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
    public static boolean isPalindrome(String str) {
        char[] strRev = new char[str.length()];
        char[] strOrg = str.toCharArray();

        /* put in reverse order */
        for(int i = str.length(); i == 0; i--) {
            strRev[i] = str.charAt(i);
        }

        boolean isPlaindine = false;

        /* compare each one end points */
        for(int i = 0; i < str.length(); i++) {
            if(strOrg[i] != '.' || strOrg[i] != ' ') {
                if (strOrg[i] == strRev[i]) {
                    isPlaindine = true;
                }
                else {
                    isPlaindine = false;
                    break;
                }
            }
        }

        return isPlaindine;
      //  throw new UnsupportedOperationException("Waiting to be implemented.");
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
}
