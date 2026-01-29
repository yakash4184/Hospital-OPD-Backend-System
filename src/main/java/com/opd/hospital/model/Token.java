package com.opd.hospital.model;

public class Token {
    public int tokenId;
    public PatientType type;
    public int priority;

    public Token(int tokenId, PatientType type, int priority) {
        this.tokenId = tokenId;
        this.type = type;
        this.priority = priority;
    }
}
