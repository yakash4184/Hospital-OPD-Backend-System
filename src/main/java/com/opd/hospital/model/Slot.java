package com.opd.hospital.model;

import java.util.PriorityQueue;

public class Slot {
    public int slotId;
    public int capacity;
    public PriorityQueue<Token> tokens;

    public Slot(int slotId, int capacity) {
        this.slotId = slotId;
        this.capacity = capacity;
        this.tokens = new PriorityQueue<>(
                (a, b) -> a.priority - b.priority
        );
    }
}
