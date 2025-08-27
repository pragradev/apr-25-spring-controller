package com.example.javaapr2025springcontroller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class EmployeeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long machineId;
    private String serialNumber;
    private String machineBrand;
    private String machineModel;

    @Override
    public String toString() {
        return "EmployeeMachine{" +
                "machineId=" + machineId +
                ", serialNumber='" + serialNumber + '\'' +
                ", machineBrand='" + machineBrand + '\'' +
                ", machineModel='" + machineModel + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeMachine that = (EmployeeMachine) o;
        return Objects.equals(machineId, that.machineId) && Objects.equals(serialNumber, that.serialNumber) && Objects.equals(machineBrand, that.machineBrand) && Objects.equals(machineModel, that.machineModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(machineId, serialNumber, machineBrand, machineModel);
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMachineBrand() {
        return machineBrand;
    }

    public void setMachineBrand(String machineBrand) {
        this.machineBrand = machineBrand;
    }

    public String getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(String machineModel) {
        this.machineModel = machineModel;
    }
}
