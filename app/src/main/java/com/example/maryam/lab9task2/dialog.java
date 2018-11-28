package com.example.maryam.lab9task2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class dialog extends AppCompatDialogFragment {
    private RadioGroup rg;
    private Dialoglis listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.activity_dialog,null);
        builder.setView(view)
                .setTitle(" Payer Status ")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id= rg.getCheckedRadioButtonId();
                        RadioButton r=(RadioButton) view.findViewById(id);
                        String a=r.getText().toString();
                        listener.applytext(a);

                    }
                });
        rg=(RadioGroup) view.findViewById(R.id.radiobtns);
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Dialoglis) context;
    }

    public interface Dialoglis
    {
        void applytext(String status);
    }
}