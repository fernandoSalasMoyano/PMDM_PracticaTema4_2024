package es.studium.practicatema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoSexo extends DialogFragment
{

    OnDialogosListener mListener;
    RadioGroup radioGroupSexo;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Inflar el layout personalizado
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_sexo, null);

        radioGroupSexo = myView.findViewById(R.id.radioGroupSexo);

        builder.setView(myView)
                .setTitle(R.string.titulo_sexo)
                .setPositiveButton(R.string.btn_aceptar, (dialogInterface, i) ->
                {
                    int selectedId = radioGroupSexo.getCheckedRadioButtonId();
                    if (selectedId != -1) {
                        RadioButton selectedRadioButton = myView.findViewById(selectedId);
                        String sexo = selectedRadioButton.getText().toString();
                        if (mListener != null) {
                            mListener.onSexoSet(sexo);
                        }
                    } else {
                        Toast.makeText(getActivity(), R.string.error_no_sexo_seleccionado, Toast.LENGTH_SHORT).show();
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
            throw new ClassCastException(context.toString() + R.string.error_OnAttach);
        }
    }
}