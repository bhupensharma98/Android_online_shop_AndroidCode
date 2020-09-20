package com.bhupendra.onlineshop.api_classes;

import com.bhupendra.onlineshop.modal_classes.PurchaseModal;
import com.bhupendra.onlineshop.modal_classes.CartModal;
import com.bhupendra.onlineshop.modal_classes.GetCartModal;
import com.bhupendra.onlineshop.modal_classes.ProductModal;
import com.bhupendra.onlineshop.modal_classes.UserModal;
import com.bhupendra.onlineshop.required_classes.SignUpResponse;
import com.bhupendra.onlineshop.required_classes.UserModalAno;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MyInterface {

    // fetch product api
    @GET("product/receiveproduct")
    Call<List<ProductModal>> receive();

    @POST("register/register_user")
    Call<Void> registerUser(@Body UserModal usersCUD);

    @FormUrlEncoded
    @POST("register/login_user")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);

    @GET("register/me")
    Call<UserModalAno> getUserDetails(@Header("Authorization") String token);

    // cart api
    @POST("cart/addcart")
    Call<Void> addCart(@Body CartModal postReviewModal);

    // get cart using parameter
    @FormUrlEncoded
    @POST("products/getProductUnlimit")
    Call<List<ProductModal>> loadProduct(@Field("product") String product);

    // get cart by using id
    @FormUrlEncoded
    @POST("cart/getCartJoin")
    Call<List<GetCartModal>> loadCartSession(@Field("userid") String userid);

    // favourite add
    @POST("book/res")
    Call<Void> addBook(@Body PurchaseModal purchaseModal);

}