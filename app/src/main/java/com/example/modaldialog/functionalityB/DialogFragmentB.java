package com.example.modaldialog.functionalityB;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.view.LayoutInflater;

import com.example.modaldialog.R;

import java.util.ArrayList;

/**
 * Info -
 */
public class DialogFragmentB extends DialogFragment {
    String TAG = "ClearHistoryDialogFragment ";
    ArrayList <Integer> mSelectedItems;


    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        super.onCreate(savedInstance);

        LayoutInflater inflater = getActivity().getLayoutInflater();


        mSelectedItems = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog
                .Builder(new ContextThemeWrapper(getActivity(), R.style.customDialogFragment));

        // Set the dialog title
        String dialogTitle = getString(R.string.dialog_b);
        builder.setTitle(dialogTitle)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(R.array.pref_array_entries, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                        // Set the action buttons
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        String removedLanguages = "";
                        String[] searchLanguageEntries = getResources()
                                .getStringArray(R.array.pref_array_entries);



                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();


    }

}
