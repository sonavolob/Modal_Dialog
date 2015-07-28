package com.example.modaldialog;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.modaldialog.functionalityA.DialogFragmentA;
import com.example.modaldialog.showTextView.ShowTextView;
import com.example.modaldialog.utils.Container;


public class MainActivity extends AppCompatActivity {

    ShowTextView showTextView;


    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Container.getInstance().initShowTextView(this);
        showTextView = Container.getInstance().showTextView;

        showTextView.populateShowTextView("some text");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);




//        resultsList = new ResultsList(this);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_dialog_fragment_a) {
            showModalYesNoDialogA();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Info - open modal dialog with alert
     * @return - boolean
     */
    private boolean showModalYesNoDialogA(){

        DialogFragment newFragment = new DialogFragmentA();
        Log.d(TAG, "_A_newFragment.isAdded(): " + newFragment.isAdded() + ", activity: " + this
                + ", newFragment.getActivity();" + newFragment.getActivity());
        newFragment.show(getSupportFragmentManager(), "ClearHistoryDialogFragment");
        Log.d(TAG, "_B_newFragment.isAdded(): " + newFragment.isAdded() + ", activity: " + this
                + ", newFragment.getActivity();" + newFragment.getActivity());

        return true;
    }

}
