package com.example.mytaskapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VechicleModel {

@SerializedName("userId")
@Expose
private String userId;
@SerializedName("vehicleName")
@Expose
private String vehicleName;
@SerializedName("vehicleRegistrationNum")
@Expose
private String vehicleRegistrationNum;
@SerializedName("vehicleMake")
@Expose
private String vehicleMake;
@SerializedName("vehicleType")
@Expose
private String vehicleType;
@SerializedName("fastTag")
@Expose
private String fastTag;
@SerializedName("tonnage")
@Expose
private String tonnage;
@SerializedName("error")
@Expose
private Object error;
@SerializedName("truckAxleType")
@Expose
private String truckAxleType;
@SerializedName("batterySerNum1")
@Expose
private String batterySerNum1;
@SerializedName("batterySerNum2")
@Expose
private String batterySerNum2;
@SerializedName("rcNum")
@Expose
private String rcNum;
@SerializedName("engineNum")
@Expose
private String engineNum;
@SerializedName("chassisNum")
@Expose
private String chassisNum;
@SerializedName("specialToolList")
@Expose
private String specialToolList;
@SerializedName("tyreSerialNum")
@Expose
private String tyreSerialNum;
@SerializedName("truckPermitFileName")
@Expose
private String truckPermitFileName;
@SerializedName("regCopyFileName")
@Expose
private String regCopyFileName;
@SerializedName("insuranceCopyFileName")
@Expose
private String insuranceCopyFileName;
@SerializedName("pollutionCertficateFileName")
@Expose
private String pollutionCertficateFileName;
@SerializedName("bodyType")
@Expose
private String bodyType;
@SerializedName("fastTagNum")
@Expose
private String fastTagNum;
@SerializedName("own")
@Expose
private String own;
@SerializedName("vehicleCode")
@Expose
private String vehicleCode;
@SerializedName("vehicleModel")
@Expose
private String vehicleModel;
@SerializedName("transporterName")
@Expose
private String transporterName;
@SerializedName("linkDriver")
@Expose
private String linkDriver;
@SerializedName("linkDriverName")
@Expose
private Object linkDriverName;
@SerializedName("vehicleStatus")
@Expose
private Object vehicleStatus;
@SerializedName("vehicleId")
@Expose
private String vehicleId;

public String getUserId() {
return userId;
}

public void setUserId(String userId) {
this.userId = userId;
}

public String getVehicleName() {
return vehicleName;
}

public void setVehicleName(String vehicleName) {
this.vehicleName = vehicleName;
}

public String getVehicleRegistrationNum() {
return vehicleRegistrationNum;
}

public void setVehicleRegistrationNum(String vehicleRegistrationNum) {
this.vehicleRegistrationNum = vehicleRegistrationNum;
}

public String getVehicleMake() {
return vehicleMake;
}

public void setVehicleMake(String vehicleMake) {
this.vehicleMake = vehicleMake;
}

public String getVehicleType() {
return vehicleType;
}

public void setVehicleType(String vehicleType) {
this.vehicleType = vehicleType;
}

public String getFastTag() {
return fastTag;
}

public void setFastTag(String fastTag) {
this.fastTag = fastTag;
}

public String getTonnage() {
return tonnage;
}

public void setTonnage(String tonnage) {
this.tonnage = tonnage;
}

public Object getError() {
return error;
}

public void setError(Object error) {
this.error = error;
}

public String getTruckAxleType() {
return truckAxleType;
}

public void setTruckAxleType(String truckAxleType) {
this.truckAxleType = truckAxleType;
}

public String getBatterySerNum1() {
return batterySerNum1;
}

public void setBatterySerNum1(String batterySerNum1) {
this.batterySerNum1 = batterySerNum1;
}

public String getBatterySerNum2() {
return batterySerNum2;
}

public void setBatterySerNum2(String batterySerNum2) {
this.batterySerNum2 = batterySerNum2;
}

public String getRcNum() {
return rcNum;
}

public void setRcNum(String rcNum) {
this.rcNum = rcNum;
}

public String getEngineNum() {
return engineNum;
}

public void setEngineNum(String engineNum) {
this.engineNum = engineNum;
}

public String getChassisNum() {
return chassisNum;
}

public void setChassisNum(String chassisNum) {
this.chassisNum = chassisNum;
}

public String getSpecialToolList() {
return specialToolList;
}

public void setSpecialToolList(String specialToolList) {
this.specialToolList = specialToolList;
}

public String getTyreSerialNum() {
return tyreSerialNum;
}

public void setTyreSerialNum(String tyreSerialNum) {
this.tyreSerialNum = tyreSerialNum;
}

public String getTruckPermitFileName() {
return truckPermitFileName;
}

public void setTruckPermitFileName(String truckPermitFileName) {
this.truckPermitFileName = truckPermitFileName;
}

public String getRegCopyFileName() {
return regCopyFileName;
}

public void setRegCopyFileName(String regCopyFileName) {
this.regCopyFileName = regCopyFileName;
}

public String getInsuranceCopyFileName() {
return insuranceCopyFileName;
}

public void setInsuranceCopyFileName(String insuranceCopyFileName) {
this.insuranceCopyFileName = insuranceCopyFileName;
}

public String getPollutionCertficateFileName() {
return pollutionCertficateFileName;
}

public void setPollutionCertficateFileName(String pollutionCertficateFileName) {
this.pollutionCertficateFileName = pollutionCertficateFileName;
}

public String getBodyType() {
return bodyType;
}

public void setBodyType(String bodyType) {
this.bodyType = bodyType;
}

public String getFastTagNum() {
return fastTagNum;
}

public void setFastTagNum(String fastTagNum) {
this.fastTagNum = fastTagNum;
}

public String getOwn() {
return own;
}

public void setOwn(String own) {
this.own = own;
}

public String getVehicleCode() {
return vehicleCode;
}

public void setVehicleCode(String vehicleCode) {
this.vehicleCode = vehicleCode;
}

public String getVehicleModel() {
return vehicleModel;
}

public void setVehicleModel(String vehicleModel) {
this.vehicleModel = vehicleModel;
}

public String getTransporterName() {
return transporterName;
}

public void setTransporterName(String transporterName) {
this.transporterName = transporterName;
}

public String getLinkDriver() {
return linkDriver;
}

public void setLinkDriver(String linkDriver) {
this.linkDriver = linkDriver;
}

public Object getLinkDriverName() {
return linkDriverName;
}

public void setLinkDriverName(Object linkDriverName) {
this.linkDriverName = linkDriverName;
}

public Object getVehicleStatus() {
return vehicleStatus;
}

public void setVehicleStatus(Object vehicleStatus) {
this.vehicleStatus = vehicleStatus;
}

public String getVehicleId() {
return vehicleId;
}

public void setVehicleId(String vehicleId) {
this.vehicleId = vehicleId;
}

}