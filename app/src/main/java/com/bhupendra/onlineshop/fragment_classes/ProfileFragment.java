package com.bhupendra.onlineshop.fragment_classes;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bhupendra.onlineshop.R;
import com.bhupendra.onlineshop.api_classes.MyInterface;
import com.bhupendra.onlineshop.api_classes.Homeurl;
import com.bhupendra.onlineshop.http_classes.Url;
import com.bhupendra.onlineshop.required_classes.UserModalAno;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {


    public static String full_name = null;
    EditText txtName, txtEmail, txtAddress, txtPhone;
    TextView tname, temail;
    UserModalAno UserModalAno;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        txtName = view.findViewById(R.id.etname);
        txtEmail = view.findViewById(R.id.etemail);
        txtAddress = view.findViewById(R.id.etaddress);
        txtPhone = view.findViewById(R.id.etphone);

        tname = view.findViewById(R.id.name);
        temail = view.findViewById(R.id.email);

        getActivity().getWindow().setStatusBarColor(Color.parseColor("#ffb300"));
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        reqUser();

        return view;
    }

    private void reqUser(){
        MyInterface interfaces = Homeurl.getRetrofit().create(MyInterface.class);
        Call<com.bhupendra.onlineshop.required_classes.UserModalAno> userCall = interfaces.getUserDetails(Url.token);
        userCall.enqueue(new Callback<UserModalAno>() {
            @Override
            public void onResponse(Call<UserModalAno> call, Response<UserModalAno> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "I am in error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                UserModalAno = response.body();
                txtName.setText(response.body().getFullname());
                txtEmail.setText(response.body().getEmail());
                txtAddress.setText(response.body().getAddress());
                txtPhone.setText(response.body().getPhone());

                tname.setText(response.body().getFullname());
                temail.setText(response.body().getEmail());
            }

            @Override
            public void onFailure(Call<UserModalAno> call, Throwable t) {
                Log.d("My message", "onFaliure" + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
