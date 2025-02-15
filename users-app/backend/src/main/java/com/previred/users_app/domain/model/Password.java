package com.previred.users_app.domain.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

public class Password {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final String hashedValue;

    private Password(String hashedValue) {
        this.hashedValue = hashedValue;
    }

    public static Password ofHash(String existingHash) {
        return new Password(existingHash);
    }

    public static Password fromPlainText(String plainText) {
        String hash = encoder.encode(plainText);
        return new Password(hash);
    }

    public String getHashedValue() {
        return hashedValue;
    }

    public boolean matches(String plainText) {
        return encoder.matches(plainText, hashedValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password)) return false;
        Password password = (Password) o;
        return Objects.equals(hashedValue, password.hashedValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashedValue);
    }
}
