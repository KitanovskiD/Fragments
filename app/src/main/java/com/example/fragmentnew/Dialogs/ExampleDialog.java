package com.example.fragmentnew.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.fragmentnew.R;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText first_name;
    private EditText second_name;

    private ExampleDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_layout, null);
        first_name = (EditText) view.findViewById(R.id.firstNameBox);
        second_name = (EditText) view.findViewById(R.id.secondNameBox);

        builder.setView(view)
                .setTitle("Enter your personal info")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String fName = first_name.getText().toString();
                        String lName = second_name.getText().toString();

                        listener.setTexts(fName, lName);
                    }
                });

        return builder.create();
    }

    public void setExampleDialogListener(ExampleDialogListener listener) {
        this.listener = listener;
    }

    public interface ExampleDialogListener {
        void setTexts(String firstName, String secondName);
    }
}
