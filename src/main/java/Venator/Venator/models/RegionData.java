package Venator.Venator.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RegionData {
    private ArrayList regionDataList = new ArrayList();
    private ArrayList constDataList = new ArrayList();
    private ArrayList systemDataList = new ArrayList();

    public ArrayList getRegionDataList() {
        return regionDataList;
    }

    public void setRegionDataList(ArrayList regionDataList) {
        this.regionDataList = regionDataList;
    }

    public ArrayList getConstDataList() {
        return constDataList;
    }

    public void setConstDataList(ArrayList constDataList) {
        this.constDataList = constDataList;
    }

    public ArrayList getSystemDataList() {
        return systemDataList;
    }

    public void setSystemDataList(ArrayList systemDataList) {
        this.systemDataList = systemDataList;
    }
}
