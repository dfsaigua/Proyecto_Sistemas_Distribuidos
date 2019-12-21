import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.model.request.ConversionPostedData;
import com.groupdocs.ui.model.response.ConversionTypesEntity;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.response.UploadedDocumentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
package com.proyecto.microservice.controller;

/**
 *
 * @author dan
 */
public class controlador_convertidor_documento {
    
     @RequestMapping(method = RequestMethod.POST, value = "/uploadDocument",
            consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public UploadedDocumentEntity uploadDocument(@Nullable @RequestParam("file") MultipartFile content,
                                                 @RequestParam(value = "url", required = false) String url,
                                                 @RequestParam("rewrite") Boolean rewrite) {
        // get documents storage path
        String documentStoragePath = conversionService.getConversionConfiguration().getFilesDirectory();
        // save the file
        String pathname = uploadFile(documentStoragePath, content, url, rewrite);
        // create response data
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/convert",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity convert(@RequestBody ConversionPostedData postedData){
        try{
            conversionService.convert(postedData);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.ok().build();
        }
    }
    
}
