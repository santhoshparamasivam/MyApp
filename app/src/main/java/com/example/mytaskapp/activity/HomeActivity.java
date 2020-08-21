package com.example.mytaskapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytaskapp.MyListAdapter;
import com.example.mytaskapp.R;
import com.example.mytaskapp.RetrofitCall.ApiManager;
import com.example.mytaskapp.model.VechicleModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    LinearLayout mainScreen,mainScreen2,mainScreen3,txt_register;
    TextView txt_single,txt_muliple,txt_container,txt_trailer,txt_open_body,txt_next;
    EditText edt_name,edt_vch_make,edt_vch_model,edt_vch_type,edt_tonnage;

    //mainscreen2
    EditText edt_engineNo,edt_chasisNo;
    TextView permit_upload,insurance_upload,register_upload,pollution_upload,txt_next1;

    //mainscreen3
    EditText edt_battery1No,edt_battery2No;

    TextView text1,text2,text3;

    Uri permit_Uri,insurance_Uri,register_Uri,pollution_Uri;
    String permit_filename,insurance_filename,register_filename,pollution_filename;

    String axle_Type;
    String body_type;

    int a=0;
        ImageView img_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    mainScreen=findViewById(R.id.mainScreen);
    mainScreen2=findViewById(R.id.mainScreen2);
    mainScreen2.setVisibility(View.GONE);
    mainScreen3=findViewById(R.id.mainScreen3);
    mainScreen3.setVisibility(View.GONE);
    txt_register=findViewById(R.id.txt_register);
        img_menu=findViewById(R.id.img_menu);
    //mainscreen1

        txt_single=findViewById(R.id.txt_single);
        txt_muliple=findViewById(R.id.txt_muliple);
        txt_container=findViewById(R.id.txt_container);
        txt_trailer=findViewById(R.id.txt_trailer);
        txt_open_body=findViewById(R.id.txt_open_body);
        edt_name=findViewById(R.id.edt_name);
        edt_vch_make=findViewById(R.id.edt_vch_make);
        edt_vch_model=findViewById(R.id.edt_vch_model);
        edt_vch_type=findViewById(R.id.edt_vch_type);
        edt_tonnage=findViewById(R.id.edt_tonnage);
        txt_next=findViewById(R.id.txt_next);

        //mainscreen2

        edt_engineNo=findViewById(R.id.edt_engineNo);
        edt_chasisNo=findViewById(R.id.edt_chasisNo);
        permit_upload=findViewById(R.id.permit_upload);
        insurance_upload=findViewById(R.id.insurance_upload);
        register_upload=findViewById(R.id.register_upload);
        pollution_upload=findViewById(R.id.pollution_upload);
        txt_next1=findViewById(R.id.txt_next1);

        //mainscreen 3
        edt_battery1No=findViewById(R.id.edt_battery1No);
        edt_battery2No=findViewById(R.id.edt_battery2No);

        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);

        text1.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        text2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        text3.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        txt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    a=1;
                    text1.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    text2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                    mainScreen.setVisibility(View.GONE);
                    mainScreen2.setVisibility(View.VISIBLE);
                    mainScreen3.setVisibility(View.GONE);
                img_menu.setImageResource(R.drawable.ic_back);
            }
        });
        txt_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=2;
                text1.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                text2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                text3.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                mainScreen.setVisibility(View.GONE);
                mainScreen2.setVisibility(View.GONE);
                mainScreen3.setVisibility(View.VISIBLE);
                img_menu.setImageResource(R.drawable.ic_back);
                txt_register.setVisibility(View.VISIBLE);

            }
        });
        txt_single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_single.setBackgroundColor(getColor(R.color.colorAccent));
                txt_muliple.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
                axle_Type="Single";
            }
        });
        txt_muliple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_muliple.setBackgroundColor(getColor(R.color.colorAccent));
                txt_single.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
                axle_Type="Multiple";
            }
        });
        txt_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_container.setBackgroundColor(getColor(R.color.colorAccent));
                txt_trailer.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
                txt_open_body.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
                body_type=txt_container.getText().toString();
            }
        });
        txt_trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                body_type=txt_trailer.getText().toString();
                txt_trailer.setBackgroundColor(getColor(R.color.colorAccent));
                txt_container.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
                txt_open_body.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
            }
        });
        txt_open_body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                body_type=txt_open_body.getText().toString();
                txt_open_body.setBackgroundColor(getColor(R.color.colorAccent));
                txt_container.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
               txt_trailer.setBackground((getResources().getDrawable(R.drawable.ic_circularbg)));
            }
        });


        permit_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    UploadPermission(1);
            }
        });
        insurance_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPermission(2);
            }
        });
        pollution_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPermission(3);
            }
        });
        register_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPermission(4);

            }
        });
        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        BacktoPrevious();
            }
        });

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    VechicleRegister();
            }
        });

    }

    @SuppressLint("NewApi")
    private void VechicleRegister() {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait...");
        progressDialog.show();
        if (permit_Uri!=null)
            permit_filename = new File(Objects.requireNonNull(permit_Uri.getPath())).getName();
        else {
            permit_filename="";
        }
        if (insurance_Uri!=null)
            insurance_filename = new File(Objects.requireNonNull(insurance_Uri.getPath())).getName();
        else {
            insurance_filename="";
        }
        if (register_Uri!=null)
            register_filename = new File(Objects.requireNonNull(register_Uri.getPath())).getName();
        else {
            register_filename="";
        }
        if (pollution_Uri!=null)
            pollution_filename = new File(Objects.requireNonNull(pollution_Uri.getPath())).getName();
        else {
            pollution_filename="";
        }

        String vchname=edt_name.getText().toString();
        String vchMake=edt_vch_make.getText().toString();
        String vchType=edt_vch_type.getText().toString();
        String tonnage=edt_tonnage.getText().toString();
        String batteryNum1=edt_battery1No.getText().toString();
        String batteryNum2=edt_battery2No.getText().toString();
        String engineNo=edt_engineNo.getText().toString();
        String chasisNo=edt_chasisNo.getText().toString();
        String vchModel=edt_vch_model.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://209.97.163.4:9010/basedrs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager service = retrofit.create(ApiManager.class);
        Call<ResponseBody> call1 =  service.AddVechicle(vchname,vchname,vchMake,vchType,"yes","Yzgb2YI2TEaRDjDgrkFsVDkUcD83","OWN",
                tonnage,axle_Type, batteryNum1,batteryNum2,engineNo,chasisNo,permit_filename,register_filename,insurance_filename,pollution_filename,body_type,vchModel);


       Log.e("url",call1.request().url()+"  ");
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                 Log.e("response",response.code()+"  ");

                progressDialog.dismiss();
                if (response.code()==200){
                    progressDialog.dismiss();
                    Intent intent=new Intent(HomeActivity.this,ViewVechicles.class);
                    startActivity(intent);

                }else{
                    progressDialog.dismiss();
                    Toast.makeText(HomeActivity.this, "Please try Again later", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Please try again later failure", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onBackPressed() {
        BacktoPrevious();

    }

    private void BacktoPrevious() {
        if (a==2){
            a=1;
            text1.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            text2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            text3.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            mainScreen.setVisibility(View.GONE);
            txt_register.setVisibility(View.GONE);
            mainScreen2.setVisibility(View.VISIBLE);
            mainScreen3.setVisibility(View.GONE);
            img_menu.setImageResource(R.drawable.ic_back);
        }else if (a==1){
            a=0;
            text1.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            text2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            text3.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            mainScreen.setVisibility(View.VISIBLE);
            mainScreen2.setVisibility(View.GONE);
            mainScreen3.setVisibility(View.GONE);
            img_menu.setImageResource(R.drawable.ic_icon);
        }
    }

    private void UploadPermission(int i) {
        if (i==1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            } else {
                selectfileMethod(1);
            }
        }else if(i==2) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
            } else {
                selectfileMethod(2);
            }

        }else if(i==3) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 3);
            } else {
                selectfileMethod(3);
            }

        }else if(i==4) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 4);
            } else {
                selectfileMethod(4);
            }

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        if (!(permissions == null)) {
            switch (requestCode) {
                case 1: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        selectfileMethod(1);
                    } else {
                        String details = "You need to enable Gallery permissions for this app. The following screen will ask for permission, please approve?";
                        AlertBoxMethod(1, details);
                    }
                }
                break;
          case 2: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        selectfileMethod(2);
                    } else {
                        String details = "You need to enable Gallery permissions for this app. The following screen will ask for permission, please approve?";
                        AlertBoxMethod(2, details);
                    }
                }
                break;
          case 3: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        selectfileMethod(3);
                    } else {
                        String details = "You need to enable Gallery permissions for this app. The following screen will ask for permission, please approve?";
                        AlertBoxMethod(3, details);
                    }
                }
                break;
          case 4: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        selectfileMethod(4);
                    } else {
                        String details = "You need to enable Gallery permissions for this app. The following screen will ask for permission, please approve?";
                        AlertBoxMethod(4, details);
                    }
                }
                break;
            }
        }
    }

    private void AlertBoxMethod(final int permission, String details) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Permission Alert");
        alertDialog.setMessage(details);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                UploadPermission(permission);

            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }




    private void selectfileMethod(int permission) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, permission);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String Fpath = data.getDataString();
        if (resultCode==RESULT_OK){
            if (requestCode==1){
                    permit_Uri = data.getData();
            }else if(requestCode==2){
                insurance_Uri = data.getData();
            }else if(requestCode==3){
                pollution_Uri=data.getData();
            }else if(requestCode==4){
                register_Uri=data.getData();
            }
        }


    }


}