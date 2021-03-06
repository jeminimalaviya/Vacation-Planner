package com.example.maulik.vacation_planner_2;
//
// Copyright 2018 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.21
//

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.amazonaws.mobile.auth.core.DefaultSignInResultHandler;
import com.amazonaws.mobile.auth.core.IdentityProvider;
import com.example.maulik.vacation_planner_2.attractions.AttractionsActivity;

/**
 * Handles Re-directing to the main activity upon sign-in.
 */
public class SignInHandler extends DefaultSignInResultHandler {
    private static final String LOG_TAG = SignInHandler.class.getSimpleName();

    @Override
    public void onSuccess(final Activity callingActivity, final IdentityProvider provider) {
        if (provider != null) {
            Log.d(LOG_TAG, String.format("User sign-in with %s provider succeeded",
                provider.getDisplayName()));
            Toast.makeText(callingActivity, String.format(
                callingActivity.getString(R.string.sign_in_succeeded_message_format),
                provider.getDisplayName()), Toast.LENGTH_LONG).show();
        }

        /** Go to the main activity. */
        callingActivity.startActivity(new Intent(callingActivity, AttractionsActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    @Override
    public boolean onCancel(final Activity callingActivity) {
        // User abandoned sign in flow.
        // For Mandatory Auth the app will exit unless an activity is launched here.
        final boolean shouldFinishSignInActivity = true;
        return shouldFinishSignInActivity;
    }

}
