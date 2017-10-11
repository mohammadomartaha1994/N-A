package com.example.mohammad.nouran;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;



/**
 * Created by mohammad on 10/18/2016.
 */

public class AddIDreq extends StringRequest {
    // private static final String REGISTER_REQUEST_URL="http://googleps.me/SPSProject/addFriend.php";
    private static final String REGISTER_REQUEST_URL="http://kufermalik.com/Nouran/add.php";
    public  String  num1,num2,num3,num4,num5,num6,num7,num8,num9,num10;
    public  String  num11,num12,num13,num14,num15,num16,num17,num18,num19,num20;
    public  String  num21,num22,num23,num24,num25,num26,num27,num28,num29,num30;
    public  String  num31,num32,num33,num34,num35,num36,num37,num38,num39,num40;
    public  String  num41,num42,num43,num44,num45,num46,num47,num48,num49,num50;
    public  String  num51,num52,num53,num54,num55,num56,num57,num58,num59,num60;
    public  String  num61,num62,num63,num64,num65,num66,num67,num68,num69,num70;
    public  String  num71,num72,num73,num74,num75;

    private Map<String,String> params;

    public AddIDreq(String num1,String num2 , String num3 , String num4, String num5, String num6 , String num7, String num8 ,String num9 , String num10 ,
                    String num11,String num12 , String num13 , String num14, String num15, String num16 , String num17, String num18 ,String num19 , String num20 ,
                    String num21,String num22 , String num23 , String num24, String num25, String num26 , String num27, String num28 ,String num29 , String num30 ,
                    String num31,String num32 , String num33 , String num34, String num35, String num36 , String num37, String num38 ,String num39 , String num40 ,
                    String num41,String num42 , String num43 , String num44, String num45, String num46 , String num47, String num48 ,String num49 , String num50 ,
                    String num51,String num52 , String num53 , String num54, String num55, String num56 , String num57, String num58 ,String num59 , String num60 ,
                    String num61,String num62 , String num63 , String num64, String num65, String num66 , String num67, String num68 ,String num69 , String num70 ,
                    String num71 , String num72,String num73 , String num74,String num75,Response.Listener<String> listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("num1",num1);
        params.put("num2",num2);
        params.put("num3",num3);
        params.put("num4",num4);
        params.put("num5",num5);
        params.put("num6",num6);
        params.put("num7",num7);
        params.put("num8",num8);
        params.put("num9",num9);
        params.put("num10",num10);

        params.put("num11",num11);
        params.put("num12",num12);
        params.put("num13",num13);
        params.put("num14",num14);
        params.put("num15",num15);
        params.put("num16",num16);
        params.put("num17",num17);
        params.put("num18",num18);
        params.put("num19",num19);
        params.put("num20",num20);

        params.put("num21",num21);
        params.put("num22",num22);
        params.put("num23",num23);
        params.put("num24",num24);
        params.put("num25",num25);
        params.put("num26",num26);
        params.put("num27",num27);
        params.put("num28",num28);
        params.put("num29",num29);
        params.put("num30",num30);

        params.put("num31",num31);
        params.put("num32",num32);
        params.put("num33",num33);
        params.put("num34",num34);
        params.put("num35",num35);
        params.put("num36",num36);
        params.put("num37",num37);
        params.put("num38",num38);
        params.put("num39",num39);
        params.put("num40",num40);

        params.put("num41",num41);
        params.put("num42",num42);
        params.put("num43",num43);
        params.put("num44",num44);
        params.put("num45",num45);
        params.put("num46",num46);
        params.put("num47",num47);
        params.put("num48",num48);
        params.put("num49",num49);
        params.put("num50",num50);

        params.put("num51",num51);
        params.put("num52",num52);
        params.put("num53",num53);
        params.put("num54",num54);
        params.put("num55",num55);
        params.put("num56",num56);
        params.put("num57",num57);
        params.put("num58",num58);
        params.put("num59",num59);
        params.put("num60",num60);

        params.put("num61",num61);
        params.put("num62",num62);
        params.put("num63",num63);
        params.put("num64",num64);
        params.put("num65",num65);
        params.put("num66",num66);
        params.put("num67",num67);
        params.put("num68",num68);
        params.put("num69",num69);
        params.put("num70",num70);


        params.put("num71",num71);
        params.put("num72",num72);
        params.put("num73",num73);
        params.put("num74",num74);
        params.put("num75",num75);

    }

    @Override
    public  Map<String,String> getParams(){
        return params;
    }

}
