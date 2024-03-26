package com.widia.iwefollow.utils;

public class Constants {

    public enum UploadResponse {
        SUCCESS("Success", "Success to upload data"),
        ERROR("Error", "Failed to upload data");

        public final String getValue;
        public final String getMessage;
        private UploadResponse(String responseStatus, String message){
            this.getValue = responseStatus;
            this.getMessage = message;
        }
    }

    public enum GroupActive {
        NONACTIVE(0, "Non-Active"),
        ACTIVE(1, "Active");

        private final int value;
        private final String label;

        GroupActive(int value, String label) {
            this.value = value;
            this.label = label;
        }

        public int getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }

        // You can add additional methods if needed
    }
}
