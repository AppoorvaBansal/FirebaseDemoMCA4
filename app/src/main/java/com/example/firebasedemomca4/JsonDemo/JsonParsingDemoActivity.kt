package com.example.firebasedemomca4.JsonDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.firebasedemomca4.R
import org.json.JSONArray
import org.json.JSONObject

import java.util.ArrayList

class JsonParsingDemoActivity : AppCompatActivity() {

    //lateinit var exp:Expression
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_parsing_demo)


        val fetchUrl="https://mysafeinfo.com/api/data?list=collegedegrees&format=json&case=default"

        val queue=Volley.newRequestQueue(this)

        val fetchData=StringRequest(Request.Method.GET,
            fetchUrl,
            Response.Listener<String>{response ->
                // fetch the data from the file

                val jsondata=response.toString()

                Log.d("Status",jsondata)

                //val jsonObject=JSONObject(jsondata)

                val jsonArray=JSONArray(jsondata)

                val arrayLength=jsonArray.length()


                for(i in 0 until arrayLength)
                {
                    var jsonarrayobject=jsonArray.getJSONObject(i)
                   var id=jsonarrayobject.getString("ID")
                    var name=jsonarrayobject.getString("Name")
                    var degree=jsonarrayobject.getString("Degree")


                    var modeljsondata=Model(id,name,degree)

                    var arrlist=ArrayList<Model>()
                    arrlist.add(modeljsondata)


                }




            },

            Response.ErrorListener {
                ///In case of any error
            }
            )

        queue.add(fetchData)

    }
}
