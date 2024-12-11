package forms_datamodel;

import android.content.Context;
 import android.annotation.SuppressLint;
 import android.database.Cursor;
 import Common.Connection;
 import java.util.ArrayList;
 import java.util.List;
 import Common.Global;
 import android.content.ContentValues;
import android.util.Log;
import android.widget.Toast;

public class Member_DataModel{

        private String _MemID = "";
        public String getMemID(){
              return _MemID;
         }
        public void setMemID(String newValue){
              _MemID = newValue;
         }
        private String _HHID = "";
        public String getHHID(){
              return _HHID;
         }
        public void setHHID(String newValue){
              _HHID = newValue;
         }
        private String _DSSID = "";
        public String getDSSID(){
              return _DSSID;
         }
        public void setDSSID(String newValue){
              _DSSID = newValue;
         }
        private String _MSlNo = "";
        public String getMSlNo(){
              return _MSlNo;
         }
        public void setMSlNo(String newValue){
              _MSlNo = newValue;
         }
        private String _Rth = "";
        public String getRth(){
              return _Rth;
         }
        public void setRth(String newValue){
              _Rth = newValue;
         }
        private String _RthOth = "";
        public String getRthOth(){
              return _RthOth;
         }
        public void setRthOth(String newValue){
              _RthOth = newValue;
         }
        private String _Name = "";
        public String getName(){
              return _Name;
         }
        public void setName(String newValue){
              _Name = newValue;
         }
    private String _HHHead = "";
    public String getHHHead(){
        return _HHHead;
    }
    public void setHHHead(String newValue){
        _HHHead = newValue;
    }
        private String _Sex = "";
        public String getSex(){
              return _Sex;
         }
        public void setSex(String newValue){
              _Sex = newValue;
         }
        private String _BDate_D = "";
        public String getBDate_D(){
              return _BDate_D;
         }
        public void setBDate_D(String newValue){
              _BDate_D = newValue;
         }
        private String _BDate_M = "";
        public String getBDate_M(){
              return _BDate_M;
         }
        public void setBDate_M(String newValue){
              _BDate_M = newValue;
         }
        private String _BDate_Y = "";
        public String getBDate_Y(){
              return _BDate_Y;
         }
        public void setBDate_Y(String newValue){
              _BDate_Y = newValue;
         }
        private String _BDate = "";
        public String getBDate(){
              return _BDate;
         }
        public void setBDate(String newValue){
              _BDate = newValue;
         }
        private String _BDateType = "";
        public String getBDateType(){
              return _BDateType;
         }
        public void setBDateType(String newValue){
              _BDateType = newValue;
         }
        private String _Age = "";
        public String getAge(){
              return _Age;
         }
        public void setAge(String newValue){
              _Age = newValue;
         }
        private String _AgeU = "";
        public String getAgeU(){
              return _AgeU;
         }
        public void setAgeU(String newValue){
              _AgeU = newValue;
         }
        private String _MoNo = "";
        public String getMoNo(){
              return _MoNo;
         }
        public void setMoNo(String newValue){
              _MoNo = newValue;
         }
        private String _MoName = "";
        public String getMoName(){
              return _MoName;
         }
        public void setMoName(String newValue){
              _MoName = newValue;
         }
        private String _FaNo = "";
        public String getFaNo(){
              return _FaNo;
         }
        public void setFaNo(String newValue){
              _FaNo = newValue;
         }
        private String _FaName = "";
        public String getFaName(){
              return _FaName;
         }
        public void setFaName(String newValue){
              _FaName = newValue;
         }
        private String _EduY = "";
        public String getEduY(){
              return _EduY;
         }
        public void setEduY(String newValue){
              _EduY = newValue;
         }
        private String _Employ = "";
        public String getEmploy(){
              return _Employ;
         }
        public void setEmploy(String newValue){
              _Employ = newValue;
         }
        private String _EmployOth = "";
        public String getEmployOth(){
              return _EmployOth;
         }
        public void setEmployOth(String newValue){
              _EmployOth = newValue;
         }
        private String _Ocp = "";
        public String getOcp(){
              return _Ocp;
         }
        public void setOcp(String newValue){
              _Ocp = newValue;
         }
        private String _OcpOth = "";
        public String getOcpOth(){
              return _OcpOth;
         }
        public void setOcpOth(String newValue){
              _OcpOth = newValue;
         }
        private String _OcpDk = "";
        public String getOcpDk(){
              return _OcpDk;
         }
        public void setOcpDk(String newValue){
              _OcpDk = newValue;
         }
        private String _Religion = "";
        public String getReligion(){
              return _Religion;
         }
        public void setReligion(String newValue){
              _Religion = newValue;
         }
        private String _ReligionOth = "";
        public String getReligionOth(){
              return _ReligionOth;
         }
        public void setReligionOth(String newValue){
              _ReligionOth = newValue;
         }
        private String _Ethnicity = "";
        public String getEthnicity(){
              return _Ethnicity;
         }
        public void setEthnicity(String newValue){
              _Ethnicity = newValue;
         }
        private String _EthnicityOth = "";
        public String getEthnicityOth(){
              return _EthnicityOth;
         }
        public void setEthnicityOth(String newValue){
              _EthnicityOth = newValue;
         }
        private String _MobileNo = "";
        public String getMobileNo(){
              return _MobileNo;
         }
        public void setMobileNo(String newValue){
              _MobileNo = newValue;
         }
        private String _MS = "";
        public String getMS(){
              return _MS;
         }
        public void setMS(String newValue){
              _MS = newValue;
         }
        private String _MSOth = "";
        public String getMSOth(){
              return _MSOth;
         }
        public void setMSOth(String newValue){
              _MSOth = newValue;
         }
        private String _Sp1 = "";
        public String getSp1(){
              return _Sp1;
         }
        public void setSp1(String newValue){
              _Sp1 = newValue;
         }
        private String _Sp1Name = "";
        public String getSp1Name(){
              return _Sp1Name;
         }
        public void setSp1Name(String newValue){
              _Sp1Name = newValue;
         }
        private String _Sp2 = "";
        public String getSp2(){
              return _Sp2;
         }
        public void setSp2(String newValue){
              _Sp2 = newValue;
         }
        private String _Sp2Name = "";
        public String getSp2Name(){
              return _Sp2Name;
         }
        public void setSp2Name(String newValue){
              _Sp2Name = newValue;
         }
        private String _Sp3 = "";
        public String getSp3(){
              return _Sp3;
         }
        public void setSp3(String newValue){
              _Sp3 = newValue;
         }
        private String _Sp3Name = "";
        public String getSp3Name(){
              return _Sp3Name;
         }
        public void setSp3Name(String newValue){
              _Sp3Name = newValue;
         }
        private String _Sp4 = "";
        public String getSp4(){
              return _Sp4;
         }
        public void setSp4(String newValue){
              _Sp4 = newValue;
         }
        private String _Sp4Name = "";
        public String getSp4Name(){
              return _Sp4Name;
         }
        public void setSp4Name(String newValue){
              _Sp4Name = newValue;
         }
        private String _Pstat = "";
        public String getPstat(){
              return _Pstat;
         }
        public void setPstat(String newValue){
              _Pstat = newValue;
         }
        private String _LmpDt = "";
        public String getLmpDt(){
              return _LmpDt;
         }
        public void setLmpDt(String newValue){
              _LmpDt = newValue;
         }
        private String _gage = "";
        public String getgage(){
              return _gage;
         }
        public void setgage(String newValue){
              _gage = newValue;
         }
        private String _gageUnit = "";
        public String getgageUnit(){
              return _gageUnit;
         }
        public void setgageUnit(String newValue){
              _gageUnit = newValue;
         }
        private String _anc_regis = "";
        public String getanc_regis(){
              return _anc_regis;
         }
        public void setanc_regis(String newValue){
              _anc_regis = newValue;
         }
        private String _anc_resp_home = "";
        public String getanc_resp_home(){
              return _anc_resp_home;
         }
        public void setanc_resp_home(String newValue){
              _anc_resp_home = newValue;
         }
        private String _anc_other_home = "";
        public String getanc_other_home(){
              return _anc_other_home;
         }
        public void setanc_other_home(String newValue){
              _anc_other_home = newValue;
         }
        private String _anc_govt_hosp = "";
        public String getanc_govt_hosp(){
              return _anc_govt_hosp;
         }
        public void setanc_govt_hosp(String newValue){
              _anc_govt_hosp = newValue;
         }
        private String _anc_govt_health = "";
        public String getanc_govt_health(){
              return _anc_govt_health;
         }
        public void setanc_govt_health(String newValue){
              _anc_govt_health = newValue;
         }
        private String _anc_govt_health_post = "";
        public String getanc_govt_health_post(){
              return _anc_govt_health_post;
         }
        public void setanc_govt_health_post(String newValue){
              _anc_govt_health_post = newValue;
         }
        private String _anc_priv_hosp = "";
        public String getanc_priv_hosp(){
              return _anc_priv_hosp;
         }
        public void setanc_priv_hosp(String newValue){
              _anc_priv_hosp = newValue;
         }
        private String _anc_tba_home = "";
        public String getanc_tba_home(){
              return _anc_tba_home;
         }
        public void setanc_tba_home(String newValue){
              _anc_tba_home = newValue;
         }
        private String _anc_ngo_hosp = "";
        public String getanc_ngo_hosp(){
              return _anc_ngo_hosp;
         }
        public void setanc_ngo_hosp(String newValue){
              _anc_ngo_hosp = newValue;
         }
        private String _anc_other = "";
        public String getanc_other(){
              return _anc_other;
         }
        public void setanc_other(String newValue){
              _anc_other = newValue;
         }
        private String _anc_other_specify = "";
        public String getanc_other_specify(){
              return _anc_other_specify;
         }
        public void setanc_other_specify(String newValue){
              _anc_other_specify = newValue;
         }
        private String _anc_dk = "";
        public String getanc_dk(){
              return _anc_dk;
         }
        public void setanc_dk(String newValue){
              _anc_dk = newValue;
         }
        private String _anc_refuse = "";
        public String getanc_refuse(){
              return _anc_refuse;
         }
        public void setanc_refuse(String newValue){
              _anc_refuse = newValue;
         }
        private String _out_date = "";
        public String getout_date(){
              return _out_date;
         }
        public void setout_date(String newValue){
              _out_date = newValue;
         }
        private String _Rnd = "";
        public String getRnd(){
              return _Rnd;
         }
        public void setRnd(String newValue){
              _Rnd = newValue;
         }
        private String _Active = "";
        public String getActive(){
              return _Active;
         }
        public void setActive(String newValue){
              _Active = newValue;
         }
        private String _EnType = "";
        public String getEnType(){
              return _EnType;
         }
        public void setEnType(String newValue){
              _EnType = newValue;
         }
        private String _ExType = "";
        public String getExType(){
              return _ExType;
         }
        public void setExType(String newValue){
              _ExType = newValue;
         }
        private String _StartTime = "";
        public void setStartTime(String newValue){
              _StartTime = newValue;
         }
        private String _EndTime = "";
        public void setEndTime(String newValue){
              _EndTime = newValue;
         }
        private String _DeviceID = "";
        public void setDeviceID(String newValue){
              _DeviceID = newValue;
         }
        private String _EntryUser = "";
        public void setEntryUser(String newValue){
              _EntryUser = newValue;
         }
        private String _Lat = "";
        public void setLat(String newValue){
              _Lat = newValue;
         }
        private String _Lon = "";
        public void setLon(String newValue){
              _Lon = newValue;
         }
        private String _EnDt = Global.DateTimeNowYMDHMS();
        private int _Upload = 2;
        private String _modifyDate = Global.DateTimeNowYMDHMS();

