package koodivelhot.Ticketguru.web;

import com.google.zxing.WriterException;

import koodivelhot.Ticketguru.Domain.QRCodeGenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.Base64;

@Controller
public class QRCodeController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    @GetMapping(value = "/generateAndDownloadQRCode/{id}/{width}/{height}")
		public void download(
				@PathVariable("id") String id,
				@PathVariable("width") Integer width,
				@PathVariable("height") Integer height)
			    throws Exception {
			        QRCodeGenerator.generateQRCodeImage("/presaleticket/" + id, width, height, QR_CODE_IMAGE_PATH);
			    }

    @GetMapping(value = "/generateQRCode/{id}/{width}/{height}")
   	public ResponseEntity<byte[]> generateQRCode(
   			@PathVariable("id") String id,
   			@PathVariable("width") Integer width,
   			@PathVariable("height") Integer height)
   		    throws Exception {
   		        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage("/presaleticket/" + id, width, height));
   		    }
}
