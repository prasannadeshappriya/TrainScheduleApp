package com.example.prasanna.trainscheduleapp.Task;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.prasanna.trainscheduleapp.DAO.TrainStationDAO;
import com.example.prasanna.trainscheduleapp.Fragment.TrainRateFragment;
import com.example.prasanna.trainscheduleapp.Utilities.Constants;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by prasanna on 4/21/17.
 */

public class GetRatesTask extends Task {
    private String fromStationCode;
    private String toStationCode;
    private String fromStationKey;
    private String toStationKey;
    private TrainStationDAO stationDAO;
    private ArrayList<String> arrPrice;
    private TrainRateFragment fragment;
    public GetRatesTask(Context _context, ProgressDialog _pd,
                        String fromStationCode, String toStationCode, TrainRateFragment fragment) {
        super(_context, _pd);
        this.toStationCode = toStationCode;
        this.fromStationCode = fromStationCode;
        this.fragment = fragment;
    }

    @Override
    protected void onPreExecute() {
        stationDAO = new TrainStationDAO(context);
        fromStationKey = stationDAO.getTrainStationKey(fromStationCode);
        toStationKey = stationDAO.getTrainStationKey(toStationCode);
        pd.setIndeterminate(true);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage("Please wait");
        pd.show();
        arrPrice = new ArrayList<>();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            String methodName = "getRates";
            SoapObject request = new SoapObject(Constants.NAMESPACE, methodName);
            request.addProperty("StartStationCode", fromStationKey);
            request.addProperty("EndStationCode", toStationKey);
            request.addProperty("lang", "en");

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);

            HttpTransportSE httpTransport = new HttpTransportSE(Constants.ENDPOINT);
            String actionName = methodName;

            httpTransport.call(actionName, envelope);
            request = (SoapObject) envelope.bodyIn;

            for(int i=0; i<request.getPropertyCount(); i++) {
                SoapObject result = (SoapObject) request.getProperty(i);
                arrPrice.add(result.getProperty("price").toString());
            }

        } catch (Exception e) {
            Log.i(Constants.TAG, "Error on test AsyncTask :- " + e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        //super.onPostExecute(aVoid);
        pd.dismiss();
        fragment.setParameters(arrPrice);
    }
}
