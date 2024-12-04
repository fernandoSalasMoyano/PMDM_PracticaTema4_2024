package es.studium.practicatema4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment
{
    OnDialogosListener mListener;
    EditText edtNombre;

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_nombre, null);

        edtNombre = myView.findViewById(R.id.editTextNombre);

        builder.setView(myView)
                .setTitle(R.string.titulo_nombre)
                .setPositiveButton(R.string.btn_aceptar, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        String nombre = edtNombre.getText().toString();
                        if (!nombre.isEmpty()) {
                            mListener.onNombreSet(nombre);
                        } else {
                            Toast.makeText(getActivity(), R.string.eror_nombre_vacio, Toast.LENGTH_SHORT).show();
                        }
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.dismiss();

                    }
                });
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
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "debe implementar OnDialogosListener");
        }
    }
}
