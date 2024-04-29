package com.devkraft.demodataprivacyvault.controller;

import com.devkraft.demodataprivacyvault.bean.EncryptedDataDetails;
import com.devkraft.demodataprivacyvault.response.EncryptedDetailsResponse;
import com.devkraft.demodataprivacyvault.service.EncryptedDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EncryptionController {


    private EncryptedDataService encryptedDataService;

    public EncryptionController(EncryptedDataService encryptedDataService) {
        this.encryptedDataService = encryptedDataService;
    }

    @PostMapping(value = "/createEncryptedData" , produces = "application/json")
    public ResponseEntity<EncryptedDetailsResponse> createEncryptedData(
            @Valid @RequestBody EncryptedDataDetails dataToEncrypt) throws Exception {
        return  ResponseEntity.status(HttpStatus.CREATED).body(
                encryptedDataService.createEncryptedDataDetails(dataToEncrypt));
    }

    @PostMapping(value = "/getDecryptedData/{entryId}", produces = "application/json")
    public ResponseEntity<EncryptedDetailsResponse> getDecryptedData(@PathVariable Long entryId,
        @RequestBody String password) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                encryptedDataService.retriveDecryptedDataDetails(entryId,password));
    }

    @PostMapping(value = "addEncryptedData")
    public ResponseEntity<EncryptedDetailsResponse> addEncryptedData(
            @Valid @RequestBody EncryptedDataDetails dataToEncrypt) throws Exception {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    encryptedDataService.addEncryptedDataDetails(dataToEncrypt));
    }

    @PutMapping(value = "/updateEncryptedData/{entryId}")
    public ResponseEntity<EncryptedDetailsResponse> updateEncryptedData(@PathVariable Long entryId,
                                 @RequestBody EncryptedDataDetails newDetailstoEncrypt) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                encryptedDataService.updateEncryptedDataDetails(entryId,newDetailstoEncrypt));
    }

    @DeleteMapping(value = "/deleteAllUserEncryptedData/{entryId}")
    public ResponseEntity<EncryptedDetailsResponse> deleteEncryptedData(@PathVariable Long entryId,
                                                                        @RequestBody String password) throws Exception {
        encryptedDataService.deleteEncryptedDataDetails(entryId,password);
        return ResponseEntity.noContent().build();
    }
}
