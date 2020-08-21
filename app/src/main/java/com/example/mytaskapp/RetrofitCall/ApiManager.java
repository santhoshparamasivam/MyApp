package com.example.mytaskapp.RetrofitCall;

import com.example.mytaskapp.model.VechicleModel;
import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiManager {


  @GET("getVehicleListBasedOnFleetowner?fleetOwner=Yzgb2YI2TEaRDjDgrkFsVDkUcD83")
  Call<ArrayList<VechicleModel>> VechicleListResponse();

  @GET("addVehicleId")
  Call<ResponseBody> AddVechicle(@Query("vehicleName") String vechName,@Query("vehicleRegNum") String vNo,@Query("vehicleMake") String vechMake,
                      @Query("vehicleType") String vechType,@Query("fastTag") String fastTasg,@Query("transporterName") String transportName,
                      @Query("own") String own,@Query("tonnage") String tonnage,@Query("truckAxleType")String truckAxle,@Query("batterySerNum1")String batterySerNum1,
                      @Query("batterySerNum2")String batterSerNum2,@Query("engineNum")String engineNum,@Query("chassisNum")String chassisNum,@Query("truckPermitFileName") String permitfilename,
                      @Query("regCopyFileName")String regcopyfilename,@Query("insuranceCopyFileName") String insuranceCopyFilename,@Query("pollutionCertficateFileName") String pollutionCertficateFileName,
                       @Query("bodyType") String bodyType,@Query("vehicleModel")String vechmodel);
}