        String TableName = "Member_Allinfo";

        public String SaveUpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            String SQL = "";
            try
            {
                 if(C.Existence("Select * from "+ TableName +"  Where MemID='"+ _MemID +"' "))
                    response = UpdateData(context);
                 else
                    response = SaveData(context);
            }
            catch(Exception  e)
            {
                 response = e.getMessage();
            }
           return response;
        }
        Connection C;

        private String SaveData(Context context)
        {
            String response = "";
            C = new Connection(context);
            try
              {
                 ContentValues contentValues = new ContentValues();
                 contentValues.put("MemID", _MemID);
                 contentValues.put("HHID", _HHID);
                 contentValues.put("DSSID", _DSSID);
                 contentValues.put("MSlNo", _MSlNo);
                 contentValues.put("Rth", _Rth);
                 contentValues.put("RthOth", _RthOth);
                 contentValues.put("Name", _Name);
                 contentValues.put("Sex", _Sex);
                 contentValues.put("BDate_D", _BDate_D);
                 contentValues.put("BDate_M", _BDate_M);
                 contentValues.put("BDate_Y", _BDate_Y);
                 contentValues.put("BDate", _BDate);
                 contentValues.put("BDateType", _BDateType);
                 contentValues.put("Age", _Age);
                 contentValues.put("AgeU", _AgeU);
                 contentValues.put("MoNo", _MoNo);
                 contentValues.put("MoName", _MoName);
                 contentValues.put("FaNo", _FaNo);
                 contentValues.put("FaName", _FaName);
                 contentValues.put("EduY", _EduY);
                 contentValues.put("Employ", _Employ);
                 contentValues.put("EmployOth", _EmployOth);
                 contentValues.put("Ocp", _Ocp);
                 contentValues.put("OcpOth", _OcpOth);
                 contentValues.put("OcpDk", _OcpDk);
                 contentValues.put("Religion", _Religion);
                 contentValues.put("ReligionOth", _ReligionOth);
                 contentValues.put("Ethnicity", _Ethnicity);
                 contentValues.put("EthnicityOth", _EthnicityOth);
                 contentValues.put("MobileNo", _MobileNo);
                 contentValues.put("MS", _MS);
                 contentValues.put("MSOth", _MSOth);
                 contentValues.put("Sp1", _Sp1);
                 contentValues.put("Sp1Name", _Sp1Name);
                 contentValues.put("Sp2", _Sp2);
                 contentValues.put("Sp2Name", _Sp2Name);
                 contentValues.put("Sp3", _Sp3);
                 contentValues.put("Sp3Name", _Sp3Name);
                 contentValues.put("Sp4", _Sp4);
                 contentValues.put("Sp4Name", _Sp4Name);
                 contentValues.put("Pstat", _Pstat);
                 contentValues.put("LmpDt", _LmpDt);
                 contentValues.put("gage", _gage);
                 contentValues.put("gageUnit", _gageUnit);
                 contentValues.put("anc_regis", _anc_regis);
                 contentValues.put("anc_resp_home", _anc_resp_home);
                 contentValues.put("anc_other_home", _anc_other_home);
                 contentValues.put("anc_govt_hosp", _anc_govt_hosp);
                 contentValues.put("anc_govt_health", _anc_govt_health);
                 contentValues.put("anc_govt_health_post", _anc_govt_health_post);
                 contentValues.put("anc_priv_hosp", _anc_priv_hosp);
                 contentValues.put("anc_tba_home", _anc_tba_home);
                 contentValues.put("anc_ngo_hosp", _anc_ngo_hosp);
                 contentValues.put("anc_other", _anc_other);
                 contentValues.put("anc_other_specify", _anc_other_specify);
                 contentValues.put("anc_dk", _anc_dk);
                 contentValues.put("anc_refuse", _anc_refuse);
                 contentValues.put("out_date", _out_date);
                 contentValues.put("Rnd", _Rnd);
                 contentValues.put("Active", _Active);
                 contentValues.put("EnType", _EnType);
                 contentValues.put("ExType", _ExType);
                 contentValues.put("isdelete", 2);
                 contentValues.put("StartTime", _StartTime);
                 contentValues.put("EndTime", _EndTime);
                 contentValues.put("DeviceID", _DeviceID);
                 contentValues.put("EntryUser", _EntryUser);
                 contentValues.put("Lat", _Lat);
                 contentValues.put("Lon", _Lon);
                 contentValues.put("EnDt", _EnDt);
                 contentValues.put("Upload", _Upload);
                 contentValues.put("modifyDate", _modifyDate);
                 C.InsertData(TableName, contentValues);
              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }

        private String UpdateData(Context context)
        {
            String response = "";
            C = new Connection(context);
            try
              {
                 ContentValues contentValues = new ContentValues();
                 contentValues.put("MemID", _MemID);
                 contentValues.put("HHID", _HHID);
                 contentValues.put("DSSID", _DSSID);
                 contentValues.put("MSlNo", _MSlNo);
                 contentValues.put("Rth", _Rth);
                 contentValues.put("RthOth", _RthOth);
                 contentValues.put("Name", _Name);
                 contentValues.put("Sex", _Sex);
                 contentValues.put("BDate_D", _BDate_D);
                 contentValues.put("BDate_M", _BDate_M);
                 contentValues.put("BDate_Y", _BDate_Y);
                 contentValues.put("BDate", _BDate);
                 contentValues.put("BDateType", _BDateType);
                 contentValues.put("Age", _Age);
                 contentValues.put("AgeU", _AgeU);
                 contentValues.put("MoNo", _MoNo);
                 contentValues.put("MoName", _MoName);
                 contentValues.put("FaNo", _FaNo);
                 contentValues.put("FaName", _FaName);
                 contentValues.put("EduY", _EduY);
                 contentValues.put("Employ", _Employ);
                 contentValues.put("EmployOth", _EmployOth);
                 contentValues.put("Ocp", _Ocp);
                 contentValues.put("OcpOth", _OcpOth);
                 contentValues.put("OcpDk", _OcpDk);
                 contentValues.put("Religion", _Religion);
                 contentValues.put("ReligionOth", _ReligionOth);
                 contentValues.put("Ethnicity", _Ethnicity);
                 contentValues.put("EthnicityOth", _EthnicityOth);
                 contentValues.put("MobileNo", _MobileNo);
                 contentValues.put("MS", _MS);
                 contentValues.put("MSOth", _MSOth);
                 contentValues.put("Sp1", _Sp1);
                 contentValues.put("Sp1Name", _Sp1Name);
                 contentValues.put("Sp2", _Sp2);
                 contentValues.put("Sp2Name", _Sp2Name);
                 contentValues.put("Sp3", _Sp3);
                 contentValues.put("Sp3Name", _Sp3Name);
                 contentValues.put("Sp4", _Sp4);
                 contentValues.put("Sp4Name", _Sp4Name);
                 contentValues.put("Pstat", _Pstat);
                 contentValues.put("LmpDt", _LmpDt);
                 contentValues.put("gage", _gage);
                 contentValues.put("gageUnit", _gageUnit);
                 contentValues.put("anc_regis", _anc_regis);
                 contentValues.put("anc_resp_home", _anc_resp_home);
                 contentValues.put("anc_other_home", _anc_other_home);
                 contentValues.put("anc_govt_hosp", _anc_govt_hosp);
                 contentValues.put("anc_govt_health", _anc_govt_health);
                 contentValues.put("anc_govt_health_post", _anc_govt_health_post);
                 contentValues.put("anc_priv_hosp", _anc_priv_hosp);
                 contentValues.put("anc_tba_home", _anc_tba_home);
                 contentValues.put("anc_ngo_hosp", _anc_ngo_hosp);
                 contentValues.put("anc_other", _anc_other);
                 contentValues.put("anc_other_specify", _anc_other_specify);
                 contentValues.put("anc_dk", _anc_dk);
                 contentValues.put("anc_refuse", _anc_refuse);
                 contentValues.put("out_date", _out_date);
                 contentValues.put("Rnd", _Rnd);
                 contentValues.put("Active", _Active);
                 contentValues.put("EnType", _EnType);
                 contentValues.put("ExType", _ExType);
                 contentValues.put("Upload", _Upload);
                 contentValues.put("modifyDate", _modifyDate);
                 C.UpdateData(TableName, "MemID", (""+ _MemID +""), contentValues);


              }
              catch(Exception  e)
              {
                 response = e.getMessage();
              }
           return response;
        }


        int Count = 0;
        private int _Count = 0;
        public int getCount(){ return _Count; }


       public List<Member_DataModel> SelectAll(Context context, String SQL)
        {
            Connection C = new Connection(context);
            List<Member_DataModel> data = new ArrayList<Member_DataModel>();
            Member_DataModel d = new Member_DataModel();
            Cursor cur = C.ReadData(SQL);

          //  cur.moveToFirst();
            while(!cur.isAfterLast())
            {
                Count += 1;
                d = new Member_DataModel();
                d._Count = Count;
                d._MemID = cur.getString(cur.getColumnIndex("MemID"));
                d._HHID = cur.getString(cur.getColumnIndex("HHID"));
                d._DSSID = cur.getString(cur.getColumnIndex("DSSID"));
                d._MSlNo = cur.getString(cur.getColumnIndex("MSlNo"));
                d._Rth = cur.getString(cur.getColumnIndex("Rth"));
                d._RthOth = cur.getString(cur.getColumnIndex("RthOth"));
                d._Name = cur.getString(cur.getColumnIndex("Name"));
                d._HHHead = cur.getString(cur.getColumnIndex("HHHead"));
                d._Sex = cur.getString(cur.getColumnIndex("Sex"));
                d._BDate_D = cur.getString(cur.getColumnIndex("BDate_D"));
                d._BDate_M = cur.getString(cur.getColumnIndex("BDate_M"));
                d._BDate_Y = cur.getString(cur.getColumnIndex("BDate_Y"));
                d._BDate = cur.getString(cur.getColumnIndex("BDate"));
                d._BDateType = cur.getString(cur.getColumnIndex("BDateType"));
                d._Age = cur.getString(cur.getColumnIndex("Age"));
                d._AgeU = cur.getString(cur.getColumnIndex("AgeU"));
                d._MoNo = cur.getString(cur.getColumnIndex("MoNo"));
                d._MoName = cur.getString(cur.getColumnIndex("MoName"));
                d._FaNo = cur.getString(cur.getColumnIndex("FaNo"));
                d._FaName = cur.getString(cur.getColumnIndex("FaName"));
                d._EduY = cur.getString(cur.getColumnIndex("EduY"));
                d._Employ = cur.getString(cur.getColumnIndex("Employ"));
                d._EmployOth = cur.getString(cur.getColumnIndex("EmployOth"));
                d._Ocp = cur.getString(cur.getColumnIndex("Ocp"));
                d._OcpOth = cur.getString(cur.getColumnIndex("OcpOth"));
                d._OcpDk = cur.getString(cur.getColumnIndex("OcpDk"));
                d._Religion = cur.getString(cur.getColumnIndex("Religion"));
                d._ReligionOth = cur.getString(cur.getColumnIndex("ReligionOth"));
                d._Ethnicity = cur.getString(cur.getColumnIndex("Ethnicity"));
                d._EthnicityOth = cur.getString(cur.getColumnIndex("EthnicityOth"));
                d._MobileNo = cur.getString(cur.getColumnIndex("MobileNo"));
                d._MS = cur.getString(cur.getColumnIndex("MS"));
                d._MSOth = cur.getString(cur.getColumnIndex("MSOth"));
                d._Sp1 = cur.getString(cur.getColumnIndex("Sp1"));
                d._Sp1Name = cur.getString(cur.getColumnIndex("Sp1Name"));
                d._Sp2 = cur.getString(cur.getColumnIndex("Sp2"));
                d._Sp2Name = cur.getString(cur.getColumnIndex("Sp2Name"));
                d._Sp3 = cur.getString(cur.getColumnIndex("Sp3"));
                d._Sp3Name = cur.getString(cur.getColumnIndex("Sp3Name"));
                d._Sp4 = cur.getString(cur.getColumnIndex("Sp4"));
                d._Sp4Name = cur.getString(cur.getColumnIndex("Sp4Name"));
                d._Pstat = cur.getString(cur.getColumnIndex("Pstat"));
                d._LmpDt = cur.getString(cur.getColumnIndex("LmpDt"));
                d._gage = cur.getString(cur.getColumnIndex("gage"));
                d._gageUnit = cur.getString(cur.getColumnIndex("gageUnit"));
                d._anc_regis = cur.getString(cur.getColumnIndex("anc_regis"));
                d._anc_resp_home = cur.getString(cur.getColumnIndex("anc_resp_home"));
                d._anc_other_home = cur.getString(cur.getColumnIndex("anc_other_home"));
                d._anc_govt_hosp = cur.getString(cur.getColumnIndex("anc_govt_hosp"));
                d._anc_govt_health = cur.getString(cur.getColumnIndex("anc_govt_health"));
                d._anc_govt_health_post = cur.getString(cur.getColumnIndex("anc_govt_health_post"));
                d._anc_priv_hosp = cur.getString(cur.getColumnIndex("anc_priv_hosp"));
                d._anc_tba_home = cur.getString(cur.getColumnIndex("anc_tba_home"));
                d._anc_ngo_hosp = cur.getString(cur.getColumnIndex("anc_ngo_hosp"));
                d._anc_other = cur.getString(cur.getColumnIndex("anc_other"));
                d._anc_other_specify = cur.getString(cur.getColumnIndex("anc_other_specify"));
                d._anc_dk = cur.getString(cur.getColumnIndex("anc_dk"));
                d._anc_refuse = cur.getString(cur.getColumnIndex("anc_refuse"));
                d._out_date = cur.getString(cur.getColumnIndex("out_date"));
                d._Rnd = cur.getString(cur.getColumnIndex("Rnd"));
                d._Active = cur.getString(cur.getColumnIndex("Active"));
                d._EnType = cur.getString(cur.getColumnIndex("EnType"));
                d._ExType = cur.getString(cur.getColumnIndex("ExType"));
                data.add(d);


                cur.moveToNext();
            }
            cur.close();
          return data;
        }


 }