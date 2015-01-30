package com.globacomp.ssystem.common;

import java.util.ArrayList;
import java.util.List;

public final class Configuration {

	public static final List<STATUS> statusList = new ArrayList<STATUS>();

	public Configuration() {
	}

	public static enum STATUS {

		DELETED((byte) 0, "Deleted"), ACTIVE((byte) 1, "Active"), DEACTIVE(
				(byte) 2, "Deactive"), PENDING((byte) 3, "pending"), REJECTED(
				(byte) 4, "rejected");

		private byte status;

		private String text;

		private STATUS(byte status, String text) {
			this.status = status;
			this.text = text;
		}

		public byte getStatus() {
			return status;
		}

		public void setStatus(byte status) {
			this.status = status;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

	public static List<STATUS> getStatusList() {

		for (STATUS status : STATUS.values()) {
			statusList.add(status);
		}

		return statusList;
	}

}
