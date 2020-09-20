package com.bhupendra.onlineshop.required_classes;

import com.bhupendra.onlineshop.activity_classes.ProductDetailActivity;
import com.bhupendra.onlineshop.api_classes.MyInterface;
import com.bhupendra.onlineshop.fragment_classes.ProfileFragment;
import com.bhupendra.onlineshop.fragment_classes.FavouriteFragment;
import com.bhupendra.onlineshop.http_classes.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    boolean isSuccess = false;

    public boolean checkuser(String email, String password) {

        MyInterface MyInterface = Url.getInstance().create(MyInterface.class);
        Call<SignUpResponse> usersCall = MyInterface.checkUser(email, password);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {
                ProductDetailActivity.userID = loginResponse.body().get_id();
                FavouriteFragment.userID = loginResponse.body().get_id();
                ProfileFragment.full_name = loginResponse.body().getFullname();
                System.out.println("UserID " + loginResponse.body().get_id());
                Url.token += loginResponse.body().getToken();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
