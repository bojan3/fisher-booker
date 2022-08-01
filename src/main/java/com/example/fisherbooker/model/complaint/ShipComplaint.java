package com.example.fisherbooker.model.complaint;

import javax.persistence.Entity;


@Entity
public class ShipComplaint {

		private Long clientId;
		private Long shipId;
		private String text;
		private Boolean answered;
		
		public ShipComplaint() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public ShipComplaint(Long clientId, Long shipId, String text, Boolean answered) {
			super();
			this.clientId = clientId;
			this.shipId = shipId;
			this.text = text;
			this.answered = answered;
		}
		
		public Long getClientId() {
			return clientId;
		}
		public void setClientId(Long clientId) {
			this.clientId = clientId;
		}
		public Long getShipId() {
			return shipId;
		}
		public void setShipId(Long shipId) {
			this.shipId = shipId;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public Boolean getAnswered() {
			return answered;
		}
		public void setAnswered(Boolean answered) {
			this.answered = answered;
		}

		@Override
		public String toString() {
			return "ShipComplaint [clientId=" + clientId + ", shipId=" + shipId + ", text=" + text + "]";
		}
		
	}