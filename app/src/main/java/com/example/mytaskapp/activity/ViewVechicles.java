package com.example.mytaskapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mytaskapp.MyListAdapter;
import com.example.mytaskapp.R;
import com.example.mytaskapp.RetrofitCall.ApiManager;
import com.example.mytaskapp.model.VechicleModel;
import java.util.ArrayList;

public class ViewVechicles extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<VechicleModel>vechicleList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vechicles);
        recycler=findViewById(R.id.recycler);
        ViewVechiclesmethod();
    }

    private void ViewVechiclesmethod() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://209.97.163.4:9010/basedrs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service = retrofit.create(ApiManager.class);
        Call<ArrayList<VechicleModel>> call1 =  service.VechicleListResponse();
        call1.enqueue(new Callback<ArrayList<VechicleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<VechicleModel>> call, Response<ArrayList<VechicleModel>> response) {
                progressDialog.dismiss();
                if (response.code()==200){
                    progressDialog.dismiss();
                    Log.e("Response in brant",response.body()+"  ");
                    vechicleList.addAll(response.body());
                  LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(ViewVechicles.this);
                   recycler.setLayoutManager(linearLayoutManager);
                    recycler.setHasFixedSize(true);
                    MyListAdapter adapter = new MyListAdapter(vechicleList, getApplicationContext());
                    recycler.setAdapter(adapter);



                    Log.e("vechicleList",vechicleList.size()+"  ");
                }else{
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<VechicleModel>> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Please try again later failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}