package com.example.fragmentnew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fragmentnew.Dialogs.ExampleDialog;

public class FirstFragment extends Fragment implements ExampleDialog.ExampleDialogListener {

    private Button btn;
    private TextView FirstName;
    private TextView SecondName;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        btn = view.findViewById(R.id.dialog_activate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        FirstName = (TextView) view.findViewById(R.id.FirstName);
        SecondName = (TextView) view.findViewById(R.id.SecondName);
    }

    private void openDialog() {
        ExampleDialog dialog = new ExampleDialog();
        dialog.setExampleDialogListener(this);
        dialog.show(getFragmentManager(), "Example Dialog");
    }

    @Override
    public void setTexts(String firstName, String secondName) {
        FirstName.setText(firstName);
        SecondName.setText(secondName);
    }
}