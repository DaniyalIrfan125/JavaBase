package com.danial.javabase.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import java.util.Objects;

public class DialogsClass {

    // custom dialog
    public static void showErrorDialogWithCustomLayout(Context context,String titleText, String errorMessage) {
        final Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.layout_error_dialog);
//
//        // set the custom dialog components - text, image and button
//        TextView titleText = dialog.findViewById(R.id.tv_title_text);
//        titleText.setText(context.getString(R.string.titleText));
//
//      //  TextView errorTextMessage = dialog.findViewById(R.id.tv_error_message);
//        errorTextMessage.setText(errorMessage);
//
//        Button dialogButton = dialog.findViewById(R.id.btn_dialog_okay);
//        // if button is clicked, close the custom dialog
//        dialogButton.setOnClickListener(v -> dialog.dismiss());
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public static void confirmationDialogWithTwoButtons(Context context,String title,String errorMessage){

            // create a dialog with AlertDialog builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(title);
            builder.setMessage(errorMessage);

            builder.setPositiveButton("okay",
                    (dialog, which) -> {
                        // dismiss alert dialog, update preferences with game score and restart play fragment

                        dialog.dismiss();
                    });

            builder.setNegativeButton("cancel",
                    (dialog, which) -> {
                        // dismiss dialog, start counter again

                        dialog.dismiss();

                    });

            AlertDialog dialog = builder.create();

            dialog.show();

    }
}
