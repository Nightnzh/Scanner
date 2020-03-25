package com.night.scanner;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.night.scanner.db.QrCodeDao;
import com.night.scanner.db.QrCodeRoomDataBase;
import com.night.scanner.model.QrCode;

import java.util.List;

public class QrCodeRepository {
    private QrCodeDao qrCodeDao;
    private LiveData<List<QrCode>> allQrCodes;

    public QrCodeRepository(Application application){
        QrCodeRoomDataBase db = QrCodeRoomDataBase.getDatabase(application);
        qrCodeDao = db.qrCodeDao();
        allQrCodes = qrCodeDao.getAll();
    }
    public LiveData<List<QrCode>> getAllQrCodes(){
        return allQrCodes;
    }
    public void insert(QrCode qrCode){
        qrCodeDao.insert(qrCode);
    }
}
