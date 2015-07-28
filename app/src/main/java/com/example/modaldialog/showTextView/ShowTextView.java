package com.example.modaldialog.showTextView;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.modaldialog.R;
import com.example.modaldialog.functionalityB.DialogFragmentB;

/**
 * Created by bolovanos on 28.7.15.
 */
public class ShowTextView extends AppCompatActivity {

    String  TAG = "ShowTextView";
    Activity activity;
    Resources res;

    TextView textView;


    public ShowTextView(Activity activity) {

        this.activity = activity;
        res = activity.getResources();
    }

    public void populateShowTextView(String text){

        textView = (TextView) activity.findViewById(R.id.infoRow);
        textView.setText(res.getString(R.string.infoRow) + ": " + text);
        textView.setVisibility(View.VISIBLE);


        textView.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //do stuff here
                    showModalYesNoDialogB();
                }

                Log.i("click text", "xyz");
                return false;
            }
        });
    }

    /**
     * Info - open modal dialog with alert
     * @return - boolean
     */
    private boolean showModalYesNoDialogB(){

        DialogFragment newFragment = new DialogFragmentB();
/*        newFragment.show(getSupportFragmentManager(), "ClearHistoryDialogFragment");
        return true;*/

        try {
            newFragment.show(getSupportFragmentManager(), "ClearHistoryDialogFragment");
            return true;
        } catch (Exception e) {
            Log.d(TAG, "showModalLongTouchDialog_stackA");
            e.printStackTrace();
            Log.d(TAG, "showModalLongTouchDialog_stackB");
            return false;
        }
    }
}
