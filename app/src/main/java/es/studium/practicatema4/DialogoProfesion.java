package es.studium.practicatema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoProfesion extends DialogFragment
{
    OnDialogosListener mListener;
    RadioGroup radioGroupProfesion;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Inflar el layout personalizado
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_profesion, null);

        radioGroupProfesion = myView.findViewById(R.id.radioGroupProfesion);
        builder.setView(myView)
                .setTitle(R.string.titulo_profesion)
                .setPositiveButton(R.string.btn_aceptar, (dialogInterface, i) ->
                {
                    int selectedId = radioGroupProfesion.getCheckedRadioButtonId();
                    if (selectedId != -1) {
                        RadioButton selectedRadioButton = myView.findViewById(selectedId);
                        String especie = selectedRadioButton.getText().toString();
                        if (mListener != null) {
                            mListener.onProfesionSet(especie);
                        }
                    } else {
                        Toast.makeText(getActivity(), R.string.error_no_profesion_seleccionada, Toast.LENGTH_SHORT).show();
                    }
                    dialogInterface.dismiss();
                })
                .setNegativeButton(R.string.btn_cancelar, (dialogInterface, i) -> dialogInterface.dismiss());

        return builder.create();
    }
    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        try
        {
            mListener = (OnDialogosListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + " debe implementar OnDialogosListener");
        }
    }
}
