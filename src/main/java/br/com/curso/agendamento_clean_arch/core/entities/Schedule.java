package br.com.curso.agendamento_clean_arch.core.entities;

import br.com.curso.agendamento_clean_arch.core.enums.ScheduleStatus;

import java.time.LocalDateTime;

public record Schedule(
        Long id,
        String title,
        String description,
        LocalDateTime initialDate,
        LocalDateTime finalDate,
        ScheduleStatus status,
        String user,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}