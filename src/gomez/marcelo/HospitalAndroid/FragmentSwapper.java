package gomez.marcelo.HospitalAndroid;

import android.app.Fragment;
import android.app.FragmentManager;

/**
 * Created with IntelliJ IDEA.
 * User: Marcelo Gomez
 * Date: 11/12/13
 * Time: 4:46 PM
 */
public class FragmentSwapper {
    FragmentManager fm;
    private boolean showingBack = false;

    public FragmentSwapper(FragmentManager fm) {
        this.fm = fm;
    }

    public FragmentSwapper(FragmentManager fm, boolean showingBack) {
        this.fm = fm;
        this.showingBack = showingBack;
    }

    public void replaceWithBackStack(Fragment fragment, int containerId) {
        if (showingBack) {
            fm.popBackStack();
            return;
        }

        // Flip to the back.
        showingBack = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.

        fm.beginTransaction()
            // Replace the default fragment animations with animator resources representing
            // rotations when switching to the back of the card, as well as animator
            // resources representing rotations when flipping back to the front (e.g. when
            // the system Back button is pressed).
            .setCustomAnimations(
                    R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                    R.animator.card_flip_left_in, R.animator.card_flip_left_out)
            // Replace any fragments currently in the container view with a fragment
            // representing the next page (indicated by the just-incremented currentPage
            // variable).
            .replace(containerId, fragment)
            // Add this transaction to the back stack, allowing users to press Back
            // to get to the front of the card.
            .addToBackStack(null)
            // Commit the transaction.
            .commit();
    }

    public void replaceWithoutBackStack(Fragment fragment, int containerId) {
        if (showingBack) {
            fm.popBackStack();
            return;
        }

        // Flip to the back.
        showingBack = true;

        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.

        fm.beginTransaction()
                // Replace the default fragment animations with animator resources representing
                // rotations when switching to the back of the card, as well as animator
                // resources representing rotations when flipping back to the front (e.g. when
                // the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                // Replace any fragments currently in the container view with a fragment
                // representing the next page (indicated by the just-incremented currentPage
                // variable).
                .replace(containerId, fragment)
                // Commit the transaction.
                .commit();
    }
}
