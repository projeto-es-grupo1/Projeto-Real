package swati4star.createpdf.util;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class BottomSheetCallback extends BottomSheetBehavior.BottomSheetCallback {

    private final ImageView mUpArrow;
    private final boolean mIsAdded;

    /** Constant to represent the maximum rotation angle (in degrees) of the arrow icon */
    private static final float MAX_ROTATION_ANGLE = 180.0f;

    /** Constant to represent the minimum bottom sheet slide offset for rotation */
    private static final float MIN_SLIDE_OFFSET = -1.0f;

    /** Constant to represent the maximum bottom sheet slide offset for rotation */
    private static final float MAX_SLIDE_OFFSET = 1.0f;

    /** Constant to represent the neutral rotation angle */
    private static final float ZERO_DEGREES = 0.0f;

    public BottomSheetCallback(ImageView mUpArrow, boolean mIsFragmentAdded) {
        this.mUpArrow = mUpArrow;
        this.mIsAdded = mIsFragmentAdded;
    }

    @Override
    public void onStateChanged(@NonNull View bottomSheet, int newState) {
    }

    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        //ensure the fragment is currently added to its activity
        if (mIsAdded) {
            animateBottomSheetArrow(slideOffset);
        }
    }

    /**
     * animates the upArrow icon when sliding the bottom sheet
     *
     * @param slideOffset offset to use to sync the animation with bottom sheet sliding
     */
    private void animateBottomSheetArrow(float slideOffset) {
        if (slideOffset >= ZERO_DEGREES && slideOffset <= MAX_SLIDE_OFFSET) {
            mUpArrow.setRotation(slideOffset * -MAX_ROTATION_ANGLE);
        } else if (slideOffset >= MIN_SLIDE_OFFSET && slideOffset < ZERO_DEGREES) {
            mUpArrow.setRotation(slideOffset * MAX_ROTATION_ANGLE);
        }
    }
}