package koodivelhot.Ticketguru.Domain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;



@Entity
public class PreSaleTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long presaleticketid;
	//@NotNull
	private Boolean used;
	//@NotNull (message = "Price cannot be null") // hinta on pakollinen tieto, ilmaislipuille syötetään hinnaksi 0
	private double price;
	private String code = UUID.randomUUID().toString(); // tällä luodaan lipulle random koodi 

	@JsonIgnore
	private byte[] qrCodeImage; 
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "sale") // myyntitapahtuma, johon lippu liittyy
	//@NotNull (message = "Presale ticket must belong to a sale event")
    private SaleEvent sale;
	
	@ManyToOne
    @JoinColumn(name = "event") // tapahtuma, johon lippu liittyy
	//@NotNull (message = "Presale ticket must belong to an event")
    private Event event;
	
	@ManyToOne
	@JoinColumn(name = "tickettype") // lipputyyppi
	@NotNull (message = "Presale ticket must have a ticket type")
	private TicketType tickettype;
	
	public PreSaleTicket() {}

	public PreSaleTicket(double price, Boolean used, Event event, SaleEvent sale) {
		this.price = price;
		this.used = used;
		this.event = event;
		this.sale = sale;
	}
	
	/*public PreSaleTicket(double price, Event event) {
		this.price = price;
		this.event = event;
	}*/


	public PreSaleTicket(@NotNull Boolean used, @NotNull(message = "Price cannot be null") double price,
			@NotNull(message = "Presale ticket must belong to a sale event") SaleEvent sale,
			@NotNull(message = "Presale ticket must belong to an event") Event event, TicketType tickettype) {
		super();
		this.used = used;
		this.price = price;
		this.sale = sale;
		this.event = event;
		this.tickettype = tickettype;
	}
	
	// Testi konstruktori
	public PreSaleTicket(Event event, double price, TicketType tickettype) {
		super();
		this.event = event;
		this.price = price;
		this.tickettype = tickettype;
	}
	
	public PreSaleTicket(TicketType tickettype) {
		super();
		this.tickettype = tickettype;
	}
	
	public PreSaleTicket(@NotNull Boolean used) {
		super();
		this.used = used;
	}

	public Long getPresaleticketid() {
		return presaleticketid;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPresaleticketid(Long presaleticketid) {
		this.presaleticketid = presaleticketid;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}
	
	public SaleEvent getSale() {
		return sale;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSale(SaleEvent sale) {
		this.sale = sale;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public TicketType getTickettype() {
		return tickettype;
	}

	public void setTickettype(TicketType tickettype) {
		this.tickettype = tickettype;
	}

	public String getQrCodeImage() {
		return Base64.getEncoder().encodeToString(qrCodeImage);
	}

	//generoi qr-koodin
	public void setQrCodeImage() {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(this.code, BarcodeFormat.QR_CODE, 1, 1);
			MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
			this.qrCodeImage = outputStream.toByteArray();
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
