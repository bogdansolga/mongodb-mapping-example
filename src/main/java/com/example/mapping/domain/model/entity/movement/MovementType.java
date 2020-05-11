package com.example.mapping.domain.model.entity.movement;

//TODO maybe reuse the enum from the Inbounds/Outbounds project?
public enum MovementType {

    TM1,    // Inbound
    TM80,   // Outbound - Return items
    TM288   // Outbound - Defect items
}
