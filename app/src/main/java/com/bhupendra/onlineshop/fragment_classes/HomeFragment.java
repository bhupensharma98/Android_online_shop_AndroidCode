package com.bhupendra.onlineshop.fragment_classes;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhupendra.onlineshop.R;
import com.bhupendra.onlineshop.adapter_classes.Adapter;
import com.bhupendra.onlineshop.adapter_classes.Product;
import com.bhupendra.onlineshop.api_classes.MyInterface;
import com.bhupendra.onlineshop.api_classes.Homeurl;
import com.bhupendra.onlineshop.modal_classes.ProductModal;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    RecyclerView recyclerproduct;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] slideImage= {R.drawable.sm,R.drawable.sn, R.drawable.so,
            R.drawable.sp, R.drawable.sq,R.drawable.sr};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.colorWhite));// set status bac

        recyclerproduct = view.findViewById(R.id.recyclerView_product);
        recyclerproduct.setNestedScrollingEnabled(false);

        for(int i=0;i<slideImage.length;i++)
            XMENArray.add(slideImage[i]);

        mPager = view.findViewById(R.id.pager);
        mPager.setAdapter(new Adapter(getActivity(),XMENArray));
        CircleIndicator indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == slideImage.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3500, 3500);

        fetchpro();
        return view;
    }
    
    public void fetchpro(){
        MyInterface retrofitMyInterface = Homeurl.getRetrofit().create(MyInterface.class);
        Call<List<ProductModal>> productModalCall = retrofitMyInterface.receive();
        productModalCall.enqueue(new Callback<List<ProductModal>>() {
            @Override
            public void onResponse(Call<List<ProductModal>> call, Response<List<ProductModal>> response) {
                Product recyclerviewAdapter = new Product(getActivity(),response.body());
                RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getContext(), 2);
                recyclerproduct.setLayoutManager(mlayoutManager);
                recyclerproduct.setHasFixedSize(true);
                recyclerproduct.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<ProductModal>> call, Throwable t) {

            }
        });
    }
}