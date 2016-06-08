package com.doctor.medical_record.dto;

/**
 * Created by lzc on 2016/5/24.
 */
public class MedicationRecVO extends MedicationRecDTO{
    private String medicationName;
    private String type;

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMedicationRecDTO(MedicationRecDTO medicationRecDTO){
        super.setId(medicationRecDTO.getId());
        super.setMedicationRule(medicationRecDTO.getMedicationRule());
        super.setAmount(medicationRecDTO.getAmount());
        super.setMedicalRecId(medicationRecDTO.getMedicalRecId());
        super.setMedicineId(medicationRecDTO.getMedicineId());
        super.setCreateTime(medicationRecDTO.getCreateTime());
        super.setModifyTime(medicationRecDTO.getModifyTime());
    }
}
