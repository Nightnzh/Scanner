package com.night.scanner.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.night.scanner.QrCodeRepository;
import com.night.scanner.model.QrCode;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private QrCodeRepository qrCodeRepository;
    private LiveData<List<QrCode>> allQrCodes;

    public HomeViewModel(Application application){
        super(application);
        qrCodeRepository = new QrCodeRepository(application);
        allQrCodes = qrCodeRepository.getAllQrCodes();
    }

    LiveData<List<QrCode>> getAllQrCodes(){
        return allQrCodes;
    }
    public void insert(QrCode qrCode){
        qrCodeRepository.insert(qrCode);
    }
}