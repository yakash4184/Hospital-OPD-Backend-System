package com.opd.hospital.service;

import com.opd.hospital.model.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TokenService {

    private Slot slot = new Slot(1, 3); // demo: capacity 3
    private int tokenCounter = 1;

    public String createToken(PatientType type) {

        int priority = switch (type) {
            case EMERGENCY -> 0;
            case PAID -> 1;
            case FOLLOW_UP -> 2;
            case ONLINE -> 3;
            case WALK_IN -> 4;
        };

        Token token = new Token(tokenCounter++, type, priority);

        if (slot.tokens.size() < slot.capacity) {
            slot.tokens.add(token);
            return "Token added: " + token.tokenId;
        }

        Token lowPriority = slot.tokens.peek();

        if (token.priority < lowPriority.priority) {
            slot.tokens.poll();
            slot.tokens.add(token);
            return "High priority token replaced low priority";
        }

        return "Slot full, token rejected";
    }

    public List<Token> getTokens() {
        return new ArrayList<>(slot.tokens);
    }
}
