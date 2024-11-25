package com.milind.demodataprivacyvault.service;

import com.milind.demodataprivacyvault.bean.EncryptedDataDetails;
import com.milind.demodataprivacyvault.response.EncryptedDetailsResponse;

import java.util.List;
import java.util.Map;

public interface EncryptedDataService {

    public EncryptedDetailsResponse createEncryptedDataDetails(EncryptedDataDetails detailsToEncrypt) throws Exception;
    public EncryptedDetailsResponse retriveDecryptedDataDetails(String entryId) throws Exception;
    public EncryptedDetailsResponse addEncryptedDataDetails(EncryptedDataDetails detailsToEncrypt) throws Exception;
    public EncryptedDetailsResponse updateEncryptedDataDetails(String entryId,EncryptedDataDetails detailsToEncrypt) throws Exception;
    public void deleteEncryptedDataDetails(String entryId) throws Exception;
    public List<Map<String,String>> getDecryptedDataForAppId(String appId);
}