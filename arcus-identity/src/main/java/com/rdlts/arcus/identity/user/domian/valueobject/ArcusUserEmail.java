package com.rdlts.arcus.identity.user.domian.valueobject;

public record ArcusUserEmail(String emailAddress) {

    public ArcusUserEmail {
        if (emailAddress == null || emailAddress.isBlank()) {
            throw new IllegalArgumentException("Email address cannot be null or blank");
        }
        if (!emailAddress.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email address format");
        }
    }
}
