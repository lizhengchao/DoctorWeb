package com.doctor.medical_record.dto;

/**
 * Created by lzc on 2016/5/30.
 */
public class MedicalRecVO extends MedicalRecDTO{
    private String doctorName;
    private String resName;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public void setDTO(MedicalRecDTO medicalRecDTO){
        super.setId(medicalRecDTO.getId());
        super.setMedicationRecIds(medicalRecDTO.getMedicationRecIds());
        super.setResId(medicalRecDTO.getResId());
        super.setSuggest(medicalRecDTO.getSuggest());
        super.setChiefComplaint(medicalRecDTO.getChiefComplaint());
        super.setCreateTime(medicalRecDTO.getCreateTime());
        super.setModifyTime(medicalRecDTO.getModifyTime());
        super.setDocId(medicalRecDTO.getDocId());
        super.setResHeaDatId(medicalRecDTO.getResHeaDatId());
    }
}